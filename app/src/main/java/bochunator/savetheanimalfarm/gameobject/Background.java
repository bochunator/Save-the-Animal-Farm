package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.asset.BackgroundAsset;
import bochunator.savetheanimalfarm.bitmap.BackgroundBitmap;

public class Background extends Entity{
    private Bitmap bitmap;
    public Background(Context context) {
        BackgroundBitmap backgroundBitmap = new BackgroundBitmap();
        bitmap = backgroundBitmap.createBitmap(BackgroundAsset.BACKGROUND_EMPTY, context);
    }
    public void draw(@NonNull Canvas canvas) {
        canvas.drawBitmap(bitmap, getX(), getY(), null);
    }
}
