/**
 * 
 */
package com.sportware.graphicgenerator.dto;

/** The record hold all the required information for visualizing the graphic.
 * @param courses are the courses of the given graphic.
 *
 */
public record GraphicDto(CourseOptionDto[] courses) {
	// Default is okay.
}
