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

import com.example.ajousmarttimetable.R;

public class MainActivity extends Activity {

	private StringAdapter mAdapter = null;
	
	private static final String TYPEFACE_NAME = "Quicksand-Regular.otf";
    private Typeface typeface = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loadTypeface();
		setContentView(R.layout.main);
		
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
		
		ListView mListView = (ListView)findViewById(R.id.listview);
		mListView.setAdapter(mAdapter);
		
		mListView.setOnItemClickListener(onClickListItem);    		
	}
	
	private void loadTypeface(){
        if(typeface==null)
            typeface = Typeface.createFromAsset(getAssets(), TYPEFACE_NAME);
    }
	
	@Override
    public void setContentView(int viewId) {
        View view = LayoutInflater.from(this).inflate(viewId, null);
        ViewGroup group = (ViewGroup)view;
        int childCnt = group.getChildCount();
        for(int i=0; i<childCnt; i++){
            View v = group.getChildAt(i);
            if(v instanceof TextView){
                ((TextView)v).setTypeface(typeface);
                Log.i("setTypeface",v.toString());
            }
        }
        super.setContentView(view);
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
        		Intent i = new Intent("com.example.ajousmarttimetable.SHOW_TIMETABLE");
        		i.putExtra("btnSaveVisible", "false");
                startActivity(i);
        		}
        		break;
        	case 1:{
        		Intent i = new Intent("com.example.ajousmarttimetable.MAKE_TIMETABLE");
                startActivity(i);
        		}
        		break;
        	case 2:{
        		Intent i = new Intent("com.example.ajousmarttimetable.MODIFY_TIMETABLE");
                startActivity(i);
        		}
        		break;
        	case 3:{
        		Intent i = new Intent("com.example.ajousmarttimetable.DELETE_TIMETABLE");
                startActivity(i);
        		}
        		break;
        	case 4:{
        		Intent i = new Intent("com.example.ajousmarttimetable.SHOW_OTHERS_TIMETABLE");
                startActivity(i);
        		}
        		break;
        	case 5:{
        		Intent i = new Intent("com.example.ajousmarttimetable.SETTINGS");
                startActivity(i);
        		}
        		break;
        	}
        	Toast.makeText(MainActivity.this, mAdapter.getItem(arg2) , Toast.LENGTH_SHORT).show();
        }
    };
}
