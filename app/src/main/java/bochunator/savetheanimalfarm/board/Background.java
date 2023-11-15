package bochunator.savetheanimalfarm.board;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.asset.BackgroundAsset;
import bochunator.savetheanimalfarm.bitmap.BitmapConfigurator;
import bochunator.savetheanimalfarm.utilities.Screen;

public enum Background implements BitmapConfigurator {
    INSTANCE;
    private Bitmap bitmap;
    public Background update(@NonNull BackgroundAsset backgroundAsset, @NonNull Context context) {
        bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), backgroundAsset.getResourceId(), getOptions()),
                Screen.INSTANCE.getWidth(),
                (int) (0.861f * Screen.INSTANCE.getHeight()),
                true
        );
        return INSTANCE;
    }
    public void render(@NonNull Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, 0, null);
    }
}
