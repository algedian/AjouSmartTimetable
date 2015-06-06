package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kim on 2015-06-03.
 */
public class TimetableDB extends SQLiteOpenHelper { // user's tt

    public TimetableDB(Context context) {
        super(context, "timetable.db", null, 1);
        Log.d("SQLite ttdb", "Constructor-ing");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite ttdb", "onCreate-ing");
        db.execSQL("CREATE TABLE timetable "
                + "(userId TEXT PRIMARY KEY NOT NULL,"
                + "timetableName TEXT NOT NULL,"
                + "courses TEXT, "
                + "defaultFlag INT NOT NULL)"); //1 - default
        
        db.execSQL("INSERT INTO timetable VALUES('201500002',"
        		+ "'2015-1-1','072021009270056050','1')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists timetable");
    }
}
