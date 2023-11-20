package bochunator.savetheanimalfarm.asset;

import bochunator.savetheanimalfarm.R;

public enum FireAsset {
    FIRE_BLUE(R.drawable.fire_blue),
    FIRE_GREEN(R.drawable.fire_green),
    FIRE_NORMAL(R.drawable.fire_normal),
    FIRE_PURPLE(R.drawable.fire_purple);
    private final int resourceId;
    FireAsset(int resourceId) {
        this.resourceId = resourceId;
    }
    public int getResourceId() {
        return resourceId;
    }
    public static FireAsset getRandom() {
        int randomId = (int) (Math.random() * FireAsset.values().length);
        return FireAsset.values()[randomId];
    }
}
