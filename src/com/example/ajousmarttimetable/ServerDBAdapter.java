package com.example.ajousmarttimetable;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by kim on 2015-06-02.
 */
public class ServerDBAdapter {

    private TimetableDB ttDBhelper;
    private UserDB userDBhelper;

    
    public ServerDBAdapter(Context context, String dbName){
        //super.onCreate(savedInstanceState);
    	if(dbName.equals("TimetableDB")){
    		ttDBhelper = new TimetableDB(this, null , null, 0);
    	}
    	else if(dbName.equals("UserDB")){
    		userDBhelper = new UserDB(context);
    	}
    }
    

    public boolean setDefaultTimetable(Timetable timetable,String UserID){

        ArrayList<Course> Courses;
        String Fullcourse = "";
        int i = 0;
        SQLiteDatabase db = ttDBhelper.getWritableDatabase();
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
    
    public boolean verifyLogin(String userId, String userPw){
    	SQLiteDatabase db = userDBhelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT password FROM User WHERE id='" + userId + "';", null);
		String getPw="";
		
		while (cursor.moveToNext()) {
			getPw = cursor.getString(0);
		}
		
		if(getPw==null || getPw.equals("")){
			return false;
		}
		else if(getPw.equals(userPw)){
			return true;
		}
		else {
			return false;
		}
    }

}
