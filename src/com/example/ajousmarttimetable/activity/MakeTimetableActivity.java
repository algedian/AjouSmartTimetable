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
	ListView listCategoryRM;
	ListView listCategoryEM;
	ListView listCategoryRL;
	ListView listCategoryEL;
	ArrayList<Course> classifiedCourseList_RM;
	ArrayList<Course> classifiedCourseList_EM;
	ArrayList<Course> classifiedCourseList_RL;
	ArrayList<Course> classifiedCourseList_EL;
	ArrayList<Course> selectedCourseList;
	TextView txtCurrentCredit;
	TextView txtLeft;
	
	private CourseAdapter RMAdapter = null;
	private CourseAdapter EMAdapter = null;
	private CourseAdapter RLAdapter = null;
	private CourseAdapter ELAdapter = null;
	
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
		listCategoryRM = (ListView)findViewById(R.id.categoryRM);
		listCategoryEM = (ListView)findViewById(R.id.categoryEM);
		listCategoryRL = (ListView)findViewById(R.id.categoryRL);
		listCategoryEL = (ListView)findViewById(R.id.categoryEL);
		
		btnRM.setOnClickListener(this);
		btnEM.setOnClickListener(this);
		btnRL.setOnClickListener(this);
		btnEL.setOnClickListener(this);
		btnSave.setOnClickListener(this);
		
		selectedCourseList = new ArrayList<Course>();
		
		classifiedCourseList_RM = new ArrayList<Course>();
		classifiedCourseList_EM = new ArrayList<Course>();
		classifiedCourseList_RL = new ArrayList<Course>();
		classifiedCourseList_EL = new ArrayList<Course>();
		//courseList에 코스 가져오기
		serverDBadapter = new ServerDBAdapter(getApplicationContext());
		classifiedCourseList_RM = serverDBadapter.getAllCourses("RM");
		classifiedCourseList_EM = serverDBadapter.getAllCourses("EM");
		classifiedCourseList_RL = serverDBadapter.getAllCourses("RL");
		classifiedCourseList_EL = serverDBadapter.getAllCourses("EL");
		putCourse();
		
        RMAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_RM); 
        EMAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_EM); 
        RLAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_RL); 
        ELAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_EL); 
		listCategoryRM.setAdapter(RMAdapter);		
		listCategoryRM.setOnItemClickListener(onClickListItemRM); 
		listCategoryEM.setAdapter(EMAdapter);		
		listCategoryEM.setOnItemClickListener(onClickListItemEM); 
		listCategoryRL.setAdapter(RMAdapter);		
		listCategoryRL.setOnItemClickListener(onClickListItemRL); 
		listCategoryEL.setAdapter(RMAdapter);		
		listCategoryEL.setOnItemClickListener(onClickListItemEL); 
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
				listCategoryEM.setVisibility(View.INVISIBLE);
				listCategoryRL.setVisibility(View.INVISIBLE);
				listCategoryEL.setVisibility(View.INVISIBLE);
				listCategoryRM = (ListView)findViewById(R.id.categoryRM);
				listCategoryRM.setVisibility(View.VISIBLE);
				
				RMAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_RM);  
				listCategoryRM.setAdapter(RMAdapter);		
				listCategoryRM.setOnItemClickListener(onClickListItemRM);
			}			
				break;
			case R.id.btnElectiveMajor:{
				//listview 수정
				listCategoryRM.setVisibility(View.INVISIBLE);
				listCategoryRL.setVisibility(View.INVISIBLE);
				listCategoryEL.setVisibility(View.INVISIBLE);
				listCategoryEM = (ListView)findViewById(R.id.categoryEM);
				listCategoryEM.setVisibility(View.VISIBLE);
				
				EMAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_EM);   
				listCategoryEM.setAdapter(EMAdapter);		
				listCategoryEM.setOnItemClickListener(onClickListItemEM);
				
			}			
				break;
			case R.id.btnRequiredLiberal:{
				//listview 수정
				listCategoryRM.setVisibility(View.INVISIBLE);
				listCategoryEM.setVisibility(View.INVISIBLE);
				listCategoryEL.setVisibility(View.INVISIBLE);
				listCategoryRL = (ListView)findViewById(R.id.categoryRL);
				listCategoryRL.setVisibility(View.VISIBLE);
				
				RLAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_RL); 
				listCategoryRL.setAdapter(RLAdapter);		
				listCategoryRL.setOnItemClickListener(onClickListItemRL);
				
			}			
				break;
			case R.id.btnElectiveLiberal:{
				//listview 수정
				listCategoryRM.setVisibility(View.INVISIBLE);
				listCategoryEM.setVisibility(View.INVISIBLE);
				listCategoryRL.setVisibility(View.INVISIBLE);
				listCategoryEL = (ListView)findViewById(R.id.categoryEL);
				listCategoryEL.setVisibility(View.VISIBLE);
				
				ELAdapter = new CourseAdapter(this, R.layout.makett_row , classifiedCourseList_EL); 
				listCategoryEL.setAdapter(ELAdapter);		
				listCategoryEL.setOnItemClickListener(onClickListItemEL);
				
			}			
				break;
			case R.id.btnSaveTimetable:{
				//show timetable activity 로				
				
				Intent intent = new Intent(MakeTimetableActivity.this, ShowTimetableActivity.class);
				intent.putExtra("selectedCourseList", selectedCourseList);
				startActivity(intent);
				finish();
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
    private OnItemClickListener onClickListItemRM = new OnItemClickListener() { 
        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
        	
        	selectedCourseList.add(RMAdapter.getItem(arg2));
        	int currentCredit = Integer.parseInt(txtCurrentCredit.getText().toString());        	
        	currentCredit += Integer.parseInt(RMAdapter.getItem(arg2).getCredit());
        	txtCurrentCredit.setText(String.valueOf(currentCredit));
        	
         }
    };
    
 // 아이템 터치 이벤트
    private OnItemClickListener onClickListItemEM = new OnItemClickListener() { 
        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
        	
        	selectedCourseList.add(EMAdapter.getItem(arg2));
        	int currentCredit = Integer.parseInt(txtCurrentCredit.getText().toString());        	
        	currentCredit += Integer.parseInt(EMAdapter.getItem(arg2).getCredit());
        	txtCurrentCredit.setText(String.valueOf(currentCredit));
        	
         }
    };
    
 // 아이템 터치 이벤트
    private OnItemClickListener onClickListItemRL = new OnItemClickListener() { 
        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
        	
        	selectedCourseList.add(RLAdapter.getItem(arg2));
        	int currentCredit = Integer.parseInt(txtCurrentCredit.getText().toString());        	
        	currentCredit += Integer.parseInt(RLAdapter.getItem(arg2).getCredit());
        	txtCurrentCredit.setText(String.valueOf(currentCredit));
        	
         }
    };
    
 // 아이템 터치 이벤트
    private OnItemClickListener onClickListItemEL = new OnItemClickListener() { 
        @Override
        public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
        	
        	selectedCourseList.add(ELAdapter.getItem(arg2));
        	int currentCredit = Integer.parseInt(txtCurrentCredit.getText().toString());        	
        	currentCredit += Integer.parseInt(ELAdapter.getItem(arg2).getCredit());
        	txtCurrentCredit.setText(String.valueOf(currentCredit));
        	
         }
    };
    
    void putCourse(){
    	/*
    	db.execSQL("INSERT INTO AllCourse VALUES ('14','수학1','12','김성재','성204','3','RL','2A 5A')");
        db.execSQL("INSERT INTO AllCourse VALUES ('15','수학2','21','김수진','성203','3','RL','2D 5D')");
        db.execSQL("INSERT INTO AllCourse VALUES ('72','컴퓨터공학개론','11', '류기열', '팔1025', '3', 'RM', '1B 4B')");
                
        db.execSQL("INSERT INTO AllCourse VALUES ('56', '자료구조', '12', '강경란', '팔410', '3', 'RM', '2A 4A')");
        db.execSQL("INSERT INTO AllCourse VALUES ('59', '알고리즘', '32', '손경아', '팔110', '3', 'RM', '1D 4D')");
		db.execSQL("INSERT INTO AllCourse VALUES ('319', '현대인의성과사랑', '21', '이예지', '다507', '3', 'EL', '1E 3E')");
		*/
    	Course tmp1 = new Course();
    	tmp1.setCourseCode("050");
    	tmp1.setCourseName("컴퓨터프로그래밍");
    	tmp1.setProfessorName("류기열");
    	tmp1.setClassroom("팔309");
    	tmp1.setCredit("3");
    	tmp1.setTime("화A 금A");
    	classifiedCourseList_RM.add(tmp1);
    	
    	Course tmp = new Course();
    	tmp.setCourseCode("057");
    	tmp.setCourseName("운영체제");
    	tmp.setProfessorName("김재훈");
    	tmp.setClassroom("팔110");
    	tmp.setCredit("3");
    	tmp.setTime("월A 수A");
    	classifiedCourseList_RM.add(tmp);
    	
    	Course tmp2 = new Course();
    	tmp2.setCourseCode("073");
    	tmp2.setCourseName("네트워크운용사례");
    	tmp2.setProfessorName("조영종");
    	tmp2.setClassroom("팔328");
    	tmp2.setCredit("3");
    	tmp2.setTime("화A 화B");
    	classifiedCourseList_EM.add(tmp2);
    	
    	Course tmp3 = new Course();
    	tmp3.setCourseCode("021");
    	tmp3.setCourseName("물리학1");
    	tmp3.setProfessorName("정역학");
    	tmp3.setClassroom("성205");
    	tmp3.setCredit("3");
    	tmp3.setTime("화A 금A");
    	classifiedCourseList_RL.add(tmp3);
    	
    	Course tmp5 = new Course();
    	tmp5.setCourseCode("029");
    	tmp5.setCourseName("생명과학실험");
    	tmp5.setProfessorName("김민수");
    	tmp5.setClassroom("실104");
    	tmp5.setCredit("1");
    	tmp5.setTime("화C 화D");
    	classifiedCourseList_RL.add(tmp5);
    	
    	Course tmp4 = new Course();
    	tmp4.setCourseCode("009");
    	tmp4.setCourseName("영어2");
    	tmp4.setProfessorName("Theresia");
    	tmp4.setClassroom("율405");
    	tmp4.setCredit("3");
    	tmp4.setTime("월A 수A");
    	classifiedCourseList_EL.add(tmp4);
    }
}
