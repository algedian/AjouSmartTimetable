package com.example.ajousmarttimetable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends Activity implements View.OnClickListener{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		
		EditText edtId = (EditText)findViewById(R.id.editLoginId);
		EditText edtPw = (EditText)findViewById(R.id.editLoginPw);
		Button btnLogin = (Button)findViewById(R.id.btnLogin);
		Button btnSignUp = (Button)findViewById(R.id.btnSignUp);
		
		btnLogin.setOnClickListener(this);
		btnSignUp.setOnClickListener(this);
		
	}
	
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLogin:
			//textFruit.setText("Apple");
			break;
		case R.id.btnSignUp:
			//textFruit.setText("Orange");
			break;
		}
	}
}
