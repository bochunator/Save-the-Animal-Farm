package bochunator.savetheanimalfarm.gameobject;

import static bochunator.savetheanimalfarm.GameThread.MAX_UPS;
import static bochunator.savetheanimalfarm.bitmap.CreatorBitmapPlanets.ZOOM;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapFloatingExplosions;

public class Enemy extends GameObjectRadius{
    private Bitmap bitmap;
    private static int updatesUntilNextSpawn = 0;
    private double velocityVertical;

    private int iteratorFloatingExplosion = 0;

    public Enemy(Context context, double deviceWidth, double deviceHeight, Bitmap bitmap) {
        super(
                Math.random()*(deviceWidth - 2 * deviceWidth/12)+deviceWidth/12,
                -deviceWidth/12,
                deviceWidth,
                deviceHeight,
                deviceWidth/12,
                ContextCompat.getColor(context, R.color.enemy)
        );
        this.bitmap = bitmap;
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

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap, (float) (x - radius * ZOOM), (float) (y - radius * ZOOM), null);
    }

    public void update() {
        y += velocityVertical;
        iteratorFloatingExplosion++;
        if(CreatorBitmapFloatingExplosions.NUMBER_OF_FRAMES <= iteratorFloatingExplosion){
            iteratorFloatingExplosion = 0;
        }
    }

    public boolean readyToRemove() {
        return y > boardHeight - getRadius();
    }

    public int getIteratorFloatingExplosion() {
        return iteratorFloatingExplosion;
    }
}
