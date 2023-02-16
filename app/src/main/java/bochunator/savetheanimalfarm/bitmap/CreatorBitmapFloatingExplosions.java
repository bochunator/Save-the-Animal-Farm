package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapFloatingExplosions extends BitmapFactoryOptions{
    public static final int NUMBER_OF_FLOATING_EXPLOSION_FRAMES = 6;
    private final Bitmap [] floatingExplosionBitmap;

    private final Context context;
    private final int deviceWidth;

    public CreatorBitmapFloatingExplosions(Context context, int deviceWidth) {
        this.context = context;
        this.deviceWidth = deviceWidth;

        floatingExplosionBitmap = new Bitmap[NUMBER_OF_FLOATING_EXPLOSION_FRAMES];
        floatingExplosionBitmap[0] = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_1);
        floatingExplosionBitmap[1] = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_2);
        floatingExplosionBitmap[2] = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_3);
        floatingExplosionBitmap[3] = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_4);
        floatingExplosionBitmap[4] = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_5);
        floatingExplosionBitmap[5] = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_6);
    }

    public Bitmap[] getFloatingExplosionBitmap() {
        return floatingExplosionBitmap;
    }

    private Bitmap getBitmapCreateScaledBitmap(int rDrawablePlanet){
        return Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), rDrawablePlanet, bitmapFactoryOptions),
                deviceWidth / 6,
                deviceWidth / 6,
                false
        );
    }
}
