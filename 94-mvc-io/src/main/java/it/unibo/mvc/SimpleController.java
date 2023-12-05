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
    @Override
    public void setNextString(final String newString) {
        if (newString == null) {
            throw new IllegalArgumentException("String cannot be set to null");
        } else {
            this.nextString = newString;
        }
    }

    /**
     * Getter for the nextString field.
     * @return the next string to be printed.
     */
    @Override
    public String getNextString() {
        return this.nextString;
    }

    /**
     * Getter for the history field.
     * @return the history of printed strings as a list of strings.
     */
    @Override
    public List<String> getPrintHistory() {
        return List.copyOf(this.history);
    }

    /**
     * Prints the next string on stdout and adds it to the history of printed strings.
     */
    @Override
    public void printString() {
        if (this.nextString == null) {
            throw new IllegalStateException("The string is unset");
        } else {
            Controller.print(this.nextString);
            this.history.add(this.nextString);
        }
    }
}
