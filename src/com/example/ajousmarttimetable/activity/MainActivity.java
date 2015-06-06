package com.example.ajousmarttimetable.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
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

import com.example.ajousmarttimetable.ASTHandler;
import com.example.ajousmarttimetable.R;

public class MainActivity extends Activity {

	ASTHandler handler;
	private StringAdapter mAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		handler = ASTHandler.getInstance();
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
        
        mAdapter = new StringAdapter(this, R.layout.row , list);      
		
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
                v = vi.inflate(R.layout.row, null);
            }
            
            String str = list.get(position);
            if (str != null) {
                TextView tv = (TextView) v.findViewById(R.id.textview);
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
        		Intent intent = new Intent(MainActivity.this, ShowTimetableActivity.class);
        		intent.putExtra("btnSaveVisible", "false");
                startActivity(intent);
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
}
