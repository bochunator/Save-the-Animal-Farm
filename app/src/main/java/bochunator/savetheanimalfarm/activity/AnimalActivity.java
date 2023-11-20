package bochunator.savetheanimalfarm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.asset.PlayerAsset;
import bochunator.savetheanimalfarm.bitmap.PlayerBitmap;
import bochunator.savetheanimalfarm.utilities.DataManager;

public class AnimalActivity extends AppCompatActivity {
    private ImageView animalActivityIvPlayer;
    private PlayerAsset playerAsset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        playerAsset = DataManager.INSTANCE.getEnum(getString(R.string.saved_player), PlayerAsset.PARROT, PlayerAsset.class);
        animalActivityIvPlayer = findViewById(R.id.animalActivityIvPlayer);
        animalActivityIvPlayer.setImageBitmap(PlayerBitmap.getBitmap(playerAsset, this));
        animalActivityIvPlayer.setOnClickListener(v -> {
            playerAsset = PlayerAsset.getRandom();
            setAndSaveImageView();
        });
        findViewById(R.id.animalActivityIvRight).setOnClickListener(view -> {
            playerAsset = playerAsset.getNext();
            setAndSaveImageView();
        });
        findViewById(R.id.animalActivityIvLeft).setOnClickListener(view -> {
            playerAsset = playerAsset.getPrevious();
            setAndSaveImageView();
        });
        findViewById(R.id.animalActivityBtnStartGameActivity).setOnClickListener(v -> {
            startActivity(new Intent(AnimalActivity.this, GameActivity.class));
            finish();
        });
        findViewById(R.id.animalActivityIvStartBackgroundActivity).setOnClickListener(v -> {
            startActivity(new Intent(AnimalActivity.this, BackgroundActivity.class));
            finish();
        });
    }
    private void setAndSaveImageView() {
        animalActivityIvPlayer.setImageBitmap(PlayerBitmap.getBitmap(playerAsset, AnimalActivity.this));
        DataManager.INSTANCE.setEnum(getString(R.string.saved_player), playerAsset);
    }
}