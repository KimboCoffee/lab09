package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;

    /**
     * Builder with parameter for this class allows to set where to save your data.
     * @param currentFile is the path of the file to be created.
     */
    public Controller(final File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * Standard builder to address ~/output.txt.
     */
    public Controller() {
        this(new File(
            System.getProperty("user.home") 
            + System.getProperty("file.separator")
            + "output.txt"
        ));
    }

    /**
     * Sets a new path where to save your strings.
     * @param newFile is the new file path.
     */
    public void setCurrentFile(final File newFile) {
        this.currentFile = newFile;
    }

    /**
     * @return the current file where strings are being saved.
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * @return the path of the current file where strings are being saved.
     */
    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    /**
     * Effectively writes on file.
     * @param toWrite is the string to be written.
     * @throws IOException when the string is null or PrintStream throws it.
     */
    public void write(final String toWrite) throws IOException {
        if (Objects.isNull(toWrite)) {
            throw new IOException("Cannot write a null string");
        } else {
            try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
                ps.print(toWrite);
            }
        }
    }
}
