package io.thomasnix.earlylearning.topic;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

	/**
	 * CRUD operations tend to be similar enough that the Spring Data JPA allows for
	 * the ability to quickly set up common operations when a given entity is provided
	 * 
	 * This is done by creating an interface that uses the implementation that comes with
	 * the spring JPA.
	 * 
	 * These CRUD operations are provided the Spring Data JPA CrudRepository
	 * 
	 * This requires a couple of generic types
	 * 
	 *  1. The entity that will be used for the CrudRepository
	 *  2. The type of the primary key specified by the Id annotation
	 */
	
	/**
	 * Finds all courses with provided name
	 * @param name
	 * @return
	 */
	public List<Topic> findByName(String name);
	
	/**
	 * Finds all courses by provided description
	 * @param description
	 * @return
	 */
	public List<Topic> findByDescription(String description);
}
