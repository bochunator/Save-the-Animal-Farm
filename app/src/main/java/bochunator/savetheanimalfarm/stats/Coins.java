package bochunator.savetheanimalfarm.stats;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.utilities.DataManager;
import bochunator.savetheanimalfarm.utilities.Screen;

public enum Coins {
    INSTANCE;
    private float textSize;
    private Paint pointsPaint;
    private Paint highestPointsPaint;
    private int points;
    private int highestPoints;
    private String highest_points_key;
    private String latest_points_key;
    public Coins update(@NonNull Context context) {
        Typeface typeface = ResourcesCompat.getFont(context, R.font.kenney_blocks);
        textSize = Math.min(Screen.INSTANCE.getHeight(), Screen.INSTANCE.getWidth()) / 10f;
        pointsPaint = new Paint();
        pointsPaint.setTextSize(textSize);
        pointsPaint.setTypeface(typeface);
        highestPointsPaint = new Paint(pointsPaint);
        pointsPaint.setColor(ContextCompat.getColor(context, R.color.dark_gold));
        highestPointsPaint.setColor(ContextCompat.getColor(context, R.color.platinum));
        highest_points_key = context.getString(R.string.highest_points);
        latest_points_key = context.getString(R.string.latest_points);
        highestPoints = DataManager.INSTANCE.getInt(highest_points_key, highestPoints);
        points = 0;
        return INSTANCE;
    }
    public void render(@NonNull Canvas canvas) {
        canvas.drawText(String.valueOf(points), textSize / 5, textSize, pointsPaint);
        canvas.drawText(String.valueOf(highestPoints), textSize / 5, textSize * 2, highestPointsPaint);
    }
    public void gain() {
        points+=10;
    }
    public void save() {
        if(points > highestPoints){
            DataManager.INSTANCE.setInt(highest_points_key, points);
        }
        DataManager.INSTANCE.setInt(latest_points_key, points);
    }
}
