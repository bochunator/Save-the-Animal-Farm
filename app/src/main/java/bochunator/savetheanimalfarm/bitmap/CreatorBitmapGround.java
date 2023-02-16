package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapGround extends BitmapFactoryOptions{
    public final int NUMBER_OF_GROUNDS = 12;
    public final int groundCake = R.drawable.ground_cake;
    public final int groundCakeBroken = R.drawable.ground_cake_broken;
    public final int groundGrass = R.drawable.ground_grass;
    public final int groundGrassBroken = R.drawable.ground_grass_broken;
    public final int groundSand = R.drawable.ground_sand;
    public final int groundSandBroken = R.drawable.ground_sand_broken;
    public final int groundSnow = R.drawable.ground_snow;
    public final int groundSnowBroken = R.drawable.ground_snow_broken;
    public final int groundStone = R.drawable.ground_stone;
    public final int groundStoneBroken = R.drawable.ground_stone_broken;
    public final int groundWood = R.drawable.ground_wood;
    public final int groundWoodBroken = R.drawable.ground_wood_broken;

    public Bitmap getCreatorBitmapGround(Context context, int width, int height){
        int[] array = new int[NUMBER_OF_GROUNDS];
        array[0] = groundCake;
        array[1] = groundCakeBroken;
        array[2] = groundGrass;
        array[3] = groundGrassBroken;
        array[4] = groundSand;
        array[5] = groundSandBroken;
        array[6] = groundSnow;
        array[7] = groundSnowBroken;
        array[8] = groundStone;
        array[9] = groundStoneBroken;
        array[10] = groundWood;
        array[11] = groundWoodBroken;
        return Bitmap.createScaledBitmap(
                BitmapFactory.decodeResource(context.getResources(), array[(int) (Math.random()*NUMBER_OF_GROUNDS)], bitmapFactoryOptions),
                width,
                height,
                true
        );
    }
}
