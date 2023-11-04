package bochunator.savetheanimalfarm;

import static android.graphics.ImageFormat.RGB_565;

import static bochunator.savetheanimalfarm.MainActivity.ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.DEFAULT_ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.SHARED_PREFERENCES;
import static bochunator.savetheanimalfarm.MainActivity.SHOW_FPS;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import bochunator.savetheanimalfarm.bitmap.CreatorBimapFireBall;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapExplosions;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapPlanets;
import bochunator.savetheanimalfarm.gameinterface.Coins;
import bochunator.savetheanimalfarm.gameinterface.GameOver;
import bochunator.savetheanimalfarm.gameinterface.Health;
import bochunator.savetheanimalfarm.gameinterface.Performance;
import bochunator.savetheanimalfarm.gameobject.AdvancedCalculations;
import bochunator.savetheanimalfarm.gameobject.Background;
import bochunator.savetheanimalfarm.gameobject.Enemy;
import bochunator.savetheanimalfarm.gameobject.Ground;
import bochunator.savetheanimalfarm.gameobject.Player;

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback{
    private GameThread gameThread;
    private Background background;
    private Ground ground;
    private final Player player;
    private final List<Enemy> enemies;
    //private final List<Explosion> explosions;
    private final CreatorBitmapPlanets creatorBitmapPlanets;
    private final CreatorBimapFireBall creatorBimapFireBall;
    private final CreatorBitmapExplosions creatorBitmapExplosions;
    private final Health health;
    private final Coins coins;
    private final GameOver gameOver;
    private Performance performance;
    private final boolean showPerformance;
    private final DisplayMetrics displayMetrics;
    private SurfaceHolder holder;
    public GameSurfaceView(Context context) {
        super(context);
        Log.d("GameSurfaceView.java", "GameSurfaceView");
        setFocusable(true);
        holder = getHolder();
        //TODO: check if getHolder is different
        getHolder().setFormat(RGB_565);
        getHolder().addCallback(this);
        //explosions = new ArrayList<>();
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        showPerformance = sharedPreferences.getBoolean(SHOW_FPS, false);
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        background = new Background(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels);
        ground = new Ground(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels);
        creatorBitmapPlanets = new CreatorBitmapPlanets(getContext(), displayMetrics.widthPixels);
        creatorBimapFireBall = new CreatorBimapFireBall(getContext(), displayMetrics.widthPixels);
        creatorBitmapExplosions = new CreatorBitmapExplosions(getContext(), displayMetrics.widthPixels);
        player = new Player(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels, sharedPreferences.getInt(ANIMAL, DEFAULT_ANIMAL));
        health = new Health(getContext(), displayMetrics.widthPixels,  3);
        coins = new Coins(getContext(), sharedPreferences, displayMetrics.widthPixels);
        gameOver = new GameOver(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels, coins);
        enemies = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            enemies.add(new Enemy(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels, creatorBitmapPlanets.getCreatorRandomBitmapPlanets(), creatorBimapFireBall.getFireballBitmap()));
        }
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        Log.d("GameSurfaceView.java", "surfaceCreated");
        gameThread = new GameThread(this);
        gameThread.setRunning(true);
        gameThread.start();
        performance = new Performance(getContext(), gameThread, displayMetrics.widthPixels);
        performance.setText("Obiekty sa " + (holder == surfaceHolder));
    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        Log.d("GameSurfaceView.java", "surfaceChanged");
    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        Log.d("GameSurfaceView.java", "surfaceDestroyed");
        coins.save();
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
//        background.draw(canvas);
//        ground.draw(canvas);
        player.draw(canvas);
        for(Enemy e : enemies){
            e.draw(canvas);
        }
//        for (Explosion e : explosions){
//            e.draw(canvas);
//        }
//        health.draw(canvas);
//        coins.draw(canvas);
        if (showPerformance) {
            performance.draw(canvas);
        }
//        if (health.isGameOver()){
//            gameOver.drawGameOver(canvas);
//        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
//                if(health.isGameOver()){
//                    gameOver.checkPosition(event.getX(), event.getY());
//                }
            }
            case MotionEvent.ACTION_MOVE:{
                if (!health.isGameOver()) {
                    player.setPositionX(event.getX());
                }
            }
            return true;
        }
        return super.onTouchEvent(event);
    }
    public void update() {
//        if(health.isGameOver()){
//            if(gameOver.isNewGame()){
//                health.newGame();
//                enemies.clear();
//                player.newGame();
//                coins.saveAndRestart();
//                background = new Background(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels);
//                ground = new Ground(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels);
//                gameOver.setNewGame(false);
//            }
//            return;
//        }
//        if(Enemy.readyToSpawn()){
//            enemies.add(new Enemy(getContext(), displayMetrics.widthPixels, displayMetrics.heightPixels, creatorBitmapPlanets.getCreatorRandomBitmapPlanets(), creatorBimapFireBall.getFireballBitmap()));
//        }
//        for(int i = 0; i < explosions.size(); i++){
//            explosions.get(i).update();
//            if(explosions.get(i).readyToRemove()){
//                explosions.remove(i);
//            }
//        }
        for(int i = 0; i < enemies.size(); i++){
            enemies.get(i).update();
            if(AdvancedCalculations.isCollidingCircleAndRectangle(enemies.get(i), player)){
//                explosions.add(new Explosion(displayMetrics.widthPixels, enemies.get(i).getPositionX(), enemies.get(i).getPositionY(), creatorBitmapExplosions.getRandomBitmaps()));
                enemies.get(i).goToSky();
//                health.decrementHealthPoints();
            }
            if(enemies.get(i).readyToRemove()){
//                coins.gain();
//                explosions.add(new Explosion(displayMetrics.widthPixels, enemies.get(i).getPositionX(), enemies.get(i).getPositionY(), creatorBitmapExplosions.getRandomBitmaps()));
                enemies.get(i).goToSky();
            }
        }
    }
}
