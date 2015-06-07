package com.example.ajousmarttimetable.activity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
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
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajousmarttimetable.Course;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.TimetableDBAdapter;

public class ShowttActivity extends Activity {
	TimetableDBAdapter ttDBadapter;
	
	private String[] courseName = {
		"a", "b", "c", "d", "e",
		"a", "b", "c", "d", "e",
		"a", "b", "c", "d", "e",
		"a", "b", "c", "d", "e",
		"a", "b", "c", "d", "e",
		"a", "b", "c", "d", "e"
	};
	
	private GridLayout container;
	private List<ResolveInfo> apps;
	private PackageManager pm;
	Activity act = this;
	GridView gridview;
	ArrayList<Course> courseList;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_timetable);
		
		ttDBadapter = new TimetableDBAdapter(getApplicationContext());
		
		Intent intent = getIntent();
		courseList = (ArrayList<Course>)intent.getExtras().get("courseList");
		
		Log.i("showtt","courselist : " + courseList.get(0).getCourseName());
		
		String btnSaveVisible = intent.getExtras().getString("btnSaveVisible");
		
		pm = getPackageManager();
		apps = pm.queryIntentActivities(intent, 0);
		
		gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new GridAdapter(this));
		gridview.setOnItemClickListener(gridviewOnItemClickListener);
		container = (GridLayout)findViewById(R.id.glTimetable);
		if(btnSaveVisible == null || btnSaveVisible.equals("")){
			//nothing 
		}
		else if(btnSaveVisible.equals("true")){ 
			Button btnSave = (Button)findViewById(R.id.btnSave);
			btnSave.setVisibility(View.VISIBLE);
			btnSave.setOnClickListener(btnSaveOnClickListener);
		}
		
	}
	
	public void onBackPressed() {
		finish();
        Intent intent = new Intent("AST.MAINACTIVITY");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
	
	private GridView.OnItemClickListener gridviewOnItemClickListener 
	    = new GridView.OnItemClickListener() {
	     
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	    	Intent intent = new Intent(ShowttActivity.this, CourseDetailActivity.class);
	    	Course c = ttDBadapter.getCoursesByCourseName(courseName[arg2]);
	    	intent.putExtra("courseName", c.getCourseName());
	    	intent.putExtra("profName", c.getProfessorName());
	    	intent.putExtra("courseTime", c.getTime());
	    	intent.putExtra("classroom", c.getClassroom());
	    	startActivity(intent);
	    }
	};
	
	private View.OnClickListener btnSaveOnClickListener
		= new View.OnClickListener() {	
		@Override
		public void onClick(View v) {
			v.setVisibility(View.INVISIBLE);
			container.buildDrawingCache();
		    Bitmap captureView = container.getDrawingCache();
		    FileOutputStream fos;
		    
		    try {
		    	String filename = "/../../sdcard0/Pictures" + "capture" + new Date();
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
 
        public GridAdapter(Context c) {
            inflater = (LayoutInflater) act
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);        	
        }
 
        public int getCount() {
            return apps.size();
        }
 
        public Object getItem(int position) {
            return apps.get(position);
        }
 
        public long getItemId(int position) {
            return position;
        }
 
        public View getView(int position, View convertView, ViewGroup parent) {
                        
            if (convertView == null) {
	        	convertView = inflater.inflate(R.layout.gridview_layout, parent,
	        			false);
            }     
            final ResolveInfo info = apps.get(position);
            
            TextView textView = (TextView)convertView.findViewById(R.id.txtImage);
            textView.setText(courseName[position]);
                       
            return convertView;
        }
    }
}
