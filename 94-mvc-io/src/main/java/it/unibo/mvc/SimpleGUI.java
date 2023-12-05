package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame();
    private final Controller printer = new SimpleController();

    /**
     * Standard constructor that sets up the view.
     */
    public SimpleGUI() {
        final JPanel canvas = new JPanel();
        frame.add(canvas);
        canvas.setLayout(new BorderLayout());
        final JTextField reader = new JTextField("Write here your next string...");
        canvas.add(reader, BorderLayout.NORTH);
        final JTextArea historyViewer = new JTextArea("See here the strings you printed...");
        canvas.add(historyViewer, BorderLayout.CENTER);
        final JButton print = new JButton("Print");
        final JButton seeHistory = new JButton("See history");
        final JPanel southPanel = new JPanel();
        southPanel.add(print);
        southPanel.add(seeHistory);
        canvas.add(southPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                printer.setNextString(reader.getText());
                printer.printString();
            }

        });
        seeHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                historyViewer.setText(printer.getPrintHistory().toString());
            }

        });
    }

    private void show() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int height = (int) screenSize.getHeight();
        final int width = (int) screenSize.getWidth();
        frame.setSize(width / PROPORTION, height / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Runs the application.
     * @param args is unused.
     */
    public static void main(final String[] args) {
        new SimpleGUI().show();
    }
}
