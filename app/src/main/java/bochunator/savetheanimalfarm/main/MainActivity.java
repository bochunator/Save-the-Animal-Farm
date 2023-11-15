package bochunator.savetheanimalfarm.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.asset.PlayerAsset;
import bochunator.savetheanimalfarm.bitmap.PlayerBitmap;
import bochunator.savetheanimalfarm.utilities.DataManager;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCES = "shared_preferences";
    public static final String ANIMAL = "old_animal";
    public static final int DEFAULT_ANIMAL = 16;
    private PlayerAsset playerAsset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView mainActivityIvStartChooseAnimalActivity = findViewById(R.id.mainActivityIvPlayer);
        DataManager dataManager = DataManager.INSTANCE.update(this);
        playerAsset = dataManager.getEnum(getString(R.string.saved_player), PlayerAsset.PARROT, PlayerAsset.class);
        mainActivityIvStartChooseAnimalActivity.setImageBitmap(PlayerBitmap.getBitmap(playerAsset, this));
        mainActivityIvStartChooseAnimalActivity.setOnClickListener(v -> {
            playerAsset = PlayerAsset.getRandom();
            mainActivityIvStartChooseAnimalActivity.setImageBitmap(PlayerBitmap.getBitmap(playerAsset, MainActivity.this));
            dataManager.setEnum(getString(R.string.saved_player), playerAsset);
        });
        findViewById(R.id.mainActivityIvRight).setOnClickListener(view -> {
            playerAsset = playerAsset.getNext();
            mainActivityIvStartChooseAnimalActivity.setImageBitmap(PlayerBitmap.getBitmap(playerAsset, MainActivity.this));
            dataManager.setEnum(getString(R.string.saved_player), playerAsset);
        });
        findViewById(R.id.mainActivityIvLeft).setOnClickListener(view -> {
            playerAsset = playerAsset.getPrevious();
            mainActivityIvStartChooseAnimalActivity.setImageBitmap(PlayerBitmap.getBitmap(playerAsset, MainActivity.this));
            dataManager.setEnum(getString(R.string.saved_player), playerAsset);
        });
        findViewById(R.id.mainActivityBtnStartGameActivity).setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, GameActivity.class));
            finish();
        });
    }
}
