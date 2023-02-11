package bochunator.savetheanimalfarm;

import static android.graphics.ImageFormat.RGB_565;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapAnimals;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapBackground;
import bochunator.savetheanimalfarm.gameobject.Enemy;
import bochunator.savetheanimalfarm.gameobject.GameObjectRadius;
import bochunator.savetheanimalfarm.gameobject.Player;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private Paint paintTextInfo;
    private Paint paintGameOver;
    private Player player;
    private final List<Enemy> enemies;
    private Bitmap background;
    private GameOver gameOver;
    private int coins = 0;
    float randPosition = 0;
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
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        CreatorBitmapBackground creatorBitmapBackground = new CreatorBitmapBackground();
        background = creatorBitmapBackground.getCreatorRandomBitmapBackground(getContext(), getHeight());
        if(getWidth() < background.getWidth()){
            randPosition = (float) (Math.random() * (getWidth() - background.getWidth()));
        }
        CreatorBitmapAnimals creatorBitmapAnimals = new CreatorBitmapAnimals();
        playerBitmap = creatorBitmapAnimals.getCreatorBitmapAnimals(3, getContext(), 1, 1);
        gameThread = new GameThread(this, surfaceHolder);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        player = new Player(getContext(), getWidth(), getHeight());
        gameOver = new GameOver(3, getContext(), getWidth(), getHeight());
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
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
        paintTextInfo.setColor(ContextCompat.getColor(getContext(), R.color.white));
        canvas.drawText("Size: " + background.getWidth() + "x" + background.getHeight(), 100, 400, paintTextInfo);

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
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:{
                if (!gameOver.isGameOver()) {
                    player.setPositionX(event.getX());
                }else{
                    gameOver.checkPosition(event.getX(), event.getY());
                }
            }
            return true;
        }
        return super.onTouchEvent(event);
    }

    public void update() {
        if(gameOver.isGameOver()){
            return;
        }
        if(Enemy.readyToSpawn()){
            enemies.add(new Enemy(getContext(), getWidth(), getHeight()));
        }

        for(Enemy e : enemies){
            e.update();
        }
        if(enemies.removeIf(e -> GameObjectRadius.isColliding(e, player))){
            gameOver.decrementHealthPoints();
        }
        if(enemies.removeIf(Enemy::readyToRemove)){
            coins += 10;
        }
    }
}