package it.unibo.mvc;

import java.util.List;

/**
 * Interface to print Output on stdout.
 */ 
public interface Controller {
    /**
     * @param toPrint The string that is going to be printed on stdout.
     */
    static void print(String toPrint) {
        System.out.println(toPrint); //NOPMD: it is asked to print on stdout
    }

    /**
     * Sets the value of the next string to be printed.
     * @param newString is the new value to save.
     */
    void setNextString(String newString);

    /**
     * @return the value of the next string to be printed.
     */
    String getNextString();

    /**
     * @return a List of String containing all the strings that have been printed.
     */
    List<String> getPrintHistory();

    /**
     * Prints the next string to be printed.
     */
    void printString();
}
