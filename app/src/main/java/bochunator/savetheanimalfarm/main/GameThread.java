package bochunator.savetheanimalfarm.main;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Toast;

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
        float secondToNanoseconds = 1_000_000_000;
        float framePeriodInNanoseconds = secondToNanoseconds / Screen.INSTANCE.getRefreshRate();
        float elapsedTimeMultiplier = 1f / framePeriodInNanoseconds;
        while (isRunning) {
            long deltaTime = elapsedTimeNanos;
            if (deltaTime > 0) {
                Canvas canvas = surfaceHolder.lockHardwareCanvas();
                elapsedTimeNanos -= deltaTime;
                objectsManager.render(elapsedTimeMultiplier * deltaTime , canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
        Log.d("MYTAG", "run: executed hhahahahah");
    }
}
