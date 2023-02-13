package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapPlanets extends BitmapFactoryOptions{

    public final int NUMBER_OF_PLANETS = 10;
    private final Bitmap planet00Bitmap;
    private final Bitmap planet01Bitmap;
    private final Bitmap planet02Bitmap;
    private final Bitmap planet03Bitmap;
    private final Bitmap planet04Bitmap;
    private final Bitmap planet05Bitmap;
    private final Bitmap planet06Bitmap;
    private final Bitmap planet07Bitmap;
    private final Bitmap planet08Bitmap;
    private final Bitmap planet09Bitmap;
    public final static double ZOOM = 1280.0 / (1280.0 - 2.0 * 127.0);

    private Context context;
    private int deviceWidth;

    public CreatorBitmapPlanets(Context context, int deviceWidth) {
        this.context = context;
        this.deviceWidth = deviceWidth;
        planet00Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet00);
        planet01Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet01);
        planet02Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet02);
        planet03Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet03);
        planet04Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet04);
        planet05Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet05);
        planet06Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet06);
        planet07Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet07);
        planet08Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet08);
        planet09Bitmap = getBitmapCreateScaledBitmap(R.drawable.planet09);
    }

    private Bitmap getBitmapCreateScaledBitmap(int rDrawablePlanet){
        return Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), rDrawablePlanet, bitmapFactoryOptions),
                (int) (deviceWidth / 6 * ZOOM),
                (int) (deviceWidth / 6 * ZOOM),
                false
        );
    }

    public Bitmap getCreatorRandomBitmapPlanets(){
        switch ((int) (Math.random()*NUMBER_OF_PLANETS)){
            case 0: return planet00Bitmap;
            case 1: return planet01Bitmap;
            case 2: return planet02Bitmap;
            case 3: return planet03Bitmap;
            case 4: return planet04Bitmap;
            case 5: return planet05Bitmap;
            case 6: return planet06Bitmap;
            case 7: return planet07Bitmap;
            case 8: return planet08Bitmap;
            case 9: return planet09Bitmap;
            default: return null;
        }
    }
}