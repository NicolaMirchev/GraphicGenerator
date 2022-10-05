/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The class contains information about the courses graphic. JPA implementation.
 */
@Entity
@Table(name = "graphic")
public class Graphic {
	
	public Graphic(int id, int gapRate) {
		this.gapRate = gapRate;
	}


	@Id
	private int id;

	@Column(name = "gap_rate")
	private int gapRate;
	
	@OneToMany(mappedBy ="graphic")
	private Set<CourseOption> courses;

	
	/**
	 * Empty constructor for JPA.
	 */
	public Graphic() {
	}
}
