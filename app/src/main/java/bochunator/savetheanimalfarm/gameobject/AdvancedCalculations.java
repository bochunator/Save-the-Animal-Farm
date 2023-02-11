package bochunator.savetheanimalfarm.gameobject;

public class AdvancedCalculations {
    public static boolean isCollidingCircleAndRectangle(GameObjectRadius gameObjectRadius, GameObjectRectangle gameObjectRectangle){

        double widthDistance = Math.abs(gameObjectRadius.getPositionX() - gameObjectRectangle.getPositionX());
        double heightDistance = Math.abs(gameObjectRadius.getPositionY() - gameObjectRectangle.getPositionY());

        if (widthDistance > gameObjectRectangle.getWidth() / 2 + gameObjectRadius.getRadius()) return false;
        if (heightDistance > gameObjectRectangle.getHeight() / 2 + gameObjectRadius.getRadius()) return false;

        if (widthDistance <= gameObjectRectangle.getWidth() / 2) return true;
        if (heightDistance <= gameObjectRectangle.getHeight() /2) return true;

        Dot topLeftCorner = new Dot(gameObjectRectangle.positionX - gameObjectRectangle.getWidth()/2, gameObjectRectangle.positionY - gameObjectRectangle.getHeight()/2);
        Dot topRightCorner = new Dot(gameObjectRectangle.positionX + gameObjectRectangle.getWidth()/2, gameObjectRectangle.positionY - gameObjectRectangle.getHeight()/2);
        if (Dot.getDistanceBetweenDots(gameObjectRadius, topLeftCorner) <= gameObjectRadius.getRadius()) return true;
        if (Dot.getDistanceBetweenDots(gameObjectRadius, topRightCorner) <= gameObjectRadius.getRadius()) return true;

        return false;
    }
}
