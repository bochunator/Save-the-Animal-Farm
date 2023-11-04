package bochunator.savetheanimalfarm.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import bochunator.savetheanimalfarm.R;
import bochunator.savetheanimalfarm.object.AnimalName;

public class Save {
    //TODO: Change Save to other name, cause when I want to load data my mind thinks I will save data
    private static Save instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public static synchronized Save getInstance(Context context) {
        if (null == instance) {
            instance = new Save(context);
        }
        return instance;
    }
    private Save(Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }
    public void setString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }
    public AnimalName getAnimalName(String key, AnimalName defaultValue) {
        return AnimalName.valueOf(sharedPreferences.getString(key, defaultValue.name()));
    }
    public void setAnimalName(String key, AnimalName value) {
        editor.putString(key, value.name());
        editor.apply();
    }
}
