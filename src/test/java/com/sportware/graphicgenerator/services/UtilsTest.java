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
	
	@Test
	void aggregateFunctionSeparateCoursesCorrectly() {
		
		List<List<CourseOption>> result = CourseCollectionManipulator.
				aggregateCoursesIntoDifferentCollection(StaticTestData.allCourses, StaticTestData.allCourseOptions);
		
		assertAll(() -> assertEquals(4, result.get(0).size()),
				() -> assertThat(result.get(0)).allMatch(option -> option.getId().getCourse().getName().contentEquals("Data structures")),
				() -> assertThat(result.get(1)).allMatch(option -> option.getId().getCourse().getName().contentEquals("Algorithms"))
				  );		
	}
	
	@Test
	void generateGraphicCombinationsFunctionWorksCorrectly() {
		List<Graphic> allPossibleGraphics = CourseCollectionManipulator.graphicGenerator(CourseCollectionManipulator.
				aggregateCoursesIntoDifferentCollection(StaticTestData.allCourses, StaticTestData.allCourseOptions));
		
		assertAll(() -> assertEquals(32 ,allPossibleGraphics.size()),
				  () -> assertThat(allPossibleGraphics).allMatch(gr -> gr.getCourses().size() == 4));
	}


}
