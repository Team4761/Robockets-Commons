package main.java.org.robockets.commons.modauto;

import edu.wpi.first.wpilibj.command.Command;

import java.lang.reflect.Constructor;

/**
 * Created by jake.backer on 3/21/2018.
 */
public abstract class StraightCommand extends Command {
	protected double distance;

	public StraightCommand (double distance) {
		this.distance = distance;
	}

	public static StraightCommand generate(double distance) {
		
	}

	@Override
	protected void initialize() {
	}

	/**
	 * DO NOT OVERRIDE THIS
	 */
	@Override
	protected void execute() {
		driveStraight(distance);
	}

	protected abstract void driveStraight(double distance);
}
