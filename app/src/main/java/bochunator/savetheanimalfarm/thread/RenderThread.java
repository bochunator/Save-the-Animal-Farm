package bochunator.savetheanimalfarm.thread;

import static bochunator.savetheanimalfarm.thread.ThreadConstants.*;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import bochunator.savetheanimalfarm.gameobject.Performance;
import bochunator.savetheanimalfarm.manager.GameRender;

public class RenderThread extends Thread {
    private final SurfaceHolder surfaceHolder;
    private final GameRender gameRender;
    private boolean running;
    private boolean shouldRender;
    public RenderThread(GameRender gameRender, SurfaceHolder surfaceHolder) {
        this.gameRender = gameRender;
        this.surfaceHolder = surfaceHolder;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    public void setShouldRender(boolean shouldRender) {
        this.shouldRender = shouldRender;
    }
    @Override
    public void run() {
        running = true;
        long currentTime;
        long elapsedTime;
        long previousTime = System.nanoTime() - TARGET_FRAME_PERIOD;
        int frameCount = 0;
        while (running) {
            if (shouldRender) {
                frameCount++;
                Canvas canvas = surfaceHolder.lockHardwareCanvas();
                gameRender.draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
            currentTime = System.nanoTime();
            elapsedTime = currentTime - previousTime;
            if (elapsedTime >= SECOND_TO_NANOSECOND) {
                previousTime += elapsedTime;
                Performance.setAverageFPS(frameCount);
                frameCount = 0;
            }
        }
    }
}
