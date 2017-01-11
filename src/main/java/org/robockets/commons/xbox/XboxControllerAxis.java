package org.robockets.commons.xbox;

/**
 * @author Simon Andrews
 */
public enum XboxControllerAxis {
    LEFT_THUMBSTICK_X(0),
    LEFT_THUMBSTICK_Y(1),
    LEFT_TRIGGER(2),
    RIGHT_TRIGGER(3),
    RIGHT_THUMBSTICK_X(4),
    RIGHT_THUMBSTICK_Y(5);

    public final int port;

    XboxControllerAxis(int port) {
        this.port = port;
    }
}
