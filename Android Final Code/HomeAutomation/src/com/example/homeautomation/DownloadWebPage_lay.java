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
import android.widget.TextView;
import android.widget.Toast;

public class DownloadWebPage_lay extends AsyncTask<String,String,String>{


	//private Context context;
	private String apple;
	private SeekBar seek;
	private TextView for_fan_speed;
	
	public DownloadWebPage_lay(String apple,TextView for_fan_speed,SeekBar seek) {
		//this.context = context;
		this.apple=apple;
		this.seek=seek;
		this.for_fan_speed = for_fan_speed;
	}
	   
	  
	/*
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
	   */
	   protected void onPreExecute(){
	      //checkInternetConenction();
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
		   if (chaa[0]=='$' && chaa[10]=='*' ){
			   //String chaaa = new String(chaa);
			   if (this.apple == "0k1") {
				   if (chaa[6]=='0') {
					   this.for_fan_speed.setText("Speed : 0");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0l1") {
				   if (chaa[6]=='1') {
					   this.for_fan_speed.setText("Speed : 1");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0m1") {
				   if (chaa[6]=='2') {
					   this.for_fan_speed.setText("Speed : 2");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0n1") {
				   if (chaa[6]=='3') {
					   this.for_fan_speed.setText("Speed : 3");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0o1") {
				   if (chaa[6]=='4') {
					   this.for_fan_speed.setText("Speed : 4");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0p1") {
				   if (chaa[6]=='5') {
					   this.for_fan_speed.setText("Speed : 5");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0r1") {
				   if (chaa[7]=='0') {
					   this.for_fan_speed.setText("Speed : 0");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0s1") {
				   if (chaa[7]=='1') {
					   this.for_fan_speed.setText("Speed : 1");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0t1") {
				   if (chaa[7]=='2') {
					   this.for_fan_speed.setText("Speed : 2");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0u1") {
				   if (chaa[7]=='3') {
					   this.for_fan_speed.setText("Speed : 3");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0v1") {
				   if (chaa[7]=='4') {
					   this.for_fan_speed.setText("Speed : 4");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0w1") {
				   if (chaa[7]=='5') {
					   this.for_fan_speed.setText("Speed : 5");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0A1") {
				   if (chaa[8]=='0') {
					   this.for_fan_speed.setText("Speed : 0");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0B1") {
				   if (chaa[8]=='1') {
					   this.for_fan_speed.setText("Speed : 1");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0C1") {
				   if (chaa[8]=='2') {
					   this.for_fan_speed.setText("Speed : 2");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0D1") {
				   if (chaa[8]=='3') {
					   this.for_fan_speed.setText("Speed : 3");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0E1") {
				   if (chaa[8]=='4') {
					   this.for_fan_speed.setText("Speed : 4");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0F1") {
				   if (chaa[8]=='5') {
					   this.for_fan_speed.setText("Speed : 5");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0H1") {
				   if (chaa[9]=='0') {
					   this.for_fan_speed.setText("Speed : 0");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0I1") {
				   if (chaa[9]=='1') {
					   this.for_fan_speed.setText("Speed : 1");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0J1") {
				   if (chaa[9]=='2') {
					   this.for_fan_speed.setText("Speed : 2");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0K1") {
				   if (chaa[9]=='3') {
					   this.for_fan_speed.setText("Speed : 3");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0L1") {
				   if (chaa[9]=='4') {
					   this.for_fan_speed.setText("Speed : 4");
				   }
				   else {
					  contin();
				   }
			   }
			   else if (this.apple == "0M1") {
				   if (chaa[9]=='5') {
					   this.for_fan_speed.setText("Speed : 5");
				   }
				   else {
					  contin();
				   }
			   }
			   
		   }
		   else {
			   contin();
		   }
		   
	   }
	   
	   
	   void contin() {
		   String orange =this.for_fan_speed.getText().toString();
		   if (orange == "Speed : 0") {
			   this.seek.setProgress(0);
		   }
		   else if (orange == "Speed : 0") {
			   this.seek.setProgress(0);
		   }
		   else if (orange == "Speed : 1") {
			   this.seek.setProgress(1);
		   }
		   else if (orange == "Speed : 2") {
			   this.seek.setProgress(2);
		   }
		   else if (orange == "Speed : 3") {
			   this.seek.setProgress(3);
		   }
		   else if (orange == "Speed : 4") {
			   this.seek.setProgress(4);
		   }
		   else if (orange == "Speed : 5") {
			   this.seek.setProgress(5);
		   }
		   
	   }
}
