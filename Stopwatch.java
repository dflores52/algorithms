package app;

public class Stopwatch {
    private long startTime = 0;
    private long stopTime = 0;
    private boolean running = false;

    // Starts the stopwatch.
    public void start() {
        this.startTime = System.nanoTime();
        this.running = true;
    }

    // Stops the stopwatch.
    public void stop() {
        this.stopTime = System.nanoTime();
        this.running = false;
    }

    // Returns the elapsed time in seconds.
    public double elapsedTimeSecs() {
        long elapsed;
        if (running) {
            elapsed = (System.nanoTime() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed / 1.0e9;
    }

    // Returns the elapsed time in milliseconds.
    public double elapsedTimeMillis() {
        long elapsed;
        if (running) {
            elapsed = (System.nanoTime() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed / 1.0e6;
    }

    // Returns a string representation of the elapsed time.
    public String toString() {
        return String.format("%1$,.3f seconds", elapsedTimeSecs());
    }
}

