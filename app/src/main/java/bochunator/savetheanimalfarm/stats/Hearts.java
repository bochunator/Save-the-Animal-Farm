package bochunator.savetheanimalfarm.stats;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.bitmap.BitmapConfigurator;
import bochunator.savetheanimalfarm.utilities.Screen;

public enum Hearts implements BitmapConfigurator {
    INSTANCE;
    private Bitmap bitmap;
    private int healthPoints;
    public int getHealthPoints() {
        return healthPoints;
    }
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public Hearts update(@NonNull Context context) {
        Bitmap resourceBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart, getOptions());
        bitmap = Bitmap.createScaledBitmap(
                resourceBitmap,
                Screen.INSTANCE.getWidth() / 15 * resourceBitmap.getWidth() / resourceBitmap.getHeight(),
                Screen.INSTANCE.getWidth() / 15,
                true
        );
        return INSTANCE;
    }
    public void render(@NonNull Canvas canvas) {
        for (int i = healthPoints; i > 0; i--) {
            canvas.drawBitmap(
                    bitmap,
                    Screen.INSTANCE.getWidth() - i * bitmap.getWidth() * 1.1f,
                    bitmap.getHeight() * .1f,
                    null
            );
        }
    }
    public void decrementHealthPoints() {
        healthPoints--;
    }
}
