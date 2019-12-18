package com.targaryen.application.rule;


/* POJO class for creating the rule
 * @param hours
 * @param animals
 * @param id*/
public class RulePOJO {
	
	int hours;
	int animals;
	String id;
	
	public RulePOJO() {
		super();
	}
	
	public RulePOJO(int hours, int animals, String id) {
		super();
		this.hours = hours;
		this.animals = animals;
		this.id = id;
	}
	
	public int getHours() {
		return hours;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
	
	public int getAnimals() {
		return animals;
	}
	
	public void setAnimals(int animals) {
		this.animals = animals;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "RuleCreation [hours=" + hours + ", animals=" + animals + ", id=" + id + "]";
	}
	
	
}
