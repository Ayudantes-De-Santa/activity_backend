package com.activityplanner.activityplanner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.activityplanner.activityplanner.model.dto.ActivityDTO;
import com.activityplanner.activityplanner.services.ActivityService;

@RestController
public class MainController {
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value= "/activity/create", method = RequestMethod.POST)
	public void create(@RequestBody ActivityDTO activity) {
		activityService.saveOrUpdateActivity(activity);
	}
	
	@RequestMapping(value= "/activity/get", method = RequestMethod.GET)
	
	public List<ActivityDTO> getAll() {
		return activityService.getActivities();
	}
	
	@RequestMapping(value= "/activity/update", method = RequestMethod.PUT)
	public void update(@RequestBody ActivityDTO activity) {
		activityService.saveOrUpdateActivity(activity);
	}
	
	@RequestMapping(value= "/activity/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable String id) {
		activityService.deleteActivity(id);
	}
	
	@RequestMapping(value= "/activity/{id}/updateparticipants", method = RequestMethod.PUT)
	public void updateParticipants(@PathVariable String id, @RequestBody List<String> participants) {
		activityService.updateParticipants(id , participants);
	}
	
	

}
