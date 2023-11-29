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

    public Controller(final File currentFile) {
        this.currentFile = currentFile;
    }

    public void setCurrentFile(final File newFile) {
        this.currentFile = newFile;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public String getCurrentFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    public void write (final String toWrite) throws IOException {
        if (Objects.isNull(toWrite)) {
            throw new IOException("Cannot write a null string");
        } else {
            try (PrintStream ps = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
                ps.print(toWrite);                
            }
        }
    }
}
