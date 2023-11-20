package bochunator.savetheanimalfarm.object;

public class Circle extends Entity {
    protected float diameter;
    public Circle(float diameter) {
        this.diameter = diameter;
    }
    public float getDiameter() {
        return diameter;
    }
}
