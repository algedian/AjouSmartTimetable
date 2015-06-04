package com.example.ajousmarttimetable;

import java.util.ArrayList;

public class ASTHandler {
	
	private static ASTHandler instance;
	UserInfo userInfo;
	ArrayList<Timetable> timetableList;
	AIM2DBAdapter aims2DBadapter;
	ServerDBAdapter serverDBadapter;
	Timetable timetable;
	TimetableDBAdapter ttDBadapter;

	private ASTHandler() {}
	 
	public static synchronized ASTHandler getInstance() {
		if(instance == null) {
			instance = new ASTHandler();
		}
		return instance;
	}
	
	public void makeNewTimetable(){
		
	}
	
	public void selectCategory(String categoryName){
		
	}
	
	public void selectCourse(){
		
	}
	
	public void submitTimetable(){
		
	}
	
	public void requestOthersTimetable(String userId){
		
	}
	
	public void saveTimetable(String timetableName){
		
	}
	
}