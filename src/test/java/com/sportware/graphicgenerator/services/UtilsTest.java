/**
 * 
 */
package com.sportware.graphicgenerator.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.CourseOptionId;
import com.sportware.graphicgenerator.entities.Graphic;
import com.sportware.graphicgenerator.utils.CourseCollectionManipulator;

/**
 * The class contains utils methods tests.
 */
class UtilsTest {
	
	

	private static List<CourseOption> allCourseOptions = List.of(
			new CourseOption(new CourseOptionId(new Course("Data structures", 1), "Wednesday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Data structures", 1), "Monday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Data structures", 1), "Friday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Algorithms", 1), "Wednesday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("System Design", 1),"Wednesday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("System Design", 1), "Wednesday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Monday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Tuesday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Algorithms", 1), "Thursday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Data structures", 1), "Thursday", LocalTime.now()), null));
	
	private static List<Course> allCourses = List.of(new Course("Data structures", 1), new Course("Algorithms", 1),
			  new Course("System Design", 1), new Course("Data bases", 1));
	
	@Test
	void aggregateFunctionSeparateCoursesCorrectly() {
		
		List<List<CourseOption>> result = CourseCollectionManipulator.aggregateCoursesIntoDifferentCollection(allCourses, allCourseOptions);
		
		assertAll(() -> assertEquals(4, result.get(0).size()),
				() -> assertThat(result.get(0)).allMatch(option -> option.getId().getCourse().getName().contentEquals("Data structures")),
				() -> assertThat(result.get(1)).allMatch(option -> option.getId().getCourse().getName().contentEquals("Algorithms"))
				  );		
	}
	
	@Test
	void generateGraphicCombinationsFunctionWorksCorrectly() {
		List<Graphic> allPossibleGraphics = CourseCollectionManipulator.graphicGenerator(CourseCollectionManipulator.aggregateCoursesIntoDifferentCollection(allCourses, allCourseOptions));
		
		assertAll(() -> assertEquals(32 ,allPossibleGraphics.size()),
				  () -> assertThat(allPossibleGraphics).allMatch(gr -> gr.getCourses().size() == 4));
	}

}
