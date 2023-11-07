package bochunator.savetheanimalfarm.manager;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.gameobject.Performance;

public class GameRender {
    private final ObjectManager objectManager;
    private final Paint paint;
    public GameRender(ObjectManager objectManager) {
        this.objectManager = objectManager;
        paint = new Paint();
        paint.setColor(Color.BLACK);
    }
    public void draw(@NonNull Canvas canvas) {
        objectManager.getBackground().draw(canvas);
        Performance.draw(canvas);
        canvas.drawCircle(500, objectManager.getPositionY(), 50, paint);
    }
}
