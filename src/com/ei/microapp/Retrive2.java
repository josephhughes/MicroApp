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

public class Retrive2 extends ListActivity{

	private String[][] strings;
	private HorizontalScrollView sv;
	 @Override
		public void onBackPressed() {
			Intent intent=new Intent(getApplicationContext(), Home.class);
			startActivity(intent);
			Retrive2.this.finish();
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
			map1.put("extractedsample", "ExtractedSample");
			map1.put("primerpair","Primerpair");
			map1.put("dateofinput","Dateofinput");
			map1.put("successfull","successfull");
			map1.put("dateofsendtosequencing","Dateofsendtosequencing");
			map1.put("username","UserName");
			
			mylist.add(map1);
		for(int i=0;i<r;i++)
		{
			HashMap<String, String> map = new HashMap<String, String>();	
			
				System.out.println("inside"+strings[0][0]);
				map.put("extractedsample", strings[i][0]);
				map.put("primerpair",strings[i][1]);
				map.put("dateofinput",strings[i][2]);
				map.put("successfull",strings[i][3]);
				map.put("dateofsendtosequencing",strings[i][4]);
				map.put("username",strings[i][5]);
			
				mylist.add(map);
		
		}
		
		ListAdapter adapter = new SimpleAdapter(this, mylist ,R.layout.list2,
                new String[] { "extractedsample","primerpair","dateofinput","successfull","dateofsendtosequencing","username"}, 
                new int[] { R.id.l2textView1,R.id.l2textView2,R.id.l2textView3,R.id.l2textView4,R.id.l2textView5,R.id.l2textView6 });
		 setListAdapter(adapter);
	        
		
	}

}
