package org.robockets.commons.xbox;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Class for working with Xbox controllers. Uses WPILib's Joystick class as a
 * base. This class is mostly for making code prettier.
 * @author Simon Andrews
 * @since 0.0.2
 */
public class XboxController extends Joystick {
    public XboxController(int port) {
        super(port);
    }

    public double getLeftThumbstickX() {
        return this.getRawAxis(XboxControllerAxis.LEFT_THUMBSTICK_X);
    }

    public double getLeftThumbstickY() {
        return this.getRawAxis(XboxControllerAxis.LEFT_THUMBSTICK_Y);
    }

    public double getLeftTrigger() {
        return this.getRawAxis(XboxControllerAxis.LEFT_TRIGGER);
    }

    public double getRightTrigger() {
        return this.getRawAxis(XboxControllerAxis.RIGHT_TRIGGER);
    }

    public double getRightThumbstickX() {
        return this.getRawAxis(XboxControllerAxis.RIGHT_THUMBSTICK_X);
    }

    public double getRightThumbstickY() {
        return this.getRawAxis(XboxControllerAxis.RIGHT_THUMBSTICK_Y);
    }

    public boolean isAButtonPressed() {
        return this.getRawButton(XboxControllerButton.A_BUTTON);
    }

    public boolean isBButtonPressed() {
        return this.getRawButton(XboxControllerButton.B_BUTTON);
    }

    public boolean isXButtonPressed() {
        return this.getRawButton(XboxControllerButton.X_BUTTON);
    }

    public boolean isYButtonPressed() {
        return this.getRawButton(XboxControllerButton.Y_BUTTON);
    }

    public boolean isLeftBumperPressed() {
        return this.getRawButton(XboxControllerButton.LEFT_BUMPER);
    }

    public boolean isRightBumperPressed() {
        return this.getRawButton(XboxControllerButton.RIGHT_BUMPER);
    }

    public boolean isSelectButtonPressed() {
        return this.getRawButton(XboxControllerButton.SELECT_BUTTON);
    }

    public boolean isStartButtonPressed() {
        return this.getRawButton(XboxControllerButton.START_BUTTON);
    }

    public boolean isLeftThumbstickButtonPressed() {
        return this.getRawButton(XboxControllerButton.LEFT_THUMBSTICK_BUTTON);
    }

    public boolean isRightThumbstickButtonPressed() {
        return this.getRawButton(XboxControllerButton.RIGHT_THUMBSTICK_BUTTON);
    }

    public double getRawAxis(XboxControllerAxis axis) {
        return super.getRawAxis(axis.port);
    }

    public boolean getRawButton(XboxControllerButton button) {
        return super.getRawButton(button.port);
    }
}
