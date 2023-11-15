package bochunator.savetheanimalfarm.asset;

import bochunator.savetheanimalfarm.R;

public enum BackgroundAsset {
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
    WINTER_8(R.drawable.winter_8);

    private final int resourceId;
    BackgroundAsset(int resourceId) {
        this.resourceId = resourceId;
    }
    public int getResourceId() {
        return resourceId;
    }
    public static BackgroundAsset getRandom() {
        int randomId = (int) (Math.random() * BackgroundAsset.values().length);
        return BackgroundAsset.values()[randomId];
    }
}
