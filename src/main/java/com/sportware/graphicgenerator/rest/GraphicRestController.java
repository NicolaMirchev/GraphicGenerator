/**
 * 
 */
package com.sportware.graphicgenerator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportware.graphicgenerator.entities.Graphic;
import com.sportware.graphicgenerator.services.GraphicService;

/**
 * Accepting request for related to graphic.
 */
@RestController
@RequestMapping("graphic")
public class GraphicRestController {

	@Autowired
	GraphicService service;
	
	/** The method returns all possible combination for all courses options.
	 * @return list of all available graphics.
	 */
	@GetMapping("all")
	public List<Graphic> findAllPossibleGraphicCombinations(){
		return service.findAllPossibleCombinations();
	}
}
