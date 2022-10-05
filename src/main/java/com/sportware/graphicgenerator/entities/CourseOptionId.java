/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/** 
 * A class which contains all fields from which composite key of the {@link CourseOption} entity is created.
 */
@Embeddable
public class CourseOptionId implements Serializable{

	@Override
	public int hashCode() {
		return Objects.hash(course, startingTime, weekday);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseOptionId other = (CourseOptionId) obj;
		return Objects.equals(course, other.course) && Objects.equals(startingTime, other.startingTime)
				&& Objects.equals(weekday, other.weekday);
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public Instant getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Instant startingTime) {
		this.startingTime = startingTime;
	}

	private static final long serialVersionUID = -629056128654897953L;
	
	@Column(name = "course")
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
