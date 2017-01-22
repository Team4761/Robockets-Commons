package org.robockets.commons.math;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.Instant;

public class Tests_RateTracker {

    @Test public void testConstruction() {
        @SuppressWarnings("unused")
		RateTracker tracker = new RateTracker();
    }

    @Test public void testStart() {
        RateTracker tracker = new RateTracker();
        long a = Instant.now().getEpochSecond();
        tracker.start();
        long b = tracker.getStartTime();
        assertEquals(a, b, 0.05);
    }

    @Test public void testIsStarted() {
        RateTracker tracker = new RateTracker();
        assertFalse(tracker.isStarted());
        tracker.start();
        assertTrue(tracker.isStarted());
    }

    @Test(expected = IllegalStateException.class) public void testUpdateFailsBeforeStart() {
        RateTracker tracker = new RateTracker();
        tracker.update();
    }

    @Test public void testUpdate() {
        RateTracker tracker = new RateTracker();
        tracker.start();
        tracker.update();
    }

    @Test public void testGetRate() throws InterruptedException {
        RateTracker tracker = new RateTracker();
        tracker.start();
        Thread.sleep(500);
        tracker.update();
        Thread.sleep(500);
        tracker.update();
        assertEquals(tracker.getRate(), 2.0, 0.05);
    }
}
