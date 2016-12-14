package org.robockets.commons.math;

/**
 * Class for working with and calculating moving averages. Can be used to
 * smooth out output to take care of spikes.
 * @author <a href="http://stackoverflow.com/a/3793957">Tony Ennis</a>
 */
public class MovingAverageCalculator {
	private int size;
	private double total = 0d;
	private int index = 0;
	private double[] samples;
	
	/**
	 * Makes a new moving average calculator.
	 * @param size How many digits do you want to average at a time?
	 */
	public MovingAverageCalculator(int size) {
		this.size = size;
		this.samples = new double[size];
		for(int i = 0; i < size; i++) samples[i] = 0d;
	}
	
	/**
	 * Adds a new number on to your existing data set.
	 * @param x Number to add on
	 */
	public void add(double x) {
		total -= samples[index];
		samples[index] = x;
		total += x;
		if(++index == size) index = 0; //cheaper than modulus
	}
	
	/**
	 * Gets the current average.
	 * @return Total of all data.
	 */
	public double getAverage() {
		return total / size;
	}
}
