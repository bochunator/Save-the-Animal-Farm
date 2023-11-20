package bochunator.savetheanimalfarm.dynamic;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

import bochunator.savetheanimalfarm.bitmap.EnemyBitmap;
import bochunator.savetheanimalfarm.bitmap.Fire;
import bochunator.savetheanimalfarm.utilities.Screen;

public class EnemyManager {
    private final List<Enemy> enemies;
    private final EnemyBitmap enemyBitmap;
    private final Fire fire;
    private int updatesUntilNextSpawn;
    private final float diameter;
    public EnemyManager() {
        diameter = Screen.INSTANCE.getWidth() / 6f;
        enemies = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            enemies.add(new Enemy(diameter));
        }
        enemyBitmap = EnemyBitmap.INSTANCE;
        fire = Fire.INSTANCE;
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
                fire.render(e.getFireAsset(), e.getNextFireBitmapCounter(), (int) e.getX(), (int) e.getY(), canvas);
                enemyBitmap.render(canvas, e.getEnemyAsset(), e.getX() - diameter/2, e.getY() - diameter/2);
            }
        }
    }
}
