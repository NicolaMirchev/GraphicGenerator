/**
 * 
 */
package com.sportware.graphicgenerator.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.CourseOptionId;

/**
 * @author nicol
 *
 */
public interface CourseOptionRepository extends JpaRepository<CourseOption, CourseOptionId> {
	
	
	@Query(value = "SELECT co.id.course,co.id.weekday,co.id.startingTime,co.graphic FROM CourseOption co ")
	public List<CourseOption> findAllCustom(); 
}
