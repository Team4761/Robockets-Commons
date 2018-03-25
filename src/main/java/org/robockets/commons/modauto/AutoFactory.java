package org.robockets.commons.modauto;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoFactory {
	private CommandGroup commands;
	private AutoCommand straightTemplate;
	private AutoCommand turnTemplate;
	private AutoCommand manipulatorTemplate;
	private AutoCommand auxTemplate;

	public AutoFactory(AutoCommand straightCommand, AutoCommand turnCommand, AutoCommand manipulatorCommand, AutoCommand auxCommand) {
		commands = new CommandGroup();
		straightTemplate = straightCommand;
		turnTemplate = turnCommand;
		manipulatorTemplate = manipulatorCommand;
		auxTemplate = auxCommand;
	}

	public AutoFactory(AutoCommand straightCommand, AutoCommand turnCommand, AutoCommand manipulatorCommand) {
		this(straightCommand,turnCommand,manipulatorCommand,null);
	}

	public void reset() {
		commands = new CommandGroup();
	}

	public void driveStraight(double distance) {
		commands.addSequential(straightTemplate.generate(distance));
	}

	public void turn(double distance) {
		commands.addSequential(turnTemplate.generate(distance));
	}

	public void moveManipulator(double distance) {
		commands.addSequential(manipulatorTemplate.generate(distance));
	}

	public void manipulatorParallel(double distance) {
		commands.addParallel(manipulatorTemplate.generate(distance));
	}

	public void runAuxCommand(double amount) {
		commands.addSequential(auxTemplate.generate(amount));
	}

	public CommandGroup returnCommand() {
		return commands;
	}
}
