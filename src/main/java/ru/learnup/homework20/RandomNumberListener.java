package ru.learnup.homework20;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
