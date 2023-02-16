package bochunator.savetheanimalfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapAnimals;
import bochunator.savetheanimalfarm.bitmap.CreatorBitmapChooseAnimal;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCES = "shared_preferences_save_the_animal_farm";
    public static final String HIGHEST_POINTS = "highest_points";
    public static final String ANIMAL = "animal";
    private SharedPreferences sharedPreferences;
    private ImageView imgViewStartChooseAnimalActivity;
    private CreatorBitmapChooseAnimal creatorBitmapChooseAnimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);

        Button btnStartGameActivity = (Button) findViewById(R.id.btnStartGameActivity);
        btnStartGameActivity.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, GameSurfaceActivity.class));
            finish();
        });
        imgViewStartChooseAnimalActivity = (ImageView) findViewById(R.id.imgViewStartChooseAnimalActivity);

        CreatorBitmapAnimals creatorBitmapAnimals = new CreatorBitmapAnimals();

        imgViewStartChooseAnimalActivity.setImageBitmap(creatorBitmapAnimals.getCreatorBitmapAnimals(sharedPreferences.getInt(ANIMAL, 16), this));
        imgViewStartChooseAnimalActivity.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ChooseAnimalActivity.class));
            finish();
        });
    }
}