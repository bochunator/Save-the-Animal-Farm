package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;

public class Player extends GameObjectRectangle{
    private final Bitmap playerBitmap;
    private int offsetHeight;
    private int offsetWidth;

    public Player(Context context, double deviceWidth, double deviceHeight, Bitmap playerBitmap, int offsetWidth, int offsetHeight) {
        super(deviceWidth/2, deviceHeight*6/7 - deviceWidth/14, deviceWidth, deviceHeight, deviceWidth/7, deviceWidth/7, ContextCompat.getColor(context, R.color.player));
        this.playerBitmap = playerBitmap;
        this.offsetWidth = offsetWidth;
        this.offsetHeight = offsetHeight;
    }

    public void setPositionX(double positionX) {
        this.x = positionX < width/2 ? width/2 : Math.min(positionX, boardWidth - width/2);
    }

    public void draw(Canvas canvas){
        //canvas.drawRect((float) (x - width/2), (float) (y - height/2), (float) (x + width/2), (float) (y + height/2), null);
        super.draw(canvas);
        canvas.drawBitmap(playerBitmap, (float) (x - width/2 - offsetWidth), (float) (y - height/2 - offsetHeight), null);
    }
}