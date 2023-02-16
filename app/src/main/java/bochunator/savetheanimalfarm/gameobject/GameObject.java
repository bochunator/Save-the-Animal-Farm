package bochunator.savetheanimalfarm.gameobject;

public class GameObject extends Coordinate {
    protected double boardWidth;
    protected double boardHeight;

    public GameObject(double positionX, double positionY, double deviceWidth, double deviceHeight) {
        super(positionX, positionY);
        boardWidth = deviceWidth;
        boardHeight = deviceHeight*6/7;
    }
}
