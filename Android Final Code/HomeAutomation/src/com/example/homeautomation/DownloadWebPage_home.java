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
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DownloadWebPage_home extends AsyncTask<String,String,String> {

	private Context context;
	private Switch sw1,sw2,sw3,sw4,sw5;
	private TextView for_fan_speed2,for_fan_speed3,for_fan_speed5,for_fan_speed4;
	private SeekBar seek2,seek3,seek4,seek5;
	
	public DownloadWebPage_home(Context context,Switch sw1,Switch sw2,Switch sw3,Switch sw4,Switch sw5,TextView for_fan_speed2,TextView for_fan_speed3,TextView for_fan_speed4,TextView for_fan_speed5,SeekBar seek2,SeekBar seek3,SeekBar seek4,SeekBar seek5) {
		this.context = context;
		this.sw1=sw1;
		this.sw2=sw2;
		this.sw3=sw3;
		this.sw4=sw4;
		this.sw5=sw5;
		this.seek2=seek2;
		this.seek3=seek3;
		this.seek4=seek4;
		this.seek5=seek5;
		this.for_fan_speed2 = for_fan_speed2;
		this.for_fan_speed3 = for_fan_speed3;
		this.for_fan_speed4 = for_fan_speed4;
		this.for_fan_speed5 = for_fan_speed5;
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
			   Intent intent = new Intent(context, Connecting_page.class);
			   context.startActivity(intent);
		   }
		   else if (chaa[0]=='$' && chaa[10]=='*' ){
			   //String chaaa = new String(chaa);
			   if (chaa[1]=='1') {
				   sw1.setChecked(true);
			   }
			   else {
				   sw1.setChecked(false);
			   }
			   if (chaa[2]=='1') {
				   sw2.setChecked(true);
			   }
			   else {
				   sw2.setChecked(false);
			   }
			   if (chaa[3]=='1') {
				   sw3.setChecked(true);
			   }
			   else {
				   sw3.setChecked(false);
			   }
			   if (chaa[4]=='1') {
				   sw4.setChecked(true);
			   }
			   else {
				   sw4.setChecked(false);
			   }
			   if (chaa[5]=='1') {
				   sw5.setChecked(true);
			   }
			   else {
				   sw5.setChecked(false);
			   }
			   if (chaa[6]=='0') {
				   for_fan_speed2.setText("Speed : 0");
				   seek2.setProgress(0);
			   }
			   else if (chaa[6]=='1'){
				   for_fan_speed2.setText("Speed : 1");
				   seek2.setProgress(1);
			   }
			   else if (chaa[6]=='2'){
				   for_fan_speed2.setText("Speed : 2");
				   seek2.setProgress(2);
			   }
			   else if (chaa[6]=='3'){
				   for_fan_speed2.setText("Speed : 3");
				   seek2.setProgress(3);
			   }
			   else if (chaa[6]=='4'){
				   for_fan_speed2.setText("Speed : 4");
				   seek2.setProgress(4);
			   }
			   else if (chaa[6]=='5'){
				   for_fan_speed2.setText("Speed : 5");
				   seek2.setProgress(5);
			   }
			   else if (chaa[6]=='6'){
				   for_fan_speed2.setText(" ");
				   seek2.setProgress(0);
			   }
			   if (chaa[9]=='0') {
				   for_fan_speed5.setText("Speed : 0");
				   seek5.setProgress(0);
			   }
			   else if (chaa[9]=='1'){
				   for_fan_speed5.setText("Speed : 1");
				   seek5.setProgress(1);
			   }
			   else if (chaa[9]=='2'){
				   for_fan_speed5.setText("Speed : 2");
				   seek5.setProgress(2);
			   }
			   else if (chaa[9]=='3'){
				   for_fan_speed5.setText("Speed : 3");
				   seek5.setProgress(3);
			   }
			   else if (chaa[9]=='4'){
				   for_fan_speed5.setText("Speed : 4");
				   seek5.setProgress(4);
			   }
			   else if (chaa[9]=='5'){
				   for_fan_speed5.setText("Speed : 5");
				   seek5.setProgress(5);
			   }
			   else if (chaa[9]=='6'){
				   for_fan_speed5.setText(" ");
				   seek5.setProgress(0);
			   }
			   if (chaa[7]=='0') {
				   for_fan_speed3.setText("Speed : 0");
				   seek3.setProgress(0);
			   }
			   else if (chaa[7]=='1'){
				   for_fan_speed3.setText("Speed : 1");
				   seek3.setProgress(1);
			   }
			   else if (chaa[7]=='2'){
				   for_fan_speed3.setText("Speed : 2");
				   seek3.setProgress(2);
			   }
			   else if (chaa[7]=='3'){
				   for_fan_speed3.setText("Speed : 3");
				   seek3.setProgress(3);
			   }
			   else if (chaa[7]=='4'){
				   for_fan_speed3.setText("Speed : 4");
				   seek3.setProgress(4);
			   }
			   else if (chaa[7]=='5'){
				   for_fan_speed3.setText("Speed : 5");
				   seek3.setProgress(5);
			   }
			   else if (chaa[7]=='6'){
				   for_fan_speed3.setText(" ");
				   seek3.setProgress(0);
			   }
			   if (chaa[8]=='0') {
				   for_fan_speed4.setText("Speed : 0");
				   seek4.setProgress(0);
			   }
			   else if (chaa[8]=='1'){
				   for_fan_speed4.setText("Speed : 1");
				   seek4.setProgress(1);
			   }
			   else if (chaa[8]=='2'){
				   for_fan_speed4.setText("Speed : 2");
				   seek4.setProgress(2);
			   }
			   else if (chaa[8]=='3'){
				   for_fan_speed4.setText("Speed : 3");
				   seek4.setProgress(3);
			   }
			   else if (chaa[8]=='4'){
				   for_fan_speed4.setText("Speed : 4");
				   seek4.setProgress(4);
			   }
			   else if (chaa[8]=='5'){
				   for_fan_speed4.setText("Speed : 5");
				   seek4.setProgress(5);
			   }
			   else if (chaa[8]=='6'){
				   for_fan_speed4.setText(" ");
				   seek4.setProgress(0);
			   }
		   }
		   else {
			   Intent intent = new Intent(context, Connecting_page.class);
			   context.startActivity(intent);
		   }
		   
	   }

	
	   
	
}
