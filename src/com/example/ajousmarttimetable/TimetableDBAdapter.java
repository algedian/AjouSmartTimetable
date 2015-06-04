package com.example.ajousmarttimetable;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
//extends ListActivity
public class TimetableDBAdapter  {

	private CourseDB courseDBhelper;
	private TimetableDB ttDBhelper;

	public TimetableDBAdapter(Context context){
		courseDBhelper = new CourseDB(context);
		ttDBhelper = new TimetableDB(context);		
	}
	
	//여기보기
	public ArrayList<String> getCourses(){
		SQLiteDatabase db = courseDBhelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select courseCode, courseName, professorName, classroom, time, task" +
				" from course WHERE ", null);
		ArrayList<String> list = new ArrayList<String>();
		while (cursor.moveToNext()){
			list.add(cursor.getString(1));
		}
		cursor.close();
		return list;
	}

	//여기보기
	public boolean addTimetable(Timetable timetable){
		SQLiteDatabase db = courseDBhelper.getWritableDatabase();
		ArrayList<Course> c;
		int i = 0;
		c = timetable.getCourses();
		Course course = new Course();
		ContentValues values = new ContentValues();

		while(i<c.size()){
			course = c.get(i);
			values.put("CourseCode",course.getCourseCode());
			values.put("CourseName",course.getCourseName());
			values.put("professorName",course.getProfessorName());
			values.put("classRoom",course.getClassroom());
			values.put("Time",course.getTime());
			values.put("Task",course.getTask().getContent());//.getTaskString());
			db.insert("course",null,values);
			// Course
			// DB쪽으로 보내는 코드 필요
			// 나머지 timetable defaultflag false로 만드느 코드
			i++;
		}
		return true;
	}
	
	//여기보기
	public ArrayList<String> getTimetableNames(String userId){ 
		ArrayList<String> res = null;
		
		return res;
	}
	
	public boolean deleteCourse(String semester){

		return true;
	}
}
