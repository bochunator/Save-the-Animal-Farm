package bochunator.savetheanimalfarm;

import static bochunator.savetheanimalfarm.MainActivity.ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.DEFAULT_ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.SHARED_PREFERENCES;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapChooseAnimal;

public class ChooseAnimalActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_animal);

        final int NUMBER_ANIMALS_IN_ROW = 5;
        final int NUMBER_ANIMALS_IN_COLUMN = 6;

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Point deviceSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(deviceSize);
        CreatorBitmapChooseAnimal creatorBitmapChooseAnimal = new CreatorBitmapChooseAnimal(this);

        ImageView imageViewSquareNoDetailsOutline = findViewById(R.id.imageViewSquareNoDetailsOutline);
        imageViewSquareNoDetailsOutline.setImageBitmap(creatorBitmapChooseAnimal.getSquareNoDetailsOutlineBitmap());
        imageViewSquareNoDetailsOutline.setAdjustViewBounds(true);

        ImageView imageViewChosenAnimal = findViewById(R.id.imageViewChosenAnimal);
        imageViewChosenAnimal.setImageBitmap(creatorBitmapChooseAnimal.getCreatorBitmapChooseAnimal( sharedPreferences.getInt(ANIMAL, DEFAULT_ANIMAL)));

        imageViewSquareNoDetailsOutline.setOnTouchListener((view, event) -> {
            float x = event.getX();
            float y = event.getY();
            if (x < 0 || x > view.getWidth() || y < 0 || y > view.getHeight()) return false;
            int column = (int) ( x / (view.getWidth() / NUMBER_ANIMALS_IN_ROW));
            if (column < 0 || column >= NUMBER_ANIMALS_IN_ROW) return false;
            int row = (int) ( y / (view.getHeight() / NUMBER_ANIMALS_IN_COLUMN));
            if (row < 0 || row >= NUMBER_ANIMALS_IN_COLUMN) return false;
            int position = row * NUMBER_ANIMALS_IN_ROW + column;

            imageViewChosenAnimal.setImageBitmap(creatorBitmapChooseAnimal.getCreatorBitmapChooseAnimal(position));
            editor.putInt(ANIMAL, position);
            editor.apply();
            return false;
        });

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(ChooseAnimalActivity.this, MainActivity.class));
            finish();
        });
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                startActivity(new Intent(ChooseAnimalActivity.this, MainActivity.class));
                finish();
            }
        };
        this.getOnBackPressedDispatcher().addCallback(this, callback);

    }
}