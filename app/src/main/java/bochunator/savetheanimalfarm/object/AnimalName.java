package bochunator.savetheanimalfarm.object;

public enum AnimalName {
    ZEBRA,
    RABBIT,
    NARWHAL,
    GOAT,
    CROCODILE,
    WHALE,
    PIG,
    MOOSE,
    GIRAFFE,
    COW,
    WALRUS,
    PENGUIN,
    BEAR,
    FROG,
    CHICKEN,
    SNAKE,
    PARROT,
    HORSE,
    ELEPHANT,
    CHICK,
    SLOTH,
    PANDA,
    HIPPO,
    DUCK,
    BUFFALO,
    RHINO,
    OWL,
    GORILLA,
    DOG,
    MONKEY;
    public AnimalName getNext() {
        return values()[(this.ordinal() + 1) % values().length];
    }
    public  AnimalName getPrevious() {
        return values()[(this.ordinal() - 1 + values().length) % values().length];
    }
}
