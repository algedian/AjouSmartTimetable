package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class UserInfo {
	private String userID;
	private String userPw;
	private String semester; //now
	private String Major;
	private ArrayList<Course> takenCourses;	
	
	public String getSemester() {
		return semester;
	}
	
	public void setSemester(String semester) {
		this.semester = semester;
	}
	
	public String getMajor() {
		return Major;
	}
	
	public void setMajor(String major) {
		Major = major;
	}
	
	public ArrayList<Course> getTakenCourses() {
		return takenCourses;
	}
	
	public void setTakenCourses(ArrayList<Course> takenCourses) {
		this.takenCourses = takenCourses;
	}
	
	public void addCourse(Course course) {
		takenCourses.add(course);
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
}
