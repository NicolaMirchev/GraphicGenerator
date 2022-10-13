/**
 * 
 */
package com.sportware.graphicgenerator.dto;

/**
 * The record hold's information about course option entity in format, which is valid for the contract for the frontend.
 * @param nameOfTheCourse is the name of the course(lecture)
 * @param startingHours it the the hour, when the lecture starts.
 * @param startingMinutes are the minures for the start.
 * @param weekday is the day of the week for the given lecture.
 */
public record CourseOptionDto(String nameOfTheCourse, int startingHours, int startingMinutes, String weekday ) {
	// Default is okay
}
