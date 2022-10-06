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
	public List<Graphic> findAllPossibleCombinations();
}
