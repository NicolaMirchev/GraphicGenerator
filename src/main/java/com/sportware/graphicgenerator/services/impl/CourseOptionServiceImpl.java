/**
 * 
 */
package com.sportware.graphicgenerator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.repositories.CourseOptionRepository;
import com.sportware.graphicgenerator.repositories.CourseRepository;
import com.sportware.graphicgenerator.services.CourseOptionService;
import com.sportware.graphicgenerator.utils.CourseCollectionManipulator;


@Service
public class CourseOptionServiceImpl extends BaseCourseOptionsGraphic implements CourseOptionService {
	
	@Override
	@Transactional
	public List<CourseOption> findAllCourseOptions() {
		return courseOptionRepository.findAll();
	}

	@Override
	public List<List<CourseOption>> aggregateAllCoursesOptionsOnCourseName() {		
		return CourseCollectionManipulator.aggregateCoursesIntoDifferentCollection(courseRepository.findAll(),courseOptionRepository.findAll());
	}

}
