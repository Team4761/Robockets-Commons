package org.robockets.commons.xbox;

/**
 * Axis on an Xbox controller. Basically any input where the output is a range
 * instead of a yes/no.
 * @author Simon Andrews
 * @since 0.0.2
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
