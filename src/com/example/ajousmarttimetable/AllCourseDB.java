package com.example.ajousmarttimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AllCourseDB extends SQLiteOpenHelper {	   
	   
    public AllCourseDB(Context context) {
        super(context, "allcourse.db", null, 1);
        Log.d("SQLite", "Constructor-ing");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        Log.d("SQLite", "onCreate-ing");
        db.execSQL("CREATE TABLE allcourse "
                + "(courseCode TEXT PRIMARY KEY NOT NULL,"
                + "courseName TEXT NOT NULL,"
                + "res TEXT NOT NULL," // ��õ�б�
                + "credit INT NOT NULL,"
                + "category TEXT NOT NULL,"
                + "time TEXT )");
        
      //���� RM, ���� EM, ���� EL, ���� RL
        db.insert("allcourse", null, addcourse("50","��ǻ�����α׷���","12",3,"RM","2A 5A"));
        db.insert("allcourse", null, addcourse("57","�ü�� ","22",3,"RM","1A 3A"));
        db.insert("allcourse", null, addcourse("14","����1","12",3,"RL","2A 5A"));
        db.insert("allcourse", null, addcourse("15","����2","21",3,"RL","2D 5D"));
        db.insert("allcourse", null, addcourse("70","�����ͺ��̽� ","31",4,"RM","2B 4A"));
        db.insert("allcourse", null, addcourse("72","��ǻ�Ͱ��а���","11",3,"RM","1B 4B"));
        db.insert("allcourse", null, addcourse("73 ","��Ʈ��ũ�����","32",3,"EM","2A 2B"));
        db.insert("allcourse", null, addcourse("74 ","����ϼ����÷���","41",3,"EM","2B 4A"));
        db.insert("allcourse", null, addcourse("78","������ȣ","31",3,"RM","1E 3E"));
        db.insert("allcourse", null, addcourse("103","���İ��߿���","41",3,"EM","2C 5C"));
        db.insert("allcourse", null, addcourse("270","â�����۾���","22",3,"RL","2C 5C"));
        db.insert("allcourse", null, addcourse("274","������Ƽ���ѱ���ȸ","22",3,"RL","3D 3E"));
        db.insert("allcourse", null, addcourse("301","�����Ǽ���","22",3,"EL","2F 4E"));
        db.insert("allcourse", null, addcourse("21","������1","11",3,"RL","2A 5A"));
        db.insert("allcourse", null, addcourse("29","������н���","12",1,"RL","2C 2D"));
        db.insert("allcourse", null, addcourse("52","������ȸ��","21",3,"RM","1B 4B"));
        db.insert("allcourse", null, addcourse("56","�ڷᱸ��","12",3,"RM","2A 4A"));
        db.insert("allcourse", null, addcourse("59","�˰���","32",3,"RM","1D 4D"));
        db.insert("allcourse", null, addcourse("62","���ռ���������Ʈ","42",4,"RM","2C 2G"));
        db.insert("allcourse", null, addcourse("216","�Ϻ���1","21",3,"EL","2C 5C"));
        db.insert("allcourse", null, addcourse("215","�߱���ȸ�͹�ȭ","12",3,"EL","2F 4E"));
        db.insert("allcourse", null, addcourse("336","���а�����","21",3,"RL","2B 4B"));
        db.insert("allcourse", null, addcourse("348","�����̶������ΰ�","42",3,"EL","2B 4A"));
        db.insert("allcourse", null, addcourse("314","���丮�ڸ��̶������ΰ�","22",3,"EL","2C 5C"));
        db.insert("allcourse", null, addcourse("228","����","22",3,"EL","2E 2F"));
        db.insert("allcourse", null, addcourse("227","�±ǵ�","31",3,"EL","2E 2F"));
        db.insert("allcourse", null, addcourse("9","����2","11",3,"EL","1A 3A"));
        db.insert("allcourse", null, addcourse("83","�����͸��̴�","42",3,"EM","3F 5F"));
        db.insert("allcourse", null, addcourse("97","��Ʈ��ũ����Ʈ����ǽ�","31",1,"RM","5E 5F"));
        db.insert("allcourse", null, addcourse("98","������Ʈ��ũ","32",3,"RM","1C 4C"));
        db.insert("allcourse", null, addcourse("79","�����Ϸ�","31",3,"RM","2A 5A"));
        db.insert("allcourse", null, addcourse("249","�����ǰ���","22",3,"EL","2B 2C"));
        db.insert("allcourse", null, addcourse("319","�������Ǽ������","21",3,"EL","1E 3E"));
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists allcourse");
        onCreate(db);
    }
    
    public ContentValues addcourse (String courseCode, String courseName, 
    		String res, int credit, String category, String time){
        ContentValues values = new ContentValues();
        values.put("courseCode", courseCode);
        values.put("courseName", courseName);
        values.put("res", res);
        values.put("credit", credit);
        values.put("category", category);
        values.put("time", time);

        return values;
    }
}