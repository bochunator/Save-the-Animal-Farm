package bochunator.savetheanimalfarm.asset;

import androidx.annotation.NonNull;

import bochunator.savetheanimalfarm.R;

public enum BackgroundAsset {
    ALL_BACKGROUNDS(R.drawable.all_backgrounds, true),
    BACKGROUND_CASTLES(R.drawable.background_castles),
    BACKGROUND_COLOR_DESERT(R.drawable.background_color_desert),
    BACKGROUND_COLOR_FALL(R.drawable.background_color_fall),
    BACKGROUND_DESERT(R.drawable.background_desert),
    BACKGROUND_COLOR_FOREST(R.drawable.background_color_forest),
    BACKGROUND_COLOR_GRASS(R.drawable.background_color_grass),
    BACKGROUND_EMPTY(R.drawable.background_empty),
    BACKGROUND_FOREST(R.drawable.background_forest),
    SUMMER_1(R.drawable.summer_1),
    SUMMER_2(R.drawable.summer_2),
    SUMMER_3(R.drawable.summer_3),
    SUMMER_4(R.drawable.summer_4),
    SUMMER_5(R.drawable.summer_5),
    SUMMER_6(R.drawable.summer_6),
    SUMMER_7(R.drawable.summer_7),
    SUMMER_8(R.drawable.summer_8),
    OCEAN_1(R.drawable.ocean_1),
    OCEAN_2(R.drawable.ocean_2),
    OCEAN_3(R.drawable.ocean_3),
    OCEAN_4(R.drawable.ocean_4),
    OCEAN_5(R.drawable.ocean_5),
    OCEAN_6(R.drawable.ocean_6),
    OCEAN_7(R.drawable.ocean_7),
    OCEAN_8(R.drawable.ocean_8),
    WINTER_1(R.drawable.winter_1),
    WINTER_2(R.drawable.winter_2),
    WINTER_3(R.drawable.winter_3),
    WINTER_4(R.drawable.winter_4),
    WINTER_5(R.drawable.winter_5),
    WINTER_6(R.drawable.winter_6),
    WINTER_7(R.drawable.winter_7),
    WINTER_8(R.drawable.winter_8),
    NATURE_1(R.drawable.nature_1),
    NATURE_2(R.drawable.nature_2),
    NATURE_3(R.drawable.nature_3),
    NATURE_4(R.drawable.nature_4),
    NATURE_5(R.drawable.nature_5),
    NATURE_6(R.drawable.nature_6),
    NATURE_7(R.drawable.nature_7),
    NATURE_8(R.drawable.nature_8),
    CITY_1(R.drawable.city_1),
    CITY_2(R.drawable.city_2),
    CITY_3(R.drawable.city_3),
    CITY_4(R.drawable.city_4),
    CITY_5(R.drawable.city_5),
    CITY_6(R.drawable.city_6),
    CITY_7(R.drawable.city_7),
    CITY_8(R.drawable.city_8),
    MOUNTAIN_1(R.drawable.mountain_1),
    MOUNTAIN_2(R.drawable.mountain_2),
    MOUNTAIN_3(R.drawable.mountain_3),
    MOUNTAIN_4(R.drawable.mountain_4),
    MOUNTAIN_5(R.drawable.mountain_5),
    MOUNTAIN_6(R.drawable.mountain_6),
    MOUNTAIN_7(R.drawable.mountain_7),
    MOUNTAIN_8(R.drawable.mountain_8);
    private final int resourceId;
    private final boolean locked;
    BackgroundAsset(int resourceId, boolean locked) {
        this.resourceId = resourceId;
        this.locked = locked;
    }
    BackgroundAsset(int resourceId) {
        this.resourceId = resourceId;
        locked = false;
    }
    public int getResourceId() {
        return resourceId;
    }
    public boolean isLocked() {
        return locked;
    }
    public BackgroundAsset getNext() {
        int next = (this.ordinal() + 1) % values().length;
        return values()[next];
    }
    public BackgroundAsset getPrevious() {
        int previous = (this.ordinal() - 1 + values().length) % values().length;
        return values()[previous];
    }
    @NonNull
    public static BackgroundAsset getRandom() {
        int randomId = (int) (Math.random() * BackgroundAsset.values().length);
        BackgroundAsset returnAsset =  BackgroundAsset.values()[randomId];
        if (returnAsset.isLocked()) {
            return getRandom();
        }
        return returnAsset;
    }
}
