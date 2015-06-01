package com.example.ajousmarttimetable;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MakeTimetableActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_category);
		
		TextView textview = (TextView)findViewById(R.id.textview2);
		Button btnRM = (Button)findViewById(R.id.btn_required_major);
		Button btnEM = (Button)findViewById(R.id.btn_elective_major);
		Button btnRL = (Button)findViewById(R.id.btn_required_liberal);
		Button btnEL = (Button)findViewById(R.id.btn_elective_liberal);
		
	}
}
