package bochunator.savetheanimalfarm.board;

import android.content.Context;
import android.graphics.Canvas;

import bochunator.savetheanimalfarm.asset.BackgroundAsset;
import bochunator.savetheanimalfarm.asset.GroundAsset;

public class Board {
    private final Background background;
    private final Ground ground;
    public Board(Context context) {
        background = Background.INSTANCE.update(BackgroundAsset.getRandom(), context);
        ground = Ground.INSTANCE.update(GroundAsset.getRandom(), context);
    }
    public void render(Canvas canvas) {
        background.render(canvas);
        ground.render(canvas);
    }
}
