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

	public static int AttNum = 0; //00001
	public static int BttNum = 0; //00002
    private ServerTimetableDB serverTtDBhelper;
    private UserDB userDBhelper;
    private CourseDB courseDBhelper;
    private AllCourseDB allcourseDBhelper;
    
    public ServerDBAdapter(Context context){
    	serverTtDBhelper = new ServerTimetableDB(context);
    	userDBhelper = new UserDB(context);
    	courseDBhelper = new CourseDB(context);
    	allcourseDBhelper = new AllCourseDB(context);
    }    

    //여기보기
    public boolean setDefaultTimetable(ArrayList<Course> courseList, String UserID){

        ArrayList<Course> Courses;
        String Fullcourse = "";
        int i = 0;
        SQLiteDatabase db = serverTtDBhelper.getWritableDatabase();
        
        //Courses = timetable.getCourses();
        //Course course = new Course();
        ContentValues values = new ContentValues();

       	for(i=0 ; i<courseList.size() ; i++){
            String tmp = courseList.get(i).getCourseCode();
            if(tmp.length() == 1){
            	tmp = "00" + tmp;
            }else if(tmp.length() == 2){
            	tmp = "0" + tmp;
            }
            Fullcourse += tmp;
        }
        values.put("userId",UserID);
        String name = UserID;
        if(name.equals("201500001")){
        	name += "-" + AttNum++;
        }else if(name.equals("201500002")){
        	name += "-" + BttNum++;
        }
        values.put("timetableName",name);
        values.put("courses",Fullcourse);

        db.insert("serverTimetable",null,values);

        return true;
    }
    
    //여기보기
    public ArrayList<Course> getAllCourses(String category){ //전체 코드 가져오기
    	ArrayList<Course> courseList = new ArrayList<Course>();
    	
    	SQLiteDatabase db = allcourseDBhelper.getReadableDatabase();
    	Cursor cursor = db.rawQuery("SELECT courseCode, courseName, professorName, time, classroom, credit"
					+ " FROM AllCourses " + "WHERE AllCourses.category='" + category + "';", null);
    	
		while(cursor.moveToNext()){
			Course tmp = new Course();
			tmp.setCourseCode(cursor.getString(0));
			
			tmp.setCourseName(cursor.getString(1));
			
			tmp.setProfessorName(cursor.getString(2));
			
			tmp.setTime(cursor.getString(3));
			
			tmp.setClassroom(cursor.getString(4));
			
			tmp.setCredit(cursor.getString(5));
			courseList.add(tmp);
		}
    	return  courseList;
    }
    
    public boolean deleteTimetable(String semester,String UserID){

        return true;
    }
	
    //여기보기
    public boolean checkPermisson(String userID) {
        
        return false;
    }
    
    public Timetable getDefaultTimetable(String userId){
		Timetable timetable = new Timetable();
		ArrayList<String> courseCodeList = new ArrayList<String>();
		
		SQLiteDatabase db = serverTtDBhelper.getReadableDatabase();
		Cursor cursor = db.rawQuery("SELECT timetableName FROM serverTimetable "
				+ "WHERE serverTimetable.userId='" + userId + "';", null);
		
		
		if(cursor != null && cursor.getCount() > 0){		
			
			//Log.i("cursor",cursor.getString(0));
			String str="";
			while(cursor.moveToNext()){
				str = cursor.getString(0);
			}
			timetable.setTimetableName(str);
			
			cursor = db.rawQuery("SELECT courses FROM serverTimetable "
					+ "WHERE serverTimetable.userId='" + userId + "';", null);
			
			String courses = "";
			while(cursor.moveToNext()){			
				courses = cursor.getString(0);
			}
			Log.i("cursor",courses);
			
			for(int i=0 ; i<courses.length() ; i+=3){
				String tmpstr = courses.substring(i, i+3);
				Log.i("tmpstr",tmpstr);
				courseCodeList.add(tmpstr);
			}				
			
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
			return timetable;
		}
		else{
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
