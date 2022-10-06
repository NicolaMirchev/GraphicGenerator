/**
 * 
 */
package com.sportware.graphicgenerator.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.Graphic;

/**
 * The class contains static methods for aggregating and manipulating courses in different new collections. Generating and so on.
 */
// TODO : Separate it with inteface.
@Component
public class CourseCollectionManipulator  {

	private CourseCollectionManipulator() {
		// Hidden constructor, because the class contains only static methods.
	};
	
	
	
	/**The method accepts list from all different courses and list from all options which contains different courses for different 
	 * scope in time. The function put all courses with the same name in a separate collections and after that all collection in new one.
	 * @param allCourses
	 * @param allCoursesOptions
	 * @return
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


	
	/** The method generates all possible combinations for a graphic for given course options. 
	 * @param allCourseOptions must be collection of aggregated collections for given course. 
	 * (e.g - allCourseOption.get(0) -> returns collection where all elements have same course, which is different 
	 * from the elements from the next collections.) 
	 * @param allGraphics 
	 * @param currentGraphic 
	 * @param outCounter 
	 * @return a collection of all possible combinations for the given courses and options.
	 */
	public static List<Graphic> graphicGenerator(List<List<CourseOption>> allCourseOptions, List<Graphic> allGraphics, Graphic currentGraphic, int outCounter) {
		// outCounter starts from 0
		
		if(outCounter >= allCourseOptions.size()) {
			allGraphics.add(new Graphic(currentGraphic));
			outCounter--;
			return allGraphics;
		}
		
		for (CourseOption course : allCourseOptions.get(outCounter)) {
			currentGraphic.getCourses().add(course);
			// Recursion starts here
			graphicGenerator(allCourseOptions, allGraphics, currentGraphic, outCounter + 1);
			
			currentGraphic.getCourses().remove(course);
		}
		
		outCounter--;
		
		return allGraphics;
	}
	
}
