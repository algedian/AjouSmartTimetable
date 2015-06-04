package com.example.ajousmarttimetable.activity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ajousmarttimetable.ASTHandler;
import com.example.ajousmarttimetable.R;

public class ShowTimetableActivity extends Activity {
	
	ASTHandler handler;
	DisplayMetrics mMetrics;
	private Integer[] mThumbIds = { 
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white,
			R.drawable.white, R.drawable.white, R.drawable.white
    };
	
	private String[] courseName = {
			"a", "b", "c", "d", "e",
			"a", "b", "c", "d", "e",
			"a", "b", "c", "d", "e",
			"a", "b", "c", "d", "e",
			"a", "b", "c", "d", "e",
			"a", "b", "c", "d", "e"
	};
	
	private GridLayout container;
	
	private static final String TYPEFACE_NAME = "Quicksand-Regular.otf.mp3";
    private Typeface typeface = null;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_timetable);
		
		handler = ASTHandler.getInstance();
		loadTypeface();
		Intent intent = getIntent();
		String btnSaveVisible = intent.getExtras().getString("btnSaveVisible");
		container = (GridLayout)findViewById(R.id.glTimetable);
		if(btnSaveVisible == null || btnSaveVisible.equals("")){
			//nothing 
		}
		else if(btnSaveVisible.equals("true")){ 
			Button btnSave = (Button)findViewById(R.id.btnSave);
			btnSave.setVisibility(View.VISIBLE);
			btnSave.setOnClickListener(btnSaveOnClickListener);
		}
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ImageAdapter(this));
		gridview.setOnItemClickListener(gridviewOnItemClickListener);
		
		mMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
	}
	
	public void onBackPressed() {
		finish();
        Intent intent = new Intent("AST.MAINACTIVITY");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
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
	

	private GridView.OnItemClickListener gridviewOnItemClickListener 
	    = new GridView.OnItemClickListener() {
	     
	    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
	            long arg3) {
	    	Intent intent = new Intent(ShowTimetableActivity.this, CourseDetailActivity.class);
	    	startActivity(intent);
	        //Toast.makeText(ShowTimetableActivity.this, arg0.getAdapter().getItem(arg2).toString(), Toast.LENGTH_SHORT).show();
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
		        fos = new FileOutputStream(
		        		Environment.getExternalStorageDirectory().toString() 
		        		+ "/../../sdcard0/Pictures" 
        				+ "/capture " + new Date() + ".jpeg");
		        captureView.compress(Bitmap.CompressFormat.JPEG, 100, fos);
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }
		    v.setVisibility(View.VISIBLE);
		    Toast.makeText(getApplicationContext(), "Captured! " + Environment.getExternalStorageDirectory().toString() + "/../../sdcard0/", Toast.LENGTH_LONG).show();
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
            /*
        	LinearLayout layout = new LinearLayout(mContext);
            layout.setLayoutParams(new GridView.LayoutParams(
            		android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            		android.view.ViewGroup.LayoutParams.MATCH_PARENT));
            layout.setOrientation(LinearLayout.VERTICAL);
            int rowWidth = (mMetrics.widthPixels) / 5;
 
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(rowWidth,200));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            
            TextView txtImage = new TextView(mContext);
            txtImage.setLayoutParams(new LinearLayout.LayoutParams(
            		android.view.ViewGroup.LayoutParams.MATCH_PARENT,
            		android.view.ViewGroup.LayoutParams.MATCH_PARENT));
            txtImage.setText(courseName[position]);
            
            layout.addView(imageView);
            layout.addView(txtImage);
            */
        	LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        	
            ImageView imageView;
            
            int rowWidth = (mMetrics.widthPixels) / 5;
            View gridView;
            
            if (convertView == null) {
	        	gridView = new View(mContext);
	
	            // get layout from dashboard_inner.xml
	            gridView = inflater.inflate(R.layout.gridview_layout, null);
            	
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
