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

public class Data4 extends Activity{
	@Override
	public void onBackPressed() {
		
	}
	private SQLiteAdapter2 mySQLiteAdapter;
	private ArrayList<SpreadSheet> spreadSheets;	
	int spID = -1;
	private ArrayList<WorkSheet> workSheets;
	private WorkSheet wk;
	private Button date1;
	private Button date2; 
	private int pYear;
    private int pMonth;
    private int pDay;
    private int pYear1;
    private int pMonth1;
    private int pDay1;
	private ToggleButton tbtn;
	private EditText extractedsample;
	private EditText primerpair;
	private EditText successfull;
	protected String extractedsample1;
	protected String primerpair1;
	protected String successfull1;
	protected String dateofinput;
	protected String dateofsendtosequence;
	private ScrollView sv;
    /** This integer will uniquely define the dialog to be used for displaying date picker.*/
    static final int DATE_DIALOG_ID = 0;
	private String user_name="null";
	static final int DATE_DIALOG1_ID=1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.data4);
		sv=(ScrollView)findViewById(R.id.sv4);
		sv.setVerticalScrollBarEnabled(false); 
		sv.setHorizontalScrollBarEnabled(false);
		 extractedsample=(EditText)findViewById(R.id.d4et1);
		 primerpair=(EditText)findViewById(R.id.d4et2);
		 date1=(Button)findViewById(R.id.d4date1);
		 successfull=(EditText)findViewById(R.id.d4et4);
		 date2=(Button)findViewById(R.id.d4date2);
		 ImageButton img1next=(ImageButton)findViewById(R.id.step1btn4);
		 ImageButton img2next=(ImageButton)findViewById(R.id.step2btn4);
		 
		 tbtn=(ToggleButton)findViewById(R.id.d4toggleButton1);
		Button clear=(Button)findViewById(R.id.d4clear);
		Button submit=(Button)findViewById(R.id.d4submit);
		Button find=(Button)findViewById(R.id.d4find);
		Button step1=(Button)findViewById(R.id.d4step1);
		Button save=(Button)findViewById(R.id.d4save);
		Button home=(Button)findViewById(R.id.d4home);
		  SQLiteAdapterName use=new SQLiteAdapterName(getApplicationContext());
			 use.openToRead();
			 user_name=use.queueAll().trim();
			 use.close();  
		 final Calendar cal = Calendar.getInstance();
	        pYear = cal.get(Calendar.YEAR);
	        pMonth = cal.get(Calendar.MONTH);
	        pDay = cal.get(Calendar.DAY_OF_MONTH);
	        pYear1 = cal.get(Calendar.YEAR);
	        pMonth1 = cal.get(Calendar.MONTH);
	        pDay1 = cal.get(Calendar.DAY_OF_MONTH);
	        //save to shared preference
	        save.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					SharedPreferences.Editor editor = getPreferences(0).edit();
					String s=extractedsample.getText().toString();
					editor.putString("Name", s);
					String s1=primerpair.getText().toString();
					editor.putString("Name1", s1);
					String s2=date1.getText().toString();
					editor.putString("Name2", s2);
					String s3=successfull.getText().toString();
					editor.putString("Name3", s3);
					String s4=date2.getText().toString();
					editor.putString("Name4", s4);
					String s5=tbtn.getText().toString();
					editor.putString("Name5", s5);
					editor.commit();
				}
			});
	        //go to home page
	        home.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(getApplicationContext(), Home.class);
					startActivity(intent);
				}
			});
	     
	        img1next.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  new AlertDialog.Builder(Data4.this)
				        .setIcon(android.R.drawable.ic_dialog_alert)
				        .setTitle("Step4 to Step1...")
				        .setMessage("Are you sure to continue...?")
				        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
				    {
				        public void onClick(DialogInterface dialog, int which) {
				        	Intent intent=new Intent(getApplicationContext(), Data1.class);
							startActivity(intent);
					        Data4.this.finish();
				            
				        }

				    })
				    .setNegativeButton("No", null)
				    .show();
				}
			});
			 img2next.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  new AlertDialog.Builder(Data4.this)
				        .setIcon(android.R.drawable.ic_dialog_alert)
				        .setTitle("Step4 to Step2...")
				        .setMessage("Are you sure to continue...?")
				        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
				    {
				        public void onClick(DialogInterface dialog, int which) {
				        	Intent intent=new Intent(getApplicationContext(), Data2.class);
							startActivity(intent);
					        Data4.this.finish();
				            
				        }

				    })
				    .setNegativeButton("No", null)
				    .show();	
				}
			});
	        
	        
	        
	        //perform when toggle btn is clicked
	      tbtn.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				 if (tbtn.isChecked()) {
					  date2.setText(
					            new StringBuilder()
					                    // Month is 0 based so add 1
					                    .append(pDay1).append("/")
					                    .append(pMonth1 + 1).append("/")
					                    .append(pYear1).append(" "));
			        } else {
			            
			        }
				
			}
		})  ;
		date1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
		date2.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 if (tbtn.isChecked()) {
					 Toast.makeText(getApplicationContext(), "Turn off Send To Sequencing", Toast.LENGTH_LONG).show();
				 }
				 else{
				showDialog(DATE_DIALOG1_ID);
				 }
			}
		});
		step1.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				  new AlertDialog.Builder(Data4.this)
			        .setIcon(android.R.drawable.ic_dialog_alert)
			        .setTitle("Step4 to Step2...")
			        .setMessage("Are you sure to continue...?")
			        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
			    {
			        public void onClick(DialogInterface dialog, int which) {
			        	Intent intent=new Intent(getApplicationContext(), Data2.class);
						startActivity(intent);
				        Data4.this.finish();
			            
			        }

			    })
			    .setNegativeButton("No", null)
			    .show();
				
			}
		});
		//clear all fields in that page
		clear.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((EditText) findViewById(R.id.d4et1)).setText("");
				((EditText) findViewById(R.id.d4et2)).setText("");
				((Button) findViewById(R.id.d4date1)).setText("DD/MM/YY");
				((Button) findViewById(R.id.d4date2)).setText("DD/MM/YY");
				((EditText) findViewById(R.id.d4et4)).setText("");
				
				SharedPreferences.Editor editor = getPreferences(0).edit();
				String s=extractedsample.getText().toString();
				editor.putString("Name", s);
				String s1=primerpair.getText().toString();
				editor.putString("Name1", s1);
				String s2=date1.getText().toString();
				editor.putString("Name2", s2);
				String s3=successfull.getText().toString();
				editor.putString("Name3", s3);
				String s4=date2.getText().toString();
				editor.putString("Name4", s4);
				String s5=tbtn.getText().toString();
				editor.putString("Name5", s5);
				editor.commit();
			}
		});
		//go to find page
		find.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(getApplicationContext(), Find1.class);
				startActivity(intent);
			}
		});
		//upload data to spreadsheet
		submit.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				extractedsample1=extractedsample.getText().toString().trim();
				primerpair1=primerpair.getText().toString().trim();
				successfull1=successfull.getText().toString().trim();
				dateofinput=date1.getText().toString().trim();
				dateofsendtosequence=date2.getText().toString().trim();
				if(!extractedsample1.isEmpty()){
					if(!primerpair1.isEmpty()){
						if(!successfull1.isEmpty()){
							if((!dateofinput.isEmpty())&&(!dateofinput.equalsIgnoreCase("DD/MM/YY"))){
								if((!dateofsendtosequence.isEmpty())&&(!dateofsendtosequence.equalsIgnoreCase("DD/MM/YY"))){
									 
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
										mySQLiteAdapter = new SQLiteAdapter2(Data4.this);
									mySQLiteAdapter.openToWrite();
									mySQLiteAdapter.insert(extractedsample1, primerpair1, dateofinput, successfull1, dateofsendtosequence);
//									mySQLiteAdapter.insert(specimencode1, extractioncode1, notes1, date11, user1, boxno1, boxrow1, boxcolumn1);
//									mySQLiteAdapter.insert(generate1, genus1, specimenname1, authority1, boxno1, boxrow1, boxcolumn1, hostgenus1, hostspecimen1, locality1, latitude1, longitude1, district1, province1, country1, determinedby1, collectedby1, datacollected1, collectionnotes1, notes1, stagesex1, abundance1, comment1);
									mySQLiteAdapter.close();
									
									Toast.makeText(getApplicationContext(), "No Internet Connection Store In Offline",Toast.LENGTH_LONG).show();
								}
									}else{
									Toast.makeText(Data4.this.getApplicationContext(), "Select Date", Toast.LENGTH_LONG).show();
									
								}
							}else{
								Toast.makeText(Data4.this.getApplicationContext(), "Select Date", Toast.LENGTH_LONG).show();
								
							}
						}else{
							Toast.makeText(Data4.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
							
						}
					}else{
						Toast.makeText(Data4.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
						
					}
				}else{
					Toast.makeText(Data4.this.getApplicationContext(), "Enter The Required Field", Toast.LENGTH_LONG).show();
					
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
            
            private DatePickerDialog.OnDateSetListener pDateSetListener1 =
                    new DatePickerDialog.OnDateSetListener() {
         
                        public void onDateSet(DatePicker view, int year, 
                                              int monthOfYear, int dayOfMonth) {
                            pYear = year;
                            pMonth = monthOfYear;
                            pDay = dayOfMonth;
                            updateDisplay1();
//                            displayToast();
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
    private void updateDisplay1() {
        date2.setText(
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
		case DATE_DIALOG1_ID:
            return new DatePickerDialog(this, 
                        pDateSetListener1,
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
			dialog = new Dialog(Data4.this);
			dialog.setTitle("Please wait");
			TextView tv = new TextView(Data4.this.getApplicationContext());
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

				record.addData("extractedsample",extractedsample1);
				record.addData("primerpair",primerpair1);
				record.addData("dateofinput",dateofinput);
				record.addData("dateofsendtosequencing",dateofsendtosequence);
				record.addData("successfull",successfull1);
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
		extractedsample.setText(s);
		String s1=prefs.getString("Name1","");
		primerpair.setText(s1);
		String s2=prefs.getString("Name2","DD/MM/YY");
		date1.setText(s2);
		String s3=prefs.getString("Name3","");
		successfull.setText(s3);
		String s4=prefs.getString("Name4","DD/MM/YY");
		date2.setText(s4);
		String s5=prefs.getString("Name5","No");
		tbtn.setText(s5);
		
	}
}
