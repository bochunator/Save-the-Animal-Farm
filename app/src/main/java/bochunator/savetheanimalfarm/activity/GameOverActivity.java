package bochunator.savetheanimalfarm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.board.Background;
import bochunator.savetheanimalfarm.board.Ground;
import bochunator.savetheanimalfarm.utilities.DataManager;

public class GameOverActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        ((ImageView) findViewById(R.id.gameOverActivityIvBackground)).setImageBitmap(Background.INSTANCE.getBitmap());
        ((ImageView) findViewById(R.id.gameOverActivityIvGround)).setImageBitmap(Ground.INSTANCE.getBitmap());
        findViewById(R.id.gameOverActivityBtnStartAnimalActivity).setOnClickListener(v -> {
            startActivity(new Intent(GameOverActivity.this, AnimalActivity.class));
            finish();
        });
        findViewById(R.id.gameOverActivityBtnStartGameActivity).setOnClickListener(v -> {
            startActivity(new Intent(GameOverActivity.this, GameActivity.class));
            finish();
        });
        ((TextView) findViewById(R.id.gameOverActivityTvTheBest)).setText(getString(R.string.the_best, DataManager.INSTANCE.getInt(getString(R.string.highest_points), 0)));
        ((TextView) findViewById(R.id.gameOverActivityTvScore)).setText(getString(R.string.score, DataManager.INSTANCE.getInt(getString(R.string.latest_points), 0)));
    }
}