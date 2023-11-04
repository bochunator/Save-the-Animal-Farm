package bochunator.savetheanimalfarm.gameobject;

public class GameObject extends Coordinate {
    protected double deviceWidth;
    protected double deviceHeight;
    protected double boardHeight;
    public GameObject(double positionX, double positionY, double deviceWidth, double deviceHeight) {
        super(positionX, positionY);
        this.deviceHeight = deviceHeight;
        this.deviceWidth = deviceWidth;
        boardHeight = deviceHeight*6/7;
    }
}
