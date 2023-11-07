package bochunator.savetheanimalfarm.gameinterface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import androidx.core.content.ContextCompat;

import bochunator.savetheanimalfarm.main.MainActivity;
import bochunator.savetheanimalfarm.R;

public class GameOverBoard {
    private final Context context;

    private final Rect board;
    private final Rect home;
    private final Rect replay;

    private final Paint paintBoard;
    private final Paint paintHomeReplay;

    public GameOverBoard(Context context, double deviceWidth, double deviceHeight) {
        this.context = context;
        paintBoard = new Paint();
        paintBoard.setColor(ContextCompat.getColor(context, R.color.cosmic_latte));
        board = new Rect((int) (deviceWidth/7), (int) (deviceHeight/4), (int) (deviceWidth*6/7), (int) (deviceHeight*3/4));

        paintHomeReplay = new Paint();
        paintHomeReplay.setColor(ContextCompat.getColor(context, R.color.warm_white));

        home = new Rect((int) (deviceWidth *3/14), (int) (deviceHeight*15/24), (int) (deviceWidth*13/28), (int) (deviceHeight*17/24));
        replay = new Rect((int) (deviceWidth *15/28), (int) (deviceHeight*15/24), (int) (deviceWidth*11/14), (int) (deviceHeight*17/24));
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(board, paintBoard);
        canvas.drawRect(home, paintHomeReplay);
        canvas.drawRect(replay, paintHomeReplay);
    }

    public boolean check(float x, float y) {
        if(x > replay.left && x < replay.right && y > replay.top && y < replay.bottom){
            return true;
        }
        if(x > home.left && x < home.right && y > home.top && y < home.bottom){
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
            ((Activity) context).finish();
        }
        return false;
    }
}
