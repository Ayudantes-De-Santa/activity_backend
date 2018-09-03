package com.activityplanner.activityplanner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.activityplanner.activityplanner.model.dto.ActivityDTO;
import com.activityplanner.activityplanner.services.ActivityService;

@Controller
public class MainController {
	
	@Autowired
	private ActivityService activityService;
	
	
	@RequestMapping(value = "/activity/{name}", method = RequestMethod.GET)
	public String getHelloWorld(@PathVariable(value = "summonName") String summonName) {
		return "Hello " + summonName;
	}
	
	@RequestMapping(value= "/activity/create")
	@ResponseBody
	public void create(@RequestBody ActivityDTO activity) {
		activityService.saveOrUpdateActivity(activity);
	}

}
