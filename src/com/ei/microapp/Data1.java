package com.ei.microapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.ei.SpreadSheet;
import com.ei.SpreadSheetFactory;
import com.ei.WorkSheet;
import com.ei.WorkSheetCell;
import com.ei.WorkSheetRow;
import com.ei.table.Record;

import android.app.Activity;
import android.app.AlertDialog;
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
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Data1 extends Activity{
	private SQLiteAdapter mySQLiteAdapter;
	private EditText genus;
	private EditText specimenname;
	private EditText authority;
	private EditText boxno;
	private EditText boxrow;
	private EditText boxcolumn;
	private EditText hostgenus;
	private EditText hostspecimen;
	private EditText locality;
	@Override
	public void onBackPressed() {
	
	}

	private EditText latitude;
	private EditText longitude;
	private EditText district;
	private EditText province;
	private EditText country;
	private EditText determinedby;
	private EditText collectedby;
	private EditText datacollected;
	private EditText collectionnotes;
	private EditText notes;
	private EditText stagesex;
	private EditText abundance;
	private EditText comment;
	private Button generate;
	private ScrollView sv;
	private ArrayList<SpreadSheet> spreadSheets;	
	int spID = -1;
	private ArrayList<WorkSheet> workSheets;
	private WorkSheet wk;
	protected String genus1;
	protected String specimenname1;
	protected String authority1;
	protected String boxno1;
	protected String boxrow1;
	protected String boxcolumn1;
	protected String hostgenus1;
	protected String hostspecimen1;
	protected String locality1;
	protected String latitude1;
	protected String longitude1;
	protected String district1;
	protected String province1;
	protected String country1;
	protected String determinedby1;
	protected String collectedby1;
	protected String datacollected1;
	protected String collectionnotes1;
	protected String notes1;
	protected String stagesex1;
	protected String abundance1;
	protected String comment1;
	protected String generate1;
	private  String user_name="null";
	private SimpleDateFormat dateFormat;
	protected String d;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.data1);
		Button clear=(Button)findViewById(R.id.d1clear);
		Button save=(Button)findViewById(R.id.d1save);
		Button submit=(Button)findViewById(R.id.d1submit);
		Button find=(Button)findViewById(R.id.d1find);
		Button next=(Button)findViewById(R.id.d1next);
		ImageButton img2next=(ImageButton)findViewById(R.id.step2btn1);
		ImageButton img4next=(ImageButton)findViewById(R.id.step4btn1);
		sv=(ScrollView)findViewById(R.id.sv);
		sv.setVerticalScrollBarEnabled(false); 
		sv.setHorizontalScrollBarEnabled(false);
	    generate=(Button)findViewById(R.id.d1gen);
		genus=(EditText)findViewById(R.id.editText1);
		 specimenname=(EditText)findViewById(R.id.editText2);
		 authority=(EditText)findViewById(R.id.editText21);
		 boxno=(EditText)findViewById(R.id.editText3);
		 boxrow=(EditText)findViewById(R.id.editText4);
		 boxcolumn=(EditText)findViewById(R.id.editText5);
		 hostgenus=(EditText)findViewById(R.id.editText6);
		 hostspecimen=(EditText)findViewById(R.id.editText7);
		 locality=(EditText)findViewById(R.id.editText8);
		 latitude=(EditText)findViewById(R.id.editText9);
		 longitude=(EditText)findViewById(R.id.editText10);
		 district=(EditText)findViewById(R.id.editText11);
		 province=(EditText)findViewById(R.id.editText12);
		 country=(EditText)findViewById(R.id.editText13);
		 determinedby=(EditText)findViewById(R.id.editText14);
		 collectedby=(EditText)findViewById(R.id.editText15);
		 datacollected=(EditText)findViewById(R.id.editText16);
		 collectionnotes=(EditText)findViewById(R.id.editText17);
		 notes=(EditText)findViewById(R.id.editText18);
		 stagesex=(EditText)findViewById(R.id.editText19);
		 abundance=(EditText)findViewById(R.id.editText20);
		 comment=(EditText)findViewById(R.id.editText22);
		 dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        final Date date = new Date();
		 SQLiteAdapterName user=new SQLiteAdapterName(getApplicationContext());
		 user.openToRead();
		 user_name=user.queueAll().trim();
		 user.close();
			Button home=(Button)findViewById(R.id.d1home);
		 home.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent intent=new Intent(getApplicationContext(), Home.class);
			startActivity(intent);
			}
		});
		 //shared preference is used to store data on that page
		 save.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				SharedPreferences.Editor editor = getPreferences(0).edit();
				String s=generate.getText().toString();
				editor.putString("Name", s);
				String s1=genus.getText().toString();
				editor.putString("Name1", s1);
				String s2=specimenname.getText().toString();
				editor.putString("Name2", s2);
				String s3=authority.getText().toString();
				editor.putString("Name3", s3);
				String s4=boxno.getText().toString();
				editor.putString("Name4", s4);
				String s5=boxrow.getText().toString();
				editor.putString("Name5", s5);
				String s6=boxcolumn.getText().toString();
				editor.putString("Name6", s6);
				String s7=hostgenus.getText().toString();
				editor.putString("Name7", s7);
				String s8=hostspecimen.getText().toString();
				editor.putString("Name8", s8);
				String s9=locality.getText().toString();
				editor.putString("Name9", s9);
				String s10=latitude.getText().toString();
				editor.putString("Name10", s10);
				String s11=longitude.getText().toString();
				editor.putString("Name11", s11);
				String s12=district.getText().toString();
				editor.putString("Name12", s12);
				String s13=province.getText().toString();
				editor.putString("Name13", s13);
				String s14=country.getText().toString();
				editor.putString("Name14", s14);
				String s15=determinedby.getText().toString();
				editor.putString("Name15", s15);
				String s16=collectedby.getText().toString();
				editor.putString("Name16", s16);
				String s17=datacollected.getText().toString();
				editor.putString("Name17", s17);
				String s18=collectionnotes.getText().toString();
				editor.putString("Name18", s18);
				String s19=notes.getText().toString();
				editor.putString("Name19", s19);
				String s20=stagesex.getText().toString();
				editor.putString("Name20", s20);
				String s21=abundance.getText().toString();
				editor.putString("Name21", s21);
				String s22=comment.getText().toString();
				editor.putString("Name22", s22);
				editor.commit();
				
			}
		});
		 img2next.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  new AlertDialog.Builder(Data1.this)
				        .setIcon(android.R.drawable.ic_dialog_alert)
				        .setTitle("Step1 to Step2...")
				        .setMessage("Are you sure to continue...?")
				        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
				    {
				        public void onClick(DialogInterface dialog, int which) {
				        	Intent intent=new Intent(getApplicationContext(), Data2.class);
							startActivity(intent);
					        Data1.this.finish();
				            
				        }

				    })
				    .setNegativeButton("No", null)
				    .show();
					
					
				}
			});
			img4next.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					  new AlertDialog.Builder(Data1.this)
				        .setIcon(android.R.drawable.ic_dialog_alert)
				        .setTitle("Step1 to Step4...")
				        .setMessage("Are you sure to continue...?")
				        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
				    {
				        public void onClick(DialogInterface dialog, int which) {
				        	Intent intent=new Intent(getApplicationContext(), Data4.class);
							startActivity(intent);
					        Data1.this.finish();
				            
				        }

				    })
				    .setNegativeButton("No", null)
				    .show();
					
					
				}
			}); 
		 //go to find page
		 find.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(), Find1.class);
				startActivity(intent);
			}
		});
		 //go to next page
		next.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  new AlertDialog.Builder(Data1.this)
			        .setIcon(android.R.drawable.ic_dialog_alert)
			        .setTitle("Step1 to Step2...")
			        .setMessage("Are you sure to continue...?")
			        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
			    {
			        public void onClick(DialogInterface dialog, int which) {
			        	Intent intent=new Intent(getApplicationContext(), Data2.class);
						startActivity(intent);
				        Data1.this.finish();
			            
			        }

			    })
			    .setNegativeButton("No", null)
			    .show();
				
			}
		});
		
		//generate code to specimen code
		generate.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String n=generate.getText().toString();
				String g=genus.getText().toString();
				String sn=specimenname.getText().toString();
			if(n.equalsIgnoreCase("generate")){
				if((!g.isEmpty()) && (!sn.isEmpty())){
					String gen=g.substring(0,2);
					String spes=sn.substring(0,2);
					Random generator = new Random();  
					generator.setSeed(System.currentTimeMillis());  
					   
					int num = generator.nextInt(999) + 99;  
					if (num < 100 || num > 999) {  
					num = generator.nextInt(999) + 99;  
					if (num < 100 || num > 999) {  
					try {
						throw new Exception("Unable to generate PIN at this time..");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					}  
					}  
					System.out.println(gen+spes+num);
					String nnn=gen+spes+num;
					generate.setText(nnn);
					
				}else{
					Toast.makeText(Data1.this.getApplicationContext(), "fill genus and specimencode", Toast.LENGTH_LONG).show();
				}
			}
			else{
				Toast.makeText(Data1.this.getApplicationContext(), "allready generated", Toast.LENGTH_LONG).show();
				
			}
			}
		});
		
		//clear all the fields in that page
		clear.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				((EditText) findViewById(R.id.editText1)).setText("");
				((Button) findViewById(R.id.d1gen)).setText("generate");
				((EditText) findViewById(R.id.editText2)).setText("");
				((EditText) findViewById(R.id.editText3)).setText("");
				((EditText) findViewById(R.id.editText4)).setText("");
				((EditText) findViewById(R.id.editText5)).setText("");
				((EditText) findViewById(R.id.editText6)).setText("");
				((EditText) findViewById(R.id.editText7)).setText("");
				((EditText) findViewById(R.id.editText8)).setText("");
				((EditText) findViewById(R.id.editText9)).setText("");
				((EditText) findViewById(R.id.editText10)).setText("");
				((EditText) findViewById(R.id.editText11)).setText("");
				((EditText) findViewById(R.id.editText12)).setText("");
				((EditText) findViewById(R.id.editText13)).setText("");
				((EditText) findViewById(R.id.editText14)).setText("");
				((EditText) findViewById(R.id.editText15)).setText("");
				((EditText) findViewById(R.id.editText16)).setText("");
				((EditText) findViewById(R.id.editText17)).setText("");
				((EditText) findViewById(R.id.editText18)).setText("");
				((EditText) findViewById(R.id.editText19)).setText("");
				((EditText) findViewById(R.id.editText20)).setText("");
				((EditText) findViewById(R.id.editText21)).setText("");
				((EditText) findViewById(R.id.editText22)).setText("");
				
				SharedPreferences.Editor editor = getPreferences(0).edit();
				String s=generate.getText().toString();
				editor.putString("Name", s);
				String s1=genus.getText().toString();
				editor.putString("Name1", s1);
				String s2=specimenname.getText().toString();
				editor.putString("Name2", s2);
				String s3=authority.getText().toString();
				editor.putString("Name3", s3);
				String s4=boxno.getText().toString();
				editor.putString("Name4", s4);
				String s5=boxrow.getText().toString();
				editor.putString("Name5", s5);
				String s6=boxcolumn.getText().toString();
				editor.putString("Name6", s6);
				String s7=hostgenus.getText().toString();
				editor.putString("Name7", s7);
				String s8=hostspecimen.getText().toString();
				editor.putString("Name8", s8);
				String s9=locality.getText().toString();
				editor.putString("Name9", s9);
				String s10=latitude.getText().toString();
				editor.putString("Name10", s10);
				String s11=longitude.getText().toString();
				editor.putString("Name11", s11);
				String s12=district.getText().toString();
				editor.putString("Name12", s12);
				String s13=province.getText().toString();
				editor.putString("Name13", s13);
				String s14=country.getText().toString();
				editor.putString("Name14", s14);
				String s15=determinedby.getText().toString();
				editor.putString("Name15", s15);
				String s16=collectedby.getText().toString();
				editor.putString("Name16", s16);
				String s17=datacollected.getText().toString();
				editor.putString("Name17", s17);
				String s18=collectionnotes.getText().toString();
				editor.putString("Name18", s18);
				String s19=notes.getText().toString();
				editor.putString("Name19", s19);
				String s20=stagesex.getText().toString();
				editor.putString("Name20", s20);
				String s21=abundance.getText().toString();
				editor.putString("Name21", s21);
				String s22=comment.getText().toString();
				editor.putString("Name22", s22);
				editor.commit();
				

			}
		});
		
		//send data to spreadsheet to upload
		submit.setOnClickListener(new OnClickListener() {
			
		

			public void onClick(View v) {
				 d=dateFormat.format(date).toString();
				 System.out.println(d);
				// TODO Auto-generated method stub
				genus1 =genus.getText().toString();
				specimenname1= specimenname.getText().toString().trim();
				authority1 =authority.getText().toString().trim();
				boxno1= boxno.getText().toString().trim();
				boxrow1= boxrow.getText().toString().trim();
				boxcolumn1= boxcolumn.getText().toString().trim();
				hostgenus1 =hostgenus.getText().toString().trim();
				hostspecimen1= hostspecimen.getText().toString().trim();
				locality1= locality.getText().toString().trim();
				latitude1 =latitude.getText().toString().trim();
				longitude1 =longitude.getText().toString().trim();
				district1 =district.getText().toString().trim();
				province1 =province.getText().toString().trim();
				country1 =country.getText().toString().trim();
				determinedby1= determinedby.getText().toString().trim();
				collectedby1 =collectedby.getText().toString().trim();
				datacollected1= datacollected.getText().toString().trim();
				collectionnotes1= collectionnotes.getText().toString().trim();
				notes1= notes.getText().toString().trim();
				stagesex1= stagesex.getText().toString().trim();
				abundance1= abundance.getText().toString().trim();
				comment1 =comment.getText().toString().trim();
				generate1 =generate.getText().toString().trim();
				if(!genus1.isEmpty()){
					if(!specimenname1.isEmpty()){
					if(authority1.isEmpty()){
						authority1="null";}
					if(boxno1.isEmpty()){
						boxno1="null";}
					if(boxrow1.isEmpty()){
						boxrow1="null";}
					if(boxcolumn1.isEmpty()){
						boxcolumn1="null";}
					if(hostgenus1.isEmpty()){
						hostgenus1="null";}
					if(hostspecimen1.isEmpty()){
						hostspecimen1="null";}
					if(locality1.isEmpty()){
						locality1="null";}
					if(latitude1.isEmpty()){
						latitude1="null";}
					if(longitude1.isEmpty()){
						longitude1="null";}
					if(district1.isEmpty()){
						district1="null";}
					if(province1.isEmpty()){
						province1="null";}
					if(country1.isEmpty()){
						country1="null";}
					if(determinedby1.isEmpty()){
						determinedby1="null";}
					if(collectedby1.isEmpty()){
						collectedby1="null";}
					if(datacollected1.isEmpty()){
						datacollected1="null";}
					if(collectionnotes1.isEmpty()){
						collectionnotes1="null";}
					if(notes1.isEmpty()){
						notes1="null";}
					if(stagesex1.isEmpty()){
						stagesex1="null";}
					if(abundance1.isEmpty()){
						abundance1="null";
					}
					if(comment1.isEmpty()){
						comment1="null";
					}
					if((!generate1.isEmpty())&&(!(generate1.equalsIgnoreCase("generate")))){
						
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
							
							mySQLiteAdapter = new SQLiteAdapter(Data1.this);
							mySQLiteAdapter.openToWrite();
							mySQLiteAdapter.insert(generate1, genus1, specimenname1, authority1, boxno1, boxrow1, boxcolumn1, hostgenus1, hostspecimen1, locality1, latitude1, longitude1, district1, province1, country1, determinedby1, collectedby1, datacollected1, collectionnotes1, notes1, stagesex1, abundance1, comment1,d);
							mySQLiteAdapter.close();
							Toast.makeText(getApplicationContext(), "No Internet Connection Store in offline",Toast.LENGTH_LONG).show();
						}
				
					}
					}else{
						Toast.makeText(getApplicationContext(), "Please generate specimencode",Toast.LENGTH_LONG).show();
						
					}
					}else{
						Toast.makeText(getApplicationContext(), "Please generate specimencode",Toast.LENGTH_LONG).show();
						
					}
				
			}
		});
	}
	

	
	//check connection upload data
	private class MyTask extends AsyncTask{

		Dialog dialog;
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			dialog = new Dialog(Data1.this);
			dialog.setTitle("Please wait");
			TextView tv = new TextView(Data1.this.getApplicationContext());
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
				record.addData("timestamp", d);
				record.addData("genus", genus1);
				record.addData("specimenname", specimenname1);
				record.addData("authority", authority1);
				record.addData("boxno", boxno1);
				record.addData("boxrow", boxrow1);
				record.addData("boxcolumn", boxcolumn1);
				record.addData("hostgenus", hostgenus1);
				record.addData("hostspecimen", hostspecimen1);
				record.addData("locality", locality1);
				record.addData("latitude", latitude1);
				record.addData("longitude", longitude1);
				record.addData("district", district1);
				record.addData("province", province1);
				record.addData("country", country1);
				record.addData("determinedby", determinedby1);
				record.addData("collectedby", collectedby1);
				record.addData("datacollected", datacollected1);
				record.addData("collectionnotes", collectionnotes1);
				record.addData("notes", notes1);
				record.addData("stagesex", stagesex1);
				record.addData("abundance", abundance1);
				record.addData("comment", comment1);
				record.addData("specimencode", generate1);
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
		String s=prefs.getString("Name","generate");
		generate.setText(s);
		String s1=prefs.getString("Name1","");
		genus.setText(s1);
		String s2=prefs.getString("Name2","");
		specimenname.setText(s2);
		String s3=prefs.getString("Name3","");
		authority.setText(s3);
		String s4=prefs.getString("Name4","");
		boxno.setText(s4);
		String s5=prefs.getString("Name5","");
		boxrow.setText(s5);
		String s6=prefs.getString("Name6","");
		boxcolumn.setText(s6);
		String s7=prefs.getString("Name7","");
		hostgenus.setText(s7);
		String s8=prefs.getString("Name8","");
		hostspecimen.setText(s8);
		String s9=prefs.getString("Name9","");
		locality.setText(s9);
		String s10=prefs.getString("Name10","");
		latitude.setText(s10);
		String s11=prefs.getString("Name11","");
		longitude.setText(s11);
		String s12=prefs.getString("Name12","");
		district.setText(s12);
		String s13=prefs.getString("Name13","");
		province.setText(s13);
		String s14=prefs.getString("Name14","");
		country.setText(s14);
		String s15=prefs.getString("Name15","");
		determinedby.setText(s15);
		String s16=prefs.getString("Name16","");
		collectedby.setText(s16);
		String s17=prefs.getString("Name17","");
		datacollected.setText(s17);
		String s18=prefs.getString("Name18","");
		collectionnotes.setText(s18);
		String s19=prefs.getString("Name19","");
		notes.setText(s19);
		String s20=prefs.getString("Name20","");
		stagesex.setText(s20);
		String s21=prefs.getString("Name21","");
		abundance.setText(s21);
		String s22=prefs.getString("Name22","");
		comment.setText(s22);

		
		
	}
	
}
