package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class ServerDBAdapter {

	public ServerDBAdapter() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean setDefaultTimetable(Timetable timetable,String UserID){
		
		ArrayList <Course> courses;
		int i = 0;
		courses = timetable.getCourses();
		Course c = new Course();
		
		while(i<courses.size()){
			c = courses.get(i); // Course
				// DB������ ������ �ڵ� �ʿ�
			i++;
		}
		return true;
	}
	public boolean deleteTimetable(String semester,String UserID){
		
		return true;
	}

	public boolean checkPermisson(String userID) {
		// TODO Auto-generated method stub // db���� ������ ����ߴ� �� Ȯ�� 
		return false;
	}

	public Timetable getTimetable(String userID) {
		// TODO Auto-generated method stub // db���� ���� course ���� �����;ߵ�
		//while(rs.next()){
			
		//	course.set  
		// timetable.add(course);	
		//}
		return null;
	}

}
