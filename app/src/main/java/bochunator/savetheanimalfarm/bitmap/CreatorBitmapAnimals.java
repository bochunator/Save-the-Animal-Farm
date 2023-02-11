package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapAnimals extends BitmapFactoryOptions{
    public Bitmap getCreatorBitmapAnimals(int id, Context context, int width, int height){//TODO:
        Bitmap spriteSheetBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.animals_square_outline, bitmapFactoryOptions);
        switch (id){
            case 0: return Bitmap.createBitmap(spriteSheetBitmap, 782, 0, 136, 153);
            case 1: return Bitmap.createBitmap(spriteSheetBitmap, 510, 136, 136, 184);
            case 2: return Bitmap.createBitmap(spriteSheetBitmap, 368, 743, 154, 153);
            case 3: return Bitmap.createBitmap(spriteSheetBitmap, 0, 468, 192, 179);
            case 4: return Bitmap.createBitmap(spriteSheetBitmap, 655, 471, 136, 136);
            case 5: return Bitmap.createBitmap(spriteSheetBitmap, 363, 578, 156, 165);
            case 6: return Bitmap.createBitmap(spriteSheetBitmap, 192, 306, 178, 136);
            case 7: return Bitmap.createBitmap(spriteSheetBitmap, 0, 0, 276, 170);
            case 8: return Bitmap.createBitmap(spriteSheetBitmap, 276, 0, 170, 169);
            case 9: return Bitmap.createBitmap(spriteSheetBitmap, 0, 170, 194, 136);
            case 10: return Bitmap.createBitmap(spriteSheetBitmap, 522, 714, 136, 142);
            case 11: return Bitmap.createBitmap(spriteSheetBitmap, 366, 442, 155, 136);
            case 12: return Bitmap.createBitmap(spriteSheetBitmap, 194, 170, 170, 136);
            case 13: return Bitmap.createBitmap(spriteSheetBitmap, 364, 169, 146, 136);
            case 14: return Bitmap.createBitmap(spriteSheetBitmap, 658, 607, 136, 153);
            case 15: return Bitmap.createBitmap(spriteSheetBitmap, 782, 153, 136, 147);
            case 16: return Bitmap.createBitmap(spriteSheetBitmap, 519, 578, 136, 136);
            case 17: return Bitmap.createBitmap(spriteSheetBitmap, 521, 320, 136, 151);
            case 18: return Bitmap.createBitmap(spriteSheetBitmap, 0, 647, 192, 146);
            case 19: return Bitmap.createBitmap(spriteSheetBitmap, 658, 760, 136, 136);
            case 20: return Bitmap.createBitmap(spriteSheetBitmap, 446, 0, 136, 136);
            case 21: return Bitmap.createBitmap(spriteSheetBitmap, 0, 793, 186, 136);
            case 22: return Bitmap.createBitmap(spriteSheetBitmap, 192, 442, 174, 136);
            case 23: return Bitmap.createBitmap(spriteSheetBitmap, 582, 0, 136, 136);
            case 24: return Bitmap.createBitmap(spriteSheetBitmap, 0, 306, 192, 162);
            case 25: return Bitmap.createBitmap(spriteSheetBitmap, 192, 578, 171, 136);
            case 26: return Bitmap.createBitmap(spriteSheetBitmap, 370, 305, 136, 136);
            case 27: return Bitmap.createBitmap(spriteSheetBitmap, 657, 305, 136, 136);
            case 28: return Bitmap.createBitmap(spriteSheetBitmap, 646, 136, 136, 169);
            case 29: return Bitmap.createBitmap(spriteSheetBitmap, 186, 793, 182, 136);
            default: return null;
        }
    }
}
