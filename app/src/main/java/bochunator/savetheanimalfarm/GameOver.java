package bochunator.savetheanimalfarm;

import static bochunator.savetheanimalfarm.MainActivity.HIGHEST_POINTS;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.core.content.ContextCompat;

public class GameOver {
    private int defaultHealthPoints;
    private int healthPoints;
    private int highestCoins;
    private int coins = 0;
    private int deviceWidth;
    private int deviceHeight;
    private Paint paintBoard;
    private Paint paintText;
    private Paint paintTextNumbers;
    private Paint paintReturnAndMenu;
    private int textSize;
    private int textSizeNumbers;
    private Rect boardRect;
    private Rect returnRect;
    private Rect menuRect;

    private Context context;
    private SharedPreferences sharedPreferences;

    public GameOver(int healthPoints, Context context, int deviceWidth, int deviceHeight, SharedPreferences sharedPreferences) {
        this.defaultHealthPoints = healthPoints;
        this.healthPoints = healthPoints;
        this.context = context;
        this.deviceWidth = deviceWidth;
        this.deviceHeight = deviceHeight;
        this.sharedPreferences = sharedPreferences;

        paintBoard = new Paint();
        paintBoard.setColor(ContextCompat.getColor(context, R.color.purple_700));
        paintReturnAndMenu = new Paint();
        paintReturnAndMenu.setColor(ContextCompat.getColor(context, R.color.white));
        paintText = new Paint();
        paintText.setColor(ContextCompat.getColor(context, R.color.white));
        textSize = deviceWidth / 5;
        paintText.setTextSize(textSize);
        paintText.setTextAlign(Paint.Align.CENTER);
        paintTextNumbers = new Paint();
        paintTextNumbers.setColor(ContextCompat.getColor(context, R.color.white));
        textSizeNumbers = deviceWidth / 20;
        paintTextNumbers.setTextSize(textSizeNumbers);
        paintTextNumbers.setTextAlign(Paint.Align.CENTER);

        boardRect = new Rect(deviceWidth/7, deviceHeight/4, deviceWidth*6/7, deviceHeight*3/4);
        menuRect = new Rect(deviceWidth *3/14, deviceHeight*15/24, deviceWidth*13/28, deviceHeight*17/24);
        returnRect = new Rect(deviceWidth *15/28, deviceHeight*15/24, deviceWidth*11/14, deviceHeight*17/24);

        highestCoins = sharedPreferences.getInt(HIGHEST_POINTS, 0);
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
        canvas.drawText("the best = " + highestCoins, deviceWidth/2, deviceHeight/2 + 2 *textSizeNumbers, paintTextNumbers);
        canvas.drawText("current = " + coins, deviceWidth/2, deviceHeight/2 + 4 * textSizeNumbers, paintTextNumbers);
    }

    public void checkPosition(float x, float y) {
        if(x > returnRect.left && x < returnRect.right && y > returnRect.top && y < returnRect.bottom){
            restart();
        }
        if(x > menuRect.left && x < menuRect.right && y > menuRect.top && y < menuRect.bottom){
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }
    public void restart(){
        this.healthPoints = defaultHealthPoints;
        this.coins = 0;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getHighestCoins() {
        return highestCoins;
    }

    public void saveCoins(){
        if(coins > highestCoins){
            highestCoins = coins;
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(HIGHEST_POINTS, coins);
            editor.apply();
        }
    }
}
