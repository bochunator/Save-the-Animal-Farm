package bochunator.savetheanimalfarm.gameobject;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameObjectRadius extends GameObject {
    protected double radius;
    private final Paint paint;

    public GameObjectRadius(double positionX, double positionY, double deviceWidth, double deviceHeight, double radius, int color) {
        super(positionX, positionY, deviceWidth, deviceHeight);
        this.radius = radius;
        paint = new Paint();
        paint.setColor(color);
    }

    public void draw(Canvas canvas){
        canvas.drawCircle((float) positionX, (float) positionY, (float)radius, paint);
    }

    public double getRadius() {
        return radius;
    }
}