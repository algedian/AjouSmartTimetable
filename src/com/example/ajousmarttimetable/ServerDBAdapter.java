package com.example.ajousmarttimetable;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by kim on 2015-06-02.
 */
public class ServerDBAdapter {

    private ServerTimetableDB serverTtDBhelper;
    private UserDB userDBhelper;
    private CourseDB courseDBhelper;
    
    public ServerDBAdapter(Context context, String dbName){
    	serverTtDBhelper = new ServerTimetableDB(context);
    	userDBhelper = new UserDB(context);
    	courseDBhelper = new CourseDB(context);
    }    

    //���⺸��
    public boolean setDefaultTimetable(Timetable timetable,String UserID){

        ArrayList<Course> Courses;
        String Fullcourse = "";
        int i = 0;
        SQLiteDatabase db = serverTtDBhelper.getWritableDatabase();
        Courses = timetable.getCourses();
        Course course = new Course();
        ContentValues values = new ContentValues();

        while(i<Courses.size()){
            course = Courses.get(i);
            Fullcourse = Fullcourse+course.getCourseCode();
            // ������ timetable defaultflag false�� ����� �ڵ�
            i++;
        }
        values.put("UserID",course.getCourseCode());
        values.put("TimetableName",course.getCourseName());
        values.put("courses",Fullcourse);

        db.insert("Timetable",null,values);

        return true;
    }
    
    //���⺸��
    public ArrayList<Course> getAllCourses(){ //��ü �ڵ� ��������
    	ArrayList<Course> courseList = new ArrayList<Course>();
    	
    	SQLiteDatabase db = serverTtDBhelper.getReadableDatabase();
		//Cursor cursor = db.rawQuery("SELECT * FROM serverTimetable " + "WHERE serverTimetable.userId='" + userId + "';", null);
		    	
    	return  courseList;
    }
    
    public boolean deleteTimetable(String semester,String UserID){

        return true;
    }
	
    //���⺸��
    public boolean checkPermisson(String userID) {
        
        return false;
    }
    
    public Timetable getDefaultTimetable(String userId){
		Timetable timetable = new Timetable();
		ArrayList<String> courseCodeList = null;
		
		SQLiteDatabase db = serverTtDBhelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT timetableName FROM serverTimetable "
				+ "WHERE serverTimetable.userId='" + userId + "';", null);
		
		Log.d("server db","1");
		if(cursor != null && cursor.getCount() > 0){		
			Log.d("server db","2");
			timetable.setTimetableName(cursor.getString(0));
			
			cursor = db.rawQuery("SELECT courses FROM serverTimetable "
					+ "WHERE serverTimetable.userId='" + userId + "';", null);
			
			Log.d("server db","3");
			String courses = cursor.getString(0);
			
			Log.d("server db","4");
			for(int i=0 ; i<courses.length() ; i+=2){
				String tmpstr = "";
				tmpstr += courses.substring(i, i+1);
				courseCodeList.add(tmpstr);
			}		
			
			Log.d("server db","5");
			if(courseCodeList != null){
				for(int i=0 ; i<courseCodeList.size() ; i++){
					db = courseDBhelper.getReadableDatabase();
					cursor = db.rawQuery("SELECT * FROM course "
							+ "WHERE course.courseCode='" + courseCodeList.get(i) + "';", null);
					while(cursor.moveToNext()){
						Course tmp = new Course();
						tmp.setCourseCode(cursor.getString(0));
						tmp.setCourseName(cursor.getString(1));
						tmp.setProfessorName(cursor.getString(2));
						tmp.setClassroom(cursor.getString(3));
						tmp.setTime(cursor.getString(4));	
						
						timetable.addCourse(tmp);
					}			
				}
			}
			cursor.close();	
			return timetable;
		}
		else{
			Log.d("server db","6");
			return null;			
		}
	}
    
    public boolean verifyLogin(String userId, String userPw){
    	SQLiteDatabase db = userDBhelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT password FROM user WHERE user.id='" + userId + "';", null);
		String getPw="";
		
		while (cursor.moveToNext()) {
			getPw = cursor.getString(0);
		}
		cursor.close();
		
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
