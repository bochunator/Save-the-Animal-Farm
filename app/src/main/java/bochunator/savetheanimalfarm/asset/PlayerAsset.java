package bochunator.savetheanimalfarm.asset;

import bochunator.savetheanimalfarm.R;

public enum PlayerAsset {
    /**
     * Moose has antlers which has not collision detection.
     * File moose.png is size width = 276, and height = 170,
     * but both width and height collisions are equal 136.
     * Offset width (left) is 70
     * and offset height (top) is 34.
     * Different animals can have different size, offsets and collision detection
     */
    ZEBRA(R.drawable.zebra, 0, 17),
    RABBIT(R.drawable.rabbit, 0, 48),
    NARWHAL(R.drawable.narwhal, 8, 11),
    GOAT(R.drawable.goat, 28, 22),
    CROCODILE(R.drawable.crocodile, 0, 0),
    WHALE(R.drawable.whale, 10, 19),
    PIG(R.drawable.pig, 22, 0),
    MOOSE(R.drawable.moose, 70, 34, 136, 136),
    GIRAFFE(R.drawable.giraffe, 17, 33),
    COW(R.drawable.cow, 29, 0),
    WALRUS(R.drawable.walrus, 0, 0),
    PENGUIN(R.drawable.penguin, 10, 0),
    BEAR(R.drawable.bear, 17, 0),
    FROG(R.drawable.frog, 5, 0),
    CHICKEN(R.drawable.chicken, 0, 17),
    SNAKE(R.drawable.snake, 0, 0),
    PARROT(R.drawable.parrot, 0, 0),
    HORSE(R.drawable.horse, 0, 15),
    ELEPHANT(R.drawable.elephant, 28, 10),
    CHICK(R.drawable.chick, 0, 0),
    SLOTH(R.drawable.sloth, 0, 0),
    PANDA(R.drawable.panda, 25, 0),
    HIPPO(R.drawable.hippo, 19, 0),
    DUCK(R.drawable.duck, 0, 0),
    BUFFALO(R.drawable.buffalo, 28, 11),
    RHINO(R.drawable.rhino, 17, 0),
    OWL(R.drawable.owl, 0, 0),
    GORILLA(R.drawable.gorilla, 0, 0),
    DOG(R.drawable.dog, 0, 33),
    MONKEY(R.drawable.monkey, 29, 0);
    private final int resourceId;
    private final int offsetWidth;
    private final int offsetHeight;
    private final int collisionWidth;
    private final int collisionHeight;
    PlayerAsset(int resourceId, int offsetWidth, int offsetHeight, int collisionWidth, int collisionHeight) {
        this.resourceId = resourceId;
        this.offsetWidth = offsetWidth;
        this.offsetHeight = offsetHeight;
        this.collisionWidth = collisionWidth;
        this.collisionHeight = collisionHeight;
    }
    PlayerAsset(int resourceId, int offsetWidth, int offsetHeight) {
        this.resourceId = resourceId;
        this.offsetWidth = offsetWidth;
        this.offsetHeight = offsetHeight;
        collisionWidth = 136;
        collisionHeight = 136;
    }
    public int getResourceId() {
        return resourceId;
    }
    public int getOffsetWidth() {
        return offsetWidth;
    }
    public int getOffsetHeight() {
        return offsetHeight;
    }
    public int getCollisionWidth() {
        return collisionWidth;
    }
    public int getCollisionHeight() {
        return collisionHeight;
    }
    public PlayerAsset getNext() {
        int next = (this.ordinal() + 1) % values().length;
        return values()[next];
    }
    public PlayerAsset getPrevious() {
        int previous = (this.ordinal() - 1 + values().length) % values().length;
        return values()[previous];
    }
    public static PlayerAsset getRandom() {
        int randomId = (int) (Math.random() * PlayerAsset.values().length);
        return PlayerAsset.values()[randomId];
    }
}
