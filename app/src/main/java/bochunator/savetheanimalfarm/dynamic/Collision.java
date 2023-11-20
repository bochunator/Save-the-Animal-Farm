package bochunator.savetheanimalfarm.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.activity.GameOverActivity;
import bochunator.savetheanimalfarm.manager.GameThread;
import bochunator.savetheanimalfarm.object.Circle;
import bochunator.savetheanimalfarm.object.Rectangle;
import bochunator.savetheanimalfarm.stats.Coins;
import bochunator.savetheanimalfarm.stats.Hearts;

public class Collision {
    private final Context context;
    private final Player player;
    private final EnemyManager enemyManager;
    public Collision(Player player, EnemyManager enemyManager, Context context) {
        this.player = player;
        this.enemyManager = enemyManager;
        this.context = context;
    }
    public void update() {
        for (Enemy e : enemyManager.getEnemies()) {
            if(e.isActive() && isColliding(player, e)) {
                Hearts.INSTANCE.decrementHealthPoints();
                if (0 >= Hearts.INSTANCE.getHealthPoints()) {
                    GameThread.setIsRunning(false);
                    Coins.INSTANCE.save();
                    context.startActivity(new Intent(context, GameOverActivity.class));
                    ((Activity) context).finish();
                }
                e.deactivate();
            }
        }
    }
    private boolean isColliding(@NonNull Rectangle rectangle, @NonNull Circle circle) {
        float distanceY = Math.abs(rectangle.getY() + rectangle.getHeight()/2 - circle.getY());
        float distanceX = Math.abs(rectangle.getX() + rectangle.getWidth()/2 - circle.getX());
        if (distanceY > rectangle.getHeight()/2 + circle.getDiameter()/2)
            return false;
        if (distanceX > rectangle.getWidth()/2 + circle.getDiameter()/2)
            return false;
        if (distanceY <= rectangle.getHeight()/2)
            return true;
        if (distanceX <= rectangle.getWidth()/2)
            return true;
        double distance = Math.pow(distanceY - rectangle.getHeight()/2, 2) + Math.pow(distanceX - rectangle.getWidth()/2, 2);
        return distance <= Math.pow(circle.getDiameter()/2, 2);
    }
}
