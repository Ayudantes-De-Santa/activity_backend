package com.activityplanner.activityplanner.model.dto;

import com.activityplanner.activityplanner.model.entities.Activity;

public class ActivityDTO {
	
	private String name;
	private String location;
	private String date;
	private String time;
	private String photo;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Activity convertToDocument() {
		Activity activity = new Activity();
		activity.setDate(this.date);
		activity.setDescription(this.description);
		activity.setLocation(this.location);
		activity.setName(this.name);
		activity.setTime(this.time);
		return activity;
	}

}
