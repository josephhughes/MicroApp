package com.ei.microapp;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.ei.SpreadSheet;
import com.ei.SpreadSheetFactory;
import com.ei.WorkSheet;
import com.ei.table.Record;

public class Data2 extends Activity{

	@Override
	public void onBackPressed() {
	
	}
	private ArrayList<SpreadSheet> spreadSheets;	
	private SQLiteAdapter1 mySQLiteAdapter;
	int spID = -1;
	private ArrayList<WorkSheet> workSheets;
	private WorkSheet wk;
	private Button date1;
    private int pYear;
    private int pMonth;
    private int pDay;
    private int pYear1;
    private int pMonth1;
    private int pDay1;
	private ToggleButton tgbtn;
	private EditText specimencode;
	private EditText extractioncode;
	private EditText notes;
	private EditText user;
	private EditText boxno;
	private EditText boxrow;
	private EditText boxcolumn;
	protected String specimencode1;
	protected String boxno1;
	protected String boxrow1;
	protected String boxcolumn1;
	protected String extractioncode1;
	protected String notes1;
	protected String user1;
	protected String date11;
	private ScrollView sv;
	private String user_name="null";
    /** This integer will uniquely define the dialog to be used for displaying date picker.*/
    static final int DATE_DIALOG_ID = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.data2);
		sv=(ScrollView)findViewById(R.id.sv2);
		sv.setVerticalScrollBarEnabled(false); 
		sv.setHorizontalScrollBarEnabled(false);
		Button step1=(Button)findViewById(R.id.d2step1);
		Button clear=(Button)findViewById(R.id.d2clear);
		Button submit=(Button)findViewById(R.id.d2submit);
		 specimencode=(EditText)findViewById(R.id.d2et1);
		 extractioncode=(EditText)findViewById(R.id.d2et2);
		 notes=(EditText)findViewById(R.id.d2et3);
		 date1=(Button)findViewById(R.id.d2date1);
		 tgbtn=(ToggleButton)findViewById(R.id.d2tbtn);
		 user=(EditText)findViewById(R.id.d2et5);
		 boxno=(EditText)findViewById(R.id.d2et6);
		 boxrow=(EditText)findViewById(R.id.d2et7);
		 boxcolumn=(EditText)findViewById(R.id.d2et8);
		Button find=(Button)findViewById(R.id.d2find);
		Button step4=(Button)findViewById(R.id.d2step4);
		Button save=(Button)findViewById(R.id.d2save);
		Button home=(Button)findViewById(R.id.d2Home);
		ImageButton img1next=(ImageButton)findViewById(R.id.step1btn2);
		ImageButton img4next=(ImageButton)findViewById(R.id.step4btn2);
		
		 final Calendar cal = Calendar.getInstance();
	        pYear = cal.get(Calendar.YEAR);
	        pMonth = cal.get(Calendar.MONTH);
	        pDay = cal.get(Calendar.DAY_OF_MONTH);
	        pYear1 = cal.get(Calendar.YEAR);
	        pMonth1 = cal.get(Calendar.MONTH);
	        pDay1 = cal.get(Calendar.DAY_OF_MONTH);
	        SQLiteAdapterName use=new SQLiteAdapterName(getApplicationContext());
			 use.openToRead();
			 user_name=use.queueAll().trim();
			 use.close();  
	        //move to home screen
	        home.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), Home.class);
				startActivity(intent);
				}
			});
	        //save to shared preference
	        save.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					SharedPreferences.Editor editor = getPreferences(0).edit();
					String s=specimencode.getText().toString();
					editor.putString("Name", s);
					String s1=extractioncode.getText().toString();
					editor.putString("Name1", s1);
					String s2=notes.getText().toString();
					editor.putString("Name2", s2);
					String s3=date1.getText().toString();
					editor.putString("Name3", s3);
					String s4=tgbtn.getText().toString();
					editor.putString("Name4", s4);
					String s5=user.getText().toString();
					editor.putString("Name5", s5);
					String s6=boxno.getText().toString();
					editor.putString("Name6", s6);
					String s7=boxrow.getText().toString();
					editor.putString("Name7", s7);
					String s8=boxcolumn.getText().toString();
					editor.putString("Name8", s8);
					editor.commit();
				}
			});
	        img1next.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  new AlertDialog.Builder(Data2.this)
				        .setIcon(android.R.drawable.ic_dialog_alert)
				        .setTitle("Step2 to Step1...")
				        .setMessage("Are you sure to continue...?")
				        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
				    {
				        public void onClick(DialogInterface dialog, int which) {
				        	Intent intent=new Intent(getApplicationContext(), Data1.class);
							startActivity(intent);
					        Data2.this.finish();
				            
				        }

				    })
				    .setNegativeButton("No", null)
				    .show();
					
				}
			});
			img4next.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  new AlertDialog.Builder(Data2.this)
				        .setIcon(android.R.drawable.ic_dialog_alert)
				        .setTitle("Step2 to Step4...")
				        .setMessage("Are you sure to continue...?")
				        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
				    {
				        public void onClick(DialogInterface dialog, int which) {
				        	Intent intent=new Intent(getApplicationContext(), Data4.class);
							startActivity(intent);
					        Data2.this.finish();
				            
				        }

				    })
				    .setNegativeButton("No", null)
				    .show();
					
				}
			});    
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        //toggle button action
	        tgbtn.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					 if (tgbtn.isChecked()) {
						  date1.setText(
						            new StringBuilder()
						                    // Month is 0 based so add 1
						                    .append(pDay1).append("/")
						                    .append(pMonth1 + 1).append("/")
						                    .append(pYear1).append(" "));
				        } else {
				            
				        }
				}
			});
	        //display date
		date1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 if (tgbtn.isChecked()) {
					 Toast.makeText(getApplicationContext(), "Turn off Send To Extraction", Toast.LENGTH_LONG).show();
				 }
				 else{
				showDialog(DATE_DIALOG_ID);
				 }
			}
		});
		//go to step1 page
		step1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				  new AlertDialog.Builder(Data2.this)
			        .setIcon(android.R.drawable.ic_dialog_alert)
			        .setTitle("Step2 to Step1...")
			        .setMessage("Are you sure to continue...?")
			        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
			    {
			        public void onClick(DialogInterface dialog, int which) {
			        	Intent intent=new Intent(getApplicationContext(), Data1.class);
						startActivity(intent);
				        Data2.this.finish();
			            
			        }

			    })
			    .setNegativeButton("No", null)
			    .show();
					
			}
		});
		//go to step4 page
		step4.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				  new AlertDialog.Builder(Data2.this)
			        .setIcon(android.R.drawable.ic_dialog_alert)
			        .setTitle("Step2 to Step4...")
			        .setMessage("Are you sure to continue...?")
			        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
			    {
			        public void onClick(DialogInterface dialog, int which) {
			        	Intent intent=new Intent(getApplicationContext(), Data4.class);
						startActivity(intent);
				        Data2.this.finish();
			            
			        }

			    })
			    .setNegativeButton("No", null)
			    .show();
				
			}
		});
		//go to find page
		find.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), Find1.class);
				startActivity(intent);
			}
		} );
		
		//clear all data in page
		clear.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((EditText) findViewById(R.id.d2et1)).setText("");
				((EditText) findViewById(R.id.d2et2)).setText("");
				((EditText) findViewById(R.id.d2et3)).setText("");
				((Button) findViewById(R.id.d2date1)).setText("DD/MM/YY");
				((EditText) findViewById(R.id.d2et5)).setText("");
				((EditText) findViewById(R.id.d2et6)).setText("");
				((EditText) findViewById(R.id.d2et7)).setText("");
				((EditText) findViewById(R.id.d2et8)).setText("");
				SharedPreferences.Editor editor = getPreferences(0).edit();
				String s=specimencode.getText().toString();
				editor.putString("Name", s);
				String s1=extractioncode.getText().toString();
				editor.putString("Name1", s1);
				String s2=notes.getText().toString();
				editor.putString("Name2", s2);
				String s3=date1.getText().toString();
				editor.putString("Name3", s3);
				String s4=tgbtn.getText().toString();
				editor.putString("Name4", s4);
				String s5=user.getText().toString();
				editor.putString("Name5", s5);
				String s6=boxno.getText().toString();
				editor.putString("Name6", s6);
				String s7=boxrow.getText().toString();
				editor.putString("Name7", s7);
				String s8=boxcolumn.getText().toString();
				editor.putString("Name8", s8);
				editor.commit();
			}
		});
		//check coonection and upload data
		submit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				specimencode1= specimencode.getText().toString().trim();
				extractioncode1=extractioncode.getText().toString().trim();
				notes1=notes.getText().toString().trim();
				user1=user.getText().toString().trim();
				date11=date1.getText().toString().trim();
				boxno1= boxno.getText().toString().trim();
				boxrow1= boxrow.getText().toString().trim();
				boxcolumn1= boxcolumn.getText().toString().trim();
				if(!specimencode1.isEmpty()){
					if(!extractioncode1.isEmpty()){
						if(!notes1.isEmpty()){
							if (!user1.isEmpty()) {
								if(!boxno1.isEmpty()){
									if(!boxrow1.isEmpty()){
										if(!boxcolumn1.isEmpty()){
											if((!date11.isEmpty())&&(!date11.equalsIgnoreCase("DD/MM/YY"))){
												
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
													mySQLiteAdapter = new SQLiteAdapter1(Data2.this);
													mySQLiteAdapter.openToWrite();
													mySQLiteAdapter.insert(specimencode1, extractioncode1, notes1, date11, user1, boxno1, boxrow1, boxcolumn1);
//													mySQLiteAdapter.insert(generate1, genus1, specimenname1, authority1, boxno1, boxrow1, boxcolumn1, hostgenus1, hostspecimen1, locality1, latitude1, longitude1, district1, province1, country1, determinedby1, collectedby1, datacollected1, collectionnotes1, notes1, stagesex1, abundance1, comment1);
													mySQLiteAdapter.close();
													
													Toast.makeText(getApplicationContext(), "No Internet Connection Store In Offline",Toast.LENGTH_LONG).show();
												}
												}else{
												Toast.makeText(Data2.this.getApplicationContext(), "Select Date", Toast.LENGTH_LONG).show();
												
											}
										}else{
											Toast.makeText(Data2.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
											
										}
									}else{
										Toast.makeText(Data2.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
										
									}
								}else{
									Toast.makeText(Data2.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
									
								}
							}else{
								Toast.makeText(Data2.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
								
							}
						}else{
							Toast.makeText(Data2.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
							
						}
					}else{
						Toast.makeText(Data2.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
						
					}
				}else{
					Toast.makeText(Data2.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
					
				}
			}
		});
		
		
		
	}
	 /** Callback received when the user "picks" a date in the dialog */
    private DatePickerDialog.OnDateSetListener pDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
 
                public void onDateSet(DatePicker view, int year, 
                                      int monthOfYear, int dayOfMonth) {
                    pYear = year;
                    pMonth = monthOfYear;
                    pDay = dayOfMonth;
                    updateDisplay();
//                    displayToast();
                }
            };
     
    /** Updates the date in the TextView */
    private void updateDisplay() {
        date1.setText(
            new StringBuilder()
                    // Month is 0 based so add 1
                    .append(pDay).append("/")
                    .append(pMonth + 1).append("/")
                    .append(pYear).append(" "));
    }
    /** Create a new dialog for date picker */
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_DIALOG_ID:
            return new DatePickerDialog(this, 
                        pDateSetListener,
                        pYear, pMonth, pDay);
        }
        return null;
    }
    
    private class MyTask extends AsyncTask{

		Dialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new Dialog(Data2.this);
			dialog.setTitle("Please wait");
			TextView tv = new TextView(Data2.this.getApplicationContext());
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

				record.addData("specimencode",specimencode1);
				record.addData("extractioncode", extractioncode1);
				record.addData("user", user1);
				record.addData("datesextracted",date11);
				record.addData("notes", notes1);
				record.addData("boxno", boxno1);
				record.addData("boxrow", boxrow1);
				record.addData("boxcolumn", boxcolumn1);
				record.addData("username", user_name);
				wk.addListRow(record.getData());

//				Toast.makeText(getApplicationContext(), "Inserted", Toast.LENGTH_LONG).show();
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
			Toast.makeText(getApplicationContext(), "Inserted Succesfully", Toast.LENGTH_LONG).show();
			
			
		    
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
    
    
    @Override
	protected void onResume() {
		
		super.onResume();
		SharedPreferences prefs = getPreferences(0);
		
		String s=prefs.getString("Name","");
		specimencode.setText(s);
		String s1=prefs.getString("Name1","");
		extractioncode.setText(s1);
		String s2=prefs.getString("Name2","");
		notes.setText(s2);
		String s3=prefs.getString("Name3","DD/MM/YY");
		date1.setText(s3);
		String s4=prefs.getString("Name4","No");
		tgbtn.setText(s4);
		String s5=prefs.getString("Name5","");
		user.setText(s5);
		String s6=prefs.getString("Name6","");
		boxno.setText(s6);
		String s7=prefs.getString("Name7","");
		boxrow.setText(s7);
		String s8=prefs.getString("Name8","");
		boxcolumn.setText(s8);
		
	}
}
