package com.ei.microapp;


import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Handler mHandler;
	private EditText name;
	protected String n;
	private int i=3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.main);
        //thread call the intent to move to next page
        SQLiteAdapterName myname=new SQLiteAdapterName(MainActivity.this);
        myname.openToRead();
        i=myname.getRowCount();
        System.out.println(i);
        myname.close();
        if(i==0)
        {
        	this.mHandler = new Handler();
     	    this.mHandler.postDelayed(m_Runnable1,3000);
        }
        else if(i==1)
        { this.mHandler = new Handler();
	    this.mHandler.postDelayed(m_Runnable,3000);
        	 
 			
        }
    }
    @Override
	public void onBackPressed() {
		
	}
	private final Runnable m_Runnable = new Runnable()
	{
		public void run()

	    { 
			//move to home page
	Intent intent=new Intent(getApplicationContext(),Home.class);
	startActivity(intent);
	MainActivity.this.finish();
		}

	};
	private final Runnable m_Runnable1= new Runnable()
	{
		public void run()

	    { 
			final Dialog dialog = new Dialog(MainActivity.this);
 			dialog.setContentView(R.layout.custmdialog);
 			dialog.setTitle("Register Ur Email-Id");
 			name = (EditText) dialog.findViewById(R.id.customname);
 			Button dialogButton = (Button) dialog.findViewById(R.id.custombtn);
 			dialogButton.setOnClickListener(new OnClickListener() {
 				public void onClick(View v) {
 					n=name.getText().toString().trim();
 					if(!n.isEmpty()){
 					 SQLiteAdapterName myname1=new SQLiteAdapterName(getApplicationContext());
 					myname1.openToWrite();
 					
 					myname1.deleteAll();
 					myname1.insert(n);
 					myname1.close();
 					MainActivity.this.mHandler = new Handler();
 		 		    MainActivity.this.mHandler.postDelayed(m_Runnable,1000);
 					}
 					else{

 	 					MainActivity.this.mHandler = new Handler();
 	 		 		    MainActivity.this.mHandler.postDelayed(m_Runnable1,1000);
 					}
 					dialog.dismiss();
 				}
 			});

 			dialog.show();
		}

	};
}
