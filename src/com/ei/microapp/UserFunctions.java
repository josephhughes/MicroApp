package com.ei.microapp;
 
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
 
public class UserFunctions {
 
    private JSONParser jsonParser;


    // Testing in localhost using wamp or xampp
    // use http://10.0.2.2/ to connect to your localhost ie http://localhost/
//    private static String loginURL = "http://10.0.2.2/login/";
//    private static String loginURL = "http://govindaraj.us/login/";
    private static String loginURL = "http://userfriendly.comze.com/login/index.php";
    
    private static String login_tag = "login";
  
    
    // constructor
    public UserFunctions(){
        jsonParser = new JSONParser();
    }
 
    /**
     * function make Login Request
     * @param email
     * @param password
     * */
    public JSONObject loginUser(String username, String password){
        // Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("tag",login_tag));
        params.add(new BasicNameValuePair("username",username));
        params.add(new BasicNameValuePair("password",password));
        JSONObject json = jsonParser.getJSONFromUrl(loginURL,params);
        // return json
        // Log.e("JSON", json.toString());
        return json;
    }

   
}
