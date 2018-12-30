package io.thomasnix.earlylearning.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	/**
	 * The RequestMapping annotation will automatically convert the POJO returned by
	 * the triggered method to JSON data
	 */

	/**
	 * Returns a (currently) hard-coded list of Topic objects
	 * 
	 * @return List<Topic>
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return Arrays.asList(
				new Topic("spring", "Spring Framework", "A framework used to easily generate and implement Spring projects"),
				new Topic("cars", "Intro to Cars", "Learn everything about the basics of cars"),
				new Topic("coffee", "How to Make Coffee", "For those Monday mornings")
		);
	}
}
