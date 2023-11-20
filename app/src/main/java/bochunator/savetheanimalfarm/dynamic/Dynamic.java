package bochunator.savetheanimalfarm.dynamic;

import android.content.Context;
import android.graphics.Canvas;

public class Dynamic {
    private final Player player;
    private final EnemyManager enemyManager;
    private final Collision collision;
    public Dynamic(Context context) {
        player = new Player();
        enemyManager = new EnemyManager();
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
