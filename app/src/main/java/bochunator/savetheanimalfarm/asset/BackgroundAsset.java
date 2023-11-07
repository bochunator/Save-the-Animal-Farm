package bochunator.savetheanimalfarm.asset;

import bochunator.savetheanimalfarm.R;

public enum BackgroundAsset {
    BACKGROUND_CASTLES(R.drawable.background_castles, 1),
    BACKGROUND_COLOR_DESERT(R.drawable.background_color_desert, 2),
    BACKGROUND_COLOR_FALL(R.drawable.background_color_fall, 3),
    BACKGROUND_DESERT(R.drawable.background_desert, 4),
    BACKGROUND_COLOR_FOREST(R.drawable.background_color_forest, 5),
    BACKGROUND_COLOR_GRASS(R.drawable.background_color_grass, 6),
    BACKGROUND_EMPTY(R.drawable.background_empty, 7),
    BACKGROUND_FOREST(R.drawable.background_forest, 8);
    private final int resourceId;
    private final int id;
    BackgroundAsset(int resourceId, int id) {
        this.resourceId = resourceId;
        this.id = id;
    }
    public int getResourceId() {
        return resourceId;
    }
    public int getId() {
        return id;
    }
}
