package com.activityplanner.activityplanner.model.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.activityplanner.activityplanner.model.entities.Activity;

public class ActivityDTO {
	private String id;

	private String name;
	private String location;
	private String date;
	private String time;
	private String photo;
	private String description;
	private List<String> participants;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public List<String> getParticipants() {
		return participants;
	}
	
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	public Activity convertToDocument() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		Activity activity = new Activity();
		if (this.id != null) {
			activity.setId(this.id);
		}
		String newDate = this.date + " " + this.time;
		activity.setDate(LocalDateTime.parse(newDate, formatter));
		activity.setDescription(this.description);
		activity.setLocation(this.location);
		activity.setName(this.name);
		activity.setParticipants(this.participants);
		activity.setPhoto(this.photo);
//		activity.setTime(this.time);
		return activity;
	}

	public ActivityDTO convertFromDocument(Activity activity) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.date = activity.getDate().format(formatter);
		this.description = activity.getDescription();
		this.location = activity.getLocation();
		this.name = activity.getName();
		this.id = activity.getId();
		this.photo = activity.getPhoto();
		this.participants = activity.getParticipants();
		DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("HH:mm");
		this.time = activity.getDate().format(newFormatter);
		return this;
	}


}
