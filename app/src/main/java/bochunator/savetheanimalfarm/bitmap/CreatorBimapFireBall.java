package bochunator.savetheanimalfarm.bitmap;

import static bochunator.savetheanimalfarm.GameThread.MAX_UPS;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

import bochunator.savetheanimalfarm.R;

public class CreatorBimapFireBall extends BitmapFactoryOptions{
    private final Bitmap [] fireballBitmap;
    private final Bitmap [] iceballBitmap;
    private final Bitmap [] poisonballBitmap;

    public CreatorBimapFireBall(Context context, int deviceWidth) {
        Bitmap spriteSheetFireball = BitmapFactory.decodeResource(context.getResources(), R.drawable.fire_ball, bitmapFactoryOptions);
        Bitmap spriteSheetIceball = BitmapFactory.decodeResource(context.getResources(), R.drawable.ice_ball, bitmapFactoryOptions);
        Bitmap spriteSheetPoisonball = BitmapFactory.decodeResource(context.getResources(), R.drawable.poison_ball, bitmapFactoryOptions);

        fireballBitmap = new Bitmap[60];
        iceballBitmap = new Bitmap[60];
        poisonballBitmap = new Bitmap[60];
        for(int i = 0; i < 6; i++){
            for(int j = 0; j<10; j++){
                fireballBitmap[i*10+j] = Bitmap.createScaledBitmap(
                        Bitmap.createBitmap(spriteSheetFireball, i*9, j*68, 9, 68),
                        deviceWidth / 6,
                        deviceWidth / 2,
                        false
                );
                iceballBitmap[i*10+j] = Bitmap.createScaledBitmap(
                        Bitmap.createBitmap(spriteSheetIceball, i*9, j*84, 9, 84),
                        deviceWidth / 6,
                        deviceWidth / 2,
                        false
                );
                poisonballBitmap[i*10+j] = Bitmap.createScaledBitmap(
                        Bitmap.createBitmap(spriteSheetPoisonball, i*9, j*65, 9, 65),
                        deviceWidth / 6,
                        deviceWidth / 2,
                        false
                );
            }
        }
    }

    public Bitmap[] getFireballBitmap() {
        int randomBall = (int) (Math.random()*3);
        switch(randomBall){
            case 1: return iceballBitmap;
            case 2: return poisonballBitmap;
            default: return fireballBitmap;
        }
    }
}
