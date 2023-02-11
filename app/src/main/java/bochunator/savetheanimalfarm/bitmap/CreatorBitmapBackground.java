package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapBackground extends BitmapFactoryOptions{
    public final int NUMBER_OF_BACKGROUNDS = 8;
    public final int backgroundCastles = R.drawable.background_castles;
    public final int backgroundColorDesert = R.drawable.background_color_desert;
    public final int backgroundColorFall = R.drawable.background_color_fall;
    public final int backgroundDesert = R.drawable.background_desert;
    public final int backgroundColorForest = R.drawable.background_color_forest;
    public final int backgroundColorGrass = R.drawable.background_color_grass;
    public final int backgroundEmpty = R.drawable.background_empty;
    public final int backgroundForest = R.drawable.background_forest;

    public Bitmap getCreatorRandomBitmapBackground(Context context, int deviceHeight){
        int[] array = new int[NUMBER_OF_BACKGROUNDS];
        array[0] = backgroundCastles;
        array[1] = backgroundColorDesert;
        array[2] = backgroundColorFall;
        array[3] = backgroundDesert;
        array[4] = backgroundColorForest;
        array[5] = backgroundColorGrass;
        array[6] = backgroundEmpty;
        array[7] = backgroundForest;
        return Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), array[(int) (Math.random()*NUMBER_OF_BACKGROUNDS)], bitmapFactoryOptions),
                deviceHeight,
                deviceHeight,
                true
        );
    }
}
