package com.activityplanner.activityplanner.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

	@SuppressWarnings("rawtypes")
	@Override
	public List<ActivityDTO> getActivities() {
		List<Activity> savedActivities = activityRepository.findAll();
		@SuppressWarnings("unchecked")
		List<ActivityDTO> activities = new ArrayList();
		savedActivities.sort(Comparator.comparing(Activity::getDate));
		for (Activity activity : savedActivities) {
			activities.add(new ActivityDTO().convertFromDocument(activity));
		}
		return activities;
	}

	@Override
	public void deleteActivity(String id) {
		activityRepository.deleteById(id);
		
	}

	@Override
	public void updateParticipants(String id, List<String> participants) {
	 Optional<Activity> activity = activityRepository.findById(id);
	 Activity activityNotOptional = activity.get();
	 activityNotOptional.setParticipants(participants);
	 activityRepository.save(activityNotOptional);
	}

}
