package bochunator.savetheanimalfarm.gameinterface;

import android.content.Context;
import android.graphics.Canvas;

public class GameOver {
    private boolean newGame = false;
    private final GameOverBoard gameOverBoard;
    private final GameOverBitmaps gameOverBitmaps;
    private final GameOverText gameOverText;

    public GameOver(Context context, double deviceWidth, double deviceHeight, Coins coins) {
        gameOverBoard = new GameOverBoard(context, deviceWidth, deviceHeight);
        gameOverBitmaps = new GameOverBitmaps(context, deviceWidth, deviceHeight);
        gameOverText = new GameOverText(context, deviceWidth, deviceHeight, coins);

    }

    public void drawGameOver(Canvas canvas){
        gameOverBoard.draw(canvas);
        gameOverBitmaps.draw(canvas);
        gameOverText.draw(canvas);
    }

    public void checkPosition(float x, float y) {
        newGame = gameOverBoard.check(x, y);
    }

    public boolean isNewGame() {
        return newGame;
    }

    public void setNewGame(boolean newGame) {
        this.newGame = newGame;
    }
}
