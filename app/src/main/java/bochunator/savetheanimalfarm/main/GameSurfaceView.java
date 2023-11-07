package bochunator.savetheanimalfarm.main;

import static android.graphics.PixelFormat.RGB_565;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.gameobject.Performance;
import bochunator.savetheanimalfarm.manager.GameManager;
import bochunator.savetheanimalfarm.utilities.DeviceMetrics;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private final GameManager gameManager;
    public GameSurfaceView(Context context) {
        super(context);
        setFocusable(true);
        getHolder().addCallback(this);
        getHolder().setFormat(RGB_565);
        getHolder().setKeepScreenOn(true);
        DeviceMetrics.init(context);
        Performance.init(context);
        gameManager = new GameManager(context, getHolder());
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        gameManager.startGameLoop();

    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        gameManager.interruptLoop();
    }
}
