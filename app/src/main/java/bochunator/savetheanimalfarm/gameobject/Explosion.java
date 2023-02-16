package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;

public class Explosion extends Coordinate {
    public static final int NUMBER_OF_FRAMES = 5;
    public int iterator;
    private boolean smoke;
    public Explosion(Context context, int width, double positionX, double positionY) {
        super(positionX - width/12, positionY - width/12);
        iterator = 0;
        smoke = 1 == (int)(Math.random()*2);
    }

    public boolean isSmoke() {
        return smoke;
    }
}
