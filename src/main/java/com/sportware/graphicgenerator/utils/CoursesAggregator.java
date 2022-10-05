/**
 * 
 */
package com.sportware.graphicgenerator.utils;

import java.util.ArrayList;
import java.util.List;

import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;

/**
 * The class contains static methods for aggregating different courses into separated collections.
 */
// TODO : Separate it with inteface.
public class CoursesAggregator {

	private CoursesAggregator() {
		// Hidden constructor, because the class contains only static methods.
	};
	
	
	/** The method accepts list from all different courses and list from all options which contains different courses for different 
	 * scope in time. The function put all courses with the same name in a separate collections and after that all collection in new one.
	 * @param allCourses
	 * @param allCoursesOptions
	 * @return collection of all collections.
	 */
	public static List<List<CourseOption>> aggregateCoursesIntoDifferentCollection(List<Course> allCourses,
			List<CourseOption> allCoursesOptions ){
		
		List<List<CourseOption>> aggregatedCourses = new ArrayList<>();
		
		allCourses.forEach(course -> {
			List<CourseOption> currentCourseAllOptions = new ArrayList<>();
			
			allCoursesOptions.forEach(courseOption -> {
				if(course.getName().contentEquals(courseOption.getId().getCourse())) {
					currentCourseAllOptions.add(courseOption);
				}
				
			});
			if(currentCourseAllOptions.size() > 0) {
				aggregatedCourses.add(currentCourseAllOptions);
			}
		});
		
		return aggregatedCourses;
		
	}
	
}
