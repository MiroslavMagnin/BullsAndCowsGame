package com.max.bullsandcowsgame;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Result {
    private SimpleIntegerProperty tries = new SimpleIntegerProperty();
    private SimpleStringProperty guess = new SimpleStringProperty();
    private SimpleIntegerProperty bulls = new SimpleIntegerProperty();
    private SimpleIntegerProperty cows = new SimpleIntegerProperty();

    public int getTries() {
        return tries.get();
    }

    public SimpleIntegerProperty triesProperty() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries.set(tries);
    }

    public String getGuess() {
        return guess.get();
    }

    public SimpleStringProperty guessProperty() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess.set(guess);
    }

    public int getBulls() {
        return bulls.get();
    }

    public SimpleIntegerProperty bullsProperty() {
        return bulls;
    }

    public void setBulls(int bulls) {
        this.bulls.set(bulls);
    }

    public int getCows() {
        return cows.get();
    }

    public SimpleIntegerProperty cowsProperty() {
        return cows;
    }

    public void setCows(int cows) {
        this.cows.set(cows);
    }

}
