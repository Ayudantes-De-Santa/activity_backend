package com.activityplanner.activityplanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activityplanner.activityplanner.model.dto.ActivityDTO;
import com.activityplanner.activityplanner.model.repository.ActivityRepository;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;

	@Override
	public void saveOrUpdateActivity(ActivityDTO activityDTO) {
		activityRepository.save(activityDTO.convertToDocument());
	}

}
