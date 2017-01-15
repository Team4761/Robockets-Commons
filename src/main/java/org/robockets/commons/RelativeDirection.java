package org.robockets.commons;

/**
 * Represents a relative direction.
 * @author Simon Andrews
 * @since 2.0.0
 */
public class RelativeDirection {
	
	/**
	 * Represents a relative direction in the x-axis.
	 * @author Simon Andrews
	 * @since 2.0.0
	 */
	public enum XAxis {
		/**
		 * Relative horizontal direction opposed to right.
		 */
		LEFT,
		
		/**
		 * Relative horizontal direction opposed to left.
		 */
		RIGHT,
	}
	
	/**
	 * Represents a relative direction in the y-axis.
	 * @author Simon Andrews
	 * @since 2.0.0
	 */
	public enum YAxis {
		/**
		 * Relative horizontal direction opposed to backward.
		 */
		FORWARD,
		
		/**
		 * Relative horizontal direction opposed for forward.
		 */
		BACKWARD,
	}
	
	/**
	 * Represents a relative direction in the y-axis.
	 * @author Simon Andrews
	 * @since 2.0.0
	 */
	public enum ZAxis {
		/**
		 * Relative vertical direction opposed to down.
		 */
		UP,
		
		/**
		 * Relative vertical direction opposed to up.
		 */
		DOWN,
	}

}
