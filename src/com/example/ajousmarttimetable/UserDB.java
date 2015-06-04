package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDB extends SQLiteOpenHelper {


    public UserDB(Context context) {
        super(context, "User.db", null, 1);
        Log.d("SQLite", "Constructor-ing");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite", "onCreate-ing");
        db.execSQL("CREATE TABLE User "
                + "(id TEXT PRIMARY KEY NOT NULL,"
                + "password TEXT NOT NULL)");
        db.execSQL("insert into User values('201500001', '201500001')");
        db.execSQL("insert into User values('201500002', '201500002')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
        onCreate(db);
    }
}
