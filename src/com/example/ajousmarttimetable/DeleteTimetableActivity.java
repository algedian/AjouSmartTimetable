package com.example.ajousmarttimetable;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
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

public class DeleteTimetableActivity extends Activity{
	private StringAdapter mAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.delete_timetable);
		
		// ListView에 아이템 추가 - db에서 가져오기
		String a = new String("2014-1");
		String b = new String("2014-2");
		String c = new String("2015-1");
		String d = new String("2015-2");
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(a);		
        list.add(b);
        list.add(c);		
        list.add(d);
        
        mAdapter = new StringAdapter(this, R.layout.row , list);       
		
		ListView mListView = (ListView)findViewById(R.id.listview3);
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
        	
        	Toast.makeText(DeleteTimetableActivity.this, mAdapter.getItem(arg2) , Toast.LENGTH_SHORT).show();
        }
    };
}