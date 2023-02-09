package bochunator.savetheanimalfarm.gameobject;

import static bochunator.savetheanimalfarm.GameThread.MAX_UPS;

import android.content.Context;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;

public class Enemy extends GameObjectRadius{
    private static int updatesUntilNextSpawn = 0;
    protected double velocityVertical;

    public Enemy(Context context, double deviceWidth, double deviceHeight) {
        super(
                Math.random()*(deviceWidth - 2 * deviceWidth/12)+deviceWidth/12,
                -deviceWidth/12,
                deviceWidth,
                deviceHeight,
                deviceWidth/12,
                ContextCompat.getColor(context, R.color.enemy)
        );
        double SECONDS_TO_REACH_GROUND = 3;
        velocityVertical = deviceHeight / (MAX_UPS * SECONDS_TO_REACH_GROUND);
        updatesUntilNextSpawn = (int) (Math.random()*MAX_UPS);
    }

    public static boolean readyToSpawn() {
        if(updatesUntilNextSpawn <= 0){
            return true;
        }
        updatesUntilNextSpawn--;
        return false;
    }

    public void update() {
        positionY += velocityVertical;
    }

    public boolean readyToRemove() {
        return positionY > boardHeight - getRadius();
    }
}
