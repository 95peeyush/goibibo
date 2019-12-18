package com.targaryen.application.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * POJO class for registering the incoming request of killing animal*/
public class KillRequest {
	 
	String dragonId;
	int animal;
	String timeStamp;
	public KillRequest() {
		super();
	}
	
	public KillRequest(String dragonId, int animal, String timeStamp) {
		super();
		this.dragonId = dragonId;
		this.animal = animal;
		this.timeStamp = timeStamp;
	}
	
	public String getDragonId() {
		return dragonId;
	}
	public void setDragonId(String dragonId) {
		this.dragonId = dragonId;
	}
	
	
	public int getAnimal() {
		return animal;
	}

	public void setAnimal(int animal) {
		this.animal = animal;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "KillRequest [dragonId=" + dragonId + ", animal=" + animal + ", timeStamp=" + timeStamp + "]";
	}

	
	
}
