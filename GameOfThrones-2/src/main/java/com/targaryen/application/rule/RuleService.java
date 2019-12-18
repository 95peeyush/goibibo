package com.targaryen.application.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
/*
 * this is the service class for the RuleCreation
 * @localVariable rules - which is the ArrayList of RuleCreation class 
 * 							and consists of all the rules defined*/
public class RuleService {

	public static List<RulePOJO> rules = new ArrayList<RulePOJO>();
	
	/*
	 * @method createRule - creates and object of RuleCreation
	 * 							and adds this object to rules arraylist*/
	public String createRule(int hours, int animals) {
		rules.add(new RulePOJO(hours,animals,"Rule"+(rules.size()+1)));
		return "Rule"+rules.size();
	}
	/*
	 * @method deleteRule - used to delete the rule*/
	public String deleteRule(String id) {
		int numericPart = Integer.parseInt(id.split("Rule")[1]);
		if(numericPart>0&& numericPart<=rules.size()) {
			rules.removeIf(rule->rule.getId().equals(id));
			return id+":Deleted";
		}
		return id+":Not Deleted";
	}
}
