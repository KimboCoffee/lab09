package it.unibo.mvc;

/**
 * Interface to print Output on stdout
 */ 
public interface Controller {
    /**
     * @param toPrint The string that is going to be printed on stdout.
     */
    public static void print(String toPrint) {
        System.out.println(toPrint);
    }
}
