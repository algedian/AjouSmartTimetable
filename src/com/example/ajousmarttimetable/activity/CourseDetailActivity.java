package com.example.ajousmarttimetable.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.ajousmarttimetable.Course;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.ServerDBAdapter;

public class CourseDetailActivity extends Activity {
	
	ServerDBAdapter serverDBadapter;
	
	private CourseAdapter mAdapter = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_detail);
		serverDBadapter = new ServerDBAdapter(getApplicationContext());
		Course c = new Course();
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		Intent intent = getIntent();
		
		TextView txtCourseName = (TextView) findViewById(R.id.txtCourseName);
		txtCourseName.setText(intent.getExtras().getString("courseName"));
		if(LogInActivity.userId.equals("201500001")){
			courseList = LogInActivity.Atimetable;
			for(int i=0 ; i<LogInActivity.Atimetable.size() ; i++){
				if(LogInActivity.Atimetable.get(i).getCourseName().equals(txtCourseName)){
					c = LogInActivity.Atimetable.get(i);
				}
			}
		}
		else if(LogInActivity.userId.equals("201500002")){
			courseList = LogInActivity.Btimetable;
			for(int i=0 ; i<LogInActivity.Btimetable.size() ; i++){
				if(LogInActivity.Btimetable.get(i).getCourseName().equals(txtCourseName)){
					c = LogInActivity.Btimetable.get(i);
				}
			}
		}
		mAdapter = new CourseAdapter(this, R.layout.course_detail_row , c);
		TextView txtProfName = (TextView) findViewById(R.id.txtProfName);
		txtProfName.setText(c.getProfessorName());
		TextView txtCourseTime = (TextView) findViewById(R.id.txtCourseTime);
		txtCourseTime.setText(c.getTime());
		TextView txtClassroom = (TextView) findViewById(R.id.txtClassroom);	
		txtClassroom.setText(c.getClassroom());			
	}
	
	private class CourseAdapter extends ArrayAdapter<Course> {
		 
		Course c;
        //private ArrayList<Course> list;
 
        public CourseAdapter(Context context, int textViewResourceId, Course c) {
            super(context, textViewResourceId);
            this.c = c;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.course_detail_row, null);
            }
            
            //Course c = list.get(position);
            if (c != null) {
                TextView cName = (TextView) v.findViewById(R.id.courseName);
                TextView cProf = (TextView) v.findViewById(R.id.professorName);
                TextView cTime = (TextView) v.findViewById(R.id.courseTime);
                TextView room = (TextView) v.findViewById(R.id.classroom);
                if(cName != null){
                    cName.setText(c.getCourseName());                            
                }
                if(cProf != null){
                    cProf.setText(c.getProfessorName());
                }
                if(cTime != null){
                    cTime.setText(c.getTime());                            
                }
                if(room != null){
                    room.setText(c.getClassroom());                            
                }
            }
            return v;
        }
	}
	
}
