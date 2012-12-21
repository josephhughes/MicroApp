package com.ei.microapp;

import java.util.ArrayList;

import com.ei.SpreadSheet;
import com.ei.SpreadSheetFactory;
import com.ei.WorkSheet;
import com.ei.WorkSheetCell;
import com.ei.WorkSheetRow;
import android.app.Activity;
import android.app.Dialog;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Find1 extends Activity {

	@Override
	public void onBackPressed() {
		
	}
	private EditText specimencode;
	private EditText country;
	private EditText specimenname;
	private EditText genus;
	private String specimencode1;
	private String country1;
	private String specimenname1;
	private int i3=0;
	private String genus1;
	private String[ ][ ] aryNumbers = new String[100][100];
	private ArrayList<SpreadSheet> spreadSheets;	
	int spID = -1;
	private ArrayList<WorkSheet> workSheets;
	private WorkSheet wk;
	ArrayList<WorkSheetRow> rows;
	String[] cols;
	private Button clear;
	private Button home;
	private Button find;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.find1);
		specimencode=(EditText)findViewById(R.id.f1editText1);
		country=(EditText)findViewById(R.id.f1editText2);
		specimenname=(EditText)findViewById(R.id.f1editText3);
		genus=(EditText)findViewById(R.id.f1editText4);
		 clear=(Button)findViewById(R.id.f1clear);
		 home=(Button)findViewById(R.id.f1home);
		 find=(Button)findViewById(R.id.f1find);
		//move to find  page with result
		 
		clear.setOnClickListener(new OnClickListener()
		{
			
			public void onClick(View v)
			{
			getclear();
				
			}
		});
		
		
		//move to home page
		home.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), Home.class);
				startActivity(intent);	
			}
		});
		//
		find.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				specimencode1= specimencode.getText().toString().trim();
				country1 =country.getText().toString().trim();
				specimenname1= specimenname.getText().toString().trim();
				genus1= genus.getText().toString().trim();
				System.out.println(specimenname1+genus1);
				if(!specimencode1.isEmpty()){

					boolean answer;
					answer=isOnline();
					System.out.println(answer);

					if(answer)
					{
					runOnUiThread(new Runnable(){
				        	public void run(){
				        		new MyTask().execute(null);
				        	}
				        });
					}else
					{
						Toast.makeText(getApplicationContext(), "No Internet Connection",Toast.LENGTH_LONG).show();
					}
					System.out.println("specimencode"+specimencode1);
				}else if(!country1.isEmpty()){
					
					boolean answer;
					answer=isOnline();
					System.out.println(answer);

					if(answer)
					{
					runOnUiThread(new Runnable(){
				        	public void run(){
				        		new MyTask().execute(null);
				        	}
				        });
					
					
					}else
					{
						Toast.makeText(getApplicationContext(), "No Internet Connection",Toast.LENGTH_LONG).show();
					}
					
					System.out.println("country"+country1);
				}else if(!specimenname1.isEmpty()){
					

						System.out.println(specimenname1);
						boolean answer;
						answer=isOnline();
						System.out.println(answer);

						if(answer)
						{
						runOnUiThread(new Runnable(){
					        	public void run(){
					        		new MyTask().execute(null);
					        	}
					        });
						
						
						}else
						{
							Toast.makeText(getApplicationContext(), "No Internet Connection",Toast.LENGTH_LONG).show();
						}
						
						System.out.println("boxno"+specimenname1);
					
				}else if((!genus1.isEmpty())){

						System.out.println(genus1);
						boolean answer;
						answer=isOnline();
						System.out.println(answer);

						if(answer)
						{
						runOnUiThread(new Runnable(){
					        	public void run(){
					        		new MyTask().execute(null);
					        	}
					        });
						
						
						}else
						{
							Toast.makeText(getApplicationContext(), "No Internet Connection",Toast.LENGTH_LONG).show();
						}
						
						System.out.println("boxrow"+genus1);
					
				}else{
					Toast.makeText(Find1.this.getApplicationContext(), "Enter the required feilds", Toast.LENGTH_LONG).show();
					
				}
			}
		});
	}

	protected void getclear() 
	{
		// TODO Auto-generated method stub
		specimencode.setText("");
		country.setText("");
		specimenname.setText("");
		genus.setText("");
	}

	//connect and check data in spreadsheet
	private class MyTask extends AsyncTask{

		Dialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new Dialog(Find1.this);
			dialog.setTitle("Please wait");
			TextView tv = new TextView(Find1.this.getApplicationContext());
			tv.setText("Searching Data in SpreadSheet...");
			dialog.setContentView(tv);
			dialog.show();
		}

		@Override
		protected Object doInBackground(Object... params) {

			   SpreadSheetFactory factory = SpreadSheetFactory.getInstance("gla.microbio@gmail.com","AndroidMicro");
				spreadSheets = factory.getAllSpreadSheets();
				if(spreadSheets == null)
				{
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
					

									
					if(!specimencode1.isEmpty()){

						
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
								if(cell.getName().equalsIgnoreCase("specimencode")){
									if(cell.getValue().equalsIgnoreCase(specimencode1)){
										for(int j2=0; j2<cells.size(); j2++){
											WorkSheetCell cell1 = cells.get(j2);
											aryNumbers[i3][j2]=cell1.getValue();
											System.out.println(cell1.getValue());
											}
										i3++;
										}
									}
							}
						
						}
						System.out.println("specimencode"+specimencode1);
					
					
					}else if(!country1.isEmpty()){
						
						if(rows == null || rows.size() == 0){
							System.out.println("null rows");
						}
						if(cols != null){
						}
//						int i3=0;
						for(int i1=0; i1<rows.size(); i1++){
							WorkSheetRow row = rows.get(i1);
							ArrayList<WorkSheetCell> cells = row.getCells();
							
							for(int j1=0; j1<cells.size(); j1++){
								WorkSheetCell cell = cells.get(j1);
								if(cell.getName().equalsIgnoreCase("country")){
									if(cell.getValue().equalsIgnoreCase(country1)){
										for(int j2=0; j2<cells.size(); j2++){
											WorkSheetCell cell1 = cells.get(j2);
											aryNumbers[i3][j2]=cell1.getValue();
											System.out.println(cell1.getValue());	
										}
										i3++;
										}
									}
							}
							
						}
						System.out.println("country"+country1);
					}else if(!specimenname1.isEmpty()){
						
						if(rows == null || rows.size() == 0){
							System.out.println("null rows");
						}
						if(cols != null){
						}
//						int i3=0;
						for(int i1=0; i1<rows.size(); i1++){
							WorkSheetRow row = rows.get(i1);
							ArrayList<WorkSheetCell> cells = row.getCells();
							
							for(int j1=0; j1<cells.size(); j1++){
								WorkSheetCell cell = cells.get(j1);
								

//										if(cell.getName().equalsIgnoreCase("genus")){
//											if(cell.getValue().equalsIgnoreCase(genus1)){
//System.out.println("inside genus");

												if(cell.getName().equalsIgnoreCase("specimenname")){
													if(cell.getValue().equalsIgnoreCase(specimenname1)){
//														System.out.println("inside specie");
													for(int j2=0; j2<cells.size(); j2++){
														WorkSheetCell cell1 = cells.get(j2);
														aryNumbers[i3][j2]=cell1.getValue();
														System.out.println(cell1.getValue());	
														System.out.println("inside all");
													}
													i3++;
													}
												
//										}
//										}
									}
								
							}
							
						}

					}else if(!genus1.isEmpty()){
						
						if(rows == null || rows.size() == 0){
							System.out.println("null rows");
						}
						if(cols != null){
						}
//						int i3=0;
						for(int i1=0; i1<rows.size(); i1++){
							WorkSheetRow row = rows.get(i1);
							ArrayList<WorkSheetCell> cells = row.getCells();
							
							for(int j1=0; j1<cells.size(); j1++){
								WorkSheetCell cell = cells.get(j1);
								

										if(cell.getName().equalsIgnoreCase("genus")){
											if(cell.getValue().equalsIgnoreCase(genus1)){
System.out.println("inside genus");

//												if(cell.getName().equalsIgnoreCase("specimenname")){
//													if(cell.getValue().equalsIgnoreCase(specimenname1)){
//														System.out.println("inside specie");
													for(int j2=0; j2<cells.size(); j2++){
														WorkSheetCell cell1 = cells.get(j2);
														aryNumbers[i3][j2]=cell1.getValue();
														System.out.println(cell1.getValue());	
														System.out.println("inside all");
													}
													i3++;
													}
												
//										}
//										}
									}
								
							}
							
						}

					}
					
					
					
					
					
				}
				
				}
				}
				Intent intent=new Intent(Find1.this.getApplicationContext(),Find2.class);
				MyParcelable myParcelable = new MyParcelable();
				myParcelable.setStrings(aryNumbers);
				intent.putExtra("parcel",myParcelable);
				intent.putExtra("row",i3);
				startActivity(intent);
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
	
}
