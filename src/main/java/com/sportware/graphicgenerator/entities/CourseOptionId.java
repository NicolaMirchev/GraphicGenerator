/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** 
 * A class which contains all fields from which composite key of the {@link CourseOption} entity is created.
 */
@Embeddable
public class CourseOptionId implements Serializable{

	private static final long serialVersionUID = -629056128654897953L;
	
	private String course;
	
	private String weekday;
	
	@Column(name = "starting_time")
	private Instant startingTime;

	/**
	 *  Empty constructor, required by JPA.
	 */
	public CourseOptionId() {
	}

}
