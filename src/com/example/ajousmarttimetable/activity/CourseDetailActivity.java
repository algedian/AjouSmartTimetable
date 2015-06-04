package com.example.ajousmarttimetable.activity;

import java.util.ArrayList;

import com.example.ajousmarttimetable.ASTHandler;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.R.layout;
import com.example.ajousmarttimetable.ServerDBAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CourseDetailActivity extends Activity {
	
	ASTHandler handler;
	ServerDBAdapter serverDBadapter;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_detail);
		handler = ASTHandler.getInstance();
		serverDBadapter = new ServerDBAdapter(getApplicationContext());
		
		/*
		//코스 각 과목 가져오기
		TextView txtCourseName = (TextView) findViewById(R.id.txtCourseName);
		txtCourseName.setText(courseName);
		TextView txtProfName = (TextView) findViewById(R.id.txtProfName);
		txtProfName.setText(profName);
		TextView txtCourseTime = (TextView) findViewById(R.id.txtCourseTime);
		txtCourseTime.setText(courseTime);
		TextView txtClassroom = (TextView) findViewById(R.id.txtClassroom);	
		txtClassroom.setText(classroom);
		*/
					
	}
	/*
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
                v = vi.inflate(R.layout.row2, null);
            }
            
            Course c = list.get(position);
            if (c != null) {
                TextView cName = (TextView) v.findViewById(R.id.courseName);
                TextView cProf = (TextView) v.findViewById(R.id.professorName);
                TextView cTime = (TextView) v.findViewById(R.id.courseTime);
                if(cName != null){
                    cName.setText(c.getName());                            
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
	*/
}
