/**
 * 
 */
package com.sportware.graphicgenerator.repositories;

import java.util.List;

import com.sportware.graphicgenerator.entities.Course;

/**
 * 
 */
public interface CourseRepository {
	public List<Course> findAllCourses();
}
