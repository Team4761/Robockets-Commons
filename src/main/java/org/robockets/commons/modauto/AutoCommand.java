package org.robockets.commons.modauto;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AutoCommand extends Command {
	public abstract AutoCommand generate(double val);
}
