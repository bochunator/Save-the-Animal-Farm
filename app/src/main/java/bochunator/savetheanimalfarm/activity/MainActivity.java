package bochunator.savetheanimalfarm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.asset.BackgroundAsset;
import bochunator.savetheanimalfarm.asset.GroundAsset;
import bochunator.savetheanimalfarm.asset.PlayerAsset;
import bochunator.savetheanimalfarm.bitmap.EnemyBitmap;
import bochunator.savetheanimalfarm.bitmap.Fire;
import bochunator.savetheanimalfarm.bitmap.PlayerBitmap;
import bochunator.savetheanimalfarm.board.Background;
import bochunator.savetheanimalfarm.board.Ground;
import bochunator.savetheanimalfarm.stats.Hearts;
import bochunator.savetheanimalfarm.utilities.DataManager;
import bochunator.savetheanimalfarm.utilities.Screen;

public class MainActivity extends AppCompatActivity {

    private TextView mainActivityTvDots;
    private int dotsCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen.INSTANCE.init(this);
        mainActivityTvDots = findViewById(R.id.mainActivityTvDots);
        startDotsAnimation();
        startLoadBitmaps();
    }
    private void startDotsAnimation() {
        Runnable runnable = () -> {
            while (!isFinishing()) {
                try {
                    Thread.sleep(300);
                    runOnUiThread(() -> {
                        StringBuilder dotsBuilder = new StringBuilder();
                        for (int i = 0; i < dotsCount; i++) {
                            dotsBuilder.append(".");
                        }
                        mainActivityTvDots.setText(dotsBuilder.toString());
                        dotsCount = (dotsCount + 1) % 4;
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(runnable).start();
    }
    private void startLoadBitmaps() {
        Runnable runnable = () -> {
            int width = Screen.INSTANCE.getWidth();
            DataManager.INSTANCE.update(this);
            BackgroundAsset backgroundAsset = DataManager.INSTANCE.getEnum(getString(R.string.saved_background), BackgroundAsset.ALL_BACKGROUNDS, BackgroundAsset.class);
            Background.INSTANCE.update(backgroundAsset, this);
            Ground.INSTANCE.update(GroundAsset.getRandom(), this);
            PlayerAsset playerAsset = DataManager.INSTANCE.getEnum(getString(R.string.saved_player), PlayerAsset.PARROT, PlayerAsset.class);
            PlayerBitmap.INSTANCE.update(playerAsset, width/7, width/7, this);
            EnemyBitmap.INSTANCE.update(width/6, this);
            Fire.INSTANCE.update(width/3, this);
            Hearts.INSTANCE.update(this);
            Screen.INSTANCE.bitmapSizesUpdated();
            if (getIntent().getBooleanExtra(getString(R.string.start_background_activity), false)) {
                startActivity(new Intent(MainActivity.this, BackgroundActivity.class));
            } else {
                startActivity(new Intent(MainActivity.this, AnimalActivity.class));
            }
            finish();
        };
        new Thread(runnable).start();
    }
}
