package bochunator.savetheanimalfarm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

import bochunator.savetheanimalfarm.core.GameActivity;
import bochunator.savetheanimalfarm.object.Animal;
import bochunator.savetheanimalfarm.object.AnimalName;
import bochunator.savetheanimalfarm.utilities.Save;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCES = "shared_preferences";
    public static final String HIGHEST_POINTS = "highest_points";
    public static final String ANIMAL = "old_animal";
    public static final String SHOW_FPS = "show_fps";
    public static final int DEFAULT_ANIMAL = 16;
    private SharedPreferences sharedPreferences;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.mainActivityBtnStartGameActivity).setOnClickListener(view -> startActivity(new Intent(MainActivity.this, GameActivity.class)));
        ImageView mainActivityIvStartChooseAnimalActivity = findViewById(R.id.mainActivityIvStartChooseAnimalActivity);
        mainActivityIvStartChooseAnimalActivity.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ChooseAnimalActivity.class)));
        Save save = Save.getInstance(this);
        mainActivityIvStartChooseAnimalActivity.setImageBitmap(Animal.getBitmap(save.getAnimalName(getString(R.string.saved_animal), AnimalName.PARROT), this));
        //TODO: delete constraintLayout, sharedPreferences and editor
        constraintLayout = findViewById(R.id.constraintLayout);
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        findViewById(R.id.right).setOnClickListener(view -> {
            AnimalName animalName = save.getAnimalName(getString(R.string.saved_animal), AnimalName.PARROT).getNext();
            mainActivityIvStartChooseAnimalActivity.setImageBitmap(Animal.getBitmap(animalName, MainActivity.this));
            save.setAnimalName(getString(R.string.saved_animal), animalName);
            editor.putInt(ANIMAL, animalName.ordinal());
            editor.apply();
        });
        findViewById(R.id.left).setOnClickListener(view -> {
            AnimalName animalName = save.getAnimalName(getString(R.string.saved_animal), AnimalName.PARROT).getPrevious();
            mainActivityIvStartChooseAnimalActivity.setImageBitmap(Animal.getBitmap(animalName, MainActivity.this));
            save.setAnimalName(getString(R.string.saved_animal), animalName);
            editor.putInt(ANIMAL, animalName.ordinal());
            editor.apply();
        });
    }
    @Override
    protected void onResume() {
        //TODO: activity settings, right top icon
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
