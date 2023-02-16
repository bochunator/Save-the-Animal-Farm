package bochunator.savetheanimalfarm.gameobject;

import static bochunator.savetheanimalfarm.bitmap.CreatorBitmapExplosions.NUMBER_OF_EXPLOSION_FRAMES;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Explosion extends Coordinate {
    private Bitmap [] bitmaps;
    public int iterator = 0;
    public Explosion(int width, double positionX, double positionY, Bitmap [] bitmaps) {
        super(positionX - width/12, positionY - width/12);
        this.bitmaps = bitmaps;
    }

    public boolean readyToRemove() {
        return iterator >= NUMBER_OF_EXPLOSION_FRAMES;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmaps[iterator], (float) positionX, (float) positionY, null);
    }

    public void update() {
        iterator++;
    }
}
