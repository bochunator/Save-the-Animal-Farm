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

    public static boolean isColliding(GameObjectRadius firstGameObjectRadius, GameObjectRadius secondGameObjectRadius){
        double distanceBetweenObjects = calculateDistanceBetweenCoordinates(firstGameObjectRadius, secondGameObjectRadius);
        double distanceToCollision = firstGameObjectRadius.getRadius() + secondGameObjectRadius.getRadius();
        return distanceBetweenObjects < distanceToCollision;
    }

    public void draw(Canvas canvas){
        canvas.drawCircle((float) x, (float) y, (float)radius, paint);
    }

    public double getRadius() {
        return radius;
    }
}