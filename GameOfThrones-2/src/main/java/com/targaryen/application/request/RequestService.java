package com.targaryen.application.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.targaryen.application.rule.RuleService;

import ch.qos.logback.core.util.Duration;
/*
 * 
 * Main Logic of handling of the request is done by this class*/
@Service
public class RequestService {
	
	
	List<KillRequest> requestList = new ArrayList<KillRequest>(); // Local variable of type arrayList for keeping list of successful requests
	/*
	 * @param - dragonID
	 * @param - animal
	 * @param - timestamp*/
	public boolean killAnimal(String dragonID,int animal,String timeStamp) throws ParseException {
		
		if(requestList.size()>0) { //checking request size
			boolean isPresent = false;
			for(int i=0;i<requestList.size();i++) {	//checking whether given dragon has already requested before or not
				if(requestList.get(i).getDragonId().equals(dragonID)) {
					isPresent = true;
					break;
				}
			}
			if(!isPresent) {	//if not requested before call addFirstEntry
				return addFirstEntry(dragonID, animal, timeStamp);
			}
			else {
				boolean allowed = checkkillAllowed(dragonID, animal, timeStamp); //else call checkkillAllowed
				if(allowed) {
					requestList.add(new KillRequest(dragonID, animal, timeStamp)); //if request can be fulfilled add this  list of successful requests
				}
				return allowed;
			}
		}
		else {	//request list size 0 means first request
			return addFirstEntry(dragonID, animal, timeStamp);
		}
	}
	
	
	public boolean addFirstEntry(String dragonID,int animal,String timeStamp) {
		
		boolean isAllowedToKill = true;
		
		for(int i=0;i<RuleService.rules.size();i++) {
			if(RuleService.rules.get(i).getAnimals()>=animal) //since first entry just check for the animal Kill request with allowed animals against each rule
				continue;
			else {
				isAllowedToKill=false; // if at any time requested count is greater than allowed count of any rule request rejected
				break;
			}
		}
		if(isAllowedToKill) {
			requestList.add(new KillRequest(dragonID,animal, timeStamp)); //if request can be fulfilled add this  list of successful requests
			return true;
		}
		return false;
	}
	
	
	public boolean checkkillAllowed(String dragonID,int animal,String timeStamp) throws ParseException {
		boolean isAllowed = true;
		for(int i=0;i<RuleService.rules.size();i++) { //for each rule 
			int killedanimal=0;
			for(int j =0;j<requestList.size();j++) { //for all the previous successful request
				if(requestList.get(j).getDragonId().equals(dragonID)&&compareDates(timeStamp, RuleService.rules.get(i).getHours(), requestList.get(j).getTimeStamp())) {
					killedanimal=killedanimal+requestList.get(j).getAnimal();
				}// adding the killCount for those previous request of this dragon that are to be considered in making decision for this request
			}
			if(killedanimal+animal>RuleService.rules.get(i).getAnimals()) { //checking already killed + request to kill doesn't exceed any rule limit
				isAllowed = false;
				return isAllowed;
			}
		}
		return isAllowed;
	}
	
	/*
	 * function for calculating the time as current request time minus the hours against each rule
	 * then checking whether the previous request of this dragon is to considered*/
	
	public boolean compareDates(String requestTime,int hours,String previousTime ) throws ParseException {
		Date d1 = new SimpleDateFormat("yyyy-MM-dd-hh:mm").parse(requestTime);
		Date d2 = new SimpleDateFormat("yyyy-MM-dd-hh:mm").parse(previousTime); 
		Calendar cal = Calendar.getInstance();
		cal.setTime(d1);
		cal.add(Calendar.HOUR, -hours);
		d1 = cal.getTime();
		double dif = (d2.getTime()-d1.getTime())/3600000.0;
		if(dif>0)
			return true;
		return false;
		
	}
}
