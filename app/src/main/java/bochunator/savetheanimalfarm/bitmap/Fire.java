package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import bochunator.savetheanimalfarm.asset.FireAsset;

public enum Fire implements BitmapConfigurator {
    INSTANCE;
    public static final int COLUMNS = 9;
    public static final int ROWS = 7;
    public static final int NUMBER_OF_FRAMES = 60;
    private EnumMap<FireAsset, List<Bitmap>> fireBitmaps;
    private int offsetWidth;
    private int offsetHeight;
    public Fire update(int diameter, Context context) {
        fireBitmaps = new EnumMap<>(FireAsset.class);
        fireBitmaps.put(FireAsset.FIRE_BLUE, create(FireAsset.FIRE_BLUE, diameter, context));
        fireBitmaps.put(FireAsset.FIRE_GREEN, create(FireAsset.FIRE_GREEN, diameter, context));
        fireBitmaps.put(FireAsset.FIRE_NORMAL, create(FireAsset.FIRE_NORMAL, diameter, context));
        fireBitmaps.put(FireAsset.FIRE_PURPLE, create(FireAsset.FIRE_PURPLE, diameter, context));
        offsetWidth = diameter / 2;
        offsetHeight = (int) (fireBitmaps.get(FireAsset.FIRE_NORMAL).get(0).getHeight() - diameter / 1.5);
        return INSTANCE;
    }
    public void render(@NonNull FireAsset fireAsset, int number, int x, int y, @NonNull Canvas canvas) {
        canvas.drawBitmap(fireBitmaps.get(fireAsset).get(number), x - offsetWidth, y - offsetHeight, null);
    }
    @NonNull
    private List<Bitmap> create(FireAsset fireAsset, int diameter, @NonNull Context context) {
        List<Bitmap> returnBitmaps = new ArrayList<>();
        Bitmap resourceBitmap = BitmapFactory.decodeResource(context.getResources(), fireAsset.getResourceId(), getOptions());
        int width = diameter * COLUMNS;
        int height = width * COLUMNS * resourceBitmap.getHeight() / (ROWS * resourceBitmap.getWidth());
        Bitmap scalledBitmap = Bitmap.createScaledBitmap(resourceBitmap, width, height, true);
        int bitmapWidth = scalledBitmap.getWidth() / COLUMNS;
        int bitmapHeight = scalledBitmap.getHeight() / ROWS;
        for (int i=0, r=0, c=0; i < NUMBER_OF_FRAMES; i++, r=i/COLUMNS, c=i%COLUMNS) {
            returnBitmaps.add(Bitmap.createBitmap(scalledBitmap, bitmapWidth * c, bitmapHeight * r, bitmapWidth, bitmapHeight));
        }
        return returnBitmaps;
    }
}
