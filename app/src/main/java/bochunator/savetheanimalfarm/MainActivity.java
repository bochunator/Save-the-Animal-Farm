package bochunator.savetheanimalfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btnStartGameActivity = findViewById(R.id.btnStartGameActivity);
        btnStartGameActivity.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, GameSurfaceActivity.class));
            //finish();
        });
    }
}