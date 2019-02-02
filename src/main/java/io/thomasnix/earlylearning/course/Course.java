package io.thomasnix.earlylearning.course;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.thomasnix.earlylearning.topic.Topic;

/**
 *	Model class for Course
 * The Entity annotation marks this model class as a database entity
 */
@Entity
public class Course {

	/**
	 * Fields
	 * The Id annotation marks id as the primary key for the entity in the DB
	 */
	@Id
	private String id;
	private String name;
	private String description;
	
	private Topic topic;

	/**
	 * No-arg constructor
	 */
	public Course() {
		super();
	}

	/**
	 * Constructor with provided fields
	 * @param id
	 * @param name
	 * @param description
	 */
	public Course(String id, String name, String description, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}

	/**
	 * id getter
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * id setter
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * name getter
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name setter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * description getter
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * description setter
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Get topic related to course
	 */
	public Topic getTopic() {
		return topic;
	}

	/**
	 * Set topic related to course
	 * @param topic
	 */
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
