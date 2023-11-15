package bochunator.savetheanimalfarm.asset;

import bochunator.savetheanimalfarm.R;

public enum GroundAsset {
    GROUND_CAKE(R.drawable.ground_cake),
    GROUND_CAKE_BROKEN(R.drawable.ground_cake_broken),
    GROUND_GRASS(R.drawable.ground_grass),
    GROUND_GRASS_BROKEN(R.drawable.ground_grass_broken),
    GROUND_SAND(R.drawable.ground_sand),
    GROUND_SAND_BROKEN(R.drawable.ground_sand_broken),
    GROUND_SNOW(R.drawable.ground_snow),
    GROUND_SNOW_BROKEN(R.drawable.ground_snow_broken),
    GROUND_STONE(R.drawable.ground_stone),
    GROUND_STONE_BROKEN(R.drawable.ground_stone_broken),
    GROUND_WOOD(R.drawable.ground_wood),
    GROUND_WOOD_BROKEN(R.drawable.ground_wood_broken);
    private final int resourceId;
    GroundAsset(int resourceId) {
        this.resourceId = resourceId;
    }
    public int getResourceId() {
        return resourceId;
    }
    public static GroundAsset getRandom() {
        int randomId = (int) (Math.random() * GroundAsset.values().length);
        return GroundAsset.values()[randomId];
    }
}