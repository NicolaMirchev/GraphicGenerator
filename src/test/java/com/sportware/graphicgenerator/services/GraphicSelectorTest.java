/**
 * 
 */
package com.sportware.graphicgenerator.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.CourseOptionId;
import com.sportware.graphicgenerator.entities.Graphic;
import com.sportware.graphicgenerator.utils.CourseCollectionManipulator;
import com.sportware.graphicgenerator.utils.GraphicSelector;

/**
 * The class contains test about graphic service (Picking right graphic, etc.)
 */
class GraphicSelectorTest {
	
	private static Graphic graphicWithCoursesInSameTime = new Graphic(0);
	
	@BeforeAll
	private static void fillCoursesForTheGraphic() {
	graphicWithCoursesInSameTime.setCourses(Set.of(new CourseOption(new CourseOptionId(new Course("Data structures", 1), "Wednesday", LocalTime.of(13, 30)), null),
			new CourseOption(new CourseOptionId(new Course("Algorithms", 1), "Wednesday", LocalTime.of(13, 30)), null),
			new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Wednesday", LocalTime.of(11, 20)), null),
			new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Tuesday", LocalTime.now()), null),
			new CourseOption(new CourseOptionId(new Course("Web applications", 1), "Friday", LocalTime.now()), null)));
	}
	
	@Test
	void divideAllCoursesFromGraphicIntoDaysOfTheWeekReturnsCoorectAndOrderedMap() {
		
		Map<String, List<CourseOption>> coursesByDays =GraphicSelector.divideAllCoursesFromGraphicIntoDaysOfTheWeek(graphicWithCoursesInSameTime);
		
		assertAll(() -> assertEquals(3, coursesByDays.size()),
				  () -> assertEquals("Data bases",coursesByDays.get("wednesday").get(0).getId().getCourse().getName()));
	}
	
	@Test
	void isThereCoursesInSameTimeReturnTrueIfThereAreCoursesInTheSameTime() {
		
		
		Map<String, List<CourseOption>> coursesByDays =GraphicSelector.divideAllCoursesFromGraphicIntoDaysOfTheWeek(graphicWithCoursesInSameTime);
		
		assertTrue(GraphicSelector.isThereCoursesInSameTime(coursesByDays));
	}
	@Test
	void isThereCoursesInSameTimeReturnFalseIfThereAreNotCoursesInTheSameTime() {
		
		
		Map<String, List<CourseOption>> coursesByDays =GraphicSelector.divideAllCoursesFromGraphicIntoDaysOfTheWeek(graphicWithCoursesInSameTime);
		coursesByDays.get("wednesday").remove(1);
		
		assertFalse(GraphicSelector.isThereCoursesInSameTime(coursesByDays));
	}

}
