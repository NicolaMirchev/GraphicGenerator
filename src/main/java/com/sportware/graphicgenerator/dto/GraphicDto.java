/**
 * 
 */
package com.sportware.graphicgenerator.dto;

import java.util.Collection;
import java.util.List;

/** The record hold all the required information for visualizing the graphic.
 * @param courses are the courses of the given graphic.
 *
 */
public record GraphicDto(List<CourseOptionDto> courses) {
	// Default is okay.
}
