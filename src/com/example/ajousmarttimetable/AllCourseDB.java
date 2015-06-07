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
        db.insert("AllCourses", null, addcourse("050","��ǻ�����α׷���","12","���⿭","��309","3","RM","tueA friA"));
        db.insert("AllCourses", null, addcourse("057","�ü��","22","������","��110","3","RM","monA wedA"));
        db.insert("AllCourses", null, addcourse("014","����1","12","�輺��","��204","3","RL","tueA friA"));
        db.insert("AllCourses", null, addcourse("015","����2","21","�����","��203","3","RL","tueD friD"));
        db.insert("AllCourses", null, addcourse("070","�����ͺ��̽�","31","������","��110","4","RM","tueB thuA"));
        db.insert("AllCourses", null, addcourse("072","��ǻ�Ͱ��а���","11","���⿭","��1025","3","RM","monB thuB"));
        db.insert("AllCourses", null, addcourse("073","��Ʈ��ũ�����","32","������","��328","3","EM","tueA tueB"));
        db.insert("AllCourses", null, addcourse("074","����ϼ����÷���","41","���¼�","��309","3","EM","tueB thuA"));
        db.insert("AllCourses", null, addcourse("078","������ȣ","31","���½�","��309","3","RM","monE wedE"));
        db.insert("AllCourses", null, addcourse("103","���İ��߿���","41","���½�","","3","EM","tueC friC"));
        db.insert("AllCourses", null, addcourse("270","â�����۾���","22","�����","��503","3","RL","tueC friC"));
        db.insert("AllCourses", null, addcourse("274","������Ƽ���ѱ���ȸ","22","�����","��504","3","RL","wedD wedE"));
        db.insert("AllCourses", null, addcourse("301","�����Ǽ���","22","�Ƹ��� ��","��503","3","EL","tueF thuE"));
        db.insert("AllCourses", null, addcourse("021","������1","11","������","��205","3","RL","tueA friA"));
        db.insert("AllCourses", null, addcourse("029","������н���","12","��μ�","��104","1","RL","tueC tueD"));
        db.insert("AllCourses", null, addcourse("052","������ȸ��","21","�輺��","��309","3","RM","monB thuB"));
        db.insert("AllCourses", null, addcourse("056","�ڷᱸ��","12","�����","��410","3","RM","tueA thuA"));
        db.insert("AllCourses", null, addcourse("059","�˰���","32","�հ��","��110","3","RM","monD thuD"));
        db.insert("AllCourses", null, addcourse("228","����","22","����","��������������","3","EL","tueE tueF"));
        db.insert("AllCourses", null, addcourse("227","�±ǵ�","31","����","ü����","3","EL","tueE tueF"));
        db.insert("AllCourses", null, addcourse("009","����2","11","Theresia","��405","3","EL","monA wedA"));
        db.insert("AllCourses", null, addcourse("083","�����͸��̴�","42","���¼�","��328","3","EM","wedF friF"));
        db.insert("AllCourses", null, addcourse("097","��Ʈ��ũ����Ʈ����ǽ�","31","���¼�","��325","1","RM","friE friF"));
        db.insert("AllCourses", null, addcourse("098","������Ʈ��ũ","32","������","��328","3","RM","monC thuC"));
        db.insert("AllCourses", null, addcourse("079","�����Ϸ�","31","������","��1025","3","RM","tueA friA"));
        db.insert("AllCourses", null, addcourse("249","�����ǰ���","22","�Ƹ��� ��","��305","3","EL","tueB tueC"));
        db.insert("AllCourses", null, addcourse("319","�������Ǽ������","21","�̿���","��507","3","EL","monE wedE"));
        db.insert("AllCourses", null, addcourse("216","�Ϻ���1","21","�̼���","��507","3","EL","tueC friC"));
        db.insert("AllCourses", null, addcourse("215","�߱���ȸ�͹�ȭ","12","ȫ����","��505","3","EL","tueF thuE"));
        db.insert("AllCourses", null, addcourse("336","���а�����","21","�̱���","��B102","3","RL","tueB thuB"));
        db.insert("AllCourses", null, addcourse("348","�����̶������ΰ�","42","�����","��205","3","EL","tueB thuA"));
        db.insert("AllCourses", null, addcourse("314","���丮�ڸ��̶������ΰ�","22","��ȿ��","��502","3","EL","tueC friC"));
        db.insert("AllCourses", null, addcourse("062","���ռ���������Ʈ","42","������","��104","4","RM","tueC tueF"));        
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