package hcity.timer;

/**
 * A Timer class uses native methods to measure times.
 *
 * @author pan
 */
public class Timer {

    private long prev;

    public void reset() {
        prev = QueryPerformanceCounter();
    }

    /**
     * @return the duration in ms from the point of reset()
     */
    public double getDuration() {
        long current = QueryPerformanceCounter();
        return (current - prev) / frequency;
    }

    static final double frequency;

    static native long QueryPerformanceFrequency();

    static native long QueryPerformanceCounter();

    static {
        System.loadLibrary("extension");
        frequency = QueryPerformanceFrequency() / 1000.0;
    }
}