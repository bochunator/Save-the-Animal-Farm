package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.asset.BackgroundAsset;
import bochunator.savetheanimalfarm.utilities.DeviceMetrics;

public class BackgroundBitmap implements BitmapConfigurator{
    public BackgroundBitmap() {
    }
    public Bitmap createBitmap(@NonNull BackgroundAsset backgroundAsset, Context context) {
        return Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), backgroundAsset.getResourceId(), getOptions()),
                DeviceMetrics.getWidth(),
                DeviceMetrics.getHeight(),
                true
        );
    }
}
