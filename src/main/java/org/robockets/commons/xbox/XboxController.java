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

    public double getLeftThumbstickX() {
        return this.getRawAxis(XboxControllerPort.LEFT_THUMBSTICK_X);
    }

    public double getLeftThumbstickY() {
        return this.getRawAxis(XboxControllerPort.LEFT_THUMBSTICK_Y);
    }

    public double getLeftTrigger() {
        return this.getRawAxis(XboxControllerPort.LEFT_TRIGGER);
    }

    public double getRightTrigger() {
        return this.getRawAxis(XboxControllerPort.RIGHT_TRIGGER);
    }

    public double getRightThumbstickX() {
        return this.getRawAxis(XboxControllerPort.RIGHT_THUMBSTICK_X);
    }

    public double getRightThumbstickY() {
        return this.getRawAxis(XboxControllerPort.RIGHT_THUMBSTICK_Y);
    }

    public boolean isAButtonPressed() {
        return this.getRawButton(XboxControllerPort.A_BUTTON);
    }

    public boolean isBButtonPressed() {
        return this.getRawButton(XboxControllerPort.B_BUTTON);
    }

    public boolean isXButtonPressed() {
        return this.getRawButton(XboxControllerPort.X_BUTTON);
    }

    public boolean isYButtonPressed() {
        return this.getRawButton(XboxControllerPort.Y_BUTTON);
    }

    public boolean isLeftBumperPressed() {
        return this.getRawButton(XboxControllerPort.LEFT_BUMPER);
    }

    public boolean isRightBumperPressed() {
        return this.getRawButton(XboxControllerPort.RIGHT_BUMPER);
    }

    public boolean isSelectButtonPressed() {
        return this.getRawButton(XboxControllerPort.SELECT_BUTTON);
    }

    public boolean isStartButtonPressed() {
        return this.getRawButton(XboxControllerPort.START_BUTTON);
    }

    public boolean isLeftThumbstickButtonPressed() {
        return this.getRawButton(XboxControllerPort.LEFT_THUMBSTICK_BUTTON);
    }

    public boolean isRightThumbstickButtonPressed() {
        return this.getRawButton(XboxControllerPort.RIGHT_THUMBSTICK_BUTTON);
    }

    public boolean isButtonPressed(XboxControllerPort buttonPort) throws IllegalArgumentException {
        switch (buttonPort) {
            case A_BUTTON:
            case B_BUTTON:
            case X_BUTTON:
            case Y_BUTTON:
            case LEFT_BUMPER:
            case RIGHT_BUMPER:
            case SELECT_BUTTON:
            case START_BUTTON:
            case LEFT_THUMBSTICK_BUTTON:
            case RIGHT_THUMBSTICK_BUTTON:
                return this.getRawButton(buttonPort);
            default:
                throw new IllegalArgumentException("Not a button");
        }
    }

    public double getRawAxis(XboxControllerPort port) {
        return super.getRawAxis(port.port);
    }

    public boolean getRawButton(XboxControllerPort port) {
        return super.getRawButton(port.port);
    }
}
