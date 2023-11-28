package it.unibo.mvc;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberNewControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import java.lang.reflect.*;
import java.util.List;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws SecurityException
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws 
        ClassNotFoundException, 
        InstantiationException, 
        IllegalAccessException, 
        IllegalArgumentException, 
        InvocationTargetException, 
        NoSuchMethodException, 
        SecurityException {
            final var model = new DrawNumberImpl();
            final DrawNumberController app = new DrawNumberNewControllerImpl(model);
            for (final String viewType : List.of("SwingView", "StdoutView")) {
                final Class<?> view = Class.forName("it.unibo.mvc.view.DrawNumber" + viewType);
                for (int i = 0; i < 3; i++){
                    final var newView = view.getConstructor().newInstance();
                    app.addView((DrawNumberView) newView);
                }
            }
        }
}
