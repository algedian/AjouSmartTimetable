package com.example.ajousmarttimetable.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajousmarttimetable.Course;
import com.example.ajousmarttimetable.R;

public class ShowOthersTimetableActivity extends Activity{
	
	TextView textview; 
	EditText EditText1; 
	Button btnIsOpen; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_others_timetable);
		
		textview = (TextView)findViewById(R.id.textview3);
		EditText1 = (EditText)findViewById(R.id.edittext1);
		btnIsOpen =(Button)findViewById(R.id.btnIsOpen);
		btnIsOpen.setOnClickListener(mClickListener);		
	}
	
	Button.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			//db에서 해당 아이디 open인지 확인
			String other = EditText1.getText().toString();
			Log.i("click","in show others");
			if(other.equals("201500001") || other.equals("201500002")){
				ArrayList<Course> courseList = new ArrayList<Course>();
				
				Intent intent = new Intent(ShowOthersTimetableActivity.this, ShowTimetableActivity.class);
				intent.putExtra("btnSaveVisible", "true");
        		intent.putExtra("detailView", "true");
        		
        		if(other.equals("201500001")){
        			courseList = LogInActivity.Atimetable;
        		}
        		else if(other.equals("201500002")){
        			//courseList = LogInActivity.Btimetable;
        			courseList = LogInActivity.Atimetable;
        			
        		}
        		ArrayList<String> codeList = new ArrayList<String>();
        		for(int i=0 ; i<30 ; i++){
              	  codeList.add("_");
                }
        		codeList.set(0,"057");
            	codeList.set(2,"057");
            	codeList.set(3,"070");
            	codeList.set(6,"070");
            	codeList.set(16,"015");
            	codeList.set(19,"015");
            	codeList.set(20,"078");
            	codeList.set(22,"078");
            	codeList.set(23,"215");
            	codeList.set(26,"215");
				//codeList = MainActivity.getCodeList(courseList);
				intent.putExtra("courseList", courseList);
				intent.putExtra("codeList", codeList);
				intent.putExtra("studentID", other);
				startActivity(intent);
			}
			else{
				Toast.makeText(getApplicationContext(), "No such user", Toast.LENGTH_SHORT).show();
			}
		}
	};
}
