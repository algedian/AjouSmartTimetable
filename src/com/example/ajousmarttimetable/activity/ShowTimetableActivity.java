package com.example.ajousmarttimetable.activity;

import com.example.ajousmarttimetable.R;
import com.example.ajousmarttimetable.R.drawable;
import com.example.ajousmarttimetable.R.id;
import com.example.ajousmarttimetable.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class ShowTimetableActivity extends Activity {
	
	DisplayMetrics mMetrics;
	private Integer[] mThumbIds = { 
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small,
			R.drawable.blue_small, R.drawable.yellowgreen_small, R.drawable.pink_small
    };
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_timetable);
		Intent intent = getIntent();
		String btnSaveVisible = intent.getExtras().getString("btnSaveVisible");
		if(btnSaveVisible == null || btnSaveVisible.equals("")){
			//nothing
		}
		else if(btnSaveVisible.equals("true")){ //이 버튼때문이라도 액션바를 만들던가 해야지 - - 왜 안보이지
			Button btnSave = (Button)findViewById(R.id.btnSave);
			btnSave.setVisibility(View.VISIBLE);
		}
			
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		gridview.setOnItemClickListener(gridviewOnItemClickListener);
		
		mMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
	}

	private GridView.OnItemClickListener gridviewOnItemClickListener 
	    = new GridView.OnItemClickListener() {
	     
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	            long arg3) {
	    	Intent intent = new Intent(ShowTimetableActivity.this, CourseDetailActivity.class);
	    	startActivity(intent);
	        //Toast.makeText(ShowTimetableActivity.this, arg0.getAdapter().getItem(arg2).toString(), Toast.LENGTH_SHORT).show();
	    }
	};
	
	public class ImageAdapter extends BaseAdapter {
        private Context mContext;
 
        public ImageAdapter(Context c) {
            mContext = c;
        }
 
        public int getCount() {
            return mThumbIds.length;
        }
 
        public Object getItem(int position) {
            return mThumbIds[position];
        }
 
        public long getItemId(int position) {
            return position;
        }
 
        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
             
            int rowWidth = (mMetrics.widthPixels) / 5;
 
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(rowWidth,200));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }
    }
}
