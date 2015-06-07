package com.example.ajousmarttimetable.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ajousmarttimetable.Course;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.ServerDBAdapter;
import com.example.ajousmarttimetable.Timetable;

public class LogInActivity extends Activity implements View.OnClickListener{
	
	ServerDBAdapter serverDBadapter;
	EditText edtId;
	EditText edtPw; 
	Button btnLogin; 
	Button btnSignUp;
	public static String userId;
	String userPw;
	
	public static ArrayList<Course> Atimetable;
	public static ArrayList<Course> Btimetable;
	
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
		Atimetable = new ArrayList<Course>();
		Btimetable = new ArrayList<Course>();
		
		Course tmpc = new Course();
		tmpc.setCourseName("�ü��");
		tmpc.setCourseCode("057");
		tmpc.setProfessorName("������");
		tmpc.setTime("monA wedA");
		tmpc.setClassroom("��110");
		tmpc.setCredit("3");
		Btimetable.add(tmpc);
		
		Course tmpd = new Course();
		tmpc.setCourseName("������ȣ");
		tmpc.setCourseCode("078");
		tmpc.setProfessorName("���½�");
		tmpc.setTime("monE wedE");
		tmpc.setClassroom("��309");
		tmpc.setCredit("3");
		Btimetable.add(tmpd);

		Course tmpe = new Course();
		tmpc.setCourseName("����2");
		tmpc.setCourseCode("015");
		tmpc.setProfessorName("�����");
		tmpc.setTime("tueD friD");
		tmpc.setClassroom("��203");
		tmpc.setCredit("3");
		Btimetable.add(tmpe);
		
		Course tmpf = new Course();
		tmpc.setCourseName("�߱���ȸ�͹�ȭ");
		tmpc.setCourseCode("215");
		tmpc.setProfessorName("ȫ����");
		tmpc.setTime("tueF thuE");
		tmpc.setClassroom("��505");
		tmpc.setCredit("3");
		Btimetable.add(tmpf);
		
		Course tmpg = new Course();
		tmpc.setCourseName("�����ͺ��̽�");
		tmpc.setCourseCode("070");
		tmpc.setProfessorName("������");
		tmpc.setTime("tueB thuA");
		tmpc.setClassroom("��110");
		tmpc.setCredit("3");
		Btimetable.add(tmpg);
	}
	
	protected void onResume(Bundle savedInstanceState){
		//Log.i("check","0");
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
					
					ArrayList<String> codeList;
	    			ArrayList<Course> courseList;
	    		
	    			codeList = new ArrayList<String>();
	    			courseList = new ArrayList<Course>();
	    			
	    			Log.i("login","ok");
	    			//Log.i("login","tt : " + timetable.getCourses());
	    			if(userId.equals("201500001")){
	    				courseList = Atimetable;
	    			}
	    			else if(userId.equals("201500002")){
	    				courseList = Btimetable;
	    			}
	    			//courseList = timetable.courseList;//MainActivity.getCourseList(timetable, getApplicationContext());
	    			//Log.d("login", ""+courseList.size());
	    			codeList = MainActivity.getCodeList(courseList);
	    			
	        		intent.putExtra("btnSaveVisible", "false");
	        		intent.putExtra("detailView", "true");
	        		intent.putExtra("codeList", codeList);
	                intent.putExtra("courseList", courseList);
					intent.putExtra("userId", userId);
		            startActivity(intent);	
		            finish();
		        }//����� ������
				else{
					Intent intent = new Intent(LogInActivity.this, MakeTimetableActivity.class);
					intent.putExtra("userId", userId);
					intent.putExtra("timetable",timetable); //serializable�ϱ�
		            startActivity(intent);
		            finish();		            
				}//����� ������
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
