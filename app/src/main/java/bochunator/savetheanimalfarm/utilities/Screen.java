package bochunator.savetheanimalfarm.utilities;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.NonNull;

public enum Screen {
    INSTANCE;
    private int previousWidth;
    private int width;
    private int previousHeight;
    private int height;
    private float refreshRate;
    public void init(@NonNull Context context) {
        if (0 == width || 0 == height) {
            update(context);
        }
    }
    public Screen update(@NonNull Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Display display = windowManager.getDefaultDisplay();
            display.getMetrics(displayMetrics);
            width = displayMetrics.widthPixels;
            height = displayMetrics.heightPixels;
            refreshRate = display.getRefreshRate();
        }
        return INSTANCE;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public float getRefreshRate() {
        return refreshRate;
    }
    public boolean isSizeChanged() {
        return previousWidth != width || previousHeight != height;
    }
    public void bitmapSizesUpdated() {
        previousWidth = width;
        previousHeight = height;
    }
}
