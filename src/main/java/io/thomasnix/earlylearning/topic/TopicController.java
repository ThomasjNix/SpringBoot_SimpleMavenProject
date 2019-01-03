package io.thomasnix.earlylearning.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	/**
	 * When using HTTP methods that are NOT get, the method MUST be specified via the 
	 * RequestMapping syntax
	 * RequestMapping(method=<HTTPMethod>, value="<route path>")
	 * 
	 * The HTTP methods are accessible via Spring's RequestMethod object, and are
	 * RequestMethod.POST
	 * RequestMethod.PUT
	 * RequestMethod.DELETE
	 * etc.
	 * 
	 * In order to access the body of the request, the method param annotation RequestBody
	 * is used to parse the body and assign it to the type specified in the method parameters
	 */
	
	/**
	 * Receives a topic via POST and calls service method to add the topic to the list
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	/**
	 * Receives a topic via PUT and calls service method to update the topic with the provided ID
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	/**
	 * Receives a topic via DELETE and calls service method to delete the topic with the provided ID
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void addTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
}
