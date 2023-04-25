package bochunator.savetheanimalfarm.gameinterface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.bitmap.BitmapFactoryOptions;

public class Health extends BitmapFactoryOptions {
    private final int maxHealth;
    private int healthPoints;
    private Bitmap bitmap;
    private final double deviceWidth;

    public Health(Context context, double deviceWidth, int maxHealth) {
        this.maxHealth = healthPoints = maxHealth;
        this.deviceWidth = deviceWidth;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart, bitmapFactoryOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap, (int) deviceWidth/15 * bitmap.getWidth()/bitmap.getHeight(), (int) deviceWidth/15, true);
    }

    public void draw(Canvas canvas) {
        for (int i = healthPoints; i > 0; i--) {
            canvas.drawBitmap(bitmap, (float) (deviceWidth - i * bitmap.getWidth() * 1.1f) , (float) bitmap.getHeight() * .1f, null);
        }
    }

    public void decrementHealthPoints() {
        healthPoints--;
    }

    public boolean isGameOver(){
        return healthPoints <= 0;
    }

    public void newGame() {
        healthPoints = maxHealth;
    }
}
