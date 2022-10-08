package com.sportware.graphicgenerator.services.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.sportware.graphicgenerator.utils.GraphicSelector;

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
		List<Graphic> allPossibleGraphics = findAllPossibleCombinations();
		
		if(algorithmOption.compareToIgnoreCase(GraphicgeneratorApplication.SINGLE_DAY_ALG) == 0) {
			return GraphicSelector.singleDayPrefferedGraphic(allPossibleGraphics);
		}
		else if(algorithmOption.compareToIgnoreCase("lessgaps") == 0) {
			return GraphicSelector.moreDaysWithSmallerGapsBetweenCoursesPrefferedGraphic(allPossibleGraphics);
		}
		
		return null;
	}

}
