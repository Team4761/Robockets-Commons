package org.robockets.commons.xbox;

/**
 * Button on an Xbox controller. Basically any input that outputs a true or
 * false.
 * @author Simon Andrews
 * @since 0.0.2
 */
public enum XboxControllerButton {
    A_BUTTON(1),
    B_BUTTON(2),
    X_BUTTON(3),
    Y_BUTTON(4),
    LEFT_BUMPER(5),
    RIGHT_BUMPER(6),
    SELECT_BUTTON(7),
    START_BUTTON(8),
    LEFT_THUMBSTICK_BUTTON(9),
    RIGHT_THUMBSTICK_BUTTON(10);

    public final int port;

    XboxControllerButton(int port) {
        this.port = port;
    }
}
