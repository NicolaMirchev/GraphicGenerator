/**
 * 
 */
package com.sportware.graphicgenerator.services;

import java.util.List;

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
	public Graphic findBestGraphicForOption(String algorithmOption);
}
