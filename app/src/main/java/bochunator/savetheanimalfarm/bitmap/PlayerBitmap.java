package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.asset.PlayerAsset;

public enum PlayerBitmap implements BitmapConfigurator {
    INSTANCE;
    private Bitmap bitmap;
    private int offsetWidth;
    private int offsetHeight;
    public static Bitmap getBitmap(@NonNull PlayerAsset playerAsset, @NonNull Context context) {
        return BitmapFactory.decodeResource(context.getResources(), playerAsset.getResourceId());
    }
    public PlayerBitmap update(@NonNull PlayerAsset playerAsset, int width, int height, @NonNull Context context) {
        Bitmap resourceBitmap = BitmapFactory.decodeResource(context.getResources(), playerAsset.getResourceId(), getOptions());
        bitmap = Bitmap.createScaledBitmap(
                resourceBitmap,
                width * resourceBitmap.getWidth() / playerAsset.getCollisionWidth(),
                height * resourceBitmap.getHeight() / playerAsset.getCollisionHeight(),
                true
        );
        offsetWidth = playerAsset.getOffsetWidth() * width / playerAsset.getCollisionWidth();
        offsetHeight = playerAsset.getOffsetHeight() * height / playerAsset.getCollisionHeight();
        return INSTANCE;
    }
    public void render(@NonNull Canvas canvas, float x, float y) {
        canvas.drawBitmap(bitmap, x - offsetWidth, y - offsetHeight, null);
    }
}
