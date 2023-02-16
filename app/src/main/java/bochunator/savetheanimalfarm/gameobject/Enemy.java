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
    private final Bitmap bitmapPlanet;
    private final Bitmap [] bitmapFloatingExplosions;
    private static int updatesUntilNextSpawn = 0;
    private final double velocityVertical;

    private int iteratorFloatingExplosion = 0;
    private int updatesUntilChangeIteratorFloatingExplosion = 0;

    public Enemy(Context context, double deviceWidth, double deviceHeight, Bitmap bitmapPlanet, Bitmap [] bitmapFloatingExplosions) {
        super(
                Math.random()*(deviceWidth - deviceWidth / 6)+deviceWidth / 12,
                -deviceWidth/12,
                deviceWidth,
                deviceHeight,
                deviceWidth/12,
                ContextCompat.getColor(context, R.color.enemy)
        );
        this.bitmapPlanet = bitmapPlanet;
        this.bitmapFloatingExplosions = bitmapFloatingExplosions;
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
        canvas.drawBitmap(bitmapFloatingExplosions[iteratorFloatingExplosion], (float) (positionX - radius), (float) (positionY - 2 * radius), null);
        canvas.drawBitmap(bitmapPlanet, (float) (positionX - radius * ZOOM), (float) (positionY - radius * ZOOM), null);
    }

    public void update() {
        positionY += velocityVertical;
        moveIteratorFloatingExplosion();
    }

    public boolean readyToRemove() {
        return positionY > boardHeight - getRadius();
    }

    private void moveIteratorFloatingExplosion(){
        updatesUntilChangeIteratorFloatingExplosion++;

        if(updatesUntilChangeIteratorFloatingExplosion >= MAX_UPS / 20){

            updatesUntilChangeIteratorFloatingExplosion = 0;
            iteratorFloatingExplosion++;

            if(CreatorBitmapFloatingExplosions.NUMBER_OF_FLOATING_EXPLOSION_FRAMES <= iteratorFloatingExplosion){
                iteratorFloatingExplosion = 0;
            }
        }
    }
}
