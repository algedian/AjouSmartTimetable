package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDB extends SQLiteOpenHelper {


    public UserDB(Context context) {
        super(context, "user.db", null, 1);
        Log.d("SQLite userdb", "Constructor-ing");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("SQLite userdb", "onCreate-ing");
        db.execSQL("CREATE TABLE user (id TEXT PRIMARY KEY NOT NULL, "
                + "password TEXT NOT NULL, "
                + "isOpen TEXT NOT NULL)"); //yes or no
        db.execSQL("INSERT INTO user VALUES('201500001', '201500001', 'yes')");
        db.execSQL("INSERT INTO user VALUES('201500002', '201500002', 'yes')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);
    }
}
