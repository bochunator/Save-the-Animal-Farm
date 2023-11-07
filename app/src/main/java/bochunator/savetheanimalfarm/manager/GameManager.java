package bochunator.savetheanimalfarm.manager;

import android.content.Context;
import android.view.SurfaceHolder;

import bochunator.savetheanimalfarm.thread.RenderThread;
import bochunator.savetheanimalfarm.thread.UpdateThread;

public class GameManager {
    private final RenderThread renderThread;
    private final UpdateThread updateThread;
    public GameManager(Context context, SurfaceHolder surfaceHolder) {
        ObjectManager objectManager = new ObjectManager(context);
        GameRender gameRender = new GameRender(objectManager);
        GameUpdate gameUpdate = new GameUpdate(objectManager);
        renderThread = new RenderThread(gameRender, surfaceHolder);
        updateThread = new UpdateThread(gameUpdate, renderThread);
    }
    public void startGameLoop() {
        updateThread.start();
        renderThread.start();
    }
    public void interruptLoop() {
        renderThread.setRunning(false);
        updateThread.setRunning(false);
        try {
            renderThread.join();
            updateThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
