package com.targaryen.application.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * @controller for the RuleCreation
 * */

@RestController
public class RuleController {

	@Autowired
	RuleService ruleService;
	/*
	 * @method createRule - maps the incoming rest request of creating rule
	 * 						to the createRule of the service class of RuleCreation
	 * */
	@RequestMapping("/rule/{hours}/{animals}")
	public String createRule(@PathVariable int hours, @PathVariable int animals) {
		return ruleService.createRule(hours, animals);
	}
	
	/*
	 * @method deleteRule - maps the incoming request of delete rule to 
	 * 						the deleteRule of service class of RuleCreation*/
	@RequestMapping(method = RequestMethod.DELETE,value = "/rule/{id}")
	public String deleteRule(@PathVariable String id) {
		return ruleService.deleteRule(id);
	}
	
}
