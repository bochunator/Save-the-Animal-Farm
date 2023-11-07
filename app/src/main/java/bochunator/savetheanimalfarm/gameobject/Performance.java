package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.utilities.DeviceMetrics;

public class Performance {
    private static int averageUPS;
    private static int averageFPS;
    private static Paint paint;
    private static Entity pointUPS;
    private static Entity pointFPS;
    private Performance() {
    }
    public static void setAverageUPS(int averageUPS) {
        Performance.averageUPS = averageUPS;
    }
    public static void setAverageFPS(int averageFPS) {
        Performance.averageFPS = averageFPS;
    }
    public static void draw(@NonNull Canvas canvas) {
        canvas.drawText("FPS: " + averageUPS, pointUPS.getX(), pointUPS.getY(), paint);
        canvas.drawText("UPS: " + averageFPS, pointFPS.getX(), pointFPS.getY(), paint);
    }
    public static void init(Context context) {
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.teal_200));
        int size = Math.min(DeviceMetrics.getHeight(), DeviceMetrics.getWidth());
        paint.setTextSize(0.07f * size);
        pointUPS = new Entity(0.12f * size, 0.28f * size);
        pointFPS = new Entity(0.12f * size, 0.35f * size);
    }
}
