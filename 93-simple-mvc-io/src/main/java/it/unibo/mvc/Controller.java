package it.unibo.mvc;

import java.io.File;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;

    public Controller(final File currentFile) {
        this.currentFile = currentFile;
    }

    public void setCurrentFile(final File newFile) {
        this.currentFile = newFile;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }
}
