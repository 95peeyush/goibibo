package com.targaryen.application.dragon;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/*
 * this is the service class for the DragonCreation
 * @localVariable dragon - which is the ArrayList of DragonCreation class 
 * 							and consists of all the Dragon registered*/

@Service
public class DragonService {

	List<DragonPOJO> dragon = new ArrayList<DragonPOJO>();
	
	public String registerDragon(String name) {
		dragon.add(new DragonPOJO(name, "Dragon"+(dragon.size()+1)));
		return "Dragon"+dragon.size();
	}
}
