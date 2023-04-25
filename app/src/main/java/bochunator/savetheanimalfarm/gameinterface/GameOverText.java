package bochunator.savetheanimalfarm.gameinterface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import bochunator.savetheanimalfarm.R;

public class GameOverText {
    private final double deviceWidth;
    private final double deviceHeight;
    private final Coins coins;

    private final Paint paintGameOverText;
    private final int textSizeGameOver;

    private final int textSizeCoins;
    private final Paint paintHighestPoints;
    private final Paint paintPoints;

    public GameOverText(Context context, double deviceWidth, double deviceHeight, Coins coins) {
        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;
        this.coins = coins;

        Typeface typeface = ResourcesCompat.getFont(context, R.font.kenney_blocks);

        textSizeGameOver = (int) (deviceWidth / 5);
        paintGameOverText = new Paint();
        paintGameOverText.setColor(ContextCompat.getColor(context, R.color.white));
        paintGameOverText.setTextSize(textSizeGameOver);
        paintGameOverText.setTextAlign(Paint.Align.CENTER);
        paintGameOverText.setTypeface(typeface);

        textSizeCoins = (int) (deviceWidth / 20);
        paintPoints = new Paint();
        paintPoints.setTextSize(textSizeCoins);
        paintPoints.setTextAlign(Paint.Align.CENTER);
        paintPoints.setTypeface(typeface);
        paintHighestPoints = new Paint(paintPoints);
        paintPoints.setColor(ContextCompat.getColor(context, R.color.dark_gold));
        paintHighestPoints.setColor(ContextCompat.getColor(context, R.color.platinum));
    }

    public void draw(Canvas canvas) {
        canvas.drawText("GAME", (float) (deviceWidth/2), (float) (deviceHeight/2 - textSizeGameOver), paintGameOverText);
        canvas.drawText("OVER", (float) (deviceWidth/2), (float) (deviceHeight/2), paintGameOverText);
        canvas.drawText("THE BEST = " + coins.getHighestPoints(), (float) (deviceWidth/2), (float) (deviceHeight/2 + 2 * textSizeCoins), paintHighestPoints);
        canvas.drawText("SCORE = " + coins.getPoints(), (float) (deviceWidth/2), (float) (deviceHeight/2 + 4 * textSizeCoins), paintPoints);
    }
}
