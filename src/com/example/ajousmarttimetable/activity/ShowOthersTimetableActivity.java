package com.example.ajousmarttimetable.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ajousmarttimetable.R;

public class ShowOthersTimetableActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_others_timetable);
		
		TextView textview = (TextView)findViewById(R.id.textview3);
		EditText EditText1 = (EditText)findViewById(R.id.edittext1);
		Button btnIsOpen =(Button)findViewById(R.id.btnIsOpen);
		btnIsOpen.setOnClickListener(mClickListener);		
	}
	
	Button.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			//db���� �ش� ���̵� open���� Ȯ��
			Log.i("click","in show others");
			Intent intent = new Intent(ShowOthersTimetableActivity.this, ShowTimetableActivity.class);
			intent.putExtra("btnSaveVisible", "true");
			startActivity(intent);
			//intent.putExtra("studentID", "201500000");
		}
	};
}
