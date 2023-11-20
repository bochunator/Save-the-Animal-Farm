package bochunator.savetheanimalfarm.stats;

import android.content.Context;
import android.graphics.Canvas;

public class Stats {
    private final Hearts hearts;
    private final Coins coins;
    public Stats(Context context) {
        hearts = Hearts.INSTANCE;
        hearts.setHealthPoints(3);
        coins = Coins.INSTANCE.update(context);
    }
    public void render(Canvas canvas) {
        hearts.render(canvas);
        coins.render(canvas);
    }
}
