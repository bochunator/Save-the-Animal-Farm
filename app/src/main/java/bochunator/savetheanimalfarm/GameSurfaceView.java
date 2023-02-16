package bochunator.savetheanimalfarm;

import static android.graphics.ImageFormat.RGB_565;

import static bochunator.savetheanimalfarm.MainActivity.ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.SHARED_PREFERENCES;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapAnimals;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapBackground;
import bochunator.savetheanimalfarm.gameobject.Enemy;
import bochunator.savetheanimalfarm.gameobject.Explosion;
import bochunator.savetheanimalfarm.gameobject.Player;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private Paint paintTextInfo;
    private Paint paintGameOver;
    private Player player;

    private final List<Enemy> enemies;
    private CreatorBitmapPlanets creatorBitmapPlanets;
    private CreatorBitmapExplosions creatorBitmapExplosions;
    private CreatorBitmapFloatingExplosions creatorBitmapFloatingExplosions;

    private final List<Explosion> explosions;
    private Bitmap background;
    private Bitmap platform;
    private GameOver gameOver;
    float randPosition = 0;
    private SharedPreferences sharedPreferences;
    Bitmap playerBitmap;
    private Paint platformPaint;

    public GameSurfaceView(Context context) {
        super(context);
        setFocusable(true);
        getHolder().setFormat(RGB_565);
        getHolder().addCallback(this);

        paintTextInfo = new Paint();
        paintTextInfo.setColor(ContextCompat.getColor(getContext(), R.color.teal_200));
        paintTextInfo.setTextSize(50);

        paintGameOver = new Paint();
        paintGameOver.setColor(ContextCompat.getColor(getContext(), R.color.purple_700));
        paintGameOver.setTextSize(getWidth()/3);
        paintGameOver.setTextAlign(Paint.Align.CENTER);
        platformPaint = new Paint();
        platformPaint.setColor(ContextCompat.getColor(getContext(), R.color.brown));

        enemies = new ArrayList<>();
        explosions = new ArrayList<>();

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        CreatorBitmapBackground creatorBitmapBackground = new CreatorBitmapBackground();
        background = creatorBitmapBackground.getCreatorRandomBitmapBackground(getContext(), getHeight());
        if(getWidth() < background.getWidth()){
            randPosition = (float) (Math.random() * (getWidth() - background.getWidth()));
        }
        platform = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(getContext().getResources(), R.drawable.ground_grass_small_broken),
                getWidth(),
                getHeight()/7,
                false
        );
        CreatorBitmapAnimals creatorBitmapAnimals = new CreatorBitmapAnimals();
        playerBitmap = creatorBitmapAnimals.getCreatorBitmapAnimals(sharedPreferences.getInt(ANIMAL, 16), getContext());
        double scaleWidth =  (double) getWidth() / (7 * 136);
        double scaleHeight =  (double) getWidth() / (7 * 136);
        playerBitmap = Bitmap.createScaledBitmap(playerBitmap,
                (int) (getWidth() / 7 * (double)playerBitmap.getWidth() / 136),
                (int) (getWidth()  / 7 * (double)playerBitmap.getHeight() / 136),
                true);
        player = new Player(getContext(), getWidth(), getHeight(), playerBitmap,
                (int) (creatorBitmapAnimals.offsetWidth(sharedPreferences.getInt(ANIMAL, 16)) * scaleWidth),
                (int) (creatorBitmapAnimals.offsetHeight(sharedPreferences.getInt(ANIMAL, 16)) * scaleHeight));
        gameOver = new GameOver(3, getContext(), getWidth(), getHeight(), sharedPreferences);
        creatorBitmapPlanets = new CreatorBitmapPlanets(getContext(), getWidth());
        creatorBitmapExplosions = new CreatorBitmapExplosions(getContext(), getWidth());
        creatorBitmapFloatingExplosions = new CreatorBitmapFloatingExplosions(getContext(), getWidth());

        gameThread = new GameThread(this, surfaceHolder);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        gameOver.saveCoins();

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
        canvas.drawBitmap(background, randPosition, 0, null);
        canvas.drawRect(0, (float) (6.0/7.0 * getHeight()),getWidth(),getHeight(), platformPaint);
        canvas.drawBitmap(platform,0, (float) (6.0/7.0 * getHeight()), null);

        player.draw(canvas);

        for(Enemy e : enemies){
            canvas.drawBitmap(
                    creatorBitmapFloatingExplosions.getFloatingExplosion(e.getIteratorFloatingExplosion()),
                    (float) (e.getX() - e.getRadius()),
                    (float) e.getY() - (int) (getWidth() * 1.618 /3),
                    null
            );
            e.draw(canvas);
        }
        for (Explosion e : explosions){
            canvas.drawBitmap(
                    e.isSmoke() ? creatorBitmapExplosions.getExplosionSmoke(e.iterator) : creatorBitmapExplosions.getExplosion(e.iterator),
                    (float) e.getX(),
                    (float) e.getY(),
                    null
            );
        }

        drawTextInfo(canvas);
        if (gameOver.isGameOver()){
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
            enemies.add(new Enemy(getContext(), getWidth(), getHeight(), creatorBitmapPlanets.getCreatorRandomBitmapPlanets()));
        }

        for(int i = 0; i < explosions.size(); i++){
            explosions.get(i).iterator++;
            if(Explosion.NUMBER_OF_FRAMES <= explosions.get(i).iterator){
                explosions.remove(i);
            }
        }

        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).update();
            if(AdvancedCalculations.isCollidingCircleAndRectangle(enemies.get(i), player)){
                explosions.add(new Explosion(getContext(), getWidth(), enemies.get(i).getX(), enemies.get(i).getY()));
                enemies.remove(i);
                gameOver.decrementHealthPoints();
            }
            if(enemies.get(i).readyToRemove()){
                gameOver.setCoins(gameOver.getCoins() + 10);
                explosions.add(new Explosion(getContext(), getWidth(), enemies.get(i).getX(), enemies.get(i).getY()));
                enemies.remove(i);
            }
        }
    }
}