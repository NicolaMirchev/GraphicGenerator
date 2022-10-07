/**
 * 
 */
package com.sportware.graphicgenerator.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/** The class represents information about given course and when can be visited during the week.
 *
 */
@Entity
@Table(name = "course_option")
public class CourseOption {
	

	@EmbeddedId
	private CourseOptionId uniqueIdentifier;
	
	@ManyToOne
	@JoinColumn(name = "graphic")
	private Graphic graphic;
	
	/**
	 *  Empty constructor required by JPA
	 */
	protected CourseOption() {
		
	}
		
	public CourseOption(CourseOptionId id, Graphic graphic) {
		this.uniqueIdentifier = id;
		this.graphic = graphic;
	}

	public CourseOptionId getId() {
		return uniqueIdentifier;
	}
	
	public void setId(CourseOptionId id) {
		this.uniqueIdentifier = id;
	}
}
