package bochunator.savetheanimalfarm.manager;

public class GameUpdate {
    private final ObjectManager objectManager;
    public GameUpdate(ObjectManager objectManager) {
        this.objectManager = objectManager;
    }
    public void advanceGameState(float elapsed) {
        float y = objectManager.getPositionY();
        if (1200 < y) {
            objectManager.setPositionY(100);
        } else {
            objectManager.setPositionY(y + 3 * elapsed);
        }
    }
}
