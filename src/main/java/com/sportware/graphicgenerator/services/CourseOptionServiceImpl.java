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

@Service
public class CourseOptionServiceImpl implements CourseOptionService {
	
	@Autowired
	private CourseOptionRepository repository;

	@Override
	@Transactional
	public List<CourseOption> findAllCourseOptions() {
		return repository.findAll();
	}

}
