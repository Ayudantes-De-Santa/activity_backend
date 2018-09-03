package com.activityplanner.activityplanner.model.repository;

import com.activityplanner.activityplanner.model.entities.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ActivityRepository extends MongoRepository<Activity, Long>{

}
