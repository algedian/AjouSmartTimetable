package com.example.ajousmarttimetable;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
//extends ListActivity
public class TimetableDBAdapter  {


	private CourseDB helper;

	public void TimetableDBAdapter(Bundle savedInstanceState){
		//super.onCreate(savedInstanceState);

		helper = new CourseDB(this, null , null, 0);

		List<String>  courses = getCourses();
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cards);
		//setListAdapter(adapter);
	}
	public ArrayList<String> getCourses(){
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery("select CourseCode,CourseName,professorName,classRoomName,Time,Task" +
				" from courses", null);
		ArrayList<String> list = new ArrayList<String>();
		while (cursor.moveToNext()){
			list.add(cursor.getString(1));
		}
		return list;
	}

	public boolean addTimetable(Timetable timetable){

		SQLiteDatabase db = helper.getWritableDatabase();
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
	public Timetable getDefaultTimetable(){

		Timetable timetable = new Timetable();

		//defaultTimetable 가져오는 코드 DB에 flag ???

		//t.addCourse(c);
		return timetable;
	}
	public boolean deleteCourse(String semester){




		return true;
	}


}
