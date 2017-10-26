package eda;
public class StopWatch {

    private long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

   /**
     * Return elapsed time (in seconds) since this object was created.
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
