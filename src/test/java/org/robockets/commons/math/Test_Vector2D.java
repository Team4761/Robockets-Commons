package org.robockets.commons.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test_Vector2D {
	@Test public void testAddition() {
		Vector2D vec1 = new Vector2D(3, Math.toRadians(45));
		Vector2D vec2 = new Vector2D(5, Math.toRadians(135));
		Vector2D res = vec1.add(vec2);
		
		assertEquals(res.getMagnitude(), 5.83, 0.1);
		assertEquals(Math.toDegrees(res.getAngle()), 104, 0.1);
	}
}
