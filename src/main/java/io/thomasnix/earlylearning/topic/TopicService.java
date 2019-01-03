package io.thomasnix.earlylearning.topic;

import java.util.ArrayList;
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
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Framework", "A framework used to easily generate and implement Spring projects"),
			new Topic("cars", "Intro to Cars", "Learn everything about the basics of cars"),
			new Topic("coffee", "How to Make Coffee", "For those Monday mornings")
	));
	
	/**
	 * Returs the list of topics (currently hard-coded)
	 * @return List<Topic>
	 */
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	/**
	 * Creates a stream of the List of topics, then iterates over
	 * the list and filters out topics that match the provided ID
	 * Returns the first topic returned from the filter
	 * @param id
	 * @return Topic
	 */
	public Topic getTopic(String id) {
		return topics
				.stream()
				.filter(topic -> topic.getId().equals(id))
				.findFirst()
				.get();
	}
	
	/**
	 * Adds the provided to the topic list 
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	/**
	 * Updates the value of the topic with the provided ID
	 * @param topic
	 * @param id
	 */
	public void updateTopic(Topic topic, String id) {
		for (int i = 0; i < topics.size(); i = i + 1) {
			if (topics.get(i).getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	/**
	 * Deletes the topic with the provided ID
	 * @param id
	 */
	public void deleteTopic(String id) {
		for (int i = 0; i < topics.size(); i = i + 1) {
			if (topics.get(i).getId().equals(id)) {
				topics.remove(i);
				return;
			}
		}
	}
}
