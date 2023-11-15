package bochunator.savetheanimalfarm.dynamic;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import bochunator.savetheanimalfarm.bitmap.EnemyBitmap;
import bochunator.savetheanimalfarm.utilities.Screen;

public class EnemyManager {
    private final List<Enemy> enemies;
    private EnemyBitmap enemyBitmap;
    private int updatesUntilNextSpawn;
    private final float diameter;
    public EnemyManager(Context context) {
        diameter = Screen.INSTANCE.getWidth() / 6f;
        enemies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            //enemies.add(Enemy.createRandomEnemy(diameter));
            enemies.add(new Enemy(diameter));
        }
        enemyBitmap = EnemyBitmap.INSTANCE;
        if (Screen.INSTANCE.isSizeChanged()) {
            enemyBitmap = EnemyBitmap.INSTANCE.update((int) diameter, context);
        }
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public void render(float timeMultiplier, Canvas canvas) {
        if (0 >= updatesUntilNextSpawn--) {
            updatesUntilNextSpawn = (int) (Math.random() * Screen.INSTANCE.getRefreshRate());
            enemies.stream()
                    .filter(e -> !e.isActive())
                    .findFirst()
                    .ifPresent(Enemy::activate);
        }
        for (Enemy e : enemies) {
            if (e.isActive()) {
                e.update(timeMultiplier);
                enemyBitmap.render(canvas, e.getEnemyAsset(), e.getX() - diameter/2, e.getY() - diameter/2);
            }
        }
    }
}
