package io.thomasnix.earlylearning.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * The Service is a spring stereotype that marks this class as a Spring service
 * Upon spring initialization, Spring will gather all classes with this annotation and
 * create a singleton that can be injected into other areas where it is dependant
 */
@Service
public class TopicService {
	private List<Topic> topics = Arrays.asList(
			new Topic("spring", "Spring Framework", "A framework used to easily generate and implement Spring projects"),
			new Topic("cars", "Intro to Cars", "Learn everything about the basics of cars"),
			new Topic("coffee", "How to Make Coffee", "For those Monday mornings")
	);
	
	/**
	 * Returs the list of topics (currently hard-coded)
	 * @return List<Topic>
	 */
	public List<Topic> getAllTopics() {
		return topics;
	}
}
