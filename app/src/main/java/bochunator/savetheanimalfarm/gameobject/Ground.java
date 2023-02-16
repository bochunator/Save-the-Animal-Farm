package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapGround;

public class Ground extends GameObject{
    private final Bitmap bitmap;
    public Ground(Context context, int deviceWidth, int deviceHeight) {
        super(0, 0, deviceWidth, deviceHeight);
        CreatorBitmapGround creatorBitmapGround = new CreatorBitmapGround();
        bitmap = creatorBitmapGround.getCreatorBitmapGround(context, deviceWidth, deviceHeight/7);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, (float) getPositionX(), (float) boardHeight, null);
    }
}
