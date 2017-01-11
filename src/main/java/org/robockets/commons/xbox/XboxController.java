package org.robockets.commons.xbox;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Class for working with Xbox controllers. Uses WPILib's JoyStick class as a
 * base. This class is mostly for making code prettier.
 * @author Simon Andrews
 */
public class XboxController extends Joystick {
    public XboxController(int port) {
        super(port);
    }

    public double getLeftTrigger() {
        return this.getRawAxis(2);
    }
}
