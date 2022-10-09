package com.sportware.graphicgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphicgeneratorApplication {
	
	/**
	 *  Const to be used in different packages in the application.
	 */
	public static final String SINGLE_DAY_ALG = "singleday";
	
	public static final String LESS_GAPS_ALG = "lessgaps";
	
	/**
	 *  Const which defines the default duration of all courses.
	 */
	public static final long DEFAULT_COURSE_DURATION_MINUTES = 90;

	public static void main(String[] args) {
		SpringApplication.run(GraphicgeneratorApplication.class, args);
	}

}
