package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapExplosions extends BitmapFactoryOptions{
    public static final int NUMBER_OF_EXPLOSION_FRAMES = 5;
    private final Bitmap [] explosionBitmap;
    private final Bitmap [] explosionSmokeBitmap;

    private final Context context;
    private final int deviceWidth;

    public CreatorBitmapExplosions(Context context, int deviceWidth) {
        this.context = context;
        this.deviceWidth = deviceWidth;
        explosionBitmap = new Bitmap[5];
        explosionSmokeBitmap = new Bitmap[5];

        explosionBitmap[0] = getBitmapCreateScaledBitmap(R.drawable.explosion1);
        explosionBitmap[1] = getBitmapCreateScaledBitmap(R.drawable.explosion2);
        explosionBitmap[2] = getBitmapCreateScaledBitmap(R.drawable.explosion3);
        explosionBitmap[3] = getBitmapCreateScaledBitmap(R.drawable.explosion4);
        explosionBitmap[4] = getBitmapCreateScaledBitmap(R.drawable.explosion5);
        explosionSmokeBitmap[0] = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke1);
        explosionSmokeBitmap[1] = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke2);
        explosionSmokeBitmap[2] = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke3);
        explosionSmokeBitmap[3] = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke4);
        explosionSmokeBitmap[4] = getBitmapCreateScaledBitmap(R.drawable.explosion_smoke5);
    }

    public Bitmap[] getRandomBitmaps() {
        return 1 == (int)(Math.random()*2) ? explosionBitmap : explosionSmokeBitmap;
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
