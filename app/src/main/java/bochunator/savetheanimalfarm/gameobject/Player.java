package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;

public class Player extends GameObjectRadius{

    public Player(Context context, int deviceWidth, int deviceHeight) {
        super(deviceWidth/2, deviceHeight*6/7 - deviceWidth/14, deviceWidth, deviceHeight, deviceWidth/14, ContextCompat.getColor(context, R.color.player));
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX < radius ? radius : Math.min(positionX, boardWidth - radius);
    }
}