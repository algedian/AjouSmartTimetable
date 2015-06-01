package com.example.ajousmarttimetable.activity;

import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.R.id;
import com.example.ajousmarttimetable.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class ShowTimetableActivity_btn extends Activity implements OnClickListener{//, OnItemClickListener{
	
	//private ArrayList<Integer> arrayItem = new ArrayList<Integer>();
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_timetable);
		
		GridLayout.LayoutParams params = new GridLayout.LayoutParams();

		params.setMargins(10, 10, 10, 10);
		
		Button btnMonA = (Button)findViewById(R.id.monA);
		Button btnMonB = (Button)findViewById(R.id.monB);
		Button btnMonC = (Button)findViewById(R.id.monC);
		Button btnMonD = (Button)findViewById(R.id.monD);
		Button btnMonE = (Button)findViewById(R.id.monE);
		Button btnMonF = (Button)findViewById(R.id.monF);
		btnMonA.setOnClickListener(this);
		btnMonB.setOnClickListener(this);
		btnMonC.setOnClickListener(this);
		btnMonD.setOnClickListener(this);
		btnMonE.setOnClickListener(this);
		btnMonF.setOnClickListener(this);
		
		Button btntueA = (Button)findViewById(R.id.tueA);
		Button btntueB = (Button)findViewById(R.id.tueB);
		Button btntueC = (Button)findViewById(R.id.tueC);
		Button btntueD = (Button)findViewById(R.id.tueD);
		Button btntueE = (Button)findViewById(R.id.tueE);
		Button btntueF = (Button)findViewById(R.id.tueF);
		btntueA.setOnClickListener(this);
		btntueB.setOnClickListener(this);
		btntueC.setOnClickListener(this);
		btntueD.setOnClickListener(this);
		btntueE.setOnClickListener(this);
		btntueF.setOnClickListener(this);
		
		Button btnwedA = (Button)findViewById(R.id.wedA);
		Button btnwedB = (Button)findViewById(R.id.wedB);
		Button btnwedC = (Button)findViewById(R.id.wedC);
		Button btnwedD = (Button)findViewById(R.id.wedD);
		Button btnwedE = (Button)findViewById(R.id.wedE);
		Button btnwedF = (Button)findViewById(R.id.wedF);
		btnwedA.setOnClickListener(this);
		btnwedB.setOnClickListener(this);
		btnwedC.setOnClickListener(this);
		btnwedD.setOnClickListener(this);
		btnwedE.setOnClickListener(this);
		btnwedF.setOnClickListener(this);
		
		Button btnthurA = (Button)findViewById(R.id.thurA);
		Button btnthurB = (Button)findViewById(R.id.thurB);
		Button btnthurC = (Button)findViewById(R.id.thurC);
		Button btnthurD = (Button)findViewById(R.id.thurD);
		Button btnthurE = (Button)findViewById(R.id.thurE);
		Button btnthurF = (Button)findViewById(R.id.thurF);
		btnthurA.setOnClickListener(this);
		btnthurB.setOnClickListener(this);
		btnthurC.setOnClickListener(this);
		btnthurD.setOnClickListener(this);
		btnthurE.setOnClickListener(this);
		btnthurF.setOnClickListener(this);
		
		Button btnfriA = (Button)findViewById(R.id.friA);
		Button btnfriB = (Button)findViewById(R.id.friB);
		Button btnfriC = (Button)findViewById(R.id.friC);
		Button btnfriD = (Button)findViewById(R.id.friD);
		Button btnfriE = (Button)findViewById(R.id.friE);
		Button btnfriF = (Button)findViewById(R.id.friF);
		btnfriA.setOnClickListener(this);
		btnfriB.setOnClickListener(this);
		btnfriC.setOnClickListener(this);
		btnfriD.setOnClickListener(this);
		btnfriE.setOnClickListener(this);
		btnfriF.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String resName = getResources().getResourceName(v.getId());
		String viewName = resName.substring(resName.length()-4);  //view이름 받기
		Toast.makeText(this, viewName, Toast.LENGTH_SHORT).show();
		//Intent intent = new Intent(this, CourseDetailActivity.class);
		
	}
}
