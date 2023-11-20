package bochunator.savetheanimalfarm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.asset.BackgroundAsset;
import bochunator.savetheanimalfarm.bitmap.BitmapConfigurator;
import bochunator.savetheanimalfarm.board.Background;
import bochunator.savetheanimalfarm.board.Ground;
import bochunator.savetheanimalfarm.utilities.DataManager;

public class BackgroundActivity extends AppCompatActivity implements BitmapConfigurator {
    private ImageView backgroundActivityIvBackground;
    private BackgroundAsset backgroundAsset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
        ((ImageView) findViewById(R.id.backgroundActivityIvGround)).setImageBitmap(Ground.INSTANCE.getBitmap());
        backgroundAsset = DataManager.INSTANCE.getEnum(getString(R.string.saved_background), BackgroundAsset.ALL_BACKGROUNDS, BackgroundAsset.class);
        backgroundActivityIvBackground = findViewById(R.id.backgroundActivityIvBackground);
        setImageView();
        findViewById(R.id.backgroundActivityBtnStartGameActivity).setOnClickListener(v -> {
            startActivity(new Intent(BackgroundActivity.this, GameActivity.class));
            finish();
        });
        findViewById(R.id.backgroundActivityIvStartAnimalActivity).setOnClickListener(v -> {
            startActivity(new Intent(BackgroundActivity.this, AnimalActivity.class));
            finish();
        });
        findViewById(R.id.backgroundActivityIvRight).setOnClickListener(v -> {
            backgroundAsset = backgroundAsset.getNext();
            setAndSaveImageView();
        });
        findViewById(R.id.backgroundActivityIvLeft).setOnClickListener(v -> {
            backgroundAsset = backgroundAsset.getPrevious();
            setAndSaveImageView();
        });
    }
    private void setImageView() {
        Background.INSTANCE.update(backgroundAsset, BackgroundActivity.this);
        backgroundActivityIvBackground.setImageBitmap(Background.INSTANCE.getBitmap());
    }
    private void setAndSaveImageView() {
        setImageView();
        DataManager.INSTANCE.setEnum(getString(R.string.saved_background), backgroundAsset);
    }
}