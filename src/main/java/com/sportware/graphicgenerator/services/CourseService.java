/**
 * 
 */
package com.sportware.graphicgenerator.services;

import java.util.List;
import com.sportware.graphicgenerator.entities.Course;

/**
 * The interface contains logic for the course objects in our application.
 */
public interface CourseService {
	public List<Course> FindAllCourses();
}
