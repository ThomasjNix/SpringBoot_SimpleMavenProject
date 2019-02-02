package io.thomasnix.earlylearning.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.thomasnix.earlylearning.topic.Topic;

@RestController
public class CourseController {
	
	/**
	 * Spring will automatically inject CourseService because of the annotation Autowired
	 */
	
	@Autowired
	private CourseService courseService;

	/**
	 * The RequestMapping annotation will automatically convert the POJO returned by
	 * the triggered method to JSON data
	 */

	/**
	 * Returns a list of Course objects received from the database
	 * @return List<Course>
	 */
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	/**
	 * By providing a route parameter in {} notation it is marked to spring as a route variable
	 * This variable can be accessed with the PathVariable annotation in the method parameters,
	 * which when paired with a matching variable name, it is passed in from the 
	 * route params to the method
	 * 
	 * If a different name is provided to the method parameter, it the value can be passed with the 
	 * notation PathVariable("routeParamVarName") <T> methodParamName
	 */
	
	/**
	 * Returns the course matching the provided ID if it is found in the DB
	 * If no courses are found, return null
	 * @param id
	 * @return
	 */
	@RequestMapping("topic/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {

		return courseService.getCourse(courseId);
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
	 * Receives a course via POST and calls service method to add the course to the database
	 */
	@RequestMapping(method=RequestMethod.POST, value="topics/{topicId}/courses")
	public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	/**
	 * Receives a course via PUT and calls service method to update the course with the provided ID
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
		courseService.updateCourse(course);
	}
	
	/**
	 * Receives a course via DELETE and calls service method to delete the course with the provided ID
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void addCourse(@PathVariable String courseId) {
		courseService.deleteCourse(courseId);
	}
}
