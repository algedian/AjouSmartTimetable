package com.example.ajousmarttimetable;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TimetableDBAdapter extends SQLiteOpenHelper{

	public TimetableDBAdapter(Context context) {
		super(context, "index.db", null, 1);
		Log.d("SQLite", "Constructor-ing");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		Log.d("SQLite", "onCreate-ing");
		db.execSQL("CREATE TABLE dic (content TEXT PRIMARY KEY, );");
		db.execSQL("INSERT INTO dic (content) VALUES ('잠시 후 전화 드리겠습니다.')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		Log.d("SQLite", "onUpgrade-ing");
		db.execSQL("DROP TABLE IF EXISTS dic");
		onCreate(db);
	}
	
}
