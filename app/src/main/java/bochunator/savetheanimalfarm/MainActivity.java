package bochunator.savetheanimalfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapAnimals;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCES = "shared_preferences_save_the_animal_farm";
    public static final String HIGHEST_POINTS = "highest_points";
    public static final String ANIMAL = "animal";
    public static final int DEFAULT_ANIMAL = 16;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btnStartGameActivity = (Button) findViewById(R.id.btnStartGameActivity);
        btnStartGameActivity.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, GameSurfaceActivity.class));
            finish();
        });

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        CreatorBitmapAnimals creatorBitmapAnimals = new CreatorBitmapAnimals();
        ImageView imgViewStartChooseAnimalActivity = (ImageView) findViewById(R.id.imgViewStartChooseAnimalActivity);
        imgViewStartChooseAnimalActivity.setImageBitmap(creatorBitmapAnimals.getCreatorBitmapAnimals(sharedPreferences.getInt(ANIMAL, DEFAULT_ANIMAL), this));
        imgViewStartChooseAnimalActivity.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ChooseAnimalActivity.class));
            finish();
        });
    }
}