package bochunator.savetheanimalfarm.gameobject;

import static bochunator.savetheanimalfarm.GameThread.MAX_UPS;
import static bochunator.savetheanimalfarm.bitmap.CreatorBitmapPlanets.ZOOM;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;

public class Enemy extends GameObjectRadius{
    private final Bitmap bitmapPlanet;
    //private final Bitmap [] bitmapFloatingExplosions;
    private final Bitmap [] fireballBitmap;
    private static int updatesUntilNextSpawn = 0;
    private final double velocityVertical;

    private int iteratorFloatingExplosion = 0;
    private int updatesUntilChangeIteratorFloatingExplosion = 0;
    private Paint paint;

    public Enemy(Context context, double deviceWidth, double deviceHeight, Bitmap bitmapPlanet, Bitmap [] fireballBitmap) {
        super(
                Math.random()*(deviceWidth - deviceWidth / 6)+deviceWidth / 12,
                -deviceWidth/12 - Math.random()*deviceHeight,
                deviceWidth,
                deviceHeight,
                deviceWidth/12
        );
        this.bitmapPlanet = bitmapPlanet;
        this.fireballBitmap = fireballBitmap;
        double SECONDS_TO_REACH_GROUND = 3;
        velocityVertical = deviceHeight / (MAX_UPS * SECONDS_TO_REACH_GROUND);
        updatesUntilNextSpawn = (int) (Math.random()*MAX_UPS);
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.enemy));
    }

    public static boolean readyToSpawn() {
        if(updatesUntilNextSpawn <= 0){
            return true;
        }
        updatesUntilNextSpawn--;
        return false;
    }

    public void draw(Canvas canvas){
        //canvas.drawBitmap(fireballBitmap[iteratorFloatingExplosion], (float) (positionX - radius), (float) (positionY - 6 * radius), null);
        //canvas.drawBitmap(bitmapPlanet, (float) (positionX - radius * ZOOM), (float) (positionY - radius * ZOOM), null);
        canvas.drawCircle((float) positionX, (float) positionY, (float) (deviceWidth/12), paint);
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

            //if(CreatorBitmapFloatingExplosions.NUMBER_OF_FLOATING_EXPLOSION_FRAMES <= iteratorFloatingExplosion){
            if(iteratorFloatingExplosion == 60){
                iteratorFloatingExplosion = 0;
            }
        }
    }
    public void goToSky() {
        setPositionX(Math.random()*(deviceWidth - deviceWidth / 6)+deviceWidth / 12);
        setPositionY(-deviceWidth/12 - Math.random()*deviceHeight);
    }
}
