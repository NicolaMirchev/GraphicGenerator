/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import java.util.HashSet;
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
	


	@Id
	private int id;

	@Column(name = "gap_rate")
	private int gapRate;
	
	@OneToMany(mappedBy ="graphic")
	private Set<CourseOption> courses;

	/**
	 * Empty constructor for JPA.
	 */
	protected Graphic() {
	}
	/** Basic constructor which initialize the collection for the courses.
	 * @param gapRate to be set a default value.
	 */
	public Graphic(int gapRate) {
		this.gapRate = gapRate;
		courses = new HashSet<>();
	}
	
	/** Constructor, which copy other graphic object.
	 * @param graphic other graphic.
	 */
	public Graphic(Graphic graphic) {
		this.gapRate = graphic.getGapRate();
		courses =  new HashSet<>(graphic.getCourses());
	}
	
	public int getGapRate() {
		return gapRate;
	}


	public void setGapRate(int gapRate) {
		this.gapRate = gapRate;
	}


	public Set<CourseOption> getCourses() {
		return courses;
	}


	public void setCourses(Set<CourseOption> courses) {
		this.courses = courses;
	}


}
