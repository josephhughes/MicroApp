package com.ei.microapp;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class Find2 extends ListActivity {

	@Override
	public void onBackPressed() {
	
	}



	private String[][] strings;
	private HorizontalScrollView sv;

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.find2);
		sv=(HorizontalScrollView)findViewById(R.id.hv);
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
		    map1.put("timestamp","Timestamp");
			map1.put("specimencode", "Specimencode");
			map1.put("genus","Genus");
			map1.put("specimenname","Specimenname");
			map1.put("authority","Authority");
			map1.put("boxno","BoxNo");
			map1.put("boxrow","BoxRow");
			map1.put("boxcolumn","BoxColumn");
			map1.put("hostgenus","Hostgenus");
			map1.put("hostspecimen","Hostspecimen");
			map1.put("locality","Locality");
			map1.put("latitude","Latitude");
			map1.put("longitude","Longitude");
			map1.put("district","District");
			map1.put("province","Province");
			map1.put("country","Country");
			map1.put("determinedby","Determinedby");
			map1.put("collectedby","Collectedby");
			map1.put("datacollected","Datacollected");
			map1.put("collectionnotes","Collectionnotes");
			map1.put("notes","Notes");
			map1.put("stagesex","Stagesex");
			map1.put("abundance","Abundance");
			map1.put("comment","Comment");
			map1.put("username", "Username");
			mylist.add(map1);
		for(int i=0;i<r;i++)
		{
			HashMap<String, String> map = new HashMap<String, String>();	
			
				System.out.println("inside"+strings[0][0]+"***"+strings[0][1]+"***"+strings[0][2]+"***"+strings[0][3]+"***"+strings[0][4]+"***"+strings[0][5]+"***"+strings[0][6]+"***"+strings[0][7]+"***"+strings[0][8]+"***"+strings[0][9]+"***"+strings[0][10]+"***"+strings[0][11]+"***"+strings[0][12]+"***"+strings[0][13]+"***"+strings[0][14]+"***"+strings[0][15]+"***"+strings[0][16]+"***"+strings[0][17]+"***"+strings[0][18]+"***"+strings[0][17]+"***"+strings[0][18]+"***"+strings[0][19]+"***"+strings[0][20]+"***"+strings[0][21]+"***"+strings[0][22]+"***"+strings[0][23]+"***"+strings[0][24]);
				map.put("timestamp",strings[i][0]);
				map.put("specimencode", strings[i][1]);
				map.put("genus",strings[i][2]);
				map.put("specimenname",strings[i][3]);
				map.put("authority",strings[i][4]);
				map.put("boxno",strings[i][5]);
				map.put("boxrow",strings[i][6]);
				map.put("boxcolumn",strings[i][7]);
				map.put("hostgenus",strings[i][8]);
				map.put("hostspecimen",strings[i][9]);
				map.put("locality",strings[i][10]);
				map.put("latitude",strings[i][11]);
				map.put("longitude",strings[i][12]);
				map.put("district",strings[i][13]);
				map.put("province",strings[i][14]);
				map.put("country",strings[i][15]);
				map.put("determinedby",strings[i][16]);
				map.put("collectedby",strings[i][17]);
				map.put("datacollected",strings[i][18]);
				map.put("collectionnotes",strings[i][19]);
				map.put("notes",strings[i][20]);
				map.put("stagesex",strings[i][21]);
				map.put("abundance",strings[i][22]);
				map.put("comment",strings[i][23]);
				map.put("username",strings[i][24]);
				mylist.add(map);
		
		}
		
		//get data from  sqlite and display in list
		ListAdapter adapter = new SimpleAdapter(this, mylist ,R.layout.list,
                new String[] { "specimencode","genus","specimenname","authority","boxno","boxrow","boxcolumn","hostgenus","hostspecimen","locality","latitude","longitude","district","province","country","determinedby","collectedby","datacollected","collectionnotes","notes","stagesex","abundance","comment","timestamp","username"}, 
                new int[] { R.id.ltextView1,R.id.ltextView2,R.id.ltextView3,R.id.ltextView4,R.id.ltextView5,R.id.ltextView6,R.id.ltextView7,R.id.ltextView8,R.id.ltextView9,R.id.ltextView10,R.id.ltextView11,R.id.ltextView12,R.id.ltextView13,R.id.ltextView14,R.id.ltextView15,R.id.ltextView16,R.id.ltextView17,R.id.ltextView18,R.id.ltextView19,R.id.ltextView20,R.id.ltextView21,R.id.ltextView22,R.id.ltextView23,R.id.ltextView24,R.id.ltextView25});
		 setListAdapter(adapter);
	        
		Button home=(Button)findViewById(R.id.f2home);
		Button back=(Button)findViewById(R.id.f2back);
//		System.out.println(notes1[0]+notes1[1]);
	
		//go to home
		home.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), Home.class);
				startActivity(intent);
			}
		});
		//go to fin page back
		back.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), Find1.class);
				startActivity(intent);	
			}
		});
	}

}
