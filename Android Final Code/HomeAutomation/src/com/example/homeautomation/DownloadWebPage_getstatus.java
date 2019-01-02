package com.example.homeautomation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DownloadWebPage_getstatus extends AsyncTask<String,String,String> {

	private TextView conpage_text1;
	private Context context;
	
	
	public DownloadWebPage_getstatus(Context context,TextView conpage_text1) {
		this.context = context;
		this.conpage_text1= conpage_text1;
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
	         Toast.makeText(context, "Not conencted to internet",
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
		   if (result == "Exception") {
			   this.conpage_text1.setText("Connection unsuccesful. Please retry.");
		   }
		   else {
			   char[] cha = result.toCharArray();
			   char[] chaa = new char[8];
			   for (int i=0;i<=7;i++) {
				   chaa[i]=cha[i];
			   }
			   //String chaaa = new String(chaa);
		   	   //inp_text.setText(chaaa);
		   	   //char[] ca = data_info.toCharArray();
			   /*
		   	   if (ca[1]=='d' && chaa[2]=='1') {
		   		   sw1.setChecked(true);
		   		   sw2.setChecked(true);
		   	   }
		   	   else {
		   		   sw1.setChecked(false);
		   		   sw2.setChecked(false);
		   	   }
		   
		   */
			   
		   }   
			   
			   
			   
			   
			   
			   
		   //this.dataField.setText(result);
		   /*
		   //SharedPreferences file5 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		   Intent intent = new Intent(context, MainActivity.class);
		   context.startActivity(intent);
		   */
		   /*
		   char[] cha = result.toCharArray();
		   String dat = cha[1]+"";
		   this.inp_text.setText(dat);
		   */
	   }
	
}
