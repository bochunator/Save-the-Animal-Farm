package bochunator.savetheanimalfarm.gameobject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapAnimals;

public class Player extends GameObjectRectangle{
    private Bitmap bitmap;
    private final int offsetHeight;
    private final int offsetWidth;
    private Paint paint;

    public Player(Context context, double deviceWidth, double deviceHeight, int idAnimal){
        super(deviceWidth/2, deviceHeight*6/7 - deviceWidth/14, deviceWidth, deviceHeight, deviceWidth/7, deviceWidth/7, ContextCompat.getColor(context, R.color.player));
        paint = new Paint();
        paint.setColor(ContextCompat.getColor(context, R.color.player));

        CreatorBitmapAnimals creatorBitmapAnimals = new CreatorBitmapAnimals();
        bitmap = creatorBitmapAnimals.getCreatorBitmapAnimals(idAnimal, context);
        double scaleWidth =  deviceWidth / (7 * 136);
        double scaleHeight =  deviceWidth / (7 * 136);
        bitmap = Bitmap.createScaledBitmap(
                bitmap,
                (int) (deviceWidth / 7 * (double)bitmap.getWidth() / 136),
                (int) (deviceWidth  / 7 * (double)bitmap.getHeight() / 136),
                true
        );
        offsetWidth = (int) (creatorBitmapAnimals.offsetWidth( idAnimal ) * scaleWidth);
        offsetHeight = (int) (creatorBitmapAnimals.offsetHeight( idAnimal ) * scaleHeight);

    }

    @Override
    public void setPositionX(double positionX) {
        this.positionX = positionX < width/2 ? width/2 : Math.min(positionX, deviceWidth - width/2);
    }

    public void draw(Canvas canvas){
        //canvas.drawBitmap(bitmap, (float) (positionX - width/2 - offsetWidth), (float) (positionY - height/2 - offsetHeight), null);
        canvas.drawRect((float) (positionX - width/2), (float) (positionY - height/2), (float) (positionX + width/2), (float) (positionY + height/2),  paint);
    }

    public void newGame() {
        setPositionX(deviceWidth/2);
    }
}