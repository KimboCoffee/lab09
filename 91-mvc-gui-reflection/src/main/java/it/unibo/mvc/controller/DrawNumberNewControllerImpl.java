package it.unibo.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import it.unibo.mvc.api.DrawNumber;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;

public class DrawNumberNewControllerImpl implements DrawNumberController {

    private final DrawNumber model;
    private List<DrawNumberView> views;

    public DrawNumberNewControllerImpl(final DrawNumber model){
        this.model = model;
        this.views = new ArrayList<>();
    }

    @Override
    public void newAttempt(int n) {
        if (views.isEmpty()){
            System.out.println("There are no views attached !");
        } else {
            this.model.attempt(n);
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    @Override
    public void addView(DrawNumberView newView) {
        Objects.requireNonNull(newView, "Cannot set a null view");
        this.views.add(newView);
        newView.setController(this);
        newView.start();
    }
    
}
