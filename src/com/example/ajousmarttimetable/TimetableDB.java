package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kim on 2015-06-03.
 */
public class TimetableDB extends SQLiteOpenHelper {


    public TimetableDB(ServerDBAdapter ServerDBAdapter, Object o, Context context, int i) {
        super(context, "Timetable.db", null, 1);
        Log.d("SQLite", "Constructor-ing");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite", "onCreate-ing");
        db.execSQL("CREATE TABLE Timetable "
                + "(UserID TEXT PRIMARY KEY NOT NULL,"
                + "TimetableName TEXT NOT NULL,"
                + "Courses TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists UserID");
    }
}
