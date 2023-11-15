package bochunator.savetheanimalfarm.stats;

import android.content.Context;
import android.graphics.Canvas;

import bochunator.savetheanimalfarm.utilities.Screen;

public class Stats {
    private Hearts hearts;
    private Coins coins;
    public Stats(Context context) {
        hearts = Hearts.INSTANCE;
        if (Screen.INSTANCE.isSizeChanged()) {
            hearts = Hearts.INSTANCE.update(context);
        }
        hearts.setHealthPoints(3);
        coins = Coins.INSTANCE.update(context);
    }
    public void render(Canvas canvas) {
        hearts.render(canvas);
        coins.render(canvas);
    }
}
