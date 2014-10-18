package ai.util;

public final class Helper {
    private static Helper instance = null;

    /**
     * Singleton method
     * @return
     */
    public static Helper getInstance() {
        if (instance == null) {
            instance = new Helper();
        }
        return instance;
    }
    
    public double nanoSecondsToSeconds(long nanoSeconds) {
        return nanoSeconds / Math.pow(10, 6);
    }
}
