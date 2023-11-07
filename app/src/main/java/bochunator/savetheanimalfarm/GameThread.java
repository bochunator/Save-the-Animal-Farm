package bochunator.savetheanimalfarm;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;

public class GameThread extends Thread {
    public static final double MAX_UPS = 70.0;
    private static final double UPS_PERIOD = 1000/MAX_UPS;
    private final OldGameSurfaceView gameSurfaceView;
    private boolean running;
    private double averageUPS;
    private double averageFPS;
    public GameThread(OldGameSurfaceView gameSurfaceView) {
        this.gameSurfaceView = gameSurfaceView;
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
        SurfaceHolder surfaceHolder = gameSurfaceView.getHolder();
        int updateCount = 0;
        int frameCount = 0;
        long startTime;
        long elapsedTime;
        long sleepTime;
        Canvas canvas;
        startTime = System.currentTimeMillis();
        int x = gameSurfaceView.getDisplayMetrics().widthPixels;
        int y = gameSurfaceView.getDisplayMetrics().heightPixels;
        Rect rect = new Rect(0,0,x,y);
        while (running){
            canvas = null;
            //try {
                canvas = surfaceHolder.lockCanvas();
                synchronized (surfaceHolder){
                    gameSurfaceView.update();
                    updateCount++;
                    gameSurfaceView.draw(canvas);                }
            //}catch (IllegalArgumentException e){
            //    e.printStackTrace();
            //}finally {
                if(!running) break;
                if(canvas != null){
                    //try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        frameCount++;
                    //}catch (Exception e){
                    //    e.printStackTrace();
                    //}
                }
            //}
            elapsedTime = System.currentTimeMillis() - startTime;
            sleepTime = (long)(updateCount * UPS_PERIOD - elapsedTime);             // może lepiej by było zamienić = na +=
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
                sleepTime = (long) (updateCount * UPS_PERIOD - elapsedTime);        // dla sleepTime = 10
            }
            elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime >= 1000){
                averageUPS = updateCount / (1E-3 * elapsedTime);
                averageFPS = frameCount / (1E-3 * elapsedTime);
                updateCount = 0;
                frameCount = 0;
                startTime = System.currentTimeMillis();                             // += 1000 -> dla np 1005 tracimy 5 ms
            }
        }
    }
}
