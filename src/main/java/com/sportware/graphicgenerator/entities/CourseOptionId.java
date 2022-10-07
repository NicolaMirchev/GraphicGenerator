/**
 * 
 */
package com.sportware.graphicgenerator.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/** 
 * A class which contains all fields from which composite key of the {@link CourseOption} entity is created.
 */
@Embeddable
public class CourseOptionId implements Serializable{

	private static final long serialVersionUID = -629056128654897953L;	
	
	@ManyToOne
	@JoinColumn(name = "course_name")
	private Course course;
	
	@Column(name = "weekday")
	private String weekday;
	
	@Column(name = "starting_time")
	private LocalTime startingTime;
	
	public CourseOptionId(Course course, String weekday, LocalTime startingTime) {
		this.course = course;
		this.weekday = weekday;
		this.startingTime = startingTime;
	}
	/**
	 *  Empty constructor, required by JPA.
	 */
	protected CourseOptionId() {
	}
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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getWeekday() {
		return weekday;
	}

	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}

	public LocalTime getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(LocalTime startingTime) {
		this.startingTime = startingTime;
	}

}
