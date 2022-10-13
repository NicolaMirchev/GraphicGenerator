/**
 * 
 */
package com.sportware.graphicgenerator.dto;

/**
 * The record hold information about all course options and details about them.
 * @param algorithm is the preffered way to calculate the best graphic for the client.
 * @param duration is the duration of a given course in minutes.
 * @param allCourseOptions  are all course options.
 */
public record BestGraphicRequieredInfoDto(String algorithm, int duration, CourseOptionDto[] allCourseOptions) {
	//Default is okay
}
