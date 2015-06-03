package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDB extends SQLiteOpenHelper {


    public UserDB(ServerDBAdapter ServerDBAdapter, Object o, Context context, int i) {
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
