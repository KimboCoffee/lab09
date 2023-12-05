package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple controller that handles I/O services.
 */
public final class SimpleController implements Controller {

    private final List<String> history;
    private String nextString;

    /**
     * Standard constructor for the Controller.
     * It creates a new empty list and sets the next string as null,
     */
    public SimpleController() {
        this.history = new ArrayList<>();
        this.nextString = null;
    }

    /**
     * Setter for the next string to print.
     * @param newString is the new string to be printed.
     */
    public void setNextString(final String newString) {
        if (newString == null) {
            throw new IllegalArgumentException("String cannot be set to null");
        } else {
            this.nextString = newString;
        }
    }
}
