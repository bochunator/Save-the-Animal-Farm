package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapAnimals extends BitmapFactoryOptions{
    private final int WIDTH_ANIMALS_SQUARE_OUTLINE = 918;
    private final int HEIGHT_ANIMALS_SQUARE_OUTLINE = 929;
    public Bitmap getCreatorBitmapAnimals(int id, Context context, int width, int height){//TODO:
        //Bitmap bitmap = new BitmapFactory();
        Bitmap spriteSheetBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.animals_square_outline, bitmapFactoryOptions);
//        return Bitmap.createScaledBitmap(
//                BitmapFactory.decodeResource(context.getResources(), R.drawable.animals_square_outline, bitmapFactoryOptions),
//                918,
//                929,
//                true
//        );
        switch (id){
            case 29: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    194 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    170 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    170 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 24: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    0 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    306 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    192 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    162 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 19: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    658 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    760 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 14: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    658 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    607 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    153 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 9: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    0 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    170 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    194 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 4: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    655 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    471 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 28: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    646 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    169 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 23: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    582 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    0 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 18: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    0 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    647 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    192 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    146 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 13: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    364 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    169 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    146 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 8: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    276 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    0 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    170 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    169 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 3: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    0 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    468 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    192 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    179 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 27: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    657 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    305 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 22: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    192 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    442 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    174 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 17: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    521 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    320 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    151 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 12: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    186 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    793 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    182 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 7: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    0 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    0 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    276 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    170 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 2: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    368 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    743 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    154 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    153 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 26: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    370 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    305 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 21: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    0 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    793 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    186 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 16: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    519 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    578 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 11: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    366 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    442 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    155 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 6: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    192 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    306 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    178 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 1: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    510 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    184 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 25: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    192 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    578 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    171 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 20: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    446 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    0 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 15: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    782 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    153 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    147 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 10: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    522 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    714 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    142 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 5: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    363 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    578 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    156 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    165 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            case 0: return Bitmap.createBitmap(
                    spriteSheetBitmap,
                    782 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    0 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE,
                    136 * spriteSheetBitmap.getWidth() / WIDTH_ANIMALS_SQUARE_OUTLINE,
                    153 * spriteSheetBitmap.getHeight() / HEIGHT_ANIMALS_SQUARE_OUTLINE);
            default: return null;
        }
        //Bitmap player = Bitmap.createBitmap(spriteSheetBitmap, 510, 136, spriteSheetBitmap.getWidth()-510, spriteSheetBitmap.getHeight()-136);
        //return spriteSheetBitmap; //510, 136, 510+136, 136+184);
    }
}
