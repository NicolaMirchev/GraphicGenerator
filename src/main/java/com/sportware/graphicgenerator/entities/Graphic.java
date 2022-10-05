/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * The class contains information about the courses graphic. JPA implementation.
 */
public class Graphic {
	
	@Id
	private int id;

	@Column(name = "gap_rate")
	private int gapRate;

	
	/**
	 * Empty constructor for JPA.
	 */
	public Graphic() {
	}
}
