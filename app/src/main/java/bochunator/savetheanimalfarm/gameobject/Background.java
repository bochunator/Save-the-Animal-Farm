package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapBackground;

public class Background extends GameObject{
    private final Bitmap bitmap;
    public Background(Context context, double deviceWidth, double deviceHeight) {
        super(0, 0, deviceWidth, deviceHeight);
        CreatorBitmapBackground creatorBitmapBackground = new CreatorBitmapBackground();
        bitmap = creatorBitmapBackground.getCreatorRandomBitmapBackground(context, (int) deviceHeight);
        if(deviceWidth < bitmap.getWidth()){
            positionX = Math.random() * (deviceWidth - bitmap.getWidth());
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, (float) getPositionX(), (float) getPositionY(), null);
    }
}
