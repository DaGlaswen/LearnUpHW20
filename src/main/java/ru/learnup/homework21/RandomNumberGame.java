package ru.learnup.homework21;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.learnup.homework21.aspects.annotations.LogMethod;
import ru.learnup.homework21.aspects.annotations.WorkTime;

import java.util.Locale;
import java.util.Scanner;

@Component
public class RandomNumberGame implements ApplicationContextAware {

    private ApplicationContext context;

    private Locale locale = Locale.getDefault();

    private RandomNumberPublisher publisher;

    private int randomInt;
    private boolean isGuessed;

    public RandomNumberGame(RandomNumberPublisher publisher) {
        randomInt = (int) (Math.random() * 1000);
        isGuessed = false;
        this.publisher = publisher;
    }

    @WorkTime
    @LogMethod
    public void startTheGame() {
        System.out.println(context.getMessage("greeting", null, locale));
        System.out.println(context.getMessage("initialInstructions", null, locale));
        Scanner scanner = new Scanner(System.in);
        while (!isGuessed) {
            publisher.publishEvent(scanner.nextInt());
        }
    }

    public void guess(int yourGuess) {
        if (yourGuess > randomInt) {
            System.out.println(context.getMessage("guessLess", null, locale));
        } else if (yourGuess < randomInt) {
            System.out.println(context.getMessage("guessMore", null, locale));
        } else {
            System.out.println(context.getMessage("successfulGuess", null, locale));
            isGuessed = true;
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}