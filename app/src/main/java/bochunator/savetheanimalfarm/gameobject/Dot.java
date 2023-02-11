package bochunator.savetheanimalfarm.gameobject;

public class Dot {
    protected double positionX;
    protected double positionY;

    public Dot(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public static double getDistanceBetweenDots(Dot firstDot, Dot secondDot){
        return Math.sqrt(
                Math.pow(secondDot.positionX - firstDot.positionX, 2) +
                        Math.pow(secondDot.positionY - firstDot.positionY, 2)
        );
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }
}