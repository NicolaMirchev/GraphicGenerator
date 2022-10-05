/**
 * 
 */
package com.sportware.graphicgenerator.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sportware.graphicgenerator.entities.Course;

/**
 * 
 */
public interface CourseRepository extends JpaRepository<Course, String> {
}
