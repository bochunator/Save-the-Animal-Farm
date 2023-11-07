package bochunator.savetheanimalfarm.thread;

public interface ThreadConstants {
    int TARGET_FPS = 60;
    long SECOND_TO_NANOSECOND = 1_000_000_000;
    long TARGET_FRAME_PERIOD = SECOND_TO_NANOSECOND / TARGET_FPS;
    float TIME_SCALE = 1f / TARGET_FRAME_PERIOD;
}
