package bochunator.savetheanimalfarm.dynamic;

import android.content.Context;
import android.graphics.Canvas;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.asset.PlayerAsset;
import bochunator.savetheanimalfarm.bitmap.PlayerBitmap;
import bochunator.savetheanimalfarm.object.Rectangle;
import bochunator.savetheanimalfarm.utilities.Screen;

public class Player extends Rectangle {
    private static PlayerAsset playerAsset;
    private PlayerBitmap playerBitmap;
    public Player(PlayerAsset playerAsset, Context context) {
        width = Screen.INSTANCE.getWidth() / 7f;
        height = Screen.INSTANCE.getWidth() / 7f;
        playerBitmap = PlayerBitmap.INSTANCE;
        if (Screen.INSTANCE.isSizeChanged() || playerAsset != Player.playerAsset) {
            Player.playerAsset = playerAsset;
            playerBitmap = PlayerBitmap.INSTANCE.update(playerAsset, (int) width, (int) height, context);
        }
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
