package ai.core;

import java.util.Arrays;
import java.util.List;

public enum Action {
    Left,
    Up,
    Right,
    Down;

    /**
     * All possible actions
     */
    public static final List<Action> ALL = Arrays.asList(values());
}
