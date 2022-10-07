/**
 * 
 */
package com.sportware.graphicgenerator.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.repositories.CourseRepository;
import com.sportware.graphicgenerator.services.CourseService;

/**
 * The class contains implementation for the serice which executes operation with the "course" object.
 */
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepo;
	

	@Transactional
	@Override
	public List<Course> findAllCourses() {
		return  courseRepo.findAll();
	}


}
