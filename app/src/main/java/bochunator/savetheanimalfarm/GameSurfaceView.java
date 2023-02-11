package bochunator.savetheanimalfarm;

import static android.graphics.ImageFormat.RGB_565;

import static bochunator.savetheanimalfarm.MainActivity.ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.SHARED_PREFERENCES;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import bochunator.savetheanimalfarm.gameobject.AdvancedCalculations;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapAnimals;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapBackground;
import bochunator.savetheanimalfarm.gameobject.Enemy;
import bochunator.savetheanimalfarm.gameobject.GameObject;
import bochunator.savetheanimalfarm.gameobject.Player;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private Paint paintTextInfo;
    private Paint paintGameOver;
    private Player player;
    private final List<Enemy> enemies;
    private Bitmap background;
    private GameOver gameOver;
    float randPosition = 0;
    private SharedPreferences sharedPreferences;
    Bitmap playerBitmap;
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

        enemies = new ArrayList<>();

        sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        CreatorBitmapBackground creatorBitmapBackground = new CreatorBitmapBackground();
        background = creatorBitmapBackground.getCreatorRandomBitmapBackground(getContext(), getHeight());
        if(getWidth() < background.getWidth()){
            randPosition = (float) (Math.random() * (getWidth() - background.getWidth()));
        }
        CreatorBitmapAnimals creatorBitmapAnimals = new CreatorBitmapAnimals();
        playerBitmap = creatorBitmapAnimals.getCreatorBitmapAnimals(sharedPreferences.getInt(ANIMAL, 16), getContext(), 1, 1);
        player = new Player(getContext(), getWidth(), getHeight());
        gameOver = new GameOver(3, getContext(), getWidth(), getHeight(), sharedPreferences);

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
        canvas.drawBitmap(playerBitmap, 0, 0, null);

        player.draw(canvas);
        for(Enemy e : enemies){
            e.draw(canvas);
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
            }
            return;
        }
        if(Enemy.readyToSpawn()){
            enemies.add(new Enemy(getContext(), getWidth(), getHeight()));
        }

        for(Enemy e : enemies){
            e.update();
        }
        if(enemies.removeIf(e -> AdvancedCalculations.isCollidingCircleAndRectangle(e, player))){
            gameOver.decrementHealthPoints();
        }
        if(enemies.removeIf(Enemy::readyToRemove)){
            gameOver.setCoins(gameOver.getCoins() + 10);
        }
    }
}