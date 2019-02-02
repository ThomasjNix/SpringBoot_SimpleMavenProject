package io.thomasnix.earlylearning.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

	/**
	 * The standard CrudRepository does not have any functionality to search by 
	 * specific parameters, so new methods must be implemented
	 *
	 * Luckily by providing a certain naming structure and a certain call signature, Spring
	 * is able to determine and automatically implement the intended functionality 
	 * of the method (cool!)
	 * 
	 * (Make sure to always use camel case)
	 */
	
	/**
	 * Finds all courses given a provided name
	 * @param name
	 * @return List<Course>
	 */
	public List<Course> findByName(String name);
	
	/**
	 * Finds all courses given a provided description
	 * @param name
	 * @return List<Course>
	 */
	public List<Course> findByDescription(String description);
	
	/**
	 * This does not work with class instances however since Spring has to search by
	 * the ID of another object
	 * 
	 * In order to make this work, the name must follow the convention
	 * findByTopicId
	 * 
	 * This will search for all courses related to topics whose Id matches the provided topicId
	 */
	
	/**
	 * Finds all courses given a provided topicId
	 * @param topicId
	 * @return
	 */
	public List<Course> findByTopicId(String topicId);
}
