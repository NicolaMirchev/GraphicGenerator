/**
 * 
 */
package com.sportware.graphicgenerator.services;

import java.util.List;

import com.sportware.graphicgenerator.dto.BestGraphicRequieredInfoDto;
import com.sportware.graphicgenerator.dto.GraphicDto;
import com.sportware.graphicgenerator.entities.Graphic;

/**
 * The interface define methods related to graphic. (E. g - generation)
 */
public interface GraphicService {
	/** The method find all combinations for graphics for signed options.
	 * @return all combinations.
	 */
	public List<Graphic> findAllPossibleCombinations();

	/** The method find best graphic, based on a client preference for attendance.
	 * @param algorithmOption Defines the different way of finding the best option.
	 * @return best option.
	 */
	public Graphic findBestGraphicForOptionOld(String algorithmOption);
	
	
	
	/** The method accepts all obbject containing all requiered data for extracting only one valid best graphic.
	 * @param courseOptionsWithGraphicDetails requiered options.
	 * @return the best graphic.
	 */
	public GraphicDto findBestGraphicForOption(BestGraphicRequieredInfoDto courseOptionsWithGraphicDetails);
	
	
}
