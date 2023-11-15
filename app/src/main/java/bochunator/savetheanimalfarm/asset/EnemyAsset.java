package bochunator.savetheanimalfarm.asset;

import bochunator.savetheanimalfarm.R;

public enum EnemyAsset {
    PLANET00(R.drawable.planet00),
    PLANET01(R.drawable.planet01),
    PLANET02(R.drawable.planet02),
    PLANET03(R.drawable.planet03),
    PLANET04(R.drawable.planet04),
    PLANET05(R.drawable.planet05),
    PLANET06(R.drawable.planet06),
    PLANET07(R.drawable.planet07),
    PLANET08(R.drawable.planet08),
    PLANET09(R.drawable.planet09);
    private final int resourceId;
    EnemyAsset(int resourceId) {
        this.resourceId = resourceId;
    }
    public int getResourceId() {
        return resourceId;
    }
    public static EnemyAsset getRandom() {
        int randomId = (int) (Math.random() * EnemyAsset.values().length);
        return EnemyAsset.values()[randomId];
    }
}
