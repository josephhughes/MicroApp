package com.ei.microapp;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	 @Override
	public void onBackPressed() {
		Intent intent=new Intent(getApplicationContext(), Home.class);
		startActivity(intent);
		Login.this.finish();
	}
	private static String KEY_SUCCESS = "success";

	final Context context = this;
	private EditText un;
	private EditText pw;
	private SQLiteAdapterLog mySQLiteAdapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.login);
		un=(EditText)findViewById(R.id.letun);
		pw=(EditText)findViewById(R.id.letpwd);
		Button log=(Button)findViewById(R.id.logbtn1);
		log.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//			Intent intent=new Intent(getApplicationContext(), Home.class);
//			startActivity(intent);
//			final Dialog dialog = new Dialog(context);
//			dialog.setContentView(R.layout.custom);
//			dialog.setTitle("Welcome");
// 
//			// set the custom dialog components - text, image and button
//			TextView text = (TextView) dialog.findViewById(R.id.text);
//			text.setText("Login Succesfully!....   ");
//		
//			Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
//			// if button is clicked, close the custom dialog
//			dialogButton.setOnClickListener(new OnClickListener() {
////				@Override
//				public void onClick(View v) {
//					Intent intent=new Intent(getApplicationContext(), Home.class);
//					startActivity(intent);
//					dialog.dismiss();
//				}
//			});
// 
//			dialog.show();
			 	String username = un.getText().toString().trim();
		        String password = pw.getText().toString().trim();
		        if((!username.isEmpty())&&(!password.isEmpty()) ){
		        	boolean answer;
					answer=isOnline();
					System.out.println(answer);

					if(answer)
					{

				employee();

		        }else
				{
					
					Toast.makeText(getApplicationContext(), "No Internet Connection",Toast.LENGTH_LONG).show();
				}
		        }else
				{
					
					Toast.makeText(getApplicationContext(), "some field missing",Toast.LENGTH_LONG).show();
				}
		        }
		});

	}
	//check for verification in local database
	private void employee() {
	       
    	String username = un.getText().toString().trim();
        String password = pw.getText().toString().trim();
System.out.println(username + " and  "+password);
        UserFunctions userFunction = new UserFunctions();
        JSONObject json = userFunction.loginUser(username,password);

        // check for login response
        try {
            if (json.getString(KEY_SUCCESS) != null) {
//                loginErrorMsg.setText("");
                String res = json.getString(KEY_SUCCESS);
                if(Integer.parseInt(res) == 1){
                	
                	mySQLiteAdapter = new SQLiteAdapterLog(Login.this);
					mySQLiteAdapter.openToWrite();
					mySQLiteAdapter.deleteAll();
					mySQLiteAdapter.insert(username,password);
					mySQLiteAdapter.close();
                   Toast.makeText(getApplicationContext(),"successfully", Toast.LENGTH_LONG).show();
                   Intent intent=new Intent(getApplicationContext(), Home.class);
                   startActivity(intent);
                   finish();                   
                }else{
                    Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                    // Error in login
//                    loginErrorMsg.setText("Incorrect username/password");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
		
        
	}
	//check for internet connection
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
