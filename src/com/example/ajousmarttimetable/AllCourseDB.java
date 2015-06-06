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
                + "res TEXT NOT NULL, " // 추천학기
                + "professorName TEXT NOT NULL, "
                + "classroom TEXT NOT NULL, "
                + "credit TEXT NOT NULL, "
                + "category TEXT NOT NULL, "
                + "time TEXT NOT NULL )");
        
       
        //전필 RM, 전선 EM, 교선 EL, 교필 RL        
        db.insert("AllCourses", null, addcourse("50","컴퓨터프로그래밍","12","류기열","팔309","3","RM","2A 5A"));
        db.insert("AllCourses", null, addcourse("57","운영체제","22","김재훈","팔110","3","RM","1A 3A"));
        db.insert("AllCourses", null, addcourse("14","수학1","12","김성재","성204","3","RL","2A 5A"));
        db.insert("AllCourses", null, addcourse("15","수학2","21","김수진","성203","3","RL","2D 5D"));
        db.insert("AllCourses", null, addcourse("70","데이터베이스","31","변광준","팔110","4","RM","2B 4A"));
        db.insert("AllCourses", null, addcourse("72","컴퓨터공학개론","11","류기열","팔1025","3","RM","1B 4B"));
        db.insert("AllCourses", null, addcourse("73","네트워크운용사례","32","조영종","팔328","3","EM","2A 2B"));
        db.insert("AllCourses", null, addcourse("74","모바일서비스플랫폼","41","정태선","팔309","3","EM","2B 4A"));
        db.insert("AllCourses", null, addcourse("78","정보보호","31","손태식","팔309","3","RM","1E 3E"));
        db.insert("AllCourses", null, addcourse("103","정컴개발연구","41","손태식","","3","EM","2C 5C"));
        db.insert("AllCourses", null, addcourse("270","창의적글쓰기","22","김기훈","다503","3","RL","2C 5C"));
        db.insert("AllCourses", null, addcourse("274","섹슈얼리티와한국사회","22","장범준","다504","3","RL","3D 3E"));
        db.insert("AllCourses", null, addcourse("301","음악의세계","22","아리아 정","다503","3","EL","2F 4E"));
        db.insert("AllCourses", null, addcourse("21","물리학1","11","정역학","성205","3","RL","2A 5A"));
        db.insert("AllCourses", null, addcourse("29","생명과학실험","12","김민수","실104","1","RL","2C 2D"));
        db.insert("AllCourses", null, addcourse("52","디지털회로","21","김성수","팔309","3","RM","1B 4B"));
        db.insert("AllCourses", null, addcourse("56","자료구조","12","강경란","팔410","3","RM","2A 4A"));
        db.insert("AllCourses", null, addcourse("59","알고리즘","32","손경아","팔110","3","RM","1D 4D"));
        db.insert("AllCourses", null, addcourse("228","수영","22","강사","수원스포츠센터","3","EL","2E 2F"));
        db.insert("AllCourses", null, addcourse("227","태권도","31","김기민","체육관","3","EL","2E 2F"));
        db.insert("AllCourses", null, addcourse("9","영어2","11","Theresia","율405","3","EL","1A 3A"));
        db.insert("AllCourses", null, addcourse("83","데이터마이닝","42","정태선","팔328","3","EM","3F 5F"));
        db.insert("AllCourses", null, addcourse("97","네트워크소프트웨어실습","31","정태선","팔325","1","RM","5E 5F"));
        db.insert("AllCourses", null, addcourse("98","무선네트워크","32","조영종","팔328","3","RM","1C 4C"));
        db.insert("AllCourses", null, addcourse("79","컴파일러","31","김재훈","팔1025","3","RM","2A 5A"));
        db.insert("AllCourses", null, addcourse("249","세계의가곡","22","아리아 정","성305","3","EL","2B 2C"));
        db.insert("AllCourses", null, addcourse("319","현대인의성과사랑","21","이예지","다507","3","EL","1E 3E"));
        db.insert("AllCourses", null, addcourse("216","일본어1","21","이수민","다507","3","EL","2C 5C"));
        db.insert("AllCourses", null, addcourse("215","중국사회와문화","12","홍원선","다505","3","EL","2F 4E"));
        db.insert("AllCourses", null, addcourse("336","과학과종교","21","이기훈","다B102","3","RL","2B 4B"));
        db.insert("AllCourses", null, addcourse("348","수학이란무엇인가","42","정재원","성205","3","EL","2B 4A"));
        db.insert("AllCourses", null, addcourse("314","스토리텔링이란무엇인가","22","민효린","다502","3","EL","2C 5C"));
        db.insert("AllCourses", null, addcourse("62","종합설계프로젝트","42","김재훈","종104","4","RM","2C 2G"));        
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