/**
 * 
 */
package com.sportware.graphicgenerator.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sportware.graphicgenerator.repositories.CourseOptionRepository;
import com.sportware.graphicgenerator.repositories.CourseRepository;

/**
 * Base class which hold common repositories, requiered in more than one services.
 */
public abstract class BaseCourseOptionsGraphic{

	@Autowired
	protected CourseOptionRepository courseOptionRepository;
	
	@Autowired
	protected CourseRepository courseRepository;
}
