package com.example.ajousmarttimetable;

import java.io.Serializable;
import java.util.ArrayList;

public class Timetable implements Serializable{

	private String timetableName; //####-#-## ex)2015-1-01
	private String courses;
	public ArrayList<Course> courseList;
	private String modifiedCoursecode;
	private boolean defaultflag ;
	
	//여기보기
	public Timetable(ArrayList<Course> Courses) {		
		this.courseList = Courses;
	}
	
	public Timetable() {
		initialize();
	}
	
	public void addCourse(Course c){
		courseList.add(c);
	}
	
	public void submitTimetable(String semester,String UserID){
		
		this.setTimetableName(semester);
		//course 객체로 보내야 하지 않을가 ??
		//setdefaultflag(true);
		//new TimetableDBAdapter().addTimetable(this);
		//new ServerDBAdapter().setDefaultTimetable(this, UserID);	
	}
	
	public String getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courseList = courses;
	}
	
	public void initialize(){
		setTimetableName(null);
		if(courses != null) courseList.clear();
		defaultflag = false;
	}
	
	public Course getCourseInfo(String CourseCode){
		
		this.modifiedCoursecode = CourseCode;
		int i=0;
		while(i<courseList.size()){
			if(modifiedCoursecode.equals(courseList.get(i).getCourseCode()))
				return courseList.get(i);
		i++;
		}
		return null;
	}
	
	public void enterModifiedInfo(String professorName,String classroom,String time){
		int i=0;
		while(i<courseList.size()){
			if(modifiedCoursecode.equals(courseList.get(i).getCourseCode())){
				courseList.get(i).setClassroom(classroom);
				courseList.get(i).setProfessorName(professorName);
				courseList.get(i).setTime(time);
				}		
		i++;
		}
	}
	
	public void setdefaultflag(boolean flag){
		this.defaultflag = flag;
		
	}
		
	public String getTimetableName() {
		return timetableName;
	}
	
	public void setTimetableName(String timetableName) {
		this.timetableName = timetableName;
	}
	
}
