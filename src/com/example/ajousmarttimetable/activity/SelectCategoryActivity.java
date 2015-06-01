package com.example.ajousmarttimetable.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ajousmarttimetable.R;

public class SelectCategoryActivity extends Activity implements View.OnClickListener{
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_category);
		
		TextView textview = (TextView)findViewById(R.id.textview2);
		Button btnRM = (Button)findViewById(R.id.btnRequiredMajor);
		Button btnEM = (Button)findViewById(R.id.btnElectiveMajor);
		Button btnRL = (Button)findViewById(R.id.btnRequiredLiberal);
		Button btnEL = (Button)findViewById(R.id.btnElectiveLiberal);
		Button btnSave = (Button)findViewById(R.id.btnSaveTimetable);
		ListView listview2 = (ListView)findViewById(R.id.listviewCategory);
		
		
		btnRM.setOnClickListener(this);
		btnEM.setOnClickListener(this);
		btnRL.setOnClickListener(this);
		btnEL.setOnClickListener(this);
		btnSave.setOnClickListener(this);
	
	}
	public void onClick(View v) {
		switch (v.getId()) { //parkingLotList 참고
			case R.id.btnRequiredMajor:{
				//listview 수정
			}			
				break;
			case R.id.btnElectiveMajor:{
				//listview 수정
			}			
				break;
			case R.id.btnRequiredLiberal:{
				//listview 수정
			}			
				break;
			case R.id.btnElectiveLiberal:{
				//listview 수정
			}			
				break;
			case R.id.btnSaveTimetable:{
				//show timetable activity 로
			}			
				break;
		}
	}
}
