package ru.learnup.homework20;

import org.springframework.context.ApplicationEvent;

public class RandomNumberEvent extends ApplicationEvent{
    private int guess;

    public RandomNumberEvent(Object source, int guess) {
        super(source);
        this.guess = guess;
    }
    public int getGuess() {
        return guess;
    }
}
