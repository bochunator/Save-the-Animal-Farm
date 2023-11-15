package bochunator.savetheanimalfarm.main;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.utilities.DataManager;

public class GameOverActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        findViewById(R.id.gameOverActivityBtnStartMainActivity).setOnClickListener(v -> {
            startActivity(new Intent(GameOverActivity.this, MainActivity.class));
            finish();
        });
        findViewById(R.id.gameOverActivityBtnStartGameActivity).setOnClickListener(v -> {
            startActivity(new Intent(GameOverActivity.this, GameActivity.class));
            finish();
        });
        TextView gameOverActivityTvTheBest = findViewById(R.id.gameOverActivityTvTheBest);
        gameOverActivityTvTheBest.setText(getString(R.string.the_best, DataManager.INSTANCE.getInt(getString(R.string.highest_points), 0)));
        TextView gameOverActivityTvScore = findViewById(R.id.gameOverActivityTvScore);
        gameOverActivityTvScore.setText(getString(R.string.score, DataManager.INSTANCE.getInt(getString(R.string.latest_points), 0)));
    }
}