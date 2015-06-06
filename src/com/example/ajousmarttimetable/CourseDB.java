package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kim on 2015-06-03.
 */
public class CourseDB extends SQLiteOpenHelper {

    public CourseDB(Context context) {
        super(context, "course.db", null, 1);
        Log.d("SQLite course", "Constructor-ing");
    }
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite course", "onCreate-ing");
        db.execSQL("CREATE TABLE course "
                + "(courseCode TEXT PRIMARY KEY NOT NULL,"
                + "courseName TEXT NOT NULL,"
                + "professorName TEXT NOT NULL,"
                + "classroom TEXT NOT NULL,"
                + "time CHAR[10] NOT NULL"
                + "task TEXT)");
        
        db.execSQL("INSERT INTO course VALUES("
        		+ "'073', '네트워크운용사례', '조영종', '팔328', '2A 2B', '')");
        
        db.execSQL("INSERT INTO course VALUES("
        		+ "'029', '생명과학실험', '김민수', '실104', '2C 2D', '')");
        
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists course");
    }
}
