package bochunator.savetheanimalfarm.gameinterface;

import static bochunator.savetheanimalfarm.MainActivity.HIGHEST_POINTS;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.bitmap.BitmapFactoryOptions;

public class Coins extends BitmapFactoryOptions {
    private int points;
    private int highestPoints;
    private final SharedPreferences sharedPreferences;
    private final Paint paintPoints;
    private final Paint paintHighestPoints;
    private final float textSize;

    public Coins(Context context, SharedPreferences sharedPreferences, double deviceWidth) {
        this.sharedPreferences = sharedPreferences;
        highestPoints = sharedPreferences.getInt(HIGHEST_POINTS, 0);

        Typeface typeface = ResourcesCompat.getFont(context, R.font.kenney_blocks);
        textSize = (float) (deviceWidth / 10);
        paintPoints = new Paint();
        paintPoints.setTextSize(textSize);
        paintPoints.setTypeface(typeface);
        paintHighestPoints = new Paint(paintPoints);
        paintPoints.setColor(ContextCompat.getColor(context, R.color.dark_gold));
        paintHighestPoints.setColor(ContextCompat.getColor(context, R.color.platinum));
    }

    public void save() {
        if(points > highestPoints){
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(HIGHEST_POINTS, points);
            editor.apply();
        }
    }

    public void saveAndRestart() {
        if(points > highestPoints){
            highestPoints = points;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(HIGHEST_POINTS, points);
            editor.apply();
        }
        points = 0;
    }

    public void gain() {
        points+=10;
    }

    public void draw(Canvas canvas) {
        canvas.drawText(String.valueOf(points), textSize / 5, textSize, paintPoints);
        canvas.drawText(String.valueOf(highestPoints), textSize / 5, textSize * 2, paintHighestPoints);
    }

    public int getPoints() {
        return points;
    }

    public int getHighestPoints() {
        return highestPoints;
    }
}
