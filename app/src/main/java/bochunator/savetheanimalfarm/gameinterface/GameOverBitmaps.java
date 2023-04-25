package bochunator.savetheanimalfarm.gameinterface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.bitmap.BitmapFactoryOptions;

public class GameOverBitmaps extends BitmapFactoryOptions {
    private Bitmap homeBitmap;
    private Bitmap replayBitmap;

    private final float homePositionX;
    private final float homePositionY;
    private final float replayPositionX;
    private final float replayPositionY;

    public GameOverBitmaps(Context context, double deviceWidth, double deviceHeight) {
        homeBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_home, bitmapFactoryOptions);
        homeBitmap = Bitmap.createScaledBitmap(homeBitmap, (int) (deviceHeight/12), (int) (deviceHeight/12), true);

        replayBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_replay, bitmapFactoryOptions);
        replayBitmap = Bitmap.createScaledBitmap(replayBitmap, (int) (deviceHeight/12), (int) (deviceHeight/12), true);
        homePositionX = (float) (deviceWidth * 19 / 56 - homeBitmap.getWidth() / 2);
        homePositionY = (float) (deviceHeight * 15 / 24);
        replayPositionX = (float) (deviceWidth * 37 / 56 - replayBitmap.getWidth() / 2);
        replayPositionY = (float) (deviceHeight * 15 / 24);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(homeBitmap, homePositionX, homePositionY,null);
        canvas.drawBitmap(replayBitmap, replayPositionX, replayPositionY, null);
    }
}
