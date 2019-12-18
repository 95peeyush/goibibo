package com.targaryen.application.request;

import java.text.ParseException;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
	
	@Autowired
	RequestService service;
	
	/*
	 * Maps the incoming kill Animal request to the killAnimal of service class of killRequest*/
	@RequestMapping("/rule/dragon/kill/{dragonID}/{animal}/{timeStamp}")
	public boolean killAnimal(@PathVariable String dragonID,@PathVariable int animal,@PathVariable String timeStamp) throws ParseException {
		return service.killAnimal(dragonID, animal, timeStamp);
	}
}
