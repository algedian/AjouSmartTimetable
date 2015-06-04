package com.example.ajousmarttimetable;

import java.io.Serializable;
import java.util.ArrayList;

public class Timetable implements Serializable{

	private String timetableName; //####-#-## ex)2015-1-01
	private ArrayList<Course> courses;
	private String modifiedCoursecode;
	private boolean defaultflag ;
	
	//여기보기
	public Timetable(ArrayList<Course> Courses) {		
		this.courses = Courses;
	}
	
	public Timetable() {
		initialize();
	}
	
	public void addCourse(Course c){
		courses.add(c);
	}
	
	public void submitTimetable(String semester,String UserID){
		
		this.setTimetableName(semester);
		//course 객체로 보내야 하지 않을가 ??
		//setdefaultflag(true);
		//new TimetableDBAdapter().addTimetable(this);
		//new ServerDBAdapter().setDefaultTimetable(this, UserID);	
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public void initialize(){
		setTimetableName(null);
		if(courses != null) courses.clear();
		defaultflag = false;
	}
	
	public Course getCourseInfo(String CourseCode){
		
		this.modifiedCoursecode = CourseCode;
		int i=0;
		while(i<courses.size()){
			if(modifiedCoursecode.equals(courses.get(i).getCourseCode()))
				return courses.get(i);
		i++;
		}
		return null;
	}
	
	public void enterModifiedInfo(String professorName,String classroom,String time){
		int i=0;
		while(i<courses.size()){
			if(modifiedCoursecode.equals(courses.get(i).getCourseCode())){
				courses.get(i).setClassroom(classroom);
				courses.get(i).setProfessorName(professorName);
				courses.get(i).setTime(time);
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
