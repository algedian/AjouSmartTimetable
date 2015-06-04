package com.example.ajousmarttimetable.activity;

import java.util.ArrayList;

import android.R.color;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajousmarttimetable.ASTHandler;
import com.example.ajousmarttimetable.Course;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.ServerDBAdapter;

public class MakeTimetableActivity extends Activity implements View.OnClickListener{
	
	ASTHandler handler;
	ServerDBAdapter serverDBadapter;
	TextView txtSelectCategory;
	Button btnRM;
	Button btnEM;
	Button btnRL;
	Button btnEL;
	Button btnSave;
	ListView listCategory;
	ArrayList<Course> classifiedCourseList;
	ArrayList<Course> selectedCourseList;
	TextView txtCurrentCredit;
	TextView txtLeft;
	
	private CourseAdapter mAdapter = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.make_timetable);
		
		handler = ASTHandler.getInstance();
		
		txtSelectCategory = (TextView)findViewById(R.id.txtSelectCategory);
		btnRM = (Button)findViewById(R.id.btnRequiredMajor);
		btnEM = (Button)findViewById(R.id.btnElectiveMajor);
		btnRL = (Button)findViewById(R.id.btnRequiredLiberal);
		btnEL = (Button)findViewById(R.id.btnElectiveLiberal);
		btnSave = (Button)findViewById(R.id.btnSaveTimetable);
		txtCurrentCredit = (TextView)findViewById(R.id.txtCurrentCredit);
		txtLeft = (TextView)findViewById(R.id.txtLeft);
		listCategory = (ListView)findViewById(R.id.categoryRM);		
		
		btnRM.setOnClickListener(this);
		btnEM.setOnClickListener(this);
		btnRL.setOnClickListener(this);
		btnEL.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		
		selectedCourseList = new ArrayList<Course>();
		
		//courseList에 코스 가져오기
		serverDBadapter = new ServerDBAdapter(getApplicationContext());
		classifiedCourseList = serverDBadapter.getAllCourses("RM");
        mAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList);       		
		listCategory.setAdapter(mAdapter);		
		listCategory.setOnItemClickListener(onClickListItem);  	
	}
	
	public void onBackPressed() {
		finish();
        Intent intent = new Intent("AST.MAINACTIVITY");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
	
	public void onClick(View v) {
		switch (v.getId()) { 
			case R.id.btnRequiredMajor:{
				//listview 수정
				listCategory.setVisibility(View.INVISIBLE);
				listCategory = (ListView)findViewById(R.id.categoryRM);
				listCategory.setVisibility(View.VISIBLE);
				
				//courseList에 코스 가져오기
				classifiedCourseList = serverDBadapter.getAllCourses("RM");
		        mAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList);       		
				listCategory.setAdapter(mAdapter);		
				listCategory.setOnItemClickListener(onClickListItem); 
			}			
				break;
			case R.id.btnElectiveMajor:{
				//listview 수정
				listCategory.setVisibility(View.INVISIBLE);
				listCategory = (ListView)findViewById(R.id.categoryEM);
				listCategory.setVisibility(View.VISIBLE);
				
				//courseList에 코스 가져오기
				classifiedCourseList = serverDBadapter.getAllCourses("EM");
		        mAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList);       		
				listCategory.setAdapter(mAdapter);		
				listCategory.setOnItemClickListener(onClickListItem); 
			}			
				break;
			case R.id.btnRequiredLiberal:{
				//listview 수정
				listCategory.setVisibility(View.INVISIBLE);
				listCategory = (ListView)findViewById(R.id.categoryRL);
				listCategory.setVisibility(View.VISIBLE);
				
				//courseList에 코스 가져오기
				classifiedCourseList = serverDBadapter.getAllCourses("RL");
		        mAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList);       		
				listCategory.setAdapter(mAdapter);		
				listCategory.setOnItemClickListener(onClickListItem); 
			}			
				break;
			case R.id.btnElectiveLiberal:{
				//listview 수정
				listCategory.setVisibility(View.INVISIBLE);
				listCategory = (ListView)findViewById(R.id.categoryEL);
				listCategory.setVisibility(View.VISIBLE);
				
				//courseList에 코스 가져오기
				classifiedCourseList = serverDBadapter.getAllCourses("EL");
		        mAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList);       		
				listCategory.setAdapter(mAdapter);		
				listCategory.setOnItemClickListener(onClickListItem); 
			}			
				break;
			case R.id.btnSaveTimetable:{
				//show timetable activity 로
			}			
				break;
		}
	}
	
	private class CourseAdapter extends ArrayAdapter<Course> {
		 
        private ArrayList<Course> list;
 
        public CourseAdapter(Context context, int textViewResourceId, ArrayList<Course> list) {
            super(context, textViewResourceId, list);
            this.list = list;
        }
                       
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.makett_row, null);
            }            
            Course course = list.get(position);
            if (course != null) {
                TextView cName = (TextView) v.findViewById(R.id.courseName);
                TextView profName = (TextView) v.findViewById(R.id.professorName);
                TextView room = (TextView) v.findViewById(R.id.classroom);
                TextView time = (TextView) v.findViewById(R.id.courseTime);
                TextView credit = (TextView) v.findViewById(R.id.credit);
                if(cName != null){
                    cName.setText(course.getCourseName());                            
                }
                if(profName != null){
                    profName.setText(course.getProfessorName());
                }
                if(room != null){
                    room.setText(course.getClassroom());                            
                }
                if(time != null){
                	time.setText(course.getTime());
                }
                if(credit != null){
                	credit.setText(course.getCredit());
                }
            }
            return v;
        }
	}
	
	// 아이템 터치 이벤트
    private OnItemClickListener onClickListItem = new OnItemClickListener() { 
        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
        	
        	//enable/disable toggle
        	int currentCredit = Integer.parseInt(txtCurrentCredit.getText().toString());        	
        	currentCredit += Integer.parseInt(mAdapter.getItem(arg2).getCredit());
        	txtCurrentCredit.setText(String.valueOf(currentCredit));
        	
        	Toast.makeText(getApplicationContext(), mAdapter.getItem(arg2).getCourseName() , Toast.LENGTH_SHORT).show();
        }
    };
}
