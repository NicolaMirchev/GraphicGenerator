/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/** The class represents information about given course and when can be visited during the week.
 *
 */
@Entity
@Table(name = "course_option")
public class CourseOption {
	
	public CourseOptionId getId() {
		return id;
	}

	public void setId(CourseOptionId id) {
		this.id = id;
	}

	@EmbeddedId
	private CourseOptionId id;
	
	/**
	 *  Empty constructor required by JPA
	 */
	public CourseOption() {
		
	}

	@MapsId("course")
	@ManyToOne
	private Course course;
		
}
