package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple controller that handles I/O services
 */
public final class SimpleController implements Controller {

    private final List<String> history;
    private final String nextString;

    /**
     * Standard constructor for the Controller.
     * It creates a new empty list and sets the next string as null,
     */
    public SimpleController() {
        this.history = new ArrayList<String>();
        this.nextString = null;
    }
}