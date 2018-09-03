package com.activityplanner.activityplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableMongoRepositories
public class ActivityplannerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityplannerApplication.class, args);
	}
	
	
}
