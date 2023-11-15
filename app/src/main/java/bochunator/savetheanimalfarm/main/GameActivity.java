package bochunator.savetheanimalfarm.main;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GameSurfaceView gameSurfaceView = new GameSurfaceView(this);
        setContentView(gameSurfaceView);
        //orientationLock();
        //TODO: sprawdz kiedy obasz gry zostal zmniejszony do polowy
    }
    private void orientationLock() {
        //TODO: sprawdz kiedy obasz gry zostal zmniejszony do polowy
        int currentOrientation = getResources().getConfiguration().orientation;
        if (Configuration.ORIENTATION_LANDSCAPE == currentOrientation) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else if (Configuration.ORIENTATION_PORTRAIT == currentOrientation) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}
