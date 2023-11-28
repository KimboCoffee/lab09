package it.unibo.mvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import it.unibo.mvc.api.DrawNumber;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

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
            System.out.println("There are no views attached");
        } else {
            for (DrawNumberView dnv : views){
                Objects.requireNonNull(dnv, "The attached view is null").result(model.attempt(n));
            }
            model.decreaseAttempts();
            if (model.attempt(n) == DrawResult.YOU_WON || model.attempt(n) == DrawResult.YOU_LOST){
                this.resetGame();
            }
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
