/**
 * 
 */
package com.sportware.graphicgenerator.services;

import java.util.List;

import com.sportware.graphicgenerator.entities.CourseOption;

/**
 * The interface contains CRUD methods related to the course options.
 */
public interface CourseOptionService {
	public List<CourseOption> findAllCourseOptions();
}
