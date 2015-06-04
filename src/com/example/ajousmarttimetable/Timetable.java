package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class Timetable {

	private String TimetableName;
	private ArrayList<Course> courses ;
	private String Modifiedcoursecode;

	//private boolean defaultflag ;
	
	public Timetable(ArrayList<Course> Courses) {
		
		this.courses = Courses;
	}
	public Timetable() {
		initialize();
	//	defaultflag = false;
	}
	public void addCourse(Course c){
		courses.add(c);
	}
	public void getDefaultTimetable(){
		
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
		courses.clear();
	}
	public Course getCourseInfo(String CourseCode){
		
		this.Modifiedcoursecode = CourseCode;
		int i=0;
		while(i<courses.size()){
			if(Modifiedcoursecode.equals(courses.get(i).getCourseCode()))
				return courses.get(i);
		i++;
		}
		return null;
	}
	public void enterModifiedInfo(String professorName,String classroom,String time){
		int i=0;
		while(i<courses.size()){
			if(Modifiedcoursecode.equals(courses.get(i).getCourseCode())){
				courses.get(i).setClassroom(classroom);
				courses.get(i).setProfessorName(professorName);
				courses.get(i).setTime(time);
				}		
		i++;
		}
	}
	/*public void setdefaultflag(boolean flag){
		this.defaultflag = flag;
		
	}
	*/
	public void saveTimetable(String TimetableName){
		
		this.setTimetableName(TimetableName);
		//course 객체로 보내야 하지 않을가 ??
		//setdefaultflag(true);
		new TimetableDBAdapter().addTimetable(this);
		
	}

	public String getTimetableName() {
		return TimetableName;
	}
	public void setTimetableName(String timetableName) {
		TimetableName = timetableName;
	}
	
}
