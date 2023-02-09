package bochunator.savetheanimalfarm;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread{
    private static final double MAX_UPS = 30.0;
    private static final double UPS_PERIOD = 1E+3/MAX_UPS;
    private final GameSurfaceView gameSurfaceView;
    private final SurfaceHolder surfaceHolder;
    private boolean running;
    private double averageUPS;
    private double averageFPS;

    public GameThread(GameSurfaceView gameSurfaceView, SurfaceHolder surfaceHolder) {
        this.gameSurfaceView = gameSurfaceView;
        this.surfaceHolder = surfaceHolder;
    }

    public double getAverageUPS() {
        return averageUPS;
    }

    public double getAverageFPS() {
        return averageFPS;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        super.run();

        int updateCount = 0;
        int frameCount = 0;

        long startTime;
        long elapsedTime;
        long sleepTime;

        Canvas canvas;
        startTime = System.currentTimeMillis();
        while (running){
            canvas = null;

            try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    gameSurfaceView.update();
                    updateCount++;
                    gameSurfaceView.draw(canvas);
                }
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }finally {
                if(canvas != null){
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        frameCount++;
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long)(updateCount * UPS_PERIOD - elapsedTime);
            if(sleepTime > 0){
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (sleepTime < 0 && updateCount < MAX_UPS - 1){
                gameSurfaceView.update();
                updateCount++;
                elapsedTime = System.currentTimeMillis() - startTime;
                sleepTime = (long) (updateCount * UPS_PERIOD - elapsedTime);
            }

            elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime >= 1000){
                averageUPS = updateCount / (1E-3 * elapsedTime);
                averageFPS = frameCount / (1E-3 * elapsedTime);
                updateCount = 0;
                frameCount = 0;
                startTime = System.currentTimeMillis();
            }
        }
    }
}