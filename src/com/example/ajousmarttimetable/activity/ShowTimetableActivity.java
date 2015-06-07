package com.example.ajousmarttimetable.activity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajousmarttimetable.Course;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.TimetableDBAdapter;

public class ShowTimetableActivity extends Activity {
	TimetableDBAdapter ttDBadapter;	
	private String[] courseCode = {
		"", "", "", "", "",
		"", "", "", "", "",
		"", "", "", "", "",
		"", "", "", "", "",
		"", "", "", "", "",
		"", "", "", "", ""
	};
	private GridLayout container;	
	ArrayList<Course> courseList;
	ArrayList<String> codeList;
	String detailView = "false";
	//
	GridView gridview;
	//
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_timetable);
		
		ttDBadapter = new TimetableDBAdapter(getApplicationContext());
		
		Intent intent = getIntent();
		courseList = new ArrayList<Course>();
		codeList = new ArrayList<String>();
		courseList = (ArrayList<Course>)intent.getExtras().get("courseList");
		codeList = (ArrayList<String>)intent.getExtras().get("codeList");
		for(int i=0 ; i<30 ; i++){
			courseCode[i] = codeList.get(i);
		}
	
		
		String btnSaveVisible = intent.getExtras().getString("btnSaveVisible");
		
		gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new GridAdapter(getApplicationContext(),R.layout.show_tt_row));
		
		container = (GridLayout)findViewById(R.id.glTimetable);
		if(btnSaveVisible == null || btnSaveVisible.equals("")){
			//nothing 
		}
		else if(btnSaveVisible.equals("true")){ 
			Button btnSave = (Button)findViewById(R.id.btnSave);
			btnSave.setVisibility(View.VISIBLE);
			btnSave.setOnClickListener(btnSaveOnClickListener);
		}	
		
		detailView = intent.getExtras().getString("detailView");
	}
	
	public void onBackPressed() {
		finish();
        Intent intent = new Intent("AST.MAINACTIVITY");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
		
	private View.OnClickListener btnSaveOnClickListener
		= new View.OnClickListener() {	
		@Override
		public void onClick(View v) {
			v.setVisibility(View.INVISIBLE);
			container.buildDrawingCache();
		    Bitmap captureView = container.getDrawingCache();
		    FileOutputStream fos;
		    
		    try {
		    	String filename = "/../../sdcard0/Pictures/" + "capture" + new Date();
		    	fos = new FileOutputStream(
		        		Environment.getExternalStorageDirectory().toString() 
		        		+ filename + ".jpeg");
		        captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		        Toast.makeText(getApplicationContext(), "Captured! " + Environment.getExternalStorageDirectory().toString() 
		        		+ filename + ".jpeg" , Toast.LENGTH_SHORT).show();
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		    v.setVisibility(View.VISIBLE);
		    
		}
	};
	
	public class GridAdapter extends BaseAdapter {
        private Context mContext;
        LayoutInflater inflater;
        private int mResource;
 
        public GridAdapter(Context c, int textResource) {
        	mContext = c;
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mResource = textResource;
        }
 
        public int getCount() {
            return courseCode.length;
        }
 
        public Object getItem(int position) {
            return courseCode[position];
        }
 
        public long getItemId(int position) {
            return position;
        }
 
        public View getView(int position, View convertView, ViewGroup parent) {
                        
            if (convertView == null) {
	        	convertView = inflater.inflate(R.layout.show_tt_row, parent,
	        			false);
            }     
            TextView textView = (TextView)convertView.findViewById(R.id.textview);
            if(courseCode[position].equals("_")){
            	textView.setText("_");
            	textView.setVisibility(View.INVISIBLE);
            }
            else{
            	for(int i=0 ; i<courseList.size() ; i++){
            		if(courseList.get(i).getCourseCode().equals(courseCode[position])){
            			textView.setText(courseList.get(i).getCourseName());
            		}
            	}
            	
            }
                       
            textView.setOnClickListener(new TextView.OnClickListener() {
            	@Override
    			public void onClick(View v) {
    				// TODO Auto-generated method stub
            		if(detailView.equals("true")){
	    				Intent intent = new Intent(ShowTimetableActivity.this, CourseDetailActivity.class);
	        	    	TextView tmp = (TextView) v;
	    				
	        	    	intent.putExtra("courseName",tmp.getText().toString());
	        	    	startActivity(intent);
            		}
    			}
            });            
            return convertView;
        }
    }
}
