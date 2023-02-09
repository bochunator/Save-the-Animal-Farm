package bochunator.savetheanimalfarm;

import static android.graphics.ImageFormat.RGB_565;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import bochunator.savetheanimalfarm.gameobject.Enemy;
import bochunator.savetheanimalfarm.gameobject.Player;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private Paint paintTextInfo;
    private Player player;
    private final List<Enemy> enemies;

    public GameSurfaceView(Context context) {
        super(context);
        setFocusable(true);
        getHolder().setFormat(RGB_565);
        getHolder().addCallback(this);

        paintTextInfo = new Paint();
        paintTextInfo.setColor(ContextCompat.getColor(getContext(), R.color.teal_200));
        paintTextInfo.setTextSize(50);

        enemies = new ArrayList<>();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameThread = new GameThread(this, surfaceHolder);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        player = new Player(getContext(), getWidth(), getHeight());
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

        player.draw(canvas);
        for(Enemy e : enemies){
            e.draw(canvas);
        }

        drawTextInfo(canvas);
    }

    public void drawTextInfo(Canvas canvas){
        String averageUPS = Double.toString(gameThread.getAverageUPS());
        canvas.drawText("UPS: " + averageUPS, 100, 100, paintTextInfo);
        String averageFPS = Double.toString(gameThread.getAverageFPS());
        canvas.drawText("FPS: " + averageFPS, 100, 200, paintTextInfo);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:{
                player.setPositionX(event.getX());
            }return true;
        }
        return super.onTouchEvent(event);
    }

    public void update() {
        if(Enemy.readyToSpawn()){
            enemies.add(new Enemy(getContext(), getWidth(), getHeight()));
        }

        for(Enemy e : enemies){
            e.update();
        }

        enemies.removeIf(Enemy::readyToRemove);
    }
}