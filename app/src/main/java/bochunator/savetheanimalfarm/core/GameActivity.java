package bochunator.savetheanimalfarm.core;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import bochunator.savetheanimalfarm.GameSurfaceView;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameSurfaceView gameSurfaceView = new GameSurfaceView(this);
        setContentView(gameSurfaceView);
    }
}
