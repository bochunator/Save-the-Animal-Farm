package bochunator.savetheanimalfarm;

import static android.graphics.ImageFormat.RGB_565;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private Paint paintTextInfo;
    public GameSurfaceView(Context context) {
        super(context);
        setFocusable(true);
        getHolder().setFormat(RGB_565);
        getHolder().addCallback(this);

        paintTextInfo = new Paint();
        paintTextInfo.setColor(ContextCompat.getColor(getContext(), R.color.teal_200));
        paintTextInfo.setTextSize(50);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        gameThread = new GameThread(this, surfaceHolder);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        gameThread.setRunning(false);
        boolean retry = true;
        while (retry){
            try {
                gameThread.join();
                retry = false;
            }catch (InterruptedException e){

            }
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawTextInfo(canvas);
    }

    public void drawTextInfo(Canvas canvas){
        String averageUPS = Double.toString(gameThread.getAverageUPS());
        canvas.drawText("UPS: " + averageUPS, 100, 100, paintTextInfo);
        String averageFPS = Double.toString(gameThread.getAverageFPS());
        canvas.drawText("FPS: " + averageFPS, 100, 200, paintTextInfo);
    }

    public void update() {
    }
}