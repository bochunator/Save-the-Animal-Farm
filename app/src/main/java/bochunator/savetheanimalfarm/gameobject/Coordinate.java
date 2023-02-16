package bochunator.savetheanimalfarm.gameobject;

public class Coordinate {
    protected double positionX;
    protected double positionY;

    public Coordinate(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static double calculateDistanceBetweenCoordinates(Coordinate firstCoordinate, Coordinate secondCoordinate){
        return Math.sqrt(
                Math.pow(secondCoordinate.positionX - firstCoordinate.positionX, 2) +
                        Math.pow(secondCoordinate.positionY - firstCoordinate.positionY, 2)
        );
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
}