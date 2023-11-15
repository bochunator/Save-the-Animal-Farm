package bochunator.savetheanimalfarm.main;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.board.Board;
import bochunator.savetheanimalfarm.dynamic.Dynamic;
import bochunator.savetheanimalfarm.stats.Stats;

public class ObjectsManager {
    private final Board board;
    private final Stats stats;
    private final Dynamic dynamic;
    public ObjectsManager(Context context) {
        board = new Board(context);
        stats = new Stats(context);
        dynamic = new Dynamic(context);
    }
    public void render(float timeMultiplier, Canvas canvas) {
        board.render(canvas);
        dynamic.render(timeMultiplier, canvas);
        stats.render(canvas);
    }
    public void onTouchEvent(@NonNull MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                //
            } break;
            case MotionEvent.ACTION_MOVE: {
                dynamic.getPlayer().setX(event.getX());
            } break;
        }
    }
}
