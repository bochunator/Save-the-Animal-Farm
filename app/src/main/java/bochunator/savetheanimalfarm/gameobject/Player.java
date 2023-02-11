package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;

public class Player extends GameObjectRectangle{
    public Player(Context context, double deviceWidth, double deviceHeight) {
        super(deviceWidth/2, deviceHeight*6/7 - deviceWidth*1.618/14, deviceWidth, deviceHeight, deviceWidth/7, deviceWidth*1.618/7, ContextCompat.getColor(context, R.color.player));
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX < width/2 ? width/2 : Math.min(positionX, boardWidth - width/2);
    }
}