package org.robockets.commons.math;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class Test_MovingAverageCalculator {

	@Test public void testInitial() {
		MovingAverageCalculator r = new MovingAverageCalculator(3);
		assertEquals(r.getAverage(), 0d, 0);
	}
	
	@Test public void testOne() {
		int size = 3;
		double value = 3.5;
		MovingAverageCalculator r = new MovingAverageCalculator(size);
		r.add(value);
		assertEquals(r.getAverage(), value / size, 0.001);
	}
	
	@Test public void testManyValues() {
		MovingAverageCalculator r = new MovingAverageCalculator(5);
		r.add(0.5045421937055368);
		r.add(1.7217385003238697);
		r.add(2.600481930624879);
		r.add(3.7496644783781883);
		r.add(4.932538655373246);
		r.add(5.556877742476397);
		r.add(6.938254024392476);
		r.add(7.3381373450261815);
		r.add(8.279090192973209);
		r.add(9.01027299573511);
		assertEquals(r.getAverage(), 7.425, 0.01);
	}
}
