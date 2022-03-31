package ru.learnup.homework21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Homework20Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(Homework20Application.class, args);
		context.getBean(RandomNumberGame.class).startTheGame();

	}

}
