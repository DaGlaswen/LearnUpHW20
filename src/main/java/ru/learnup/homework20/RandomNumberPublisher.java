package ru.learnup.homework20;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class RandomNumberPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publishEvent(int guess) {
        System.out.println("Publishing random number event. ");
        context.publishEvent(new RandomNumberEvent(context, guess));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
