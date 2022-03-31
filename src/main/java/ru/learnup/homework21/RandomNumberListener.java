package ru.learnup.homework21;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RandomNumberListener implements ApplicationListener<RandomNumberEvent> {

    private RandomNumberGame randomNumberGame;

    public RandomNumberListener(RandomNumberGame randomNumberGame) {
        this.randomNumberGame = randomNumberGame;
    }

    @Override
    public void onApplicationEvent(RandomNumberEvent event) {
        log.info("Event {timestamp: {}, data {}", event.getTimestamp(), event.getGuess());
        randomNumberGame.guess(event.getGuess());
    }
}
