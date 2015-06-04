package com.example.ajousmarttimetable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by kim on 2015-06-04.
 */
public class AIM2DB extends SQLiteOpenHelper {
    public AIM2DB(Context context) {
        super(context, "userInfo.db", null, 1);
        Log.d("SQLite", "Constructor-ing");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        ContentValues values = new ContentValues();
        Log.d("SQLite", "onCreate-ing");
        db.execSQL("CREATE TABLE userInfo "
                + "(userId TEXT PRIMARY KEY NOT NULL,"
                + "major TEXT NOT NULL,"
                + "semester TEXT NOT NULL"
                + "takenCourseCode TEXT )");

        db.insert("userInfo", null, addUser("201020235", "computerscience", ""));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists userInfo");

    }
    public ContentValues addUser (String userId, String major, String takenCourseCode){
        ContentValues values = new ContentValues();
        values.put("userID", userId);
        values.put("major", major);
        values.put("takenCourseCode", takenCourseCode);

        return values;
    }
}
