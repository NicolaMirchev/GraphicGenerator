/**
 * 
 */
package com.sportware.graphicgenerator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.services.CourseOptionService;

/**
 * The class accept incoming request related to {@link CourseOption} entity to a given endpoint.
 */
@RestController
@RequestMapping("courseoption")
public class CourseOptionRestController {
	
	@Autowired
	private CourseOptionService service;
	
	@GetMapping("all")
	public List<CourseOption> findAllCourseOptions(){
		return service.findAllCourseOptions();
	}
}
