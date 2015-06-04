package com.example.ajousmarttimetable.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.ServerDBAdapter;
import com.example.ajousmarttimetable.UserDB;

public class LogInActivity extends Activity implements View.OnClickListener{
	
	UserDB userDBhelper;
	ServerDBAdapter userDBadapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		
		userDBadapter = new ServerDBAdapter(getApplicationContext(), "UserDB");
		
		EditText edtId = (EditText)findViewById(R.id.editLoginId);
		EditText edtPw = (EditText)findViewById(R.id.editLoginPw);
		Button btnLogin = (Button)findViewById(R.id.btnLogin);
		Button btnSignUp = (Button)findViewById(R.id.btnSignUp);
		
		btnLogin.setOnClickListener(this);
		btnSignUp.setOnClickListener(this);
		
		//userDBhelper = new UserDB(getApplicationContext());
		
		
	}
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin:{
			Intent i = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(i);
		}			
			break;
		case R.id.btnSignUp:{
			Toast.makeText(getApplicationContext(), "Sign up", Toast.LENGTH_SHORT).show();
		}
			break;
		}
	}
}
