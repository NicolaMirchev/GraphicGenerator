/**
 * 
 */
package com.sportware.graphicgenerator.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.CourseOptionId;

/**
 * @author nicol
 *
 */
public interface CourseOptionRepository extends JpaRepository<CourseOption, CourseOptionId> {

}
