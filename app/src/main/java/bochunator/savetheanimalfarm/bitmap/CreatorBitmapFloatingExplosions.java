package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapFloatingExplosions extends BitmapFactoryOptions{
    public static final int NUMBER_OF_FRAMES = 6;
    private final Bitmap floatingExplosionBitmap1;
    private final Bitmap floatingExplosionBitmap2;
    private final Bitmap floatingExplosionBitmap3;
    private final Bitmap floatingExplosionBitmap4;
    private final Bitmap floatingExplosionBitmap5;
    private final Bitmap floatingExplosionBitmap6;

    private Context context;
    private int deviceWidth;

    public CreatorBitmapFloatingExplosions(Context context, int deviceWidth) {
        this.context = context;
        this.deviceWidth = deviceWidth;

        floatingExplosionBitmap1 = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_1);
        floatingExplosionBitmap2 = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_2);
        floatingExplosionBitmap3 = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_3);
        floatingExplosionBitmap4 = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_4);
        floatingExplosionBitmap5 = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_5);
        floatingExplosionBitmap6 = getBitmapCreateScaledBitmap(R.drawable.floating_explosion_6);
    }

    public Bitmap getFloatingExplosion(int iterator){
        switch (iterator){
            case 0: return floatingExplosionBitmap1;
            case 1: return floatingExplosionBitmap2;
            case 2: return floatingExplosionBitmap3;
            case 3: return floatingExplosionBitmap4;
            case 4: return floatingExplosionBitmap5;
            case 5: return floatingExplosionBitmap6;
            default: return null;
        }
    }

    private Bitmap getBitmapCreateScaledBitmap(int rDrawablePlanet){
        return Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), rDrawablePlanet, bitmapFactoryOptions),
                deviceWidth / 6,
                (int) (deviceWidth * 1.618 /3),
                false
        );
    }
}
