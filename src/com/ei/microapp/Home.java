package com.ei.microapp;

import java.util.ArrayList;

import com.ei.SpreadSheet;
import com.ei.SpreadSheetFactory;
import com.ei.WorkSheet;
import com.ei.WorkSheetCell;
import com.ei.WorkSheetRow;
import com.ei.table.Record;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends Activity{

	
	private int i3=0;
	private String boxrow1;
	private String[ ][ ] aryNumbers = new String[100][100];
	private String boxcolumn1;
	private ArrayList<SpreadSheet> spreadSheets;	
	int spID = -1;
	private ArrayList<WorkSheet> workSheets;
	private WorkSheet wk;
	ArrayList<WorkSheetRow> rows;
	private String[] data1;
	private int d1=0;
	private SQLiteAdapter mySQLiteAdapter0;
	private String[] data2;
	private String[] data3;
	private String[] data4;
	private String[] data5;
	private String[] data6;
	private String[] data7;
	private String[] data8;
	private String[] data9;
	private String[] data10;
	private String[] data11;
	private String[] data12;
	private String[] data13;
	private String[] data14;
	private String[] data15;
	private String[] data16;
	private String[] data17;
	private String[] data18;
	private String[] data19;
	private String[] data20;
	private String[] data21;
	private String[] data22;
	String[] cols;
	private String[] string1;
	private String[] string2;
	private String[] string3;
	private String[] string4;
	private String[] string5;
	private int r;
	
	private String[] string11;
	private String[] string21;
	private String[] string31;
	private String[] string41;
	private String[] string51;
	private int r1;
	public String[] string61;
	public String[] string71;
	private String[] string81;
	@Override
	//when back key is pressed it ask for a dialog box to quit or not
	public void onBackPressed() {
		// TODO Auto-generated method stub

	     new AlertDialog.Builder(this)
        .setIcon(android.R.drawable.ic_dialog_alert)
        .setTitle("Quit App...")
        .setMessage("Are you sure you want to Quit?")
        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
    {
        public void onClick(DialogInterface dialog, int which) {
        	Intent startMain = new Intent(Intent.ACTION_MAIN); 
	        startMain.addCategory(Intent.CATEGORY_HOME); 
	        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
	        startActivity(startMain); 
	        Home.this.finish();
            
        }

    })
    .setNegativeButton("No", null)
    .show();
		
	}
	final Context context = this;
	private SQLiteAdapter2 mySQLiteAdapter;
	private SQLiteAdapter1 mySQLiteAdapter1;
	protected int i;
	private String user_name="null";
	private CharSequence[] selectFruit=new CharSequence[]{"collection","extraction","sequence"};
	private String[] data23;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.home);
		Button add=(Button)findViewById(R.id.hadddata);
		Button find=(Button)findViewById(R.id.hfind);
		Button upload=(Button)findViewById(R.id.hupload);
		Button retrive=(Button)findViewById(R.id.hretrive);
		Button logout=(Button)findViewById(R.id.hlogout);
		  SQLiteAdapterName use=new SQLiteAdapterName(getApplicationContext());
			 use.openToRead();
			 user_name=use.queueAll().trim();
			 use.close();  
		
		//get data from sqlite database for send data which are store in offline
		   mySQLiteAdapter0 = new SQLiteAdapter(Home.this);
			mySQLiteAdapter0.openToWrite();
	     	String value=mySQLiteAdapter0.queueAll00().trim();
			System.out.println(value);
			String value1=mySQLiteAdapter0.queueAll01().trim();
			System.out.println(value1);		
			String value2=mySQLiteAdapter0.queueAll02().trim();
			System.out.println(value2);
			String value3=mySQLiteAdapter0.queueAll03().trim();
			System.out.println(value3);
			String value4=mySQLiteAdapter0.queueAll04().trim();
			System.out.println(value4);
			String value5=mySQLiteAdapter0.queueAll05().trim();
			System.out.println(value5);
			String value6=mySQLiteAdapter0.queueAll06().trim();
			System.out.println(value6);
			String value7=mySQLiteAdapter0.queueAll07().trim();
			System.out.println(value7);
			String value8=mySQLiteAdapter0.queueAll08().trim();
			System.out.println(value8);
			String value9=mySQLiteAdapter0.queueAll09().trim();
			System.out.println(value9);		
			String value10=mySQLiteAdapter0.queueAll10().trim();
			System.out.println(value10);
			String value11=mySQLiteAdapter0.queueAll11().trim();
			System.out.println(value11);
			String value12=mySQLiteAdapter0.queueAll12().trim();
			System.out.println(value12);
			String value13=mySQLiteAdapter0.queueAll13().trim();
			System.out.println(value13);
			String value14=mySQLiteAdapter0.queueAll14().trim();
			System.out.println(value14);
			String value15=mySQLiteAdapter0.queueAll15().trim();
			System.out.println(value15);
			String value16=mySQLiteAdapter0.queueAll16().trim();
			System.out.println(value16);
			String value17=mySQLiteAdapter0.queueAll17().trim();
			System.out.println(value17);		
			String value18=mySQLiteAdapter0.queueAll18().trim();
			System.out.println(value18);
			String value19=mySQLiteAdapter0.queueAll19().trim();
			System.out.println(value19);
			String value20=mySQLiteAdapter0.queueAll20().trim();
			System.out.println(value20);
			String value21=mySQLiteAdapter0.queueAll21().trim();
			System.out.println(value21);
			String value22=mySQLiteAdapter0.queueAll22().trim();
			System.out.println(value22);
			 d1=mySQLiteAdapter0.getRowCount();
			System.out.println("d1"+d1);
			data1=value.split(" ",d1);
			data2=value1.split(" ",d1);
			data3=value2.split(" ",d1);
			data4=value3.split(" ",d1);
			data5=value4.split(" ",d1);
			data6=value5.split(" ",d1);
			data7=value6.split(" ",d1);
			data8=value7.split(" ",d1);
			data9=value8.split(" ",d1);
			data10=value9.split(" ",d1);
			data11=value10.split(" ",d1);
			data12=value11.split(" ",d1);
			data13=value12.split(" ",d1);
			data14=value13.split(" ",d1);
			data15=value14.split(" ",d1);
			data16=value15.split(" ",d1);
			data17=value16.split(" ",d1);
			data18=value17.split(" ",d1);
			data19=value18.split(" ",d1);
			data20=value19.split(" ",d1);
			data21=value20.split(" ",d1);
			data22=value21.split(" ",d1);
			data23=value22.split(" ",d1);
//			System.out.println(string11);
			mySQLiteAdapter0.close();
		
		
		
			//get data from sqlite database for send data which are store in offline
		mySQLiteAdapter1 = new SQLiteAdapter1(Home.this);
		mySQLiteAdapter1.openToWrite();
//		mySQLiteAdapter1.insert("specmencode1", "extractioncode1", "note1", "dateextracted1", "user1","boxno1","boxrow1","boxcolumn1");
    	String values=mySQLiteAdapter1.queueAll().trim();
		System.out.println(values);
		String values1=mySQLiteAdapter1.queueAll1().trim();
		System.out.println(values1);		
		String values2=mySQLiteAdapter1.queueAll2().trim();
		System.out.println(values2);
		String values3=mySQLiteAdapter1.queueAll3().trim();
		System.out.println(values3);
		String values4=mySQLiteAdapter1.queueAll4().trim();
		System.out.println(values4);
		String values5=mySQLiteAdapter1.queueAll5().trim();
		System.out.println(values5);
		String values6=mySQLiteAdapter1.queueAll6().trim();
		System.out.println(values6);
		String values7=mySQLiteAdapter1.queueAll7().trim();
		System.out.println(values7);
		 r1=mySQLiteAdapter1.getRowCount();
		System.out.println(r1);
		string11=values.split(" ",r1);
		string21=values1.split(" ",r1);
		string31=values2.split(" ",r1);
		string41=values3.split(" ",r1);
		string51=values4.split(" ",r1);
		string61=values5.split(" ",r1);
		string71=values6.split(" ",r1);
		string81=values7.split(" ",r1);
	System.out.println(string11);
		mySQLiteAdapter1.close();
		
		   mySQLiteAdapter = new SQLiteAdapter2(Home.this);
			mySQLiteAdapter.openToWrite();
//			mySQLiteAdapter.insert(specimencode1, extractioncode1, notes1, date11, user1, boxno1, boxrow1, boxcolumn1);
//			mySQLiteAdapter.insert("extracted", "primerpair2", "dateofinput", "successfull1", "dateofsendtosequence");
//			mySQLiteAdapter.insert(specimencode1, extractioncode1, notes1, date11, user1, boxno1, boxrow1, boxcolumn1);
//			mySQLiteAdapter.insert(generate1, genus1, specimenname1, authority1, boxno1, boxrow1, boxcolumn1, hostgenus1, hostspecimen1, locality1, latitude1, longitude1, district1, province1, country1, determinedby1, collectedby1, datacollected1, collectionnotes1, notes1, stagesex1, abundance1, comment1);
			String string=mySQLiteAdapter.queueAll().trim();
			System.out.println(string);
			String pp=mySQLiteAdapter.queueAll1().trim();
			System.out.println(pp);
			String doi=mySQLiteAdapter.queueAll2().trim();
			System.out.println(doi);
			String suc=mySQLiteAdapter.queueAll3().trim();
			System.out.println(suc);
			String dos=mySQLiteAdapter.queueAll4().trim();
			System.out.println(dos);
			
			
			
			 r=mySQLiteAdapter.getRowCount();
			System.out.println(r);
			 string1=string.split(" ",r);
			 string2=pp.split(" ",r);
			 string3=doi.split(" ",r);
			 string4=suc.split(" ",r);
			 string5=dos.split(" ",r);
			for(int k=0;k<r;k++){
				System.out.println(string1[k].trim());
				System.out.println(string2[k].trim());
				System.out.println(string3[k].trim());
				System.out.println(string4[k].trim());
				System.out.println(string5[k].trim());
				
				
			}
			
			mySQLiteAdapter.close();
		
		
			
			
			boolean answer;
			answer=isOnline();
			System.out.println(answer);

			if(answer){
	        		
	        		if(d1==0){
	        			if(r1==0){
	        				if(r==0){
	        					
	        				}else{
	        					runOnUiThread(new Runnable(){
	        			        	public void run(){
	        			        		new MyTask4().execute(null);
	        			        	}
	        			        });
	        				}
	        			}else{
	        				runOnUiThread(new Runnable(){
	    			        	public void run(){
	    			        		new MyTask2().execute(null);
	    			        	}
	    			        });
	        			}
	        		}
	        		else{
	        			runOnUiThread(new Runnable(){
				        	public void run(){
				        		new MyTask().execute(null);
				        	}
				        });
	        		}
			}else
			{
				Toast.makeText(getApplicationContext(), "No Internet Connection",Toast.LENGTH_LONG).show();
			}
		
			
			
			
			
			
		upload.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					Intent intent=new Intent(getApplicationContext(), Login.class);
					startActivity(intent);
					Home.this.finish();
				
	}
		});
		add.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				SQLiteAdapterLog my=new SQLiteAdapterLog(getApplicationContext());
				my.openToRead();
				i=my.getRowCount();
				my.close();
				if(i==0){
				
				Toast.makeText(getApplicationContext(), "Please GoTo Setting",Toast.LENGTH_LONG).show();
				}
				else
				{
				Intent intent=new Intent(getApplicationContext(), Data1.class);
				startActivity(intent);	
				Home.this.finish();
				}
			}
		});
		find.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				SQLiteAdapterLog my=new SQLiteAdapterLog(getApplicationContext());
				my.openToRead();
				i=my.getRowCount();
				my.close();
				if(i==0){
				
				Toast.makeText(getApplicationContext(), "Please GoTo Setting",Toast.LENGTH_LONG).show();
				}
				else
				{
				Intent intent=new Intent(getApplicationContext(), Find1.class);
				startActivity(intent);
				Home.this.finish();
				}
			}
		});
		retrive.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				SQLiteAdapterLog my=new SQLiteAdapterLog(getApplicationContext());
				my.openToRead();
				i=my.getRowCount();
				my.close();
				if(i==0){
				
				Toast.makeText(getApplicationContext(), "Please GoTo Setting",Toast.LENGTH_LONG).show();
				}
				else
				{
				boolean answer;
				answer=isOnline();
				System.out.println(answer);

				if(answer)
				{
				
					SingleChoice();
				
				}
				else
				{
					Toast.makeText(getApplicationContext(), "No Internet Connection",Toast.LENGTH_LONG).show();
				}
				
				}
			}
		});
		logout.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
		        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
		 
					// set title
					alertDialogBuilder.setTitle("Quit App...");
		 
					// set dialog message
					alertDialogBuilder
						.setMessage("Are you sure you want to Quit?")
						.setCancelable(false)
						.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, close
								// current activity
//								Home.this.finish();
								Intent startMain = new Intent(Intent.ACTION_MAIN); 
						        startMain.addCategory(Intent.CATEGORY_HOME); 
						        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
						        startActivity(startMain); 
						        Home.this.finish();
							}
						  })
						.setNegativeButton("No",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						});
		 
						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
		 
						// show it
						alertDialog.show();
		        
			}
		});
	}
	
	private void SingleChoice() {  
	     Builder builder = new AlertDialog.Builder(this);  
	     builder.setTitle("Select Sheet...");  
	     builder.setItems(selectFruit, new DialogInterface.OnClickListener() {  
//	       @Override  
	       public void onClick(DialogInterface dialog, int which) {  
	        String x=selectFruit[which].toString().trim();
	    	   if(x.equalsIgnoreCase("collection")){
	    		   runOnUiThread(new Runnable(){
			        	public void run(){
			        		new MyTask_1().execute(null);
			        	}
			        }); 
	    	   }
	    	   else if(x.equalsIgnoreCase("extraction")){
	    		   runOnUiThread(new Runnable(){
			        	public void run(){
			        		new MyTask_2().execute(null);
			        	}
			        });
	    		   
	    	   } else if(x.equalsIgnoreCase("sequence")){
	    		   runOnUiThread(new Runnable(){
			        	public void run(){
			        		new MyTask_3().execute(null);
			        	}
			        });
	    		   
	    	   }
	    	   
	         dialog.dismiss();  
	       }  
	     });  
	     builder.setNegativeButton("cancel",  
	         new DialogInterface.OnClickListener() {  
//	           @Override  
	           public void onClick(DialogInterface dialog, int which) {  
	             dialog.dismiss();  
	           }  
	         });  
	     AlertDialog alert = builder.create();  
	     alert.show();  
	   }  
	//check for connection in google and upload data to spreadsheet
	private class MyTask_1 extends AsyncTask{

		Dialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new Dialog(Home.this);
			dialog.setTitle("Please wait");
			TextView tv = new TextView(Home.this.getApplicationContext());
			tv.setText("Loading Data From SpreadSheet...");
			dialog.setContentView(tv);
			dialog.show();
		}

		@Override
		protected Object doInBackground(Object... params) {

			   SpreadSheetFactory factory = SpreadSheetFactory.getInstance("gla.microbio@gmail.com","AndroidMicro");
				spreadSheets = factory.getAllSpreadSheets();
				if(spreadSheets == null){
					System.out.println("null");
					Toast.makeText(getApplicationContext(), "NoSheet", Toast.LENGTH_LONG).show();
				}
				else{
				SpreadSheet sp = spreadSheets.get(0);
				workSheets = sp.getAllWorkSheets();
				int number = workSheets.size();
				for(int i=0; i<number; i++){
				if(workSheets.get(i).getTitle().equalsIgnoreCase("collection")){
					wk = workSheets.get(i);
					cols = wk.getColumns();
					rows = wk.getData(false);
													
					if(rows == null || rows.size() == 0){
						System.out.println("null rows");
					}
					if(cols != null){
					}
					for(int i1=0; i1<rows.size(); i1++){
						WorkSheetRow row = rows.get(i1);
						ArrayList<WorkSheetCell> cells = row.getCells();
						
						for(int j1=0; j1<cells.size(); j1++){
							WorkSheetCell cell = cells.get(j1);
							aryNumbers[i1][j1]=cell.getValue();
						}
						i3++;
					}
					
					
				}
				
				}
				}
				Intent intent=new Intent(Home.this.getApplicationContext(),Retrive.class);
				MyParcelable myParcelable = new MyParcelable();
				myParcelable.setStrings(aryNumbers);
				intent.putExtra("parcel",myParcelable);
				intent.putExtra("row",i3);
				startActivity(intent);
				Home.this.finish();
				
				
				return null;
				
		}
		
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(dialog.isShowing())
				dialog.cancel();
			
		    
		}

	}
	private class MyTask_2 extends AsyncTask{

		Dialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new Dialog(Home.this);
			dialog.setTitle("Please wait");
			TextView tv = new TextView(Home.this.getApplicationContext());
			tv.setText("Loading Data From SpreadSheet...");
			dialog.setContentView(tv);
			dialog.show();
		}

		@Override
		protected Object doInBackground(Object... params) {

			   SpreadSheetFactory factory = SpreadSheetFactory.getInstance("gla.microbio@gmail.com","AndroidMicro");
				spreadSheets = factory.getAllSpreadSheets();
				if(spreadSheets == null){
					System.out.println("null");
					Toast.makeText(getApplicationContext(), "NoSheet", Toast.LENGTH_LONG).show();
				}
				else{
				SpreadSheet sp = spreadSheets.get(0);
				workSheets = sp.getAllWorkSheets();
				int number = workSheets.size();
				for(int i=0; i<number; i++){
				if(workSheets.get(i).getTitle().equalsIgnoreCase("extraction")){
					wk = workSheets.get(i);
					cols = wk.getColumns();
					rows = wk.getData(false);
													
					if(rows == null || rows.size() == 0){
						System.out.println("null rows");
					}
					if(cols != null){
					}
					for(int i1=0; i1<rows.size(); i1++){
						WorkSheetRow row = rows.get(i1);
						ArrayList<WorkSheetCell> cells = row.getCells();
						
						for(int j1=0; j1<cells.size(); j1++){
							WorkSheetCell cell = cells.get(j1);
							aryNumbers[i1][j1]=cell.getValue();
						}
						i3++;
					}
					
					
				}
				
				}
				}
				Intent intent=new Intent(Home.this.getApplicationContext(),Retrive1.class);
				MyParcelable myParcelable = new MyParcelable();
				myParcelable.setStrings(aryNumbers);
				intent.putExtra("parcel",myParcelable);
				intent.putExtra("row",i3);
				startActivity(intent);
				Home.this.finish();
				
				
				return null;
				
		}
		
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(dialog.isShowing())
				dialog.cancel();
			
		    
		}

	}
	private class MyTask_3 extends AsyncTask{

		Dialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new Dialog(Home.this);
			dialog.setTitle("Please wait");
			TextView tv = new TextView(Home.this.getApplicationContext());
			tv.setText("Loading Data From SpreadSheet...");
			dialog.setContentView(tv);
			dialog.show();
		}

		@Override
		protected Object doInBackground(Object... params) {

			   SpreadSheetFactory factory = SpreadSheetFactory.getInstance("gla.microbio@gmail.com","AndroidMicro");
				spreadSheets = factory.getAllSpreadSheets();
				if(spreadSheets == null){
					System.out.println("null");
					Toast.makeText(getApplicationContext(), "NoSheet", Toast.LENGTH_LONG).show();
				}
				else{
				SpreadSheet sp = spreadSheets.get(0);
				workSheets = sp.getAllWorkSheets();
				int number = workSheets.size();
				for(int i=0; i<number; i++){
				if(workSheets.get(i).getTitle().equalsIgnoreCase("sequence")){
					wk = workSheets.get(i);
					cols = wk.getColumns();
					rows = wk.getData(false);
													
					if(rows == null || rows.size() == 0){
						System.out.println("null rows");
					}
					if(cols != null){
					}
					for(int i1=0; i1<rows.size(); i1++){
						WorkSheetRow row = rows.get(i1);
						ArrayList<WorkSheetCell> cells = row.getCells();
						
						for(int j1=0; j1<cells.size(); j1++){
							WorkSheetCell cell = cells.get(j1);
							aryNumbers[i1][j1]=cell.getValue();
						}
						i3++;
					}
					
					
				}
				
				}
				}
				Intent intent=new Intent(Home.this.getApplicationContext(),Retrive2.class);
				MyParcelable myParcelable = new MyParcelable();
				myParcelable.setStrings(aryNumbers);
				intent.putExtra("parcel",myParcelable);
				intent.putExtra("row",i3);
				startActivity(intent);
				Home.this.finish();
				
				
				return null;
				
		}
		
		@Override
		protected void onPostExecute(Object result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(dialog.isShowing())
				dialog.cancel();
			
		    
		}

	}
	public boolean isOnline() {
        ConnectivityManager cm =
            (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
	
	
	 private class MyTask4 extends AsyncTask{

			Dialog dialog;
			
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				dialog = new Dialog(Home.this);
				dialog.setTitle("Please wait");
				TextView tv = new TextView(Home.this.getApplicationContext());
				tv.setText("Uploading Data to SpreadSheet...");
				dialog.setContentView(tv);
				dialog.show();
			}

			@Override
			protected Object doInBackground(Object... params) {

				   SpreadSheetFactory factory = SpreadSheetFactory.getInstance("gla.microbio@gmail.com","AndroidMicro");
					spreadSheets = factory.getAllSpreadSheets();
					if(spreadSheets == null){
						System.out.println("null");
						Toast.makeText(getApplicationContext(), "NoSheet", Toast.LENGTH_LONG).show();
					}
					else{
					SpreadSheet sp = spreadSheets.get(0);
					workSheets = sp.getAllWorkSheets();
					int number = workSheets.size();
					for(int i=0; i<number; i++){
					if(workSheets.get(i).getTitle().equalsIgnoreCase("sequence")){
						wk = workSheets.get(i);

					Record record=new Record();

					for(int b=0;b<r;b++){
					
					record.addData("extractedsample",string1[b]);
					record.addData("primerpair",string2[b]);
					record.addData("dateofinput",string3[b]);
					record.addData("successfull",string4[b]);
					record.addData("dateofsendtosequencing",string5[b]);
					record.addData("username", user_name);
					wk.addListRow(record.getData());
						}
//					Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
					}
					}
					}
					return null;
			}
			
			@Override
			protected void onPostExecute(Object result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				if(dialog.isShowing())
					dialog.cancel();
				 mySQLiteAdapter = new SQLiteAdapter2(Home.this);
					mySQLiteAdapter.openToWrite();
					mySQLiteAdapter.deleteAll();
					mySQLiteAdapter.close();
					Home.this.deleteDatabase("micro2");

					Toast.makeText(Home.this.getApplicationContext(), "Inserted Succesfully", Toast.LENGTH_LONG).show();
					
			
			    
			}


}
	 
	 private class MyTask2 extends AsyncTask{

			Dialog dialog;
			
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				dialog = new Dialog(Home.this);
				dialog.setTitle("Please wait");
				TextView tv = new TextView(Home.this.getApplicationContext());
				tv.setText("Uploading Data to SpreadSheet...");
				dialog.setContentView(tv);
				dialog.show();
			}

			@Override
			protected Object doInBackground(Object... params) {

				   SpreadSheetFactory factory = SpreadSheetFactory.getInstance("gla.microbio@gmail.com","AndroidMicro");
					spreadSheets = factory.getAllSpreadSheets();
					if(spreadSheets == null){
						System.out.println("null");
						Toast.makeText(getApplicationContext(), "NoSheet", Toast.LENGTH_LONG).show();
					}
					else{
					SpreadSheet sp = spreadSheets.get(0);
					workSheets = sp.getAllWorkSheets();
					int number = workSheets.size();
					for(int i=0; i<number; i++){
					if(workSheets.get(i).getTitle().equalsIgnoreCase("extraction")){
						wk = workSheets.get(i);

					Record record=new Record();

					for(int b=0;b<r1;b++){
					
					record.addData("specimencode",string11[b]);
					record.addData("extractioncode",string21[b]);
					record.addData("notes",string31[b]);
					record.addData("datesextracted",string41[b]);
					record.addData("user",string51[b]);
					record.addData("boxno",string61[b]);
					record.addData("boxrow",string71[b]);
					record.addData("boxcolumn",string81[b]);
					record.addData("username", user_name);
					wk.addListRow(record.getData());
						}
//					Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
					}
					}
					}
					return null;
			}
			
			@Override
			protected void onPostExecute(Object result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				if(dialog.isShowing())
					dialog.cancel();
				Toast.makeText(Home.this.getApplicationContext(), "Please Wait.....", Toast.LENGTH_LONG).show();
				 mySQLiteAdapter1 = new SQLiteAdapter1(Home.this);
					mySQLiteAdapter1.openToWrite();
					mySQLiteAdapter1.deleteAll();
					mySQLiteAdapter1.close();
					Home.this.deleteDatabase("micro1");

					runOnUiThread(new Runnable(){
				        	public void run(){
				        		new MyTask4().execute(null);
				        	}
				        });
					
				
			    
			}


}

	 
	 private class MyTask extends AsyncTask{

			Dialog dialog;
			
			@Override
			protected void onPreExecute() {
				// TODO Auto-generated method stub
				super.onPreExecute();
				dialog = new Dialog(Home.this);
				dialog.setTitle("Please wait");
				TextView tv = new TextView(Home.this.getApplicationContext());
				tv.setText("Uploading Data to SpreadSheet...");
				dialog.setContentView(tv);
				dialog.show();
			}

			@Override
			protected Object doInBackground(Object... params) {

				   SpreadSheetFactory factory = SpreadSheetFactory.getInstance("gla.microbio@gmail.com","AndroidMicro");
					spreadSheets = factory.getAllSpreadSheets();
					if(spreadSheets == null){
						System.out.println("null");
						Toast.makeText(getApplicationContext(), "NoSheet", Toast.LENGTH_LONG).show();
					}
					else{
					SpreadSheet sp = spreadSheets.get(0);
					workSheets = sp.getAllWorkSheets();
					int number = workSheets.size();
					for(int i=0; i<number; i++){
					if(workSheets.get(i).getTitle().equalsIgnoreCase("collection")){
						wk = workSheets.get(i);

					Record record=new Record();

					for(int b=0;b<d1;b++){
					
					record.addData("specimencode",data1[b]);
					record.addData("genus",data2[b]);
					record.addData("specimenname",data3[b]);
					record.addData("authority",data4[b]);
					record.addData("boxno",data5[b]);
					record.addData("boxrow",data6[b]);
					record.addData("boxcolumn",data7[b]);
					record.addData("hostgenus",data8[b]);
					record.addData("hostspecimen",data9[b]);
					record.addData("locality",data10[b]);
					record.addData("latitude",data11[b]);
					record.addData("longitude",data12[b]);
					record.addData("district",data13[b]);
					record.addData("province",data14[b]);
					record.addData("country",data15[b]);
					record.addData("determinedby",data16[b]);
					record.addData("collectedby",data17[b]);
					record.addData("datacollected",data18[b]);
					record.addData("collectionnotes",data19[b]);
					record.addData("notes",data20[b]);
					record.addData("abundance",data21[b]);
					record.addData("comment",data22[b]);
					record.addData("timestamp",data23[b]);
					record.addData("username", user_name);
					wk.addListRow(record.getData());
						}
//					Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
					}
					}
					}
					return null;
			}
			
			@Override
			protected void onPostExecute(Object result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result);
				if(dialog.isShowing())
					dialog.cancel();
				Toast.makeText(Home.this.getApplicationContext(), "Please Wait...", Toast.LENGTH_LONG).show();
				  
		        mySQLiteAdapter0 = new SQLiteAdapter(Home.this);
				mySQLiteAdapter0.openToWrite();
				mySQLiteAdapter0.deleteAll();
				mySQLiteAdapter0.close();
				Home.this.deleteDatabase("micro");

				runOnUiThread(new Runnable(){
			        	public void run(){
			        		new MyTask2().execute(null);
			        	}
			        });
				
			}


} 
	
}
