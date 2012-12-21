package com.ei.microapp;

import java.util.ArrayList;
import java.util.HashMap;

import com.ei.SpreadSheet;
import com.ei.SpreadSheetFactory;
import com.ei.WorkSheet;
import com.ei.WorkSheetCell;
import com.ei.WorkSheetRow;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Retrive1 extends ListActivity{

	private String[][] strings;
	private HorizontalScrollView sv;
	 @Override
		public void onBackPressed() {
			Intent intent=new Intent(getApplicationContext(), Home.class);
			startActivity(intent);
			Retrive1.this.finish();
		}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.retrive);
		sv=(HorizontalScrollView)findViewById(R.id.h1);
		sv.setVerticalScrollBarEnabled(false); 
		sv.setHorizontalScrollBarEnabled(false);
		Intent intent = getIntent();
		Bundle b = intent.getExtras();
		MyParcelable myParcelable = b.getParcelable("parcel");
		int r=b.getInt("row");
		System.out.println(r+"row");
		strings = myParcelable.getStrings();
		 ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
		
//			HashMap<String, String> map = new HashMap<String, String>();	
				
		 
		 HashMap<String, String> map1 = new HashMap<String, String>();	
			
//			System.out.println("inside"+strings[0][0]);
			map1.put("specimencode", "Specimencode");
			map1.put("extractioncode","Extractioncode");
			map1.put("notes","Notes");
			map1.put("dataextracted","DataExtracted");
			map1.put("user","User");
			map1.put("boxno","BoxNo");
			map1.put("boxrow","BoxRow");
			map1.put("boxcolumn","BoxColumn");
			map1.put("username","UserName");
			
			mylist.add(map1);
		for(int i=0;i<r;i++)
		{
			HashMap<String, String> map = new HashMap<String, String>();	
			
				System.out.println("inside"+strings[0][0]);
				map.put("specimencode", strings[i][0]);
				map.put("extractioncode",strings[i][1]);
				map.put("notes",strings[i][2]);
				map.put("dataextracted",strings[i][3]);
				map.put("user",strings[i][4]);
				map.put("boxno",strings[i][5]);
				map.put("boxrow",strings[i][6]);
				map.put("boxcolumn",strings[i][7]);
				map.put("username",strings[i][8]);
				mylist.add(map);
		
		}
		
		ListAdapter adapter = new SimpleAdapter(this, mylist ,R.layout.list1,
                new String[] { "specimencode","extractioncode","notes","dataextracted","user","boxno","boxrow","boxcolumn","username" }, 
                new int[] { R.id.l1textView1,R.id.l1textView2,R.id.l1textView3,R.id.l1textView4,R.id.l1textView5,R.id.l1textView6,R.id.l1textView7,R.id.l1textView8,R.id.l1textView9 });
		 setListAdapter(adapter);
	        
		
	}

}
