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
        db.insert("AllCourses", null, addcourse("050","컴퓨터프로그래밍","12","류기열","팔309","3","RM","tueA friA"));
        db.insert("AllCourses", null, addcourse("057","운영체제","22","김재훈","팔110","3","RM","monA wedA"));
        db.insert("AllCourses", null, addcourse("014","수학1","12","김성재","성204","3","RL","tueA friA"));
        db.insert("AllCourses", null, addcourse("015","수학2","21","김수진","성203","3","RL","tueD friD"));
        db.insert("AllCourses", null, addcourse("070","데이터베이스","31","변광준","팔110","4","RM","tueB thuA"));
        db.insert("AllCourses", null, addcourse("072","컴퓨터공학개론","11","류기열","팔1025","3","RM","monB thuB"));
        db.insert("AllCourses", null, addcourse("073","네트워크운용사례","32","조영종","팔328","3","EM","tueA tueB"));
        db.insert("AllCourses", null, addcourse("074","모바일서비스플랫폼","41","정태선","팔309","3","EM","tueB thuA"));
        db.insert("AllCourses", null, addcourse("078","정보보호","31","손태식","팔309","3","RM","monE wedE"));
        db.insert("AllCourses", null, addcourse("103","정컴개발연구","41","손태식","","3","EM","tueC friC"));
        db.insert("AllCourses", null, addcourse("270","창의적글쓰기","22","김기훈","다503","3","RL","tueC friC"));
        db.insert("AllCourses", null, addcourse("274","섹슈얼리티와한국사회","22","장범준","다504","3","RL","wedD wedE"));
        db.insert("AllCourses", null, addcourse("301","음악의세계","22","아리아 정","다503","3","EL","tueF thuE"));
        db.insert("AllCourses", null, addcourse("021","물리학1","11","정역학","성205","3","RL","tueA friA"));
        db.insert("AllCourses", null, addcourse("029","생명과학실험","12","김민수","실104","1","RL","tueC tueD"));
        db.insert("AllCourses", null, addcourse("052","디지털회로","21","김성수","팔309","3","RM","monB thuB"));
        db.insert("AllCourses", null, addcourse("056","자료구조","12","강경란","팔410","3","RM","tueA thuA"));
        db.insert("AllCourses", null, addcourse("059","알고리즘","32","손경아","팔110","3","RM","monD thuD"));
        db.insert("AllCourses", null, addcourse("228","수영","22","강사","수원스포츠센터","3","EL","tueE tueF"));
        db.insert("AllCourses", null, addcourse("227","태권도","31","김기민","체육관","3","EL","tueE tueF"));
        db.insert("AllCourses", null, addcourse("009","영어2","11","Theresia","율405","3","EL","monA wedA"));
        db.insert("AllCourses", null, addcourse("083","데이터마이닝","42","정태선","팔328","3","EM","wedF friF"));
        db.insert("AllCourses", null, addcourse("097","네트워크소프트웨어실습","31","정태선","팔325","1","RM","friE friF"));
        db.insert("AllCourses", null, addcourse("098","무선네트워크","32","조영종","팔328","3","RM","monC thuC"));
        db.insert("AllCourses", null, addcourse("079","컴파일러","31","김재훈","팔1025","3","RM","tueA friA"));
        db.insert("AllCourses", null, addcourse("249","세계의가곡","22","아리아 정","성305","3","EL","tueB tueC"));
        db.insert("AllCourses", null, addcourse("319","현대인의성과사랑","21","이예지","다507","3","EL","monE wedE"));
        db.insert("AllCourses", null, addcourse("216","일본어1","21","이수민","다507","3","EL","tueC friC"));
        db.insert("AllCourses", null, addcourse("215","중국사회와문화","12","홍원선","다505","3","EL","tueF thuE"));
        db.insert("AllCourses", null, addcourse("336","과학과종교","21","이기훈","다B102","3","RL","tueB thuB"));
        db.insert("AllCourses", null, addcourse("348","수학이란무엇인가","42","정재원","성205","3","EL","tueB thuA"));
        db.insert("AllCourses", null, addcourse("314","스토리텔링이란무엇인가","22","민효린","다502","3","EL","tueC friC"));
        db.insert("AllCourses", null, addcourse("062","종합설계프로젝트","42","김재훈","종104","4","RM","tueC tueF"));        
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
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