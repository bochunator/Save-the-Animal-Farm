package bochunator.savetheanimalfarm.thread;

import static bochunator.savetheanimalfarm.thread.ThreadConstants.*;

import bochunator.savetheanimalfarm.gameobject.Performance;
import bochunator.savetheanimalfarm.manager.GameUpdate;

public class UpdateThread extends Thread {
    private final GameUpdate gameUpdate;
    private final RenderThread renderThread;
    private boolean running;
    public UpdateThread(GameUpdate gameUpdate, RenderThread renderThread) {
        this.gameUpdate = gameUpdate;
        this.renderThread = renderThread;
    }
    public void setRunning(boolean running) {
        this.running = running;
    }
    @Override
    public void run() {
        running = true;
        long currentTime;
        long elapsedTime;
        long previousTime = System.nanoTime() - TARGET_FRAME_PERIOD;
        long previousSecondTime = System.nanoTime();
        int updateCount = 0;
        while (running) {
            currentTime = System.nanoTime();
            elapsedTime = currentTime - previousTime;
            if (TARGET_FRAME_PERIOD <= elapsedTime) {
                previousTime += elapsedTime;
                gameUpdate.advanceGameState(TIME_SCALE * elapsedTime);
                updateCount++;
                renderThread.setShouldRender(true);
            }
            elapsedTime = currentTime - previousSecondTime;
            if (elapsedTime >= SECOND_TO_NANOSECOND) {
                previousSecondTime += elapsedTime;
                Performance.setAverageUPS(updateCount);
                updateCount = 0;
            }
        }
    }
}
