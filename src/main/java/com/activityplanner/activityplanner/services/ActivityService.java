package com.activityplanner.activityplanner.services;

import java.util.List;

import com.activityplanner.activityplanner.model.dto.ActivityDTO;

public interface ActivityService {
	
	public void saveOrUpdateActivity(ActivityDTO activityDTO);

	public List<ActivityDTO> getActivities();

	public void deleteActivity(String id);

	public void updateParticipants(String id, List<String> participants);

}
