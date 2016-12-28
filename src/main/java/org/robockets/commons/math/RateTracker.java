package org.robockets.commons.math;

import java.time.Instant;

public class RateTracker {
    private int totalSamples = 0;
    private long startTime;
    private boolean started = false;

    /**
     * Method called so that the tracker starts tracking.
     */
    public void start() {
        startTime = Instant.now().getEpochSecond();
        started = true;
    }

    /**
     * Lets the tracker know that another cycle has been completed.
     */
    public void update() {
        if(isStarted()) {
            totalSamples += 1;
        }
        else {
            throw new IllegalStateException("Attempted to update rate counter before tracker was started");
        }
    }

    /**
     * Gets the rate of cycles per second.
     * @return Rate, in hertz (s<sup>-1</sup>)
     */
    public double getRate() {
        return totalSamples / (Instant.now().getEpochSecond() - startTime);
    }

    /**
     * Gets the time that the tracker was started.
     * @return Start time, in seconds since the UNIX epoch.
     */
    public long getStartTime() { return startTime; }

    /**
     * Says if the tracker has been started yet or not.
     * @return Has the tracker been started yet?
     */
    public boolean isStarted() {
        return started;
    }
}
