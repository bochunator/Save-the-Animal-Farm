package bochunator.savetheanimalfarm.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.R;

public enum DataManager {
    INSTANCE;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    public DataManager update(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.shared_preferences), Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        return INSTANCE;
    }
    @NonNull
    public <T extends Enum<T>> T getEnum(String key, @NonNull T defaultValue, Class<T> enumType) {
        return Enum.valueOf(enumType, sharedPreferences.getString(key, defaultValue.name()));
    }
    public <T extends Enum<T>> void setEnum(String key, @NonNull T value) {
        editor.putString(key, value.name());
        editor.apply();
    }
    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }
    public void setInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }
}
