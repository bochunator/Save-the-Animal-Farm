package bochunator.savetheanimalfarm.manager;

import android.content.Context;

import bochunator.savetheanimalfarm.gameobject.Background;
import bochunator.savetheanimalfarm.gameobject.Performance;

public class ObjectManager {
    private float positionY;
    private Background background;
    public ObjectManager(Context context) {
        background = new Background(context);
    }
    public float getPositionY() {
        return positionY;
    }
    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }
    public Background getBackground() {
        return background;
    }
    public void setBackground(Background background) {
        this.background = background;
    }
}
