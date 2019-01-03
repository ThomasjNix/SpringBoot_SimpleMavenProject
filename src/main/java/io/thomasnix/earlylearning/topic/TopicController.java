package io.thomasnix.earlylearning.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	/**
	 * Spring will automatically inject TopicService because of the annotation Autowired
	 */
	
	@Autowired
	private TopicService topicService;

	/**
	 * The RequestMapping annotation will automatically convert the POJO returned by
	 * the triggered method to JSON data
	 */

	/**
	 * Returns a (currently) hard-coded list of Topic objects
	 * FROM the business service
	 * @return List<Topic>
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
}
