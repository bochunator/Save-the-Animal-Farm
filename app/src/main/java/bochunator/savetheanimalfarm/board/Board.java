package bochunator.savetheanimalfarm.board;

import android.content.Context;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.asset.BackgroundAsset;
import bochunator.savetheanimalfarm.asset.GroundAsset;
import bochunator.savetheanimalfarm.utilities.DataManager;

public class Board {
    private final Background background;
    private final Ground ground;
    public Board(@NonNull Context context) {
        background = Background.INSTANCE;
        if (DataManager.INSTANCE.getEnum(context.getString(R.string.saved_background), BackgroundAsset.ALL_BACKGROUNDS, BackgroundAsset.class).isLocked()) {
            background.update(BackgroundAsset.getRandom(), context);
        }
        ground = Ground.INSTANCE.update(GroundAsset.getRandom(), context);
    }
    public void render(Canvas canvas) {
        background.render(canvas);
        ground.render(canvas);
    }
}
