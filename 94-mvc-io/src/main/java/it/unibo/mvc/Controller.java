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

    public void setNextString(String newString);

    public String getNextString();

    public List<String> getPrintHistory();

    public void printString();
}
