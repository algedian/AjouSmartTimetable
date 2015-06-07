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
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_detail);
		serverDBadapter = new ServerDBAdapter(getApplicationContext());
		
		Intent intent = getIntent();
		
		TextView txtCourseName = (TextView) findViewById(R.id.txtCourseName);
		txtCourseName.setText(intent.getExtras().getString("courseName"));
		TextView txtProfName = (TextView) findViewById(R.id.txtProfName);
		txtProfName.setText(intent.getExtras().getString("profName"));
		TextView txtCourseTime = (TextView) findViewById(R.id.txtCourseTime);
		txtCourseTime.setText(intent.getExtras().getString("courseTime"));
		TextView txtClassroom = (TextView) findViewById(R.id.txtClassroom);	
		txtClassroom.setText(intent.getExtras().getString("classroom"));			
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
                v = vi.inflate(R.layout.course_detail_row, null);
            }
            
            Course c = list.get(position);
            if (c != null) {
                TextView cName = (TextView) v.findViewById(R.id.courseName);
                TextView cProf = (TextView) v.findViewById(R.id.professorName);
                TextView cTime = (TextView) v.findViewById(R.id.courseTime);
                if(cName != null){
                    cName.setText(c.getCourseName());                            
                }
                if(cProf != null){
                    cProf.setText(c.getProfessorName());
                }
                if(cTime != null){
                    cTime.setText(c.getTime());                            
                }
            }
            return v;
        }
	}
	
}
