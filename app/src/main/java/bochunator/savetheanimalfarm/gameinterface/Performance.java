package bochunator.savetheanimalfarm.gameinterface;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.GameThread;
import bochunator.savetheanimalfarm.R;

public class Performance {
    private final GameThread gameThread;
    private final Paint paintUpdatesAndFramesPerSecond;
    private final float textSize;

    public Performance(Context context, GameThread gameThread, double deviceWidth) {
        this.gameThread = gameThread;
        paintUpdatesAndFramesPerSecond = new Paint();
        paintUpdatesAndFramesPerSecond.setColor(ContextCompat.getColor(context, R.color.teal_200));
        textSize = (float) (deviceWidth / 15);
        paintUpdatesAndFramesPerSecond.setTextSize(textSize);
    }

    public void draw(Canvas canvas){
        drawUPS(canvas);
        drawFPS(canvas);
    }

    public void drawUPS(Canvas canvas){
        String averageUPS = Integer.toString(Math.round((float) gameThread.getAverageUPS()));
        canvas.drawText("UPS: " + averageUPS, textSize / 5, textSize * 4, paintUpdatesAndFramesPerSecond);
    }

    public void drawFPS(Canvas canvas){
        String averageFPS = Integer.toString(Math.round((float) gameThread.getAverageFPS()));
        canvas.drawText("FPS: " + averageFPS, textSize / 5, textSize * 5, paintUpdatesAndFramesPerSecond);
    }
}
