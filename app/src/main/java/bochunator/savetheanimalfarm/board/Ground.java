package bochunator.savetheanimalfarm.board;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.asset.GroundAsset;
import bochunator.savetheanimalfarm.bitmap.BitmapConfigurator;
import bochunator.savetheanimalfarm.utilities.Screen;

public enum Ground implements BitmapConfigurator {
    INSTANCE;
    private Bitmap bitmap;
    private float y;
    public Ground update(@NonNull GroundAsset groundAsset, @NonNull Context context) {
        bitmap = Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), groundAsset.getResourceId(), getOptions()),
                Screen.INSTANCE.getWidth(),
                (int) (0.14f * Screen.INSTANCE.getHeight()),
                true
        );
        y = 0.86f * Screen.INSTANCE.getHeight();
        return INSTANCE;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }
    public void render(@NonNull Canvas canvas) {
        canvas.drawBitmap(bitmap, 0, y, null);
    }
}
