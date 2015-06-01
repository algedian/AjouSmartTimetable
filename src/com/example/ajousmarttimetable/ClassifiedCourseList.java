package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class ClassifiedCourseList {

	private  ArrayList<Course> courses;
	
	public ClassifiedCourseList() {
		// TODO Auto-generated constructor stub
	}
	public ClassifiedCourseList(String CategoryName,String Major
			,ArrayList<Course> arrayList,String UserID) {
		// TODO Auto-generated constructor stub
		this.courses = new AIM2DBAdapter().getCourses(UserID);
		//while(i<n){ course 숫자 만큼
		ClassifiedCourse(CategoryName,Major);
		//}
	}
	public void ClassifiedCourse(String categoryName,String Major){
		//courses 와 categoryName major로 분별
	}
	
	public void addCourse (String CourseCode){
		
		 Course c = new Course();
		 c = selectCourse(CourseCode);
		 
	}
	public Course selectCourse(String CourseCode){
		
		int i=0;
		while(i<courses.size()){
			if(CourseCode.equals(courses.get(i).getCourseCode()))
				return courses.get(i);
		i++;
		}
		return null;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
}
