package io.thomasnix.earlylearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is where the SpringBoot application will be bootstrapped
 * This happens by running main(), which has this SpringApplication that bootstraps the application
 */
@SpringBootApplication
public class SimpleApiApp {

	public static void main(String[] args) {
		
		/**
		 * This class has a run() method that takes the class to run as well as the arguments passed
		 * This creates a servlet container, starts it, and hosts the application (wow!)
		 */
		SpringApplication.run(SimpleApiApp.class, args);
	}

}
