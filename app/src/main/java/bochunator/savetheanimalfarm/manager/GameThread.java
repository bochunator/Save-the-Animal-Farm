package bochunator.savetheanimalfarm.manager;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import bochunator.savetheanimalfarm.utilities.Screen;

public class GameThread extends Thread {
    private final ObjectsManager objectsManager;
    private final SurfaceHolder surfaceHolder;
    private static boolean isRunning;
    private long elapsedTimeNanos;
    public GameThread(ObjectsManager objectsManager, SurfaceHolder surfaceHolder) {
        this.objectsManager = objectsManager;
        this.surfaceHolder = surfaceHolder;
    }
    public static void setIsRunning(boolean isRunning) {
        GameThread.isRunning = isRunning;
    }
    public void addElapsedTimeNanos(long elapsedTimeNanos) {
        this.elapsedTimeNanos += elapsedTimeNanos;
    }
    @Override
    public void run() {
        isRunning = true;
        int fast = 3;
        float secondToNanoseconds = 1_000_000_000;
        float framePeriodInNanoseconds = secondToNanoseconds / Screen.INSTANCE.getRefreshRate();
        float elapsedTimeMultiplier = 1f / framePeriodInNanoseconds;
        while (isRunning) {
            long deltaTime = elapsedTimeNanos;
            if (deltaTime > 0 || fast > 0) {
                Canvas canvas = surfaceHolder.lockHardwareCanvas();
                elapsedTimeNanos -= deltaTime;
                objectsManager.render(elapsedTimeMultiplier * deltaTime , canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
                fast--;
            }
        }
    }
}
