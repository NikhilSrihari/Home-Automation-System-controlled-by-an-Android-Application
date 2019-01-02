package com.example.homeautomation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DownloadWebPage_sendrec extends AsyncTask<String,String,String> {

	private Context context;
	private Switch sw;
	private String databits;
	public DownloadWebPage_sendrec(Context context,Switch sw,String databits) {
		this.context = context;
		this.sw=sw;
		this.databits = databits;
		//this.dataField = dataField;
	}
	   
	   //check Internet connection. 
	   private void checkInternetConenction(){
	      ConnectivityManager check = (ConnectivityManager) this.context.
	      getSystemService(Context.CONNECTIVITY_SERVICE);
	      if (check != null) 
	      {
	         NetworkInfo[] info = check.getAllNetworkInfo();
	         if (info != null) 
	            for (int i = 0; i <info.length; i++) 
	            if (info[i].getState() == NetworkInfo.State.CONNECTED)
	            {
	               Toast.makeText(context, "Internet is connected",
	               Toast.LENGTH_SHORT).show();
	            }

	      }
	      else{
	         Toast.makeText(context, "not conencted to internet",
	         Toast.LENGTH_SHORT).show();
	          }
	   }
	   protected void onPreExecute(){
	      checkInternetConenction();
	      
	   }	   

	   protected String doInBackground(String... arg0) {
		      try{
		         String link = (String)arg0[0];
		         URL url = new URL(link);
		         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		         conn.setReadTimeout(10000);
		         conn.setConnectTimeout(15000);
		         conn.setRequestMethod("GET");
		         conn.setDoInput(true);
		         conn.connect();
		         InputStream is = conn.getInputStream();
		         BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8") );
		         String data = null;
		         String webPage = "";
		         while ((data = reader.readLine()) != null){
		            webPage += data + "\n";
		         }
		         return webPage;
		      }catch(Exception e){
		         return new String("Exception");
		      }
		   }

	   
	   protected void onPostExecute(String result){
		   char[] cha = result.toCharArray();
		   char[] chaa = new char[11];
		   for (int i=0;i<=10;i++) {
			   chaa[i]=cha[i];
		   }
		   if (this.databits=="0a1") {
			   if (chaa[1]=='0')
				   this.sw.setChecked(false);
			   else
				   this.sw.setChecked(true);
		   }
		   else if (this.databits=="0b1") {
			   if (chaa[1]=='1')
				   this.sw.setChecked(true);
			   else
				   this.sw.setChecked(false);
		   }
		   else if (this.databits=="0c1") {
			   if (chaa[2]=='0')
				   this.sw.setChecked(false);
			   else
				   this.sw.setChecked(true);
		   }
		   else if (this.databits=="0d1") {
			   if (chaa[2]=='1')
				   this.sw.setChecked(true);
			   else
				   this.sw.setChecked(false);
		   }
		   else if (this.databits=="0e1") {
			   if (chaa[3]=='0')
				   this.sw.setChecked(false);
			   else
				   this.sw.setChecked(true);
		   }
		   else if (this.databits=="0f1") {
			   if (chaa[3]=='1')
				   this.sw.setChecked(true);
			   else
				   this.sw.setChecked(false);
		   }
		   else if (this.databits=="0g1") {
			   if (chaa[4]=='0')
				   this.sw.setChecked(false);
			   else
				   this.sw.setChecked(true);
		   }
		   else if (this.databits=="0h1") {
			   if (chaa[4]=='1')
				   this.sw.setChecked(true);
			   else
				   this.sw.setChecked(false);
		   }
		   else if (this.databits=="0i1") {
			   if (chaa[5]=='0')
				   this.sw.setChecked(false);
			   else
				   this.sw.setChecked(true);
		   }
		   else if (this.databits=="0j1") {
			   if (chaa[5]=='1')
				   this.sw.setChecked(true);
			   else
				   this.sw.setChecked(false);
		   }
		  
	   }

	
}
