package com.targaryen.application.dragon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * @controller for the DragonCreation
 * */  
@RestController
public class DragonController {

	@Autowired
	DragonService dragonService;
	
	/*
	 * @method registerDragon - maps the incoming request of register Dragon to 
	 * 						the registerDragon of service class of DragonCreation*/
	
	@RequestMapping("/rule/dragon/{name}")
	public String registerDragon(String name) {
		return dragonService.registerDragon(name);
	}
}
