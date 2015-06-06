package com.example.ajousmarttimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AllCourseDB extends SQLiteOpenHelper {	   
	   
    public AllCourseDB(Context context) {
        super(context, "AllCourses.db", null, 1);
        Log.d("SQLite AllCourses", "Constructor-ing");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        Log.d("SQLite AllCourses", "onCreate-ing");
        db.execSQL("CREATE TABLE AllCourses ( "
                + "courseCode TEXT PRIMARY KEY NOT NULL, "
                + "courseName TEXT NOT NULL, "
                + "res TEXT NOT NULL, " // ��õ�б�
                + "professorName TEXT NOT NULL, "
                + "classroom TEXT NOT NULL, "
                + "credit TEXT NOT NULL, "
                + "category TEXT NOT NULL, "
                + "time TEXT NOT NULL )");
        
       
        //���� RM, ���� EM, ���� EL, ���� RL        
        db.insert("AllCourses", null, addcourse("50","��ǻ�����α׷���","12","���⿭","��309","3","RM","2A 5A"));
        db.insert("AllCourses", null, addcourse("57","�ü��","22","������","��110","3","RM","1A 3A"));
        db.insert("AllCourses", null, addcourse("14","����1","12","�輺��","��204","3","RL","2A 5A"));
        db.insert("AllCourses", null, addcourse("15","����2","21","�����","��203","3","RL","2D 5D"));
        db.insert("AllCourses", null, addcourse("70","�����ͺ��̽�","31","������","��110","4","RM","2B 4A"));
        db.insert("AllCourses", null, addcourse("72","��ǻ�Ͱ��а���","11","���⿭","��1025","3","RM","1B 4B"));
        db.insert("AllCourses", null, addcourse("73","��Ʈ��ũ�����","32","������","��328","3","EM","2A 2B"));
        db.insert("AllCourses", null, addcourse("74","����ϼ����÷���","41","���¼�","��309","3","EM","2B 4A"));
        db.insert("AllCourses", null, addcourse("78","������ȣ","31","���½�","��309","3","RM","1E 3E"));
        db.insert("AllCourses", null, addcourse("103","���İ��߿���","41","���½�","","3","EM","2C 5C"));
        db.insert("AllCourses", null, addcourse("270","â�����۾���","22","�����","��503","3","RL","2C 5C"));
        db.insert("AllCourses", null, addcourse("274","������Ƽ���ѱ���ȸ","22","�����","��504","3","RL","3D 3E"));
        db.insert("AllCourses", null, addcourse("301","�����Ǽ���","22","�Ƹ��� ��","��503","3","EL","2F 4E"));
        db.insert("AllCourses", null, addcourse("21","������1","11","������","��205","3","RL","2A 5A"));
        db.insert("AllCourses", null, addcourse("29","������н���","12","��μ�","��104","1","RL","2C 2D"));
        db.insert("AllCourses", null, addcourse("52","������ȸ��","21","�輺��","��309","3","RM","1B 4B"));
        db.insert("AllCourses", null, addcourse("56","�ڷᱸ��","12","�����","��410","3","RM","2A 4A"));
        db.insert("AllCourses", null, addcourse("59","�˰���","32","�հ��","��110","3","RM","1D 4D"));
        db.insert("AllCourses", null, addcourse("228","����","22","����","��������������","3","EL","2E 2F"));
        db.insert("AllCourses", null, addcourse("227","�±ǵ�","31","����","ü����","3","EL","2E 2F"));
        db.insert("AllCourses", null, addcourse("9","����2","11","Theresia","��405","3","EL","1A 3A"));
        db.insert("AllCourses", null, addcourse("83","�����͸��̴�","42","���¼�","��328","3","EM","3F 5F"));
        db.insert("AllCourses", null, addcourse("97","��Ʈ��ũ����Ʈ����ǽ�","31","���¼�","��325","1","RM","5E 5F"));
        db.insert("AllCourses", null, addcourse("98","������Ʈ��ũ","32","������","��328","3","RM","1C 4C"));
        db.insert("AllCourses", null, addcourse("79","�����Ϸ�","31","������","��1025","3","RM","2A 5A"));
        db.insert("AllCourses", null, addcourse("249","�����ǰ���","22","�Ƹ��� ��","��305","3","EL","2B 2C"));
        db.insert("AllCourses", null, addcourse("319","�������Ǽ������","21","�̿���","��507","3","EL","1E 3E"));
        db.insert("AllCourses", null, addcourse("216","�Ϻ���1","21","�̼���","��507","3","EL","2C 5C"));
        db.insert("AllCourses", null, addcourse("215","�߱���ȸ�͹�ȭ","12","ȫ����","��505","3","EL","2F 4E"));
        db.insert("AllCourses", null, addcourse("336","���а�����","21","�̱���","��B102","3","RL","2B 4B"));
        db.insert("AllCourses", null, addcourse("348","�����̶������ΰ�","42","�����","��205","3","EL","2B 4A"));
        db.insert("AllCourses", null, addcourse("314","���丮�ڸ��̶������ΰ�","22","��ȿ��","��502","3","EL","2C 5C"));
        db.insert("AllCourses", null, addcourse("62","���ռ���������Ʈ","42","������","��104","4","RM","2C 2G"));        
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS allcourse");
        db.execSQL("DROP TABLE IF EXISTS Allcourse");
        db.execSQL("DROP TABLE IF EXISTS allCourse");
    	db.execSQL("DROP TABLE IF EXISTS AllCourse");
    	db.execSQL("DROP TABLE IF EXISTS AllCourses");
        onCreate(db);
    }
    
    public ContentValues addcourse (String courseCode,String courseName,String res,String professorName,
    		String classroom,String credit,String category,String time){
          ContentValues values = new ContentValues();
          values.put("courseCode", courseCode);
          values.put("courseName", courseName);
          values.put("res", res);
          values.put("professorName", professorName);
          values.put("classroom", classroom);          
          values.put("time", time);
          values.put("credit", credit);
          values.put("category", category);
          
          return values;
    }
    
}