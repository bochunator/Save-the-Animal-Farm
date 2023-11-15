package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import bochunator.savetheanimalfarm.asset.EnemyAsset;

public enum EnemyBitmap implements BitmapConfigurator {
    INSTANCE;
    private Map<EnemyAsset, Bitmap> bitmaps;
    public EnemyBitmap update(int diameter, Context context) {
        bitmaps = new HashMap<>();
        for (EnemyAsset e : EnemyAsset.values()) {
            Bitmap bitmap = Bitmap.createScaledBitmap(
                    BitmapFactory.decodeResource(context.getResources(), e.getResourceId(), getOptions()),
                    diameter,
                    diameter,
                    true
            );
            bitmaps.put(e, bitmap);
        }
        return INSTANCE;
    }
    public void render(@NonNull Canvas canvas, EnemyAsset enemyAsset, float x, float y) {
        canvas.drawBitmap(Objects.requireNonNull(bitmaps.get(enemyAsset)), x, y, null);
    }
}
