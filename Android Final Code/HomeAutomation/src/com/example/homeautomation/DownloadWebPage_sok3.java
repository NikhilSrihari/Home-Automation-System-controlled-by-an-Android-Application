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
import android.widget.Toast;

public class DownloadWebPage_sok3 extends AsyncTask<String,String,String>{

private Context context;
	
	public DownloadWebPage_sok3(Context context) {
		this.context = context;
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
		   if (result == "Exception") {
			   Intent intent = new Intent(context, Edit_socket3.class);
			   context.startActivity(intent);
		   }
		   else if (chaa[0]=='$' && chaa[10]=='*' ){
			   //String chaaa = new String(chaa);
			   if (chaa[2]=='0' && chaa[7]=='0') {
				   Intent intennnt = new Intent(context, Socket3.class);
				   context.startActivity(intennnt);
			   }
			   else {
				   Intent intennt = new Intent(context, Edit_socket3.class);
				   context.startActivity(intennt);

			   }
		   }   
		   else {
			   Intent intent = new Intent(context, Edit_socket3.class);
			   context.startActivity(intent);
		   }
		   
	   }

	
	
}
