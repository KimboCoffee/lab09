package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 4;

    private final JFrame frame = new JFrame("My first graphical interface");

    /**
     * Builder for the SimpleGUI. Sets up the standard view.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout()); 
        final JTextArea stringReader = new JTextArea("Insert your string here");
        canvas.add(stringReader, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Sets the frame dimention to one fifth of the screen size, and then makes it visible.
     * Delegates positioning to the OS, to avoid showing it in position (0,0).
     */
    public void show() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width = (int) screenSize.getWidth();
        final int height = (int) screenSize.getHeight();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setLocationByPlatform(true);
        this.frame.setVisible(true);
    }

    /**
     * Runs the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final SimpleGUI toBeSeen = new SimpleGUI();
        toBeSeen.show();
    }
}
