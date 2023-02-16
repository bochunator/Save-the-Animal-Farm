package bochunator.savetheanimalfarm.gameobject;

import android.graphics.Canvas;
import android.graphics.Paint;

public class GameObjectRectangle extends GameObject{
    protected double width;
    protected double height;
    private final Paint paint;

    public GameObjectRectangle(double positionX, double positionY, double deviceWidth, double deviceHeight, double width, double height, int color) {
        super(positionX, positionY, deviceWidth, deviceHeight);
        this.width = width;
        this.height = height;

        paint = new Paint();
        paint.setColor(color);
    }

    public void draw(Canvas canvas){
        canvas.drawRect((float) (x - width/2), (float) (y - height/2), (float) (x + width/2), (float) (y + height/2), paint);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
