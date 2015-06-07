package com.example.ajousmarttimetable.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajousmarttimetable.Course;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.ServerDBAdapter;
import com.example.ajousmarttimetable.Timetable;

public class MainActivity extends Activity {

	private StringAdapter mAdapter = null;
	static ServerDBAdapter serverDBadapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		if(LogInActivity.logInActivity != null){
			LogInActivity.logInActivity.finish();
		}
				
		// ListView에 아이템 추가
		String a = new String("Show Timetable");
		String b = new String("Make Timetable");
		String c = new String("Modify Timetable");
		String d = new String("Delete Timetable");
		String e = new String("Show Others Timetable");
		String f = new String("Settings");
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(a);		
        list.add(b);
        list.add(c);		
        list.add(d);
        list.add(e);
        list.add(f);
        
        serverDBadapter = new ServerDBAdapter(getApplicationContext());
        mAdapter = new StringAdapter(this, R.layout.main_row , list);      
		
		ListView mListView = (ListView)findViewById(R.id.listMain);
		mListView.setAdapter(mAdapter);
		
		mListView.setOnItemClickListener(onClickListItem);    		
	}	
	
	private class StringAdapter extends ArrayAdapter<String> {
		 
        private ArrayList<String> list;
 
        public StringAdapter(Context context, int textViewResourceId, ArrayList<String> list) {
            super(context, textViewResourceId, list);
            this.list = list;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.main_row, null);
            }
            
            String str = list.get(position);
            if (str != null) {
                TextView tv = (TextView) v.findViewById(R.id.txtMain);
                if(tv != null){
                    tv.setText(str.toString());                            
                }
            }
            return v;
        }
	}
	
	// 아이템 터치 이벤트
    private OnItemClickListener onClickListItem = new OnItemClickListener() { 
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
           switch(arg2){
        	case 0:{
        		Timetable timetable = serverDBadapter.getDefaultTimetable(LogInActivity.userId);
        		if(timetable != null){
        			ArrayList<String> codeList;
        			ArrayList<Course> courseList;
        		
        			codeList = new ArrayList<String>();
        			//courseList = new ArrayList<Course>();
        			
        			if(LogInActivity.userId.equals("201500001")){
        				courseList = LogInActivity.Atimetable;
        			} else{//(LogInActivity.userId.equals("201500002")){
        				courseList = LogInActivity.Btimetable;
        			}
        			
        			Log.i("main","onclick");
        			//courseList = getCourseList(timetable, getApplicationContext());
        			codeList = getCodeList(courseList);
        			
	        		Intent intent = new Intent(MainActivity.this, ShowTimetableActivity.class);
	        		intent.putExtra("btnSaveVisible", "false");
	        		intent.putExtra("detailView", "true");
	        		intent.putExtra("codeList", codeList);
                    intent.putExtra("courseList", courseList);
	                startActivity(intent);
        		}else{
        			Toast.makeText(getApplicationContext(), "Make timetable first", Toast.LENGTH_SHORT).show();
        		}
        		}
        		break;
        	case 1:{
        		Intent intent = new Intent(MainActivity.this, MakeTimetableActivity.class);
                startActivity(intent);
        		}
        		break;
        	case 2:{
        		//Intent intent = new Intent(MainActivity.this, ModifyTimetableActivity.class);
                //startActivity(intent);
        		Toast.makeText(getApplicationContext(), "yet implement!", Toast.LENGTH_SHORT).show();
        		}
        		break;
        	case 3:{
        		//Intent intent = new Intent(MainActivity.this, DeleteTimetableActivity.class);
                //startActivity(intent);
        		Toast.makeText(getApplicationContext(), "yet implement!", Toast.LENGTH_SHORT).show();
        		}
        		break;
        	case 4:{
        		Intent intent = new Intent(MainActivity.this, ShowOthersTimetableActivity.class);
                startActivity(intent);
        		}
        		break;
        	case 5:{
        		//Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                //startActivity(intent);
        		Toast.makeText(getApplicationContext(), "yet implement!", Toast.LENGTH_SHORT).show();
        		}
        		break;
        	}
         }
    };
    
    public static ArrayList<String> getCodeList(ArrayList<Course> courseList){
    	ArrayList<String> res = new ArrayList<String>();
    	for(int i=0 ; i<30 ; i++){
      	  res.add("_");
        }
    	for(int i=0 ; i<courseList.size() ; i++){
    		int[] tt = courseList.get(i).getTimeInt();
    		
    		res.set(tt[0], courseList.get(i).getCourseCode());
    		res.set(tt[1], courseList.get(i).getCourseCode());
    	}    	
    	return res;
    }
    
    public static ArrayList<Course> getCourseList(Timetable t, Context c){
    	/*
    	serverDBadapter = new ServerDBAdapter(c);
    	ArrayList<Course> res = new ArrayList<Course>();
    	ArrayList<Course> allCourse = new ArrayList<Course>();
    	
    	ArrayList<Course> tmpCourse1 = new ArrayList<Course>();
    	tmpCourse1 = serverDBadapter.getAllCourses("RM");
    	ArrayList<Course> tmpCourse2 = new ArrayList<Course>();
    	tmpCourse2 = serverDBadapter.getAllCourses("EM");
    	ArrayList<Course> tmpCourse3 = new ArrayList<Course>();
    	tmpCourse3 = serverDBadapter.getAllCourses("RL");
    	ArrayList<Course> tmpCourse4 = new ArrayList<Course>();
    	tmpCourse4 = serverDBadapter.getAllCourses("EL");
    	
    	for(int i=0 ; i<tmpCourse1.size() ; i++){
    		allCourse.add(tmpCourse1.get(i));
    	}
    	for(int i=0 ; i<tmpCourse2.size() ; i++){
    		allCourse.add(tmpCourse2.get(i));
    	}
    	for(int i=0 ; i<tmpCourse3.size() ; i++){
    		allCourse.add(tmpCourse3.get(i));
    	}
    	for(int i=0 ; i<tmpCourse4.size() ; i++){
    		allCourse.add(tmpCourse4.get(i));
    	}
    	
    	String str = new String();
    	str = t.courseList;
    	Log.d("main",str);
    	for(int i=0 ; i<str.length() ; i+=3){
    		String tmpstr = str.substring(i, i+3);
    		for(int j=0 ; j<allCourse.size() ; j++){
    			if(tmpstr.equals(allCourse.get(j).getCourseCode())){
    				res.add(allCourse.get(j));
    				break;
    			}
    		}    		
    	}      	
    	return res;
    	*/
    	
    	return t.courseList;
    }
}
