package com.example.ajousmarttimetable;

import java.io.Serializable;

import android.util.Log;

public class Course implements Serializable{

	private String professorName;
	private String courseName;
	private String time; 
	private String courseCode;
	private String classroom;
	private Task task;
	private String credit;
	
	public String getProfessorName() {
		return professorName;
	}

	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}
	public String getTime() {
		return time;
	}
	
	public int[] getTimeInt(){
		int t1=0, t2=0;
		String t = getTime();

		t1 = (t.charAt(3)-'A') * 5;
		
		if(t.substring(0, 3).equals("mon")){
			t1 += 0; 
		}
		if(t.substring(0, 3).equals("tue")){
			t1 += 1;
		}		
		if(t.substring(0, 3).equals("wed")){
			t1 += 2;
		}
		if(t.substring(0, 3).equals("thu")){
			t1 += 3;
		}
		if(t.substring(0, 3).equals("fri")){
			t1 += 4;
		}
		
		t2 = (t.charAt(8)-'A') * 5;
		if(t.substring(5, 8).equals("mon")){
			t2 += 0;
		}
		if(t.substring(5, 8).equals("tue")){
			t2 += 1;
		}
		if(t.substring(5, 8).equals("wed")){
			t2 += 2;
		}
		if(t.substring(5, 8).equals("thu")){
			t2 += 3;
		}
		if(t.substring(5, 8).equals("fri")){
			t2 += 4;
		}
		int[] timeint = {t1, t2};
		return timeint;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	
	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}
	
}
