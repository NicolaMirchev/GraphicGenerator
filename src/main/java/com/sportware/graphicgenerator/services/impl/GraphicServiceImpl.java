package com.sportware.graphicgenerator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
