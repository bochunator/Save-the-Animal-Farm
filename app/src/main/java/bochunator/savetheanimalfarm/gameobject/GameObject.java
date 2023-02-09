package bochunator.savetheanimalfarm.gameobject;

public class GameObject {
    protected double positionX;
    protected double positionY;
    protected double boardWidth;
    protected double boardHeight;

    public GameObject(double positionX, double positionY, double deviceWidth, double deviceHeight) {
        this.positionX = positionX;
        this.positionY = positionY;
        boardWidth = deviceWidth;
        boardHeight = deviceHeight*6/7;
    }

    protected static double getDistanceBetweenObjects(GameObject firstGameObject, GameObject secondGameObject){
        return Math.sqrt(
                Math.pow(secondGameObject.positionX - firstGameObject.positionX, 2) +
                        Math.pow(secondGameObject.positionY - firstGameObject.positionY, 2)
        );
    }
}
