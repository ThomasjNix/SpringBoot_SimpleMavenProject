package io.thomasnix.earlylearning.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a controller created with the annotation RestController
 * REST meaning Representational State Transfer
 * This will allow mapping of a URL to a response
 */

@RestController
public class HelloController {
	
	/**
	 * Here the RequestMapping annotation takes in a string for the provided requested URL
	 * and marks a method to be executed upon that route being triggered
	 * 
	 * This method automatically triggers on GET, but additional setup is required for other HTTP request methods
	 */

	/**
	 * This returns "Hello!" when the /hello URL is requested
	 * @return String "Hello!"
	 */
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello!";
	}
}
