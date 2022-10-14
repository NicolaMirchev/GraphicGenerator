/**
 * 
 */
package com.sportware.graphicgenerator.services;

import java.time.LocalTime;
import java.util.List;

import com.sportware.graphicgenerator.dto.CourseOptionDto;
import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.CourseOptionId;

/**
 * The class contains static data which can be used in more than one tests.
 */
public class StaticTestData {

	public static List<CourseOption> allCourseOptions = List.of(
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
	
	public static List<Course> allCourses = List.of(new Course("Data structures", 1), new Course("Algorithms", 1),
			  new Course("System Design", 1), new Course("Data bases", 1));
	
	public static List<CourseOptionDto> allCourseOptionDtos = List.of(
			new CourseOptionDto("Algorithms", 10, 15, "Tuesday"),
			new CourseOptionDto("Algorithms", 10, 15, "Wednesday"),
			new CourseOptionDto("Algorithms", 13, 30, "Thursday"),
			new CourseOptionDto("Data structures", 13, 30, "Friday"),
			new CourseOptionDto("Data structures", 10, 15, "Tuesday"),
			new CourseOptionDto("Data structures", 10, 00, "Friday"),
			new CourseOptionDto("Science", 10, 00, "Monday"),
			new CourseOptionDto("Sport", 13, 30, "Monday"),
			new CourseOptionDto("Sport", 9, 00, "Thursday"),
			new CourseOptionDto("Sport", 13, 30, "Friday"));
			
}
