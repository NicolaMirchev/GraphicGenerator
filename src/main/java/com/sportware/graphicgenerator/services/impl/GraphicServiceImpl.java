package com.sportware.graphicgenerator.services.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportware.graphicgenerator.GraphicgeneratorApplication;

import com.sportware.graphicgenerator.dto.BestGraphicRequieredInfoDto;
import com.sportware.graphicgenerator.dto.GraphicDto;
import com.sportware.graphicgenerator.entities.Course;
import com.sportware.graphicgenerator.entities.CourseOption;
import com.sportware.graphicgenerator.entities.Graphic;
import com.sportware.graphicgenerator.rest.GraphicRestController;
import com.sportware.graphicgenerator.services.GraphicService;
import com.sportware.graphicgenerator.utils.CourseCollectionManipulator;
import com.sportware.graphicgenerator.utils.DtoWithEntityConvertor;
import com.sportware.graphicgenerator.utils.GraphicSelector;

/**
 *
 */
@Service
public class GraphicServiceImpl extends BaseCourseOptionsGraphic implements GraphicService {
	private final Logger LOGGER = Logger.getLogger(GraphicServiceImpl.class.getName());
	
	@Override
	@Transactional
	public List<Graphic> findAllPossibleCombinations() {
		List<CourseOption> allCourseOptions = courseOptionRepository.findAll();
		List<Course> allCourses = courseRepository.findAll();

		List<List<CourseOption>> allCourseOptionsSeparatedByCourseName = 
		CourseCollectionManipulator.aggregateCoursesIntoDifferentCollection(allCourses,allCourseOptions);
		
		return CourseCollectionManipulator.graphicGenerator(allCourseOptionsSeparatedByCourseName);
	}

	@Override
	public Graphic findBestGraphicForOptionOld(String algorithmOption) {
		List<Graphic> allPossibleGraphics = findAllPossibleCombinations();
		
		if(algorithmOption.compareToIgnoreCase(GraphicgeneratorApplication.SINGLE_DAY_ALG) == 0) {
			return GraphicSelector.singleDayPrefferedGraphic(allPossibleGraphics, 90);
		}
		else if(algorithmOption.compareToIgnoreCase("lessgaps") == 0) {
			return GraphicSelector.moreDaysWithSmallerGapsBetweenCoursesPrefferedGraphic(allPossibleGraphics, 90);
		}
		
		return null;
	}

	@Override
	public GraphicDto findBestGraphicForOption(BestGraphicRequieredInfoDto courseOptionsWithGraphicDetails) {		
		List<CourseOption> courseOptionsInEntityFormat = DtoWithEntityConvertor.
				convertDtoToEntity(courseOptionsWithGraphicDetails.allCourseOptions());
		List<Course> allCourses = DtoWithEntityConvertor.getAllCoursesFromCourseOption(courseOptionsInEntityFormat);
		List<List<CourseOption>> allCourseOptionsSeparatedByCourseName = 
				CourseCollectionManipulator.aggregateCoursesIntoDifferentCollection(allCourses,courseOptionsInEntityFormat);
		
		List<Graphic> allPossibleGraphics = CourseCollectionManipulator.graphicGenerator(allCourseOptionsSeparatedByCourseName);
		
		LOGGER.log(Level.SEVERE, "BeforeAlgorithm");
		
		if(courseOptionsWithGraphicDetails.algorithm().compareToIgnoreCase(GraphicgeneratorApplication.SINGLE_DAY_ALG) == 0) {
			LOGGER.log(Level.SEVERE, "In the algorithm!");
			
			return DtoWithEntityConvertor.convertEntityGraphicToDtoGraphic(
					GraphicSelector.singleDayPrefferedGraphic(allPossibleGraphics, courseOptionsWithGraphicDetails.duration()));
		}
		else if(courseOptionsWithGraphicDetails.algorithm().compareToIgnoreCase(GraphicgeneratorApplication.LESS_GAPS_ALG) == 0) {
			return DtoWithEntityConvertor.convertEntityGraphicToDtoGraphic(
					GraphicSelector.moreDaysWithSmallerGapsBetweenCoursesPrefferedGraphic(allPossibleGraphics, courseOptionsWithGraphicDetails.duration()));
		}
		
				
		
		return null;
	}
	
}
