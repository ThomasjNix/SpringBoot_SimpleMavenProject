package io.thomasnix.earlylearning.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	/**
	 * By providing a route paramter in {} notation it is marked to spring as a route variable
	 * This variable can be accessed with the PathVariable annotation in the method parameters,
	 * which when paired with a matching variable name, it is passed in from the 
	 * route params to the method
	 * 
	 * If a different name is provided to the method parameter, it the value can be passed with the 
	 * notation PathVariable("routeParamVarName") <T> methodParamName
	 */
	
	/**
	 * Returns the first topic in list of topics matching the provided ID
	 * @param id
	 * @return
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
}
