/**
 * 
 */
package com.sportware.graphicgenerator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.services.CourseService;

/**
 *
 */
@RestController
@RequestMapping("/course")
public class CourseRestController {
	
	// CourseService autowired!	
	@Autowired
	private CourseService courseService;
	
	/** 
	 * @return
	 */
	@GetMapping("all")
	public List<Course> findAllCourses(){
		return courseService.findAllCourses();
	}
	
}
