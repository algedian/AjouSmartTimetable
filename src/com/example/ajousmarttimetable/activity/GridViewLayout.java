package com.example.ajousmarttimetable.activity;

import com.example.ajousmarttimetable.ASTHandler;
import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.R.id;
import com.example.ajousmarttimetable.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewLayout extends Activity {
	
	ASTHandler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_layout);

		handler = ASTHandler.getInstance();
		Intent intent = getIntent();

		int val = intent.getIntExtra("param1", 0);
		
		ImageView view = (ImageView) this.findViewById(R.id.image);
		view.setImageResource(val);

		TextView text = (TextView) this.findViewById(R.id.txtImage);
		String s = Integer.toString(val);
		text.setText(s);

		
	}
}