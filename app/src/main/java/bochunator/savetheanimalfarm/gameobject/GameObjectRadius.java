package bochunator.savetheanimalfarm.gameobject;

public class GameObjectRadius extends GameObject {
    protected double radius;
    public GameObjectRadius(double positionX, double positionY, double deviceWidth, double deviceHeight, double radius) {
        super(positionX, positionY, deviceWidth, deviceHeight);
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
}
