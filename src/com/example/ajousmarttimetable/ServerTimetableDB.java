package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kim on 2015-06-03.
 */
public class ServerTimetableDB extends SQLiteOpenHelper { // server's tt


    public ServerTimetableDB(Context context) {
        super(context, "serverTimetable.db", null, 1);
        Log.d("SQLite sv ttdb", "Constructor-ing");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite sv ttdb", "onCreate-ing");
        db.execSQL("CREATE TABLE serverTimetable "
                + "(userId TEXT PRIMARY KEY NOT NULL,"
                + "timetableName TEXT NOT NULL,"
                + "courses TEXT)"); 
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists serverTimetable");
    }
}
