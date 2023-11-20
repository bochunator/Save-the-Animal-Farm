package bochunator.savetheanimalfarm.dynamic;

import bochunator.savetheanimalfarm.asset.EnemyAsset;
import bochunator.savetheanimalfarm.asset.FireAsset;
import bochunator.savetheanimalfarm.object.Circle;
import bochunator.savetheanimalfarm.stats.Coins;
import bochunator.savetheanimalfarm.utilities.Screen;

public class Enemy extends Circle {
    private final EnemyAsset enemyAsset;
    private FireAsset fireAsset;
    private int fireBitmapCounter;
    private final float verticalVelocity;
    private final float distance;
    private boolean active;
    public Enemy(float diameter) {
        super(diameter);
        enemyAsset = EnemyAsset.getRandom();
        float secondsToReachGround = 3f;
        distance = 6f / 7 * Screen.INSTANCE.getHeight() - diameter/2;
        verticalVelocity = distance / (Screen.INSTANCE.getRefreshRate() * secondsToReachGround);
        fireAsset = FireAsset.getRandom();
    }
    public EnemyAsset getEnemyAsset() {
        return enemyAsset;
    }
    public FireAsset getFireAsset() {
        return fireAsset;
    }
    public int getNextFireBitmapCounter() {
        fireBitmapCounter++;
        if (fireBitmapCounter >= 60) {
            fireBitmapCounter = 0;
        }
        return fireBitmapCounter;
    }
    public void update(float timeMultiplier) {
        y += verticalVelocity * timeMultiplier;
        if (y >= distance) {
            active = false;
            Coins.INSTANCE.gain();
        }
    }
    public void activate() {
        active = true;
        x = (float) (Math.random() * (Screen.INSTANCE.getWidth() - diameter) + diameter/2);
        y = -diameter / 2;
        fireAsset = FireAsset.getRandom();
    }
    public void deactivate() {
        active = false;
    }
    public boolean isActive() {
        return active;
    }
}
