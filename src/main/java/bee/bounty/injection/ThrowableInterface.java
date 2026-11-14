package bee.bounty.injection;

public interface ThrowableInterface {

    default void bounty$setMergeDelay(int delay) {

    }
    default int bounty$getMergeDelay() {
        return 0;
    }

}
