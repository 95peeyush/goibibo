package com.targaryen.application.dragon;

import java.util.List;

import com.targaryen.application.rule.RulePOJO;
import com.targaryen.application.rule.RuleService;

/* POJO class for creating the dragon
 * @param name
 * @param id*/

public class DragonPOJO {

	String name;
	String id;
	
	List<RulePOJO> rules =  RuleService.rules;
	public DragonPOJO() {
		super();
	}
	public DragonPOJO(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "RegisterDragon [name=" + name + ", id=" + id + "]";
	}
	
}
