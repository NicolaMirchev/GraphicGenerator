/**
 * 
 */
package com.sportware.graphicgenerator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.repositories.CourseOptionRepository;
import com.sportware.graphicgenerator.repositories.CourseRepository;
import com.sportware.graphicgenerator.utils.CoursesAggregator;


@Service
public class CourseOptionServiceImpl implements CourseOptionService {
	
	@Autowired
	private CourseOptionRepository courseOptionRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	@Transactional
	public List<CourseOption> findAllCourseOptions() {
		return courseOptionRepository.findAll();
	}

	@Override
	public List<List<CourseOption>> aggregateAllCoursesOptionsOnCourseName() {		
		return CoursesAggregator.aggregateCoursesIntoDifferentCollection(courseRepository.findAll(),courseOptionRepository.findAll());
	}

}
