package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class AIM2DBAdapter {
	
	private String UserID;	
	
	public UserInfo getUserInfo(String userID){
		this.UserID = userID;
		UserInfo data = new UserInfo();
		data.setMajor(""); // aim2���� �޾ƿ��� �͵� ����
		data.setSemester(""); // aim2���� �޾ƿ��� �͵� ����
		//data.addCourse(course); // aim2���� �޾ƿ��� �͵� ����
		
		
		return data;
		
	}
	public static ArrayList<Course> getCourses(String UserID){
		
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course = new Course();		
		
		return courses;
	}

}
