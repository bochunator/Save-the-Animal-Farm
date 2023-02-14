package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapExplosions extends BitmapFactoryOptions{
    private final Bitmap explosionBitmap1;
    private final Bitmap explosionBitmap2;
    private final Bitmap explosionBitmap3;
    private final Bitmap explosionBitmap4;
    private final Bitmap explosionBitmap5;
    private final Bitmap explosionSmokeBitmap1;
    private final Bitmap explosionSmokeBitmap2;
    private final Bitmap explosionSmokeBitmap3;
    private final Bitmap explosionSmokeBitmap4;
    private final Bitmap explosionSmokeBitmap5;

    private Context context;
    private int deviceWidth;

    public CreatorBitmapExplosions(Context context, int deviceWidth) {
        this.context = context;
        this.deviceWidth = deviceWidth;

        explosionBitmap1 = getBitmapCreateScaledBitmap(R.drawable.explosion1);
        explosionBitmap2 = getBitmapCreateScaledBitmap(R.drawable.explosion2);
        explosionBitmap3 = getBitmapCreateScaledBitmap(R.drawable.explosion3);
        explosionBitmap4 = getBitmapCreateScaledBitmap(R.drawable.explosion4);
        explosionBitmap5 = getBitmapCreateScaledBitmap(R.drawable.explosion5);
        explosionSmokeBitmap1 = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke1);
        explosionSmokeBitmap2 = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke2);
        explosionSmokeBitmap3 = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke3);
        explosionSmokeBitmap4 = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke4);
        explosionSmokeBitmap5 = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke5);
    }

    public Bitmap getExplosion(int iterator){
        switch (iterator){
            case 0: return explosionBitmap1;
            case 1: return explosionBitmap2;
            case 2: return explosionBitmap3;
            case 3: return explosionBitmap4;
            case 4: return explosionBitmap5;
            default: return null;
        }
    }

    public Bitmap getExplosionSmoke(int iterator){
        switch (iterator){
            case 0: return explosionSmokeBitmap1;
            case 1: return explosionSmokeBitmap2;
            case 2: return explosionSmokeBitmap3;
            case 3: return explosionSmokeBitmap4;
            case 4: return explosionSmokeBitmap5;
            default: return null;
        }
    }

    private Bitmap getBitmapCreateScaledBitmap(int rDrawableExplosion){
        return Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), rDrawableExplosion, bitmapFactoryOptions),
                deviceWidth / 6,
                deviceWidth / 6,
                false
        );
    }
}
