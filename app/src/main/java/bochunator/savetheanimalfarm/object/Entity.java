package bochunator.savetheanimalfarm.object;

import androidx.annotation.NonNull;

public class Entity {
    protected float x;
    protected float y;
    public Entity() {
    }
    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public static float calculateDistance(@NonNull Entity first, @NonNull Entity second) {
        return (float) Math.sqrt(Math.pow(first.x - second.x, 2) + Math.pow(first.y - second.y, 2));
    }
}
