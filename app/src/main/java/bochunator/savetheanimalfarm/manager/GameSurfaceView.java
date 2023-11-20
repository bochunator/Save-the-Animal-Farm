package bochunator.savetheanimalfarm.manager;

import static android.graphics.PixelFormat.RGB_565;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.activity.MainActivity;
import bochunator.savetheanimalfarm.stats.Coins;
import bochunator.savetheanimalfarm.utilities.Screen;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Choreographer.FrameCallback {
    private final ObjectsManager objectsManager;
    private GameThread gameThread;
    private long lastFrameTimeNanos;
    public GameSurfaceView(Context context) {
        super(context);
        Screen.INSTANCE.update(context);
        if (Screen.INSTANCE.isSizeChanged()) {
            Intent intent = new Intent(context, MainActivity.class);
            intent.putExtra(context.getString(R.string.start_background_activity), true);
            context.startActivity(intent);
            ((Activity) context).finish();
        }
        setFocusable(true);
        getHolder().addCallback(this);
        getHolder().setKeepScreenOn(true);
        getHolder().setFormat(RGB_565);
        objectsManager = new ObjectsManager(context);
    }
    @Override
    public void doFrame(long frameTimeNanos) {
        gameThread.addElapsedTimeNanos(frameTimeNanos - lastFrameTimeNanos);
        lastFrameTimeNanos = frameTimeNanos;
        Choreographer.getInstance().postFrameCallback(this);
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        lastFrameTimeNanos = System.nanoTime();
        Choreographer.getInstance().postFrameCallback(this);
        gameThread = new GameThread(objectsManager, getHolder());
        gameThread.start();
    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        Coins.INSTANCE.save();
        GameThread.setIsRunning(false);
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        objectsManager.onTouchEvent(event);
        return true;
    }
}
