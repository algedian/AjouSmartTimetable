package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kim on 2015-06-03.
 */
public class CourseDB extends SQLiteOpenHelper {

    public CourseDB(TimetableDBAdapter timetableDBAdapter, Object o, Context context, int i) {
        super(context, "course.db", null, 1);
        Log.d("SQLite", "Constructor-ing");
    }
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite", "onCreate-ing");
        db.execSQL("CREATE TABLE courses "
                + "(Coursecode TEXT PRIMARY KEY NOT NULL,"
                + "CourseName TEXT NOT NULL,"
                + "professorName TEXT NOT NULL,"
                + "classRoom TEXT NOT NULL,"
                + "Time CHAR[10] NOT NULL"
                + "Task TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Cousrscode");
    }
}
