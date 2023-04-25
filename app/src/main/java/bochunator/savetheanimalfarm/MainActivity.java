package bochunator.savetheanimalfarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapAnimals;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCES = "shared_preferences_save_the_animal_farm";
    public static final String HIGHEST_POINTS = "highest_points";
    public static final String ANIMAL = "animal";
    public static final String SHOW_FPS = "show_fps";
    public static final int DEFAULT_ANIMAL = 16;

    private SharedPreferences sharedPreferences;
    private ConstraintLayout constraintLayout;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btnStartGameActivity = (Button) findViewById(R.id.btnStartGameActivity);
        btnStartGameActivity.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, GameSurfaceActivity.class));
        });

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        CreatorBitmapAnimals creatorBitmapAnimals = new CreatorBitmapAnimals();
        ImageView imgViewStartChooseAnimalActivity = (ImageView) findViewById(R.id.imgViewStartChooseAnimalActivity);
        imgViewStartChooseAnimalActivity.setImageBitmap(creatorBitmapAnimals.getCreatorBitmapAnimals(sharedPreferences.getInt(ANIMAL, DEFAULT_ANIMAL), this));
        imgViewStartChooseAnimalActivity.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ChooseAnimalActivity.class));
            finish();
        });

        constraintLayout = findViewById(R.id.constraintLayout);

    }

    @Override
    protected void onResume() {
        Snackbar.make(constraintLayout, "Click on an avatar to change it", Snackbar.LENGTH_SHORT)
                .setAction(sharedPreferences.getBoolean(SHOW_FPS, false) ? "HIDE FPS" : "SHOW FPS", view -> {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean(SHOW_FPS, !sharedPreferences.getBoolean(SHOW_FPS, false));
                    editor.apply();
                })
                .setActionTextColor(getColor(R.color.dark_gold))
                .setTextColor(getColor(R.color.teal_200))
                .show();
        super.onResume();
    }
}