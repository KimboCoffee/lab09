package it.unibo.mvc;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;

    private final JFrame frame = new JFrame("My second Java graphical interface"); //NOPMD: for now
    private final Controller writer = new Controller();

    /**
     * Builds a GUI with a file chooser to write strings on a desired file.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout()); 
        final JTextArea stringReader = new JTextArea("Insert your string here");
        canvas.add(stringReader, BorderLayout.CENTER);
        final JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.SOUTH);
        frame.add(canvas);
        final JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        frame.add(northPanel, BorderLayout.NORTH);
        final JTextField currentFile = new JTextField();
        currentFile.setEditable(false);
        currentFile.setText(writer.getCurrentFilePath());
        northPanel.add(currentFile, BorderLayout.CENTER);
        final JButton browse = new JButton("Browse");
        northPanel.add(browse, BorderLayout.LINE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    writer.write(stringReader.getText());
                } catch (final IOException e1) {
                    e1.printStackTrace(); //NOPMD: allowed since it is only an exercise
                }
            }
        });
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int result = fileChooser.showSaveDialog(currentFile);
                if (result == JFileChooser.APPROVE_OPTION) {
                    writer.setCurrentFile(new File(currentFile.getText()));
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(browse, "An error has occured!");
                }
            }
        });
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
}
