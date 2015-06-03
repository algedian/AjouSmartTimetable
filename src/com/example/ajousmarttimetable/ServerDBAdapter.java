package com.example.ajousmarttimetable;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by kim on 2015-06-02.
 */
public class ServerDBAdapter {

    private TimetableDB helper;

    public void ServerDBAdapter(Bundle savedInstanceState){
        //super.onCreate(savedInstanceState);

        helper = new TimetableDB(this, null , null, 0);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cards);
        //setListAdapter(adapter);
    }

    public boolean setDefaultTimetable(Timetable timetable,String UserID){

        ArrayList<Course> Courses;
        String Fullcourse = "";
        int i = 0;
        SQLiteDatabase db = helper.getWritableDatabase();
        Courses = timetable.getCourses();
        Course course = new Course();
        ContentValues values = new ContentValues();

        while(i<Courses.size()){
            course = Courses.get(i);
            Fullcourse = Fullcourse+course.getCourseCode();
            // 나머지 timetable defaultflag false로 만드느 코드
            i++;
        }
        values.put("UserID",course.getCourseCode());
        values.put("TimetableName",course.getCourseName());
        values.put("courses",Fullcourse);

        db.insert("Timetable",null,values);

        return true;
    }
    public boolean deleteTimetable(String semester,String UserID){

        return true;
    }

    public boolean checkPermisson(String userID) {
        // TODO Auto-generated method stub // db에서 유저가 허락했는 지 확인
        return false;
    }

    public Timetable getTimetable(String userID) {
        // TODO Auto-generated method stub // db에서 유저 course 들을 가져와야됨
        //while(rs.next()){

        //	course.set
        // timetable.add(course);
        //}
        return null;
    }

}
