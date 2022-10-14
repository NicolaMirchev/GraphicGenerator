/**
 * 
 */
package com.sportware.graphicgenerator.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.sportware.graphicgenerator.dto.CourseOptionDto;
import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.utils.DtoWithEntityConvertor;


/**
 * @author nicol
 *
 */
class EntityWithDtoConverterTest {

	@Test
	void courseOptionDtoToEntityWorksCorrect() {
		List<CourseOptionDto> dtoOptions = StaticTestData.allCourseOptionDtos;
		List<CourseOption> entityOptions = DtoWithEntityConvertor.convertDtoToEntity(dtoOptions);
		
		entityOptions.sort((first,second) -> first.getId().getCourse().getName().compareTo(second.getId().getCourse().getName()));
		
		for(int i = 0; i < dtoOptions.size(); i++) {
			assertEquals(dtoOptions.get(i).nameOfTheCourse(), entityOptions.get(i).getId().getCourse().getName());
		}

	}
	
	@Test
	void getAllCoursesFromCourseOptionWorksCorrect() {
		List<Course> uniqueCourses = DtoWithEntityConvertor.getAllCoursesFromCourseOption(
				DtoWithEntityConvertor.convertDtoToEntity(StaticTestData.allCourseOptionDtos));
		uniqueCourses.sort((first, second) -> first.getName().compareTo(second.getName()));
			
		String[] courses = {"Algorithms", "Data structures", "Science", "Sport"};
				
		assertEquals(uniqueCourses.size(), 4);
		for (int i = 0; i < courses.length; i ++) {
			assertEquals(uniqueCourses.get(i).getName(), courses[i]);
		}
	}

}
