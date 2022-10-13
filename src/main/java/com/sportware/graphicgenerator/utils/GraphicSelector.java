/**
 * 
 */
package com.sportware.graphicgenerator.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

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
	
	/** The function invokes the algorithm of defining gap rate with gap value of a day - 21600 seconds(6 hours)
	 * , which means that the gap rate of all graphics between gaps of the courses and attendance to the university. 
	 * @param allGraphics all courses.
	 * @param duration is the single course duration in minutes.
	 * @return the best graphic for this option.
	 */
	public static Graphic singleDayPrefferedGraphic(List<Graphic> allGraphics, int duration) {
		return findGraphicWithSmallestGapsBetweenCourses(allGraphics, 21600, duration);
	}
	
	/** The function invokes the algorithm of defining gap rate with gap value of a day - 0, which means that the gap rate of all programms 
	 * is defined only between gaps of the courses. 
	 * @param allGraphics all courses.
	 * @return the best graphic for this option.
	 */
	public static Graphic moreDaysWithSmallerGapsBetweenCoursesPrefferedGraphic(List<Graphic> allGraphics, int duration) {
		return findGraphicWithSmallestGapsBetweenCourses(allGraphics, 0, duration);
	}
	
	/**	The function set the gap rate of every graphic, based on a rule and then pick the graphic with smallest gap rate.
	 * @param allGraphics list of all possible graphics.
	 * @param singleDayDefaultGapValue the default gap which a day gives to a graphic (E.g if in monday you have gap of 5 hours between courses, or
	 * you can have only one course on monday and one on tuesday, without any gaps(this is chosen by the user)).
	 * @return best graphic based on the default gap for whole day presenting the university and all combination of graphics.
	 */
	private static Graphic findGraphicWithSmallestGapsBetweenCourses(List<Graphic> allGraphics,int singleDayDefaultGapValue, int duration) {
		
		int singleDayAlgorithmEveryDayGapValue = singleDayDefaultGapValue;
		
		Graphic graphicWithSmallestGapRate = allGraphics.get(0);
		
		for(Graphic currentGraphic : allGraphics) {

			Map<String, List<CourseOption>> coursesByDay = divideAllCoursesFromGraphicIntoDaysOfTheWeek(currentGraphic);
			if(isThereCoursesInSameTime(coursesByDay, duration)) {
				currentGraphic.setGapRate(Integer.MAX_VALUE);
			}
			else {

				coursesByDay.forEach((day, courses) -> {	
					int currentDayGapRate = singleDayAlgorithmEveryDayGapValue;
					// Calculate more gap rate only if for the current day there are more than one courses planned.
					if (courses.size() > 1) {
						for(int i = 0 ; i < courses.size() - 1; i++) {
							int gapBetweenTwoCourses = 0;
							int endOfThisCoursInSecondsOfDay = courses.get(i).getId().getStartingTime().
									plusMinutes(GraphicgeneratorApplication.DEFAULT_COURSE_DURATION_MINUTES).toSecondOfDay();
							
							// Add gap rate, which is the seconds between the two courses.
							gapBetweenTwoCourses += courses.get(i + 1).getId().getStartingTime().toSecondOfDay() - endOfThisCoursInSecondsOfDay;
							currentDayGapRate += gapBetweenTwoCourses;
						}
					}							
					currentGraphic.setGapRate(currentGraphic.getGapRate() + currentDayGapRate);
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
	public static  boolean isThereCoursesInSameTime(Map<String, List<CourseOption>> coursesForGraphicWhichKeyIsDayOfTheWeek,int duration) {
			
		try {
			coursesForGraphicWhichKeyIsDayOfTheWeek.forEach((String day,List<CourseOption> courses) -> {
				if(courses.size() > 1) {
					for(int i = 0; i < courses.size() - 1; i++) {
						if (courses.get(i).getId().getStartingTime().plusMinutes(duration).
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
