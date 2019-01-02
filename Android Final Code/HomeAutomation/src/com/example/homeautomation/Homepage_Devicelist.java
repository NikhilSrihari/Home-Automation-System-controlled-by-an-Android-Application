package com.example.homeautomation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;

public class Homepage_Devicelist extends Activity {
	int time_for_delay=2000;
	private Switch sw1,sw2,sw3,sw4,sw5;
	private TextView for_fan_speed5,for_fan_speed4,for_fan_speed3,for_fan_speed2;
	private LinearLayout lay2,lay3,lay4,lay5;
	String url = "http://nikhilsrihari.site90.net/index.php";
	private String databit=""; 
	private SeekBar seek2 = null;
	private SeekBar seek3 = null;
	private SeekBar seek4 = null;
	private SeekBar seek5 = null;
	int progressChanged2 = 0;
	int progressChanged3 = 0;
	int progressChanged4 = 0;
	int progressChanged5 = 0;
	int pattisamps=2000;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homepage__devicelist);
		SharedPreferences file5 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		sw1 = (Switch)findViewById(R.id.id_switch1);
		sw2 = (Switch)findViewById(R.id.id_switch2);
		sw3 = (Switch)findViewById(R.id.id_switch3);
		sw4 = (Switch)findViewById(R.id.id_switch4);
		sw5 = (Switch)findViewById(R.id.id_switch5);
		String dis_home_sok1 = file5.getString("key_sok1_name","Null");
		String dis_home_sok2 = file5.getString("key_sok2_name","Null");
		String dis_home_sok3 = file5.getString("key_sok3_name","Null");
		String dis_home_sok4 = file5.getString("key_sok4_name","Null");
		String dis_home_sok5 = file5.getString("key_sok5_name","Null");
		String bag2 = file5.getString("key_sok2_type","Null");
		String bag3 = file5.getString("key_sok3_type","Null");
		String bag4 = file5.getString("key_sok4_type","Null");
		String bag5 = file5.getString("key_sok5_type","Null");
		for_fan_speed2 = (TextView)findViewById(R.id.id_fan_speed2);
		for_fan_speed3 = (TextView)findViewById(R.id.id_fan_speed3);
		for_fan_speed4 = (TextView)findViewById(R.id.id_fan_speed4);
		for_fan_speed5 = (TextView)findViewById(R.id.id_fan_speed5);
		TextView home_dis_sok1 = (TextView) findViewById(R.id.id_home_dis_sok1);
		TextView home_dis_sok2 = (TextView) findViewById(R.id.id_home_dis_sok2);
		TextView home_dis_sok3 = (TextView) findViewById(R.id.id_home_dis_sok3);
		TextView home_dis_sok4 = (TextView) findViewById(R.id.id_home_dis_sok4);
		TextView home_dis_sok5 = (TextView) findViewById(R.id.id_home_dis_sok5);
		home_dis_sok1.setText(dis_home_sok1);
		home_dis_sok2.setText(dis_home_sok2);
		home_dis_sok3.setText(dis_home_sok3);
		home_dis_sok4.setText(dis_home_sok4);
		home_dis_sok5.setText(dis_home_sok5);
		final String url = "http://nikhilsrihari.site90.net/index.php";
		seek2 = (SeekBar) findViewById(R.id.seekBar2);	
		seek3 = (SeekBar) findViewById(R.id.seekBar3);	
		seek4 = (SeekBar) findViewById(R.id.seekBar4);	
		seek5 = (SeekBar) findViewById(R.id.seekBar5);	
		new DownloadWebPage_home(this,sw1,sw2,sw3,sw4,sw5,for_fan_speed2,for_fan_speed3,for_fan_speed4,for_fan_speed5,seek2,seek3,seek4,seek5).execute(url);
		lay2 = (LinearLayout)findViewById(R.id.id_lay2);
		lay3 = (LinearLayout)findViewById(R.id.id_lay3);
		lay4 = (LinearLayout)findViewById(R.id.id_lay4);
		lay5 = (LinearLayout)findViewById(R.id.id_lay5);
		lay2.setVisibility(View.VISIBLE);
		lay3.setVisibility(View.VISIBLE);
		lay4.setVisibility(View.VISIBLE);
		lay5.setVisibility(View.VISIBLE);
		//0 1 1.9 2 3 255
		if (bag2=="Analog") {
			lay2.setVisibility(View.VISIBLE);
			seek2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
					progressChanged2 = progress;
				}
				public void onStartTrackingTouch(SeekBar seekbar) {
				// TODO Auto-generated method stub
				}
				public void onStopTrackingTouch(SeekBar seekbar) {
					for_fan_speed2.setText("Speed : "+progressChanged2);
					seek2.setProgress(progressChanged2);
					String apple;
					if (progressChanged2 == 0)
					{apple ="0k1";}
					else if (progressChanged2 == 1)
					{apple ="0l1";}
					else if (progressChanged2 == 2)
					{apple ="0m1";}
					else if (progressChanged2 == 3)
					{apple ="0n1";}
					else if (progressChanged2 == 4)
					{apple ="0o1";}
					else if (progressChanged2 == 5)
					{apple ="0p1";}
					else apple = "0q1";
					sending_net(apple);
					make_u_sleep(time_for_delay);
					
					new DownloadWebPage_lay(apple,for_fan_speed2,seek2).execute(url);
				}
			});
		}
		else {
			lay2.setVisibility(View.GONE);
		}
		
		
		if (bag3=="Analog") {
			lay3.setVisibility(View.VISIBLE);
			seek3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
					progressChanged3 = progress;
				}
				public void onStartTrackingTouch(SeekBar seekbar) {
				// TODO Auto-generated method stub
				}
				public void onStopTrackingTouch(SeekBar seekbar) {
					for_fan_speed3.setText("Speed : "+progressChanged3);
					seek3.setProgress(progressChanged3);
					String apple;
					if (progressChanged3 == 0)
					{apple ="0r1";}
					else if (progressChanged3 == 1)
					{apple ="0s1";}
					else if (progressChanged3 == 2)
					{apple ="0t1";}
					else if (progressChanged3 == 3)
					{apple ="0u1";}
					else if (progressChanged3 == 4)
					{apple ="0v1";}
					else if (progressChanged3 == 5)
					{apple ="0w1";}
					else apple = "0x1";
					sending_net(apple);
					make_u_sleep(time_for_delay);
					
					new DownloadWebPage_lay(apple,for_fan_speed3,seek3).execute(url);
				}
			});
		}
		else {
			lay3.setVisibility(View.GONE);
		}
		
		
		if (bag4=="Analog") {
			lay4.setVisibility(View.VISIBLE);
			seek4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
					progressChanged4 = progress;
				}
				public void onStartTrackingTouch(SeekBar seekbar) {
				// TODO Auto-generated method stub
				}
				public void onStopTrackingTouch(SeekBar seekbar) {
					for_fan_speed4.setText("Speed : "+progressChanged4);
					seek4.setProgress(progressChanged4);
					String apple;
					if (progressChanged4 == 0)
					{apple ="0A1";}
					else if (progressChanged4 == 1)
					{apple ="0B1";}
					else if (progressChanged4 == 2)
					{apple ="0C1";}
					else if (progressChanged4 == 3)
					{apple ="0D1";}
					else if (progressChanged4 == 4)
					{apple ="0E1";}
					else if (progressChanged4 == 5)
					{apple ="0F1";}
					else apple = "0G1";
					sending_net(apple);
					make_u_sleep(time_for_delay);
					
					new DownloadWebPage_lay(apple,for_fan_speed4,seek4).execute(url);
				}
			});
		}
		else {
			lay4.setVisibility(View.GONE);
		}
		
		
		if (bag5=="Analog") {
			lay5.setVisibility(View.VISIBLE);
			seek5.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
				public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
					progressChanged5 = progress;
				}
				public void onStartTrackingTouch(SeekBar seekbar) {
				// TODO Auto-generated method stub
				}
				public void onStopTrackingTouch(SeekBar seekbar) {
					for_fan_speed5.setText("Speed : "+progressChanged5);
					seek5.setProgress(progressChanged5);
					String apple;
					if (progressChanged5 == 0)
					{apple ="0H1";}
					else if (progressChanged5 == 1)
					{apple ="0I1";}
					else if (progressChanged5 == 2)
					{apple ="0J1";}
					else if (progressChanged5 == 3)
					{apple ="0K1";}
					else if (progressChanged5 == 4)
					{apple ="0L1";}
					else if (progressChanged5 == 5)
					{apple ="0M1";}
					else apple = "0N1";
					sending_net(apple);
					make_u_sleep(time_for_delay);
					
					new DownloadWebPage_lay(apple,for_fan_speed5,seek5).execute(url);
				}
			});
		}
		else {
			lay5.setVisibility(View.GONE);
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.homepage__devicelist, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	//socket1 details
	public void socket1_details (View view) {
		save_to_me();
		Intent intent1 = new Intent(this, Socket1.class);
		startActivity(intent1);
	}
	
	public void socket2_details (View view) {
		save_to_me();
		Intent intent2 = new Intent(this, Socket2.class);
		startActivity(intent2);
	}
	
	public void socket3_details (View view) {
		save_to_me();
	
			Intent intent3 = new Intent(this, Socket3.class);
			startActivity(intent3);
		
	}
	
	public void socket4_details (View view) {
		save_to_me();
		Intent intent4 = new Intent(this, Socket4.class);
			startActivity(intent4);
		
	}
	
	public void socket5_details (View view) {
		save_to_me();
		Intent intent5 = new Intent(this, Socket5.class);
			startActivity(intent5);
	}
	
	
	public void save_to_me() {
		SharedPreferences file_net = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		SharedPreferences.Editor file_editor10 = file_net.edit();
		if (sw1.isChecked()==true) {
			file_editor10.putInt("key_sok1_stat",1);
		}
		else if (sw1.isChecked()==false) {
			file_editor10.putInt("key_sok1_stat",0);
		}
		if (sw2.isChecked()==true) {
			file_editor10.putInt("key_sok2_stat",1);
		}
		else if (sw2.isChecked()==false) {
			file_editor10.putInt("key_sok2_stat",0);
		}
		if (sw3.isChecked()==true) {
			file_editor10.putInt("key_sok3_stat",1);
		}
		else if (sw3.isChecked()==false) {
			file_editor10.putInt("key_sok3_stat",0);
		}
		if (sw4.isChecked()==true) {
			file_editor10.putInt("key_sok4_stat",1);
		}
		else if (sw4.isChecked()==false) {
			file_editor10.putInt("key_sok4_stat",0);
		}
		if (sw5.isChecked()==true) {
			file_editor10.putInt("key_sok5_stat",1);
		}
		else if (sw5.isChecked()==false) {
			file_editor10.putInt("key_sok5_stat",0);
		}
		if (for_fan_speed2.getText()=="Speed : 0") {
			file_editor10.putInt("key_sok2_speed",0);
		}
		else if (for_fan_speed2.getText()=="Speed : 1") {
			file_editor10.putInt("key_sok2_speed",1);
		}
		else if (for_fan_speed2.getText()=="Speed : 2") {
			file_editor10.putInt("key_sok2_speed",2);
		}
		else if (for_fan_speed2.getText()=="Speed : 3") {
			file_editor10.putInt("key_sok2_speed",3);
		}
		else if (for_fan_speed2.getText()=="Speed : 4") {
			file_editor10.putInt("key_sok2_speed",4);
		}
		else if (for_fan_speed2.getText()=="Speed : 5") {
			file_editor10.putInt("key_sok2_speed",5);
		}
		else if (for_fan_speed2.getText()==" "){
			file_editor10.putInt("key_sok2_speed",6);
		}
		if (for_fan_speed3.getText()=="Speed : 0") {
			file_editor10.putInt("key_sok3_speed",0);
		}
		else if (for_fan_speed3.getText()=="Speed : 1") {
			file_editor10.putInt("key_sok3_speed",1);
		}
		else if (for_fan_speed3.getText()=="Speed : 2") {
			file_editor10.putInt("key_sok3_speed",2);
		}
		else if (for_fan_speed3.getText()=="Speed : 3") {
			file_editor10.putInt("key_sok3_speed",3);
		}
		else if (for_fan_speed3.getText()=="Speed : 4") {
			file_editor10.putInt("key_sok3_speed",4);
		}
		else if (for_fan_speed3.getText()=="Speed : 5") {
			file_editor10.putInt("key_sok3_speed",5);
		}
		else if (for_fan_speed3.getText()==" "){
			file_editor10.putInt("key_sok3_speed",6);
		}
		if (for_fan_speed4.getText()=="Speed : 0") {
			file_editor10.putInt("key_sok4_speed",0);
		}
		else if (for_fan_speed4.getText()=="Speed : 1") {
			file_editor10.putInt("key_sok4_speed",1);
		}
		else if (for_fan_speed4.getText()=="Speed : 2") {
			file_editor10.putInt("key_sok4_speed",2);
		}
		else if (for_fan_speed4.getText()=="Speed : 3") {
			file_editor10.putInt("key_sok4_speed",3);
		}
		else if (for_fan_speed4.getText()=="Speed : 4") {
			file_editor10.putInt("key_sok4_speed",4);
		}
		else if (for_fan_speed4.getText()=="Speed : 5") {
			file_editor10.putInt("key_sok4_speed",5);
		}
		else if (for_fan_speed4.getText()==" "){
			file_editor10.putInt("key_sok4_speed",6);
		}
		if (for_fan_speed5.getText()=="Speed : 0") {
			file_editor10.putInt("key_sok5_speed",0);
		}
		else if (for_fan_speed5.getText()=="Speed : 1") {
			file_editor10.putInt("key_sok5_speed",1);
		}
		else if (for_fan_speed5.getText()=="Speed : 2") {
			file_editor10.putInt("key_sok5_speed",2);
		}
		else if (for_fan_speed5.getText()=="Speed : 3") {
			file_editor10.putInt("key_sok5_speed",3);
		}
		else if (for_fan_speed5.getText()=="Speed : 4") {
			file_editor10.putInt("key_sok5_speed",4);
		}
		else if (for_fan_speed5.getText()=="Speed : 5") {
			file_editor10.putInt("key_sok5_speed",5);
		}
		else if (for_fan_speed5.getText()==" "){
			file_editor10.putInt("key_sok5_speed",6);
		}
		file_editor10.commit();
	}
	
	public void sending_net(final String data_bit) {
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://nikhilsrihari.site90.net/index.php");
				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
					nameValuePairs.add(new BasicNameValuePair("informa",data_bit ));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					httpclient.execute(httppost); // send the parameter to the server
				}
				catch (ClientProtocolException e) {
		    	 
				} 
				catch (IOException e) {
		    	 
				}
			}
		}).start();
	}
	
	public void make_u_sleep(int pattisamps)
	{
		try {
    		Thread.sleep(pattisamps);
		} 
		catch (InterruptedException e) {
		}
	
	}
	
	
	public void switch1_click (View view) {
		boolean on1 = ((Switch) view).isChecked();
		SharedPreferences read_file1 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		int sok1_con = read_file1.getInt("key_sok1_con",1);
		
		if (sok1_con==1) {
			if (on1) {
				databit="0b1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw1,databit).execute(url);
			}
			else {
				databit="0a1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw1,databit).execute(url);
		    }		
		}
		else {
			;
		}
	}
	
	public void switch2_click (View view) {
		boolean on2 = ((Switch) view).isChecked();
		SharedPreferences read_file2 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		int sok2_con = read_file2.getInt("key_sok2_con",1);
		
		if (sok2_con==1) {
			if (on2) {
				databit="0d1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw2,databit).execute(url);
			}
			else {
				databit="0c1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw2,databit).execute(url);
			}
		}
		else {
			;
		}
	}
	
	public void switch3_click (View view) {
		boolean on3 = ((Switch) view).isChecked();
		SharedPreferences read_file3 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		int sok3_con = read_file3.getInt("key_sok3_con",1);
		if (sok3_con==1) {
			if (on3) {
				databit="0f1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw3,databit).execute(url);
			}
			else {
				databit="0e1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw3,databit).execute(url);
			}
		}
		else {
			;
		}
	}
	
	public void switch4_click (View view) {
		boolean on4 = ((Switch) view).isChecked();
		SharedPreferences read_file4 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		int sok4_con = read_file4.getInt("key_sok4_con",1);
		if (sok4_con==1) {
			if (on4) {
				databit="0h1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw4,databit).execute(url);
			}
			else {
				databit="0g1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw4,databit).execute(url);
			}
		}
		else {
			;
		}
	}
	
	public void switch5_click (View view) {
		boolean on5 = ((Switch) view).isChecked();
		SharedPreferences read_file5 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		int sok5_con = read_file5.getInt("key_sok5_con",1);
		if (sok5_con==1) {
			if (on5) {
				databit="0j1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw5,databit).execute(url);
			}
			else {
				databit="0i1";
				sending_net(databit);
				make_u_sleep(time_for_delay);
				new DownloadWebPage_sendrec(this,sw5,databit).execute(url);		
			}
		}
		else {
			;
		}
	}
	
	
	public void refr(View view) 
	{	save_to_me();
		Intent intent_fish = new Intent(this, Homepage_Devicelist.class);
		startActivity(intent_fish);
	}
	
	
}