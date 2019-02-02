package io.thomasnix.earlylearning.course;

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
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	/**
	 * Returns the list of courses (currently hard-coded)
	 * @return List<Course>
	 */
	public List<Course> getAllCourses(String topicId) {
		// New method from the CourseRepository to find all courses related to given topicId used here
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId)
			.forEach(courses::add);
		return courses;
	}
	
	/**
	 * Indexes the database and returns the course matching the provided ID
	 * If no matches are found it returns null
	 * @param id
	 * @return Course
	 */
	public Course getCourse(String id) {
		return courseRepository.findById(id)
				.orElse(null);
		
	}
	
	/**
	 * Calls CrudRepository to add Course to the database 
	 * @param course
	 */
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	/**
	 * Indexes the database to find a Course with matching ID
	 * If a Course with matching ID is found, it updates the Course in the DB to the provided Course
	 * @param course
	 * @param id
	 */
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	/**
	 * Deletes the course with the provided ID
	 * @param id
	 */
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
}
