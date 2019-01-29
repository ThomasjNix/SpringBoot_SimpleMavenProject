package io.thomasnix.earlylearning.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Service is a spring stereotype that marks this class as a Spring service
 * Upon spring initialization, Spring will gather all classes with this annotation and
 * create a singleton that can be injected into other areas where it is dependent
 */
@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	/**
	 * Returns the list of topics (currently hard-coded)
	 * @return List<Topic>
	 */
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
			.forEach(topics::add);
		return topics;
	}
	
	/**
	 * Indexes the database and returns the topic matching the provided ID
	 * If no matches are found it returns null
	 * @param id
	 * @return Topic
	 */
	public Topic getTopic(String id) {
		return topicRepository.findById(id)
				.orElse(null);
		
	}
	
	/**
	 * Calls CrudRepository to add Topic to the database 
	 * @param topic
	 */
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	/**
	 * Indexes the database to find a Topic with matching ID
	 * If a Topic with matching ID is found, it updates the Topic in the DB to the provided Topic
	 * @param topic
	 * @param id
	 */
	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}
	
	/**
	 * Deletes the topic with the provided ID
	 * @param id
	 */
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}
