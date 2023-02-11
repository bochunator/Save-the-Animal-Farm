package bochunator.savetheanimalfarm.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import bochunator.savetheanimalfarm.R;

public class CreatorBitmapChooseAnimal{
    private static final int NUMBER_OF_ROWS = 6;
    private static final int NUMBER_OF_COLUMNS = 5;

    Bitmap squareNoDetailsOutlineBitmap;
    Context context;

    public CreatorBitmapChooseAnimal(Context context) {
        this.context = context;
        this.squareNoDetailsOutlineBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.square_no_details_outline);
    }

    public Bitmap getSquareNoDetailsOutlineBitmap() {
        return squareNoDetailsOutlineBitmap;
    }

    public Bitmap getCreatorBitmapChooseAnimal(int id){
        int column = id % NUMBER_OF_COLUMNS;
        int row = id / NUMBER_OF_COLUMNS;
        return  Bitmap.createBitmap(
                squareNoDetailsOutlineBitmap,
                squareNoDetailsOutlineBitmap.getWidth() * column / NUMBER_OF_COLUMNS,
                squareNoDetailsOutlineBitmap.getHeight() * row / NUMBER_OF_ROWS,
                squareNoDetailsOutlineBitmap.getWidth() / NUMBER_OF_COLUMNS,
                squareNoDetailsOutlineBitmap.getHeight() / NUMBER_OF_ROWS
        );
    }
}
