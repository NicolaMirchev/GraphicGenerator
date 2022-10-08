/**
 * 
 */
package com.sportware.graphicgenerator.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.CourseOptionId;
import com.sportware.graphicgenerator.entities.Graphic;
import com.sportware.graphicgenerator.utils.GraphicSelector;

/**
 * The class contains test about graphic service (Picking right graphic, etc.)
 */
class GraphicSelectorTest {

	private static Graphic graphicWithCoursesInSameTime = new Graphic(0);
	private static List<Graphic> allPossibleGraphics = new ArrayList<Graphic>();
	
	private static Graphic singleDayGraphic;
	private static Graphic lessGapsGraphic;;
	
	/**
	 * Filling the above objects which are after that used in the tests.
	 */
	@BeforeAll
	private static void fillCoursesForTheGraphic() {
		graphicWithCoursesInSameTime.setCourses(Set.of(
				new CourseOption(
						new CourseOptionId(new Course("Data structures", 1), "Wednesday", LocalTime.of(13, 30)), null),
				new CourseOption(new CourseOptionId(new Course("Algorithms", 1), "Wednesday", LocalTime.of(13, 30)),
						null),
				new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Wednesday", LocalTime.of(11, 20)),
						null),
				new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Tuesday", LocalTime.of(12, 30)), null),
				new CourseOption(new CourseOptionId(new Course("Web applications", 1), "Friday", LocalTime.of(13, 30)),
						null)));
		
		
		
		Graphic invalidGraphic = new Graphic(0);
		invalidGraphic.setCourses(Set.of(
				new CourseOption(
						new CourseOptionId(new Course("Data structures", 1), "Wednesday", LocalTime.of(13, 30)), null),
				new CourseOption(new CourseOptionId(new Course("Algorithms", 1), "Wednesday", LocalTime.of(13, 30)),
						null),
				new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Wednesday", LocalTime.of(11, 20)),
						null),
				new CourseOption(new CourseOptionId(new Course("Web applications", 1), "Friday", LocalTime.of(12, 30)),
						null)));
		allPossibleGraphics.add(invalidGraphic);

		singleDayGraphic = new Graphic(0);
		singleDayGraphic.setCourses(Set.of(
				new CourseOption(
						new CourseOptionId(new Course("Data structures", 1), "Wednesday", LocalTime.of(10, 00)), null),
				new CourseOption(new CourseOptionId(new Course("Algorithms", 1), "Wednesday", LocalTime.of(16, 30)),
						null),
				new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Thursday", LocalTime.of(11, 20)),
						null),
				new CourseOption(new CourseOptionId(new Course("Web applications", 1), "Friday", LocalTime.of(12, 30)),
						null)));
		allPossibleGraphics.add(singleDayGraphic);

		lessGapsGraphic = new Graphic(0);
		lessGapsGraphic.setCourses(Set.of(
				new CourseOption(new CourseOptionId(new Course("Data structures", 1), "Tuesday", LocalTime.of(10, 00)),
						null),
				new CourseOption(new CourseOptionId(new Course("Algorithms", 1), "Wednesday", LocalTime.of(16, 30)),
						null),
				new CourseOption(new CourseOptionId(new Course("Data bases", 1), "Thursday", LocalTime.of(11, 20)),
						null),
				new CourseOption(new CourseOptionId(new Course("Web applications", 1), "Friday", LocalTime.of(12, 30)),
						null)));
		allPossibleGraphics.add(lessGapsGraphic);
	}
	
	

	/**
	 * TODO: Must refactor the methods which set the gap ID. MUST NOT BE in the method which selects the
	 * graphic with smallest gap rate!!!
	 */
	@BeforeEach
	private void resetGapRates() {
		allPossibleGraphics.forEach(g -> g.setGapRate(0));
	}

	@Test
	void divideAllCoursesFromGraphicIntoDaysOfTheWeekReturnsCoorectAndOrderedMap() {

		Map<String, List<CourseOption>> coursesByDays = GraphicSelector
				.divideAllCoursesFromGraphicIntoDaysOfTheWeek(graphicWithCoursesInSameTime);

		assertAll(() -> assertEquals(3, coursesByDays.size()),
				() -> assertEquals("Data bases", coursesByDays.get("wednesday").get(0).getId().getCourse().getName()));
	}

	@Test
	void isThereCoursesInSameTimeReturnTrueIfThereAreCoursesInTheSameTime() {

		Map<String, List<CourseOption>> coursesByDays = GraphicSelector
				.divideAllCoursesFromGraphicIntoDaysOfTheWeek(graphicWithCoursesInSameTime);

		assertTrue(GraphicSelector.isThereCoursesInSameTime(coursesByDays));
	}
		

	@Test
	void isThereCoursesInSameTimeReturnFalseIfThereAreNotCoursesInTheSameTime() {

		Map<String, List<CourseOption>> coursesByDays = GraphicSelector
				.divideAllCoursesFromGraphicIntoDaysOfTheWeek(graphicWithCoursesInSameTime);
		coursesByDays.get("wednesday").remove(1);

		assertFalse(GraphicSelector.isThereCoursesInSameTime(coursesByDays));
	}

	@Test
	void singleDayPrefferedGraphicReturnTheCorrectGraphic() {
		
		Graphic expected = GraphicSelector.singleDayPrefferedGraphic(allPossibleGraphics);
		
		assertThat(expected).isEqualTo(singleDayGraphic);	
	}
	
	@Test
	void moreDaysWithSmallerGapsBetweenCoursesPrefferedGraphicReturnTheCorrectGraphic() {

		Graphic expected = GraphicSelector.moreDaysWithSmallerGapsBetweenCoursesPrefferedGraphic(allPossibleGraphics);

		assertThat(expected).isEqualTo(lessGapsGraphic);
		assertThat(expected).isNotEqualTo(singleDayGraphic);

	}

}
