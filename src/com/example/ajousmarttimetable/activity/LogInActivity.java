package com.example.ajousmarttimetable.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.ServerDBAdapter;
import com.example.ajousmarttimetable.Timetable;

public class LogInActivity extends Activity implements View.OnClickListener{
	
	ServerDBAdapter serverDBadapter;
	EditText edtId;
	EditText edtPw; 
	Button btnLogin; 
	Button btnSignUp;
	String userId;
	String userPw;
	
	public static Activity logInActivity;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		
		logInActivity = LogInActivity.this;
		edtId = (EditText)findViewById(R.id.editLoginId);
		edtPw = (EditText)findViewById(R.id.editLoginPw);
		btnLogin = (Button)findViewById(R.id.btnLogin);
		btnSignUp = (Button)findViewById(R.id.btnSignUp);
		
		btnLogin.setOnClickListener(this);
		btnSignUp.setOnClickListener(this);
		
		serverDBadapter = new ServerDBAdapter(getApplicationContext());		
	}
	
	protected void onResume(Bundle savedInstanceState){
		Log.i("check","0");
		if(userId != null){
			Intent intent = new Intent(LogInActivity.this, MainActivity.class);
		}
	}
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin:{
			userId = edtId.getText().toString();
			userPw = edtPw.getText().toString();
			
			boolean loginOk = serverDBadapter.verifyLogin(userId, userPw);
			
			if(loginOk){
				Timetable timetable = serverDBadapter.getDefaultTimetable(userId);
				
				if(timetable != null){
					Intent intent = new Intent(LogInActivity.this, ShowTimetableActivity.class);
					intent.putExtra("userId", userId);
		            startActivity(intent);	
		            finish();
		        }//만든게 있을때
				else{
					Intent intent = new Intent(LogInActivity.this, MakeTimetableActivity.class);
					intent.putExtra("userId", userId);
					intent.putExtra("timetable",timetable); //serializable하기
		            startActivity(intent);
		            finish();		            
				}//만든게 없을때
			}
			else{
				Toast.makeText(getApplicationContext(), "login failed", Toast.LENGTH_SHORT).show();
			}			
		}			
			break;
		case R.id.btnSignUp:{
			Toast.makeText(getApplicationContext(), "Sign up", Toast.LENGTH_SHORT).show();		}
			break;
		}
	}
}
