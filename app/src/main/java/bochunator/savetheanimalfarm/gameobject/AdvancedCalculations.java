package bochunator.savetheanimalfarm.gameobject;

public class AdvancedCalculations {
    public static boolean isCollidingCircleAndRectangle(GameObjectRadius gameObjectRadius, GameObjectRectangle gameObjectRectangle){

        double widthDistance = Math.abs(gameObjectRadius.getX() - gameObjectRectangle.getX());
        double heightDistance = Math.abs(gameObjectRadius.getY() - gameObjectRectangle.getY());

        if (widthDistance > gameObjectRectangle.getWidth() / 2 + gameObjectRadius.getRadius()) return false;
        if (heightDistance > gameObjectRectangle.getHeight() / 2 + gameObjectRadius.getRadius()) return false;

        if (widthDistance <= gameObjectRectangle.getWidth() / 2) return true;
        if (heightDistance <= gameObjectRectangle.getHeight() /2) return true;

        Coordinate topLeftCorner = new Coordinate(gameObjectRectangle.x - gameObjectRectangle.getWidth()/2, gameObjectRectangle.y - gameObjectRectangle.getHeight()/2);
        Coordinate topRightCorner = new Coordinate(gameObjectRectangle.x + gameObjectRectangle.getWidth()/2, gameObjectRectangle.y - gameObjectRectangle.getHeight()/2);
        if (Coordinate.calculateDistanceBetweenCoordinates(gameObjectRadius, topLeftCorner) <= gameObjectRadius.getRadius()) return true;
        if (Coordinate.calculateDistanceBetweenCoordinates(gameObjectRadius, topRightCorner) <= gameObjectRadius.getRadius()) return true;

        return false;
    }
}
