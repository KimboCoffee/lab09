package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdoutView implements DrawNumberView {

    private DrawNumberController observer;

    @Override
    public void setController(DrawNumberController observer) {
        this.observer = observer;
    }

    public DrawNumberController getObserver(){
        return observer;
    }

    @Override
    public void start() {
        System.out.println("Welcome to a new game of Draw a Number !");
    }

    @Override
    public void result(DrawResult res) {
        System.out.println(res.getDescription());
    }
    
}
