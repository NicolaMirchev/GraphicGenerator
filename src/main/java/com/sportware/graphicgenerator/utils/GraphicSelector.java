/**
 * 
 */
package com.sportware.graphicgenerator.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportware.graphicgenerator.GraphicgeneratorApplication;
import com.sportware.graphicgenerator.Weekdays;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.Graphic;

/**
 * The class contains logic about manipulating graphic collections and different algorithms for defining 
 * which graphic is the best.
 */
public class GraphicSelector {
	
	// The class cannot be initialized because contains only static methods.
	private GraphicSelector() {
	}
	
	// The function set the gap rate of every graphic, based on a rule and then pick the graphic with smallest gap rate.
	// It is public - to be tested.
	public static Graphic findBestGraphicForSingleDaySolution(List<Graphic> allGraphics) {
		
		// Every day gives the graphic +6 hours(21600 seconds) gap rate, so if in one day there are two courses with 5 hours of gap - this is 
		// better than one of the courses to be alone on the next day.
		int singleDayAlgorithmEveryDayGapValue = 21600;
		
		Graphic graphicWithSmallestGapRate = allGraphics.get(0);
		
		for(Graphic currentGraphic : allGraphics) {

			Map<String, List<CourseOption>> coursesByDay = divideAllCoursesFromGraphicIntoDaysOfTheWeek(currentGraphic);
			if(isThereCoursesInSameTime(coursesByDay)) {
				currentGraphic.setGapRate(Integer.MAX_VALUE);
			}
			else {
				coursesByDay.forEach((day, courses) -> {
					int currentGraphicGapRate = singleDayAlgorithmEveryDayGapValue;
					
					// Calculate more gap rate only if for the current day there are more than one courses planned.
					if (courses.size() > 1) {
						for(int i = 0 ; i < courses.size() - 1; i++) {
							int gapBetweenTwoCourses = 0;
							int endOfThisCoursInSeconds = courses.get(i).getId().getStartingTime().
									plusMinutes(GraphicgeneratorApplication.DEFAULT_COURSE_DURATION_MINUTES).toSecondOfDay();
							
							// Add gap rate, which is the seconds between the two courses.
							gapBetweenTwoCourses += courses.get(i + 1).getId().getStartingTime().toSecondOfDay() - endOfThisCoursInSeconds;
							currentGraphicGapRate += gapBetweenTwoCourses;
						}
					}
					
						currentGraphic.setGapRate(currentGraphicGapRate);
						
				});
				if(currentGraphic.getGapRate() < graphicWithSmallestGapRate.getGapRate()) {
					graphicWithSmallestGapRate = currentGraphic;
				}	
			}
		};
		
		return graphicWithSmallestGapRate;
	}
	
	// The function takes a graphic entity and divide it's courses on days and put them in a map.
	public static Map<String, List<CourseOption>> divideAllCoursesFromGraphicIntoDaysOfTheWeek(Graphic graphic){
		Map<String,List<CourseOption>> coursesForEachDay = new HashMap<>();
		
		String[] weekdays = {Weekdays.MONDAY.name(),Weekdays.TUESDAY.name(),Weekdays.WEDNESDAY.name(),Weekdays.THURSDAY.name(),
				Weekdays.FRIDAY.name(),Weekdays.SATURDAY.name(),Weekdays.SUNDAY.name()};
		
		for (String weekday : weekdays) {
			// For that day collect all courses from the graphic.
			List<CourseOption> thisDayCourses = new ArrayList<>();	
			graphic.getCourses().forEach(courseOption -> {
				if(courseOption.getId().getWeekday().compareToIgnoreCase(weekday) == 0) {
					thisDayCourses.add(courseOption);
					// Sort the courses to be from earliest to the latest.
					thisDayCourses.sort((first, second) -> first.getId().getStartingTime().compareTo(second.getId().getStartingTime()));
					
					coursesForEachDay.put(weekday.toLowerCase(), thisDayCourses);
				}
			});
			
		}
		
		return coursesForEachDay;
	}
	
	
	// The function check if given graphic is valid (Do not have two courses in same time). 
	// Return true If there are courses in the same time . The function throws and catches exception, because in foreach function
	// cannot change outer variable.
	public static  boolean isThereCoursesInSameTime(Map<String, List<CourseOption>> coursesForGraphicWhichKeyIsDayOfTheWeek) {
			
		try {
			coursesForGraphicWhichKeyIsDayOfTheWeek.forEach((String day,List<CourseOption> courses) -> {
				if(courses.size() > 1) {
					for(int i = 0; i < courses.size() - 1; i++) {
						if (courses.get(i).getId().getStartingTime().plusMinutes(GraphicgeneratorApplication.DEFAULT_COURSE_DURATION_MINUTES).
								isAfter(courses.get(i + 1).getId().getStartingTime())) {
							throw new IllegalArgumentException();
						}
					}
				}
			});
		}
		catch(IllegalArgumentException exception) {
			return true;
		}
		return false;
	}

}
