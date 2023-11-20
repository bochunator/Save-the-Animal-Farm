package bochunator.savetheanimalfarm.dynamic;

import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.bitmap.PlayerBitmap;
import bochunator.savetheanimalfarm.object.Rectangle;
import bochunator.savetheanimalfarm.utilities.Screen;

public class Player extends Rectangle {
    private final PlayerBitmap playerBitmap;
    public Player() {
        width = Screen.INSTANCE.getWidth() / 7f;
        height = Screen.INSTANCE.getWidth() / 7f;
        playerBitmap = PlayerBitmap.INSTANCE;
        y = 0.861f * Screen.INSTANCE.getHeight() - height;
        x = 0.5f * Screen.INSTANCE.getWidth() - width/2;
    }
    @Override
    public void setX(float x) {
        if (Screen.INSTANCE.getWidth() - width/2 <= x) {
            super.setX(Screen.INSTANCE.getWidth() - width);
        } else if (width/2 >= x) {
            super.setX(0);
        } else {
            super.setX(x - width/2);
        }
    }
    public void render(@NonNull Canvas canvas) {
        playerBitmap.render(canvas, x, y);
    }
}
