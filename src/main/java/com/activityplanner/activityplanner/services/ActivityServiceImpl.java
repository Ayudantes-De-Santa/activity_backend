package com.activityplanner.activityplanner.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activityplanner.activityplanner.model.dto.ActivityDTO;
import com.activityplanner.activityplanner.model.entities.Activity;
import com.activityplanner.activityplanner.model.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void saveOrUpdateActivity(ActivityDTO activityDTO) {
		activityRepository.save(activityDTO.convertToDocument());
	}

	@Override
	public List<ActivityDTO> getActivities() {
		List<Activity> savedActivities = activityRepository.findAll();
		List<ActivityDTO> activities = new ArrayList();
		for (Activity activity : savedActivities) {
			activities.add(new ActivityDTO().convertFromDocument(activity));
		}
		return activities;
	}
	

}
