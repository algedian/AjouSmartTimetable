package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class AIM2DBAdapter {
	
	private  String UserID;
	
	
	public Datatype getUserInfo(String userID){
		this.UserID = userID;
		Datatype data = new Datatype();
		data.setMajor(""); // aim2���� �޾ƿ��� �͵� ����
		data.setSemester(""); // aim2���� �޾ƿ��� �͵� ����
		//data.addCourse(course); // aim2���� �޾ƿ��� �͵� ����
		
		
		return data;
		
	}
	public ArrayList<Course> getCourses(String UserID){
		
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course = new Course();
		//while(rs.next()){
			
		//	cousre . set
		//}
		
		
		
		return courses;
	}

}
