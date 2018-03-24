package org.robockets.commons.modauto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoFactory<Straight extends StraightCommand, Turn extends Command, Manipulator extends Command, Auxiliary extends Command> {
	private CommandGroup commands;

	public AutoFactory() {
		commands = new CommandGroup();
	}

	public void reset() {
		commands = new CommandGroup();
	}

	public void driveStraight(double distance) {
		commands.addSequential(Straight.generate(distance));
	}
}
