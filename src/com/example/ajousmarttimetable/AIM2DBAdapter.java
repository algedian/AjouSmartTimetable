package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class AIM2DBAdapter {
	
	private String UserID;	
	
	public UserInfo getUserInfo(String userID){
		this.UserID = userID;
		UserInfo data = new UserInfo();
		data.setMajor(""); // aim2에서 받아오는 것들 저장
		data.setSemester(""); // aim2에서 받아오는 것들 저장
		//data.addCourse(course); // aim2에서 받아오는 것들 저장
		
		
		return data;
		
	}
	public static ArrayList<Course> getCourses(String UserID){
		
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course = new Course();		
		
		return courses;
	}

}
