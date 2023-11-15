package bochunator.savetheanimalfarm.dynamic;

import android.content.Context;
import android.graphics.Canvas;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.asset.PlayerAsset;
import bochunator.savetheanimalfarm.utilities.DataManager;

public class Dynamic {
    private final Player player;
    private final EnemyManager enemyManager;
    private final Collision collision;
    public Dynamic(Context context) {
        player = new Player(DataManager.INSTANCE.getEnum(context.getString(R.string.saved_player), PlayerAsset.PARROT, PlayerAsset.class), context);
        enemyManager = new EnemyManager(context);
        collision = new Collision(player, enemyManager, context);
    }
    public Player getPlayer() {
        return player;
    }
    public void render(float timeMultiplier, Canvas canvas) {
        player.render(canvas);
        enemyManager.render(timeMultiplier, canvas);
        collision.update();
    }
}
