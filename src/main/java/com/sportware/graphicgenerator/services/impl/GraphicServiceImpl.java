package com.sportware.graphicgenerator.services.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportware.graphicgenerator.GraphicgeneratorApplication;
import com.sportware.graphicgenerator.Weekdays;
import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.Graphic;
import com.sportware.graphicgenerator.repositories.CourseOptionRepository;
import com.sportware.graphicgenerator.repositories.CourseRepository;
import com.sportware.graphicgenerator.services.GraphicService;
import com.sportware.graphicgenerator.utils.CourseCollectionManipulator;

/**
 *
 */
@Service
public class GraphicServiceImpl extends BaseCourseOptionsGraphic implements GraphicService {
	
	@Override
	@Transactional
	public List<Graphic> findAllPossibleCombinations() {
		List<CourseOption> allCourseOptions = courseOptionRepository.findAll();
		List<Course> allCourses = courseRepository.findAll();

		List<List<CourseOption>> allCourseOptionsSeparatedByCourseName = 
		CourseCollectionManipulator.aggregateCoursesIntoDifferentCollection(allCourses,allCourseOptions);
		
		return CourseCollectionManipulator.graphicGenerator(allCourseOptionsSeparatedByCourseName);
	}

	@Override
	public Graphic findBestGraphicForOption(String algorithmOption) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// TODO : Separate this function into more. Factory function which returns algorithm?
	private Function<List<Graphic> ,Graphic> algoritmSelector(String algorithmName){
	
		if(algorithmName.equalsIgnoreCase(GraphicgeneratorApplication.SINGLE_DAY_ALG)) {
			Function <List<Graphic>, Graphic> func = 
					(list) -> { 
						
						// Create value which will hold the graphic with best scored value about gap rate.
						list.forEach( graphic -> {														
							checkIfGivenGraphicHasCoursesInSameTime(graphic);
							
							// Compare this graphic with the currently best value.
						});
						
						return list.get(0);
				};
		}
		
		return null;

	}
	
	private  boolean checkIfGivenGraphicHasCoursesInSameTime(Graphic graphic) {
		String[] weekdays = {Weekdays.MONDAY.name(),Weekdays.TUESDAY.name(),Weekdays.WEDNESDAY.name(),Weekdays.THURSDAY.name(),
				Weekdays.FRIDAY.name(),Weekdays.SATURDAY.name(),Weekdays.SUNDAY.name()};
		
		for (String weekday : weekdays) {
			List<CourseOption> thisDayCourses = new ArrayList<>();	
			graphic.getCourses().forEach(thisDayCourses::add);
			
			thisDayCourses.sort((first, second) -> first.getId().getStartingTime().compareTo(second.getId().getStartingTime()));
			for(int i = 0; i < thisDayCourses.size(); i++) {
				if (thisDayCourses.get(i).getId().getStartingTime().plusMinutes(GraphicgeneratorApplication.DEFAULT_COURSE_DURATION_MINUTES).
						isAfter(thisDayCourses.get(i + 1).getId().getStartingTime())) {
					return false;
				}
			}
		}
		return true;
		
	}
	

}
