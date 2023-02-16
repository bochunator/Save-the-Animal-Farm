package bochunator.savetheanimalfarm;

import static android.graphics.ImageFormat.RGB_565;

import static bochunator.savetheanimalfarm.MainActivity.ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.DEFAULT_ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.SHARED_PREFERENCES;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapExplosions;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapFloatingExplosions;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapPlanets;
import bochunator.savetheanimalfarm.gameobject.AdvancedCalculations;
import bochunator.savetheanimalfarm.gameobject.Background;
import bochunator.savetheanimalfarm.gameobject.Enemy;
import bochunator.savetheanimalfarm.gameobject.Explosion;
import bochunator.savetheanimalfarm.gameobject.Ground;
import bochunator.savetheanimalfarm.gameobject.Player;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private Background background;
    private Ground ground;
    private Player player;
    private final List<Enemy> enemies;
    private final List<Explosion> explosions;
    private final SharedPreferences sharedPreferences;
    private CreatorBitmapPlanets creatorBitmapPlanets;
    private CreatorBitmapFloatingExplosions creatorBitmapFloatingExplosions;
    private CreatorBitmapExplosions creatorBitmapExplosions;

    private Paint paintTextInfo; //TODO:
    private Paint paintGameOver; //TODO:
    private GameOver gameOver; //TODO:

    public GameSurfaceView(Context context) {
        super(context);
        setFocusable(true);
        getHolder().setFormat(RGB_565);
        getHolder().addCallback(this);

        paintTextInfo = new Paint(); //TODO:
        paintTextInfo.setColor(ContextCompat.getColor(getContext(), R.color.teal_200)); //TODO:
        paintTextInfo.setTextSize(50); //TODO:

        paintGameOver = new Paint();
        paintGameOver.setColor(ContextCompat.getColor(getContext(), R.color.purple_700));
        paintGameOver.setTextSize(getWidth()/3);
        paintGameOver.setTextAlign(Paint.Align.CENTER);

        enemies = new ArrayList<>();
        explosions = new ArrayList<>();

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        background = new Background(getContext(), getWidth(), getHeight());
        ground = new Ground(getContext(), getWidth(), getHeight());
        creatorBitmapPlanets = new CreatorBitmapPlanets(getContext(), getWidth());
        creatorBitmapFloatingExplosions  = new CreatorBitmapFloatingExplosions(getContext(), getWidth());
        creatorBitmapExplosions = new CreatorBitmapExplosions(getContext(), getWidth());
        player = new Player(getContext(), getWidth(), getHeight(), sharedPreferences.getInt(ANIMAL, DEFAULT_ANIMAL));

        gameOver = new GameOver(3, getContext(), getWidth(), getHeight(), sharedPreferences);//TODO:

        gameThread = new GameThread(this, surfaceHolder);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        gameOver.saveCoins();//TODO:

        gameThread.setRunning(false);
        boolean retry = true;
        while (retry){
            try {
                gameThread.join();
                retry = false;
            }catch (InterruptedException e){

            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        background.draw(canvas);
        ground.draw(canvas);
        player.draw(canvas);

        for(Enemy e : enemies){
            e.draw(canvas);
        }
        for (Explosion e : explosions){
            e.draw(canvas);
        }

        drawTextInfo(canvas);//TODO:
        if (gameOver.isGameOver()){//TODO:
            gameOver.drawGameOver(canvas);
        }

    }

    public void drawTextInfo(Canvas canvas){
        String averageUPS = Double.toString(gameThread.getAverageUPS());
        canvas.drawText("UPS: " + averageUPS, 100, 100, paintTextInfo);
        String averageFPS = Double.toString(gameThread.getAverageFPS());
        canvas.drawText("FPS: " + averageFPS, 100, 200, paintTextInfo);
        canvas.drawText("HEALTH POINTS: " + gameOver.getHealthPoints(), 100, 300, paintTextInfo);
        canvas.drawText("COINS: " + gameOver.getCoins(), 100, 400, paintTextInfo);
        canvas.drawText("RECORD: " + gameOver.getHighestCoins(), 100, 500, paintTextInfo);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                if(gameOver.isGameOver()){
                    gameOver.checkPosition(event.getX(), event.getY());
                }
            }
            case MotionEvent.ACTION_MOVE:{
                if (!gameOver.isGameOver()) {
                    player.setPositionX(event.getX());
                }
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void update() {
        if(gameOver.isGameOver()){
            if(!enemies.isEmpty()){
                gameOver.saveCoins();
                enemies.clear();
                player.setPositionX(getWidth()/2);
            }
            return;
        }
        if(Enemy.readyToSpawn()){
            enemies.add(new Enemy(getContext(), getWidth(), getHeight(), creatorBitmapPlanets.getCreatorRandomBitmapPlanets(), creatorBitmapFloatingExplosions.getFloatingExplosionBitmap()));
        }

        for(int i = 0; i < explosions.size(); i++){
            explosions.get(i).update();
            if(explosions.get(i).readyToRemove()){
                explosions.remove(i);
            }
        }

        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).update();
            if(AdvancedCalculations.isCollidingCircleAndRectangle(enemies.get(i), player)){
                explosions.add(new Explosion(getWidth(), enemies.get(i).getPositionX(), enemies.get(i).getPositionY(), creatorBitmapExplosions.getRandomBitmaps()));
                enemies.remove(i);
                gameOver.decrementHealthPoints();
            }
            if(enemies.get(i).readyToRemove()){
                gameOver.setCoins(gameOver.getCoins() + 10);
                explosions.add(new Explosion(getWidth(), enemies.get(i).getPositionX(), enemies.get(i).getPositionY(), creatorBitmapExplosions.getRandomBitmaps()));
                enemies.remove(i);
            }
        }
    }
}