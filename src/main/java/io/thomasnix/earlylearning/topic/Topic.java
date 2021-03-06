package io.thomasnix.earlylearning.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *	Model class for Topic
 * The Entity annotation marks this model class as a database entity
 */
@Entity
public class Topic {

	/**
	 * Fields
	 * The Id annotation marks id as the primary key for the entity in the DB
	 */
	@Id
	private String id;
	private String name;
	private String description;

	/**
	 * No-arg constructor
	 */
	public Topic() {
		super();
	}

	/**
	 * Constructor with provided fields
	 * @param id
	 * @param name
	 * @param description
	 */
	public Topic(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
}
