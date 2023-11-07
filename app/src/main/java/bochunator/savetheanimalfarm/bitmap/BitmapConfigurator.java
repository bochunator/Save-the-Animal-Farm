package bochunator.savetheanimalfarm.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

public interface BitmapConfigurator {
    BitmapFactory.Options OPTIONS = createDefaultOptions();
    default BitmapFactory.Options getOptions() {
        return OPTIONS;
    }
    @NonNull
    static BitmapFactory.Options createDefaultOptions() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inScaled = false;
        return options;
    }
}
