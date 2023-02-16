package bochunator.savetheanimalfarm;

import static bochunator.savetheanimalfarm.MainActivity.ANIMAL;
import static bochunator.savetheanimalfarm.MainActivity.HIGHEST_POINTS;
import static bochunator.savetheanimalfarm.MainActivity.SHARED_PREFERENCES;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import bochunator.savetheanimalfarm.bitmap.CreatorBitmapChooseAnimal;

public class ChooseAnimalActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_animal);

        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Point deviceSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(deviceSize);
        CreatorBitmapChooseAnimal creatorBitmapChooseAnimal = new CreatorBitmapChooseAnimal(this);

        ImageView imageViewSquareNoDetailsOutline = (ImageView) findViewById(R.id.imageViewSquareNoDetailsOutline);
        imageViewSquareNoDetailsOutline.setImageBitmap(creatorBitmapChooseAnimal.getSquareNoDetailsOutlineBitmap());
        imageViewSquareNoDetailsOutline.getLayoutParams().width = deviceSize.x;
        imageViewSquareNoDetailsOutline.getLayoutParams().height = deviceSize.x*6/5;

        ImageView imageViewChosenAnimal = (ImageView) findViewById(R.id.imageViewChosenAnimal);
        imageViewChosenAnimal.setImageBitmap(creatorBitmapChooseAnimal.getCreatorBitmapChooseAnimal( sharedPreferences.getInt(ANIMAL, 16)));

        imageViewSquareNoDetailsOutline.setOnTouchListener((view, event) -> {
            float x = event.getX();
            float y = event.getY();
            int column = (int) (x / (view.getWidth() / 5));
            int row = (int) (y / (view.getHeight() / 6));
            int position = row * 5 + column;
            imageViewChosenAnimal.setImageBitmap(creatorBitmapChooseAnimal.getCreatorBitmapChooseAnimal(position));
            editor.putInt(ANIMAL, position);
            editor.apply();
            return false;
        });

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(view -> {
            startActivity(new Intent(ChooseAnimalActivity.this, MainActivity.class));
            finish();
        });

        // This callback will only be called when MyFragment is at least Started.
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                startActivity(new Intent(ChooseAnimalActivity.this, MainActivity.class));
                finish();
            }
        };
        this.getOnBackPressedDispatcher().addCallback(this, callback);

    }
}