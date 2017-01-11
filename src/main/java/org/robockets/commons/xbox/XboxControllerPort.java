package org.robockets.commons.xbox;

/**
 * @author Simon Andrews
 */
public enum XboxControllerPort {
    LEFT_THUMBSTICK_X(0),
    LEFT_THUMBSTICK_Y(1),
    LEFT_TRIGGER(2),
    RIGHT_TRIGGER(3),
    RIGHT_THUMBSTICK_X(4),
    RIGHT_THUMBSTICK_Y(5),

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

    XboxControllerPort(int port) {
        this.port = port;
    }
}
