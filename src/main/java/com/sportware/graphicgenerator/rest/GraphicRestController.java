/**
 * 
 */
package com.sportware.graphicgenerator.rest;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sportware.graphicgenerator.GraphicgeneratorApplication;
import com.sportware.graphicgenerator.dto.BestGraphicRequieredInfoDto;
import com.sportware.graphicgenerator.dto.GraphicDto;
import com.sportware.graphicgenerator.entities.Graphic;
import com.sportware.graphicgenerator.services.GraphicService;

/**
 * Accepting request for related to graphic.
 */
@RestController
@RequestMapping("graphic")
@CrossOrigin(origins = "http://localhost:4200")
public class GraphicRestController {
	private final Logger LOGGER = Logger.getLogger(GraphicRestController.class.getName());

	@Autowired
	GraphicService service;
	
	/** The method returns all possible combination for all courses options.
	 * @return list of all available graphics.
	 */
	@GetMapping("all")
	public List<Graphic> findAllPossibleGraphicCombinations(){
		return service.findAllPossibleCombinations();
	}
	
	/** The method accepts request on given endpoint and uses a query parameter, which defines the client 
	 * preffered way of attending the courses.
	 * @param algorithmOption the client opinion of best graphic.
	 * @return best graphic for the client.
	 */
	@PostMapping("best")
	public GraphicDto findBestGraphicForOption(@RequestBody BestGraphicRequieredInfoDto courseOptionsWithGraphicDetails) {
		LOGGER.log(Level.SEVERE, "From Controller");
		return service.findBestGraphicForOption(courseOptionsWithGraphicDetails);

	}
	
	@GetMapping("best")
	public String getBestDefaultAnswer() {
		return "It works";

	}
}
