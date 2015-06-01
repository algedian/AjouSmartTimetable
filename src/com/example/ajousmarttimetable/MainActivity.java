package com.example.ajousmarttimetable;

import java.util.ArrayList;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private StringAdapter mAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// ListView에 아이템 추가
		String a = new String("시간표 보기");
		String b = new String("시간표 만들기");
		String c = new String("시간표 수정");
		String d = new String("시간표 삭제");
		String e = new String("다른사람 시간표 보기");
		String f = new String("설정");
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(a);		
        list.add(b);
        list.add(c);		
        list.add(d);
        list.add(e);
        list.add(f);
        
        mAdapter = new StringAdapter(this, R.layout.row , list);
        		//(getApplicationContext(), R.layout.row ,list);        
		
		ListView mListView = (ListView)findViewById(R.id.listview);
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
            // 이벤트 발생 시 해당 아이템 위치의 텍스트를 출력
            //Intent i = new Intent("com.example.smartparking.ParkingLotDetail.SHOW_WEBPAGE");
        	//i.putExtra("parkingLotName", mAdapter.getItem(arg2).toString());
            //startActivity(i);
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
