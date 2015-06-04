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
                + "res TEXT NOT NULL," // 추천학기
                + "credit INT NOT NULL,"
                + "category TEXT NOT NULL,"
                + "time TEXT )");
        
      //전필 RM, 전선 EM, 교선 EL, 교필 RL
        db.insert("allcourse", null, addcourse("50","컴퓨터프로그래밍","12",3,"RM","2A 5A"));
        db.insert("allcourse", null, addcourse("57","운영체제 ","22",3,"RM","1A 3A"));
        db.insert("allcourse", null, addcourse("14","수학1","12",3,"RL","2A 5A"));
        db.insert("allcourse", null, addcourse("15","수학2","21",3,"RL","2D 5D"));
        db.insert("allcourse", null, addcourse("70","데이터베이스 ","31",4,"RM","2B 4A"));
        db.insert("allcourse", null, addcourse("72","컴퓨터공학개론","11",3,"RM","1B 4B"));
        db.insert("allcourse", null, addcourse("73 ","네트워크운용사례","32",3,"EM","2A 2B"));
        db.insert("allcourse", null, addcourse("74 ","모바일서비스플랫폼","41",3,"EM","2B 4A"));
        db.insert("allcourse", null, addcourse("78","정보보호","31",3,"RM","1E 3E"));
        db.insert("allcourse", null, addcourse("103","정컴개발연구","41",3,"EM","2C 5C"));
        db.insert("allcourse", null, addcourse("270","창의적글쓰기","22",3,"RL","2C 5C"));
        db.insert("allcourse", null, addcourse("274","섹슈얼리티와한국사회","22",3,"RL","3D 3E"));
        db.insert("allcourse", null, addcourse("301","음악의세계","22",3,"EL","2F 4E"));
        db.insert("allcourse", null, addcourse("21","물리학1","11",3,"RL","2A 5A"));
        db.insert("allcourse", null, addcourse("29","생명과학실험","12",1,"RL","2C 2D"));
        db.insert("allcourse", null, addcourse("52","디지털회로","21",3,"RM","1B 4B"));
        db.insert("allcourse", null, addcourse("56","자료구조","12",3,"RM","2A 4A"));
        db.insert("allcourse", null, addcourse("59","알고리즘","32",3,"RM","1D 4D"));
        db.insert("allcourse", null, addcourse("62","종합설계프로젝트","42",4,"RM","2C 2G"));
        db.insert("allcourse", null, addcourse("216","일본어1","21",3,"EL","2C 5C"));
        db.insert("allcourse", null, addcourse("215","중국사회와문화","12",3,"EL","2F 4E"));
        db.insert("allcourse", null, addcourse("336","과학과종교","21",3,"RL","2B 4B"));
        db.insert("allcourse", null, addcourse("348","수학이란무엇인가","42",3,"EL","2B 4A"));
        db.insert("allcourse", null, addcourse("314","스토리텔링이란무엇인가","22",3,"EL","2C 5C"));
        db.insert("allcourse", null, addcourse("228","수영","22",3,"EL","2E 2F"));
        db.insert("allcourse", null, addcourse("227","태권도","31",3,"EL","2E 2F"));
        db.insert("allcourse", null, addcourse("9","영어2","11",3,"EL","1A 3A"));
        db.insert("allcourse", null, addcourse("83","데이터마이닝","42",3,"EM","3F 5F"));
        db.insert("allcourse", null, addcourse("97","네트워크소프트웨어실습","31",1,"RM","5E 5F"));
        db.insert("allcourse", null, addcourse("98","무선네트워크","32",3,"RM","1C 4C"));
        db.insert("allcourse", null, addcourse("79","컴파일러","31",3,"RM","2A 5A"));
        db.insert("allcourse", null, addcourse("249","세계의가곡","22",3,"EL","2B 2C"));
        db.insert("allcourse", null, addcourse("319","현대인의성과사랑","21",3,"EL","1E 3E"));
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