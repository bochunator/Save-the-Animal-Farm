package bochunator.savetheanimalfarm.gameobject;

public class Coordinate {
    protected double x;
    protected double y;

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double calculateDistanceBetweenCoordinates(Coordinate firstCoordinate, Coordinate secondCoordinate){
        return Math.sqrt(
                Math.pow(secondCoordinate.x - firstCoordinate.x, 2) +
                        Math.pow(secondCoordinate.y - firstCoordinate.y, 2)
        );
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}