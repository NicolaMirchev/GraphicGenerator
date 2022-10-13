/**
 * 
 */
package com.sportware.graphicgenerator.utils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.sportware.graphicgenerator.dto.CourseOptionDto;
import com.sportware.graphicgenerator.dto.GraphicDto;
import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.CourseOptionId;
import com.sportware.graphicgenerator.entities.Graphic;

/**
 * @author nicol
 *
 */
public class DtoWithEntityConvertor {
	
	private DtoWithEntityConvertor() {
		// private constructor, because the class contains only static methods.
	}
	
	/**
	 * @param dtoOptions
	 * @return
	 */
	public static List<CourseOption> convertDtoToEntity(List<CourseOptionDto> dtoOptions) {
		List<CourseOption> result = new ArrayList<>();	
		for(CourseOptionDto dto : dtoOptions) {
			result.add(new CourseOption(new CourseOptionId(
					new Course(dto.nameOfTheCourse(),1), dto.weekday(), LocalTime.of(dto.startingHours(), dto.startingMinutes())), null));
		}
	return result;
	}
	
	/**
	 * @param entityOptions
	 * @return
	 */
	public static List<CourseOptionDto> convertEntityToDto(List<CourseOption> entityOptions){
		List<CourseOptionDto> result = new ArrayList<>();
		
		for(CourseOption entity : entityOptions) {
			result.add(new CourseOptionDto(entity.getId().getCourse().getName(),
					entity.getId().getStartingTime().getHour(), entity.getId().getStartingTime().getMinute(),
					entity.getId().getWeekday()));
		}
		
		return result;
	}
	/**
	 * @param allOptions
	 * @return
	 */
	public static List<Course> getAllCoursesFromCourseOption(List<CourseOption> allOptions){
		List<Course> result = new ArrayList<>();
		
		for (CourseOption option : allOptions) {
			if(!result.stream().anyMatch(c -> c.getName() == option.getId().getCourse().getName())) {
				result.add(option.getId().getCourse());				
			}
		}
		return result;
	}

	/**
	 * @param entityGraphic
	 * @return
	 */
	public static GraphicDto convertEntityGraphicToDtoGraphic(Graphic entityGraphic) {
		List<CourseOptionDto> options = convertEntityToDto(entityGraphic.getCourses().stream().toList()); 
		return new GraphicDto(options);
	}





}
