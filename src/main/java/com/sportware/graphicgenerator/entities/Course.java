/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** The class contains fields about course. Also defines how to be mapped to the db table.
 *
 */
@Entity
@Table(name ="courses")
public class Course {

	@Id
	private String name;
	
	@Column(name = "times_per_week")
	private int timesPerWeek;
	
	
	/**
	 * 		// Empty constructor, required by Hibernate.
	 */
	public Course() {
		// Empty constructor, required by Hibernate.
	}

	/** Public constructor initializing object.
	 * @param name
	 * @param timesPerWeek
	 */
	public Course(String name, int timesPerWeek) {
		this.name = name;
		this.timesPerWeek = timesPerWeek;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimesPerWeek() {
		return timesPerWeek;
	}
	
}
