package bochunator.savetheanimalfarm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.core.content.ContextCompat;

public class GameOver {
    private int healthPoints;
    private int deviceWidth;
    private int deviceHeight;
    private Paint paintBoard;
    private Paint paintText;
    private Paint paintReturnAndMenu;
    private int textSize;
    private Rect boardRect;
    private Rect returnRect;
    private Rect menuRect;

    private Context context;

    public GameOver(int healthPoints, Context context, int deviceWidth, int deviceHeight) {
        this.healthPoints = healthPoints;
        this.context = context;
        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;

        paintBoard = new Paint();
        paintBoard.setColor(ContextCompat.getColor(context, R.color.purple_700));
        paintReturnAndMenu = new Paint();
        paintReturnAndMenu.setColor(ContextCompat.getColor(context, R.color.white));
        paintText = new Paint();
        paintText.setColor(ContextCompat.getColor(context, R.color.white));
        textSize = deviceWidth / 5;
        paintText.setTextSize(textSize);
        paintText.setTextAlign(Paint.Align.CENTER);

        boardRect = new Rect(deviceWidth/7, deviceHeight/4, deviceWidth*6/7, deviceHeight*3/4);
        returnRect = new Rect(deviceWidth *3/14, deviceHeight*15/24, deviceWidth*13/28, deviceHeight*17/24);
        menuRect = new Rect(deviceWidth *15/28, deviceHeight*15/24, deviceWidth*11/14, deviceHeight*17/24);
    }

    public void decrementHealthPoints(){
        healthPoints--;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public boolean isGameOver(){
        return healthPoints <= 0;
    }

    public void drawGameOver(Canvas canvas){
        canvas.drawRect(boardRect, paintBoard);
        canvas.drawRect(returnRect, paintReturnAndMenu);
        canvas.drawRect(menuRect, paintReturnAndMenu);
        canvas.drawText("GAME", deviceWidth/2,deviceHeight/2 - textSize,paintText);
        canvas.drawText("OVER", deviceWidth/2,deviceHeight/2,paintText);
    }

    public void checkPosition(float x, float y) {
        if(x > returnRect.left && x < returnRect.right && y > returnRect.top && y < returnRect.bottom){
            Intent intent = new Intent(context, GameSurfaceActivity.class);
            //intent.putExtra("points",points);
            context.startActivity(intent);
            ((Activity) context).finish();
        }
        if(x > menuRect.left && x < menuRect.right && y > menuRect.top && y < menuRect.bottom){
            Intent intent = new Intent(context, MainActivity.class);
            //intent.putExtra("points",points);
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }
}
