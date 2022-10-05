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
	
	/** The method find all different courses and put all options for given course in one collection. After that put all collections
	 * in new collection.
	 * @return collection, which contains all collections of aggregated courses.
	 */
	public List<List<CourseOption>> aggregateAllCoursesOptionsOnCourseName();
}
