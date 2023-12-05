package it.unibo.mvc;

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
}
