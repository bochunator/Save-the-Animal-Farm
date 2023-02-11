package bochunator.savetheanimalfarm.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class BitmapFactoryOptions {
    protected final BitmapFactory.Options bitmapFactoryOptions;

    public BitmapFactoryOptions() {
        bitmapFactoryOptions = new BitmapFactory.Options();
        bitmapFactoryOptions.inPreferredConfig = Bitmap.Config.RGB_565; // Transparency is in ARGB_8888, RGB_565 is lighter version without transparency
        bitmapFactoryOptions.inScaled = false; // Default is true, and then bitmap width and high are gained by device density
    }
}
