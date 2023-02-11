package bochunator.savetheanimalfarm.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class BitmapFactoryOptions {
    protected final BitmapFactory.Options bitmapFactoryOptions;

    public BitmapFactoryOptions() {
        bitmapFactoryOptions = new BitmapFactory.Options();
        bitmapFactoryOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    }
}
