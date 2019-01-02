package com.example.homeautomation;

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
import android.widget.TextView;

public class Socket3 extends Activity {

	private SeekBar seek3 = null;
	private TextView tv3 = null;
	int progressChanged3 = 0;
	int pattisamps=2000;
	String url = "http://nikhilsrihari.site90.net/index.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket3);
		
		
		//Initialising the global file......
				SharedPreferences file6 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
				
				//Displaying connection status
				int int_sock3_con = file6.getInt("key_sok3_con",1);
				TextView text_socket3_con_dis = (TextView) findViewById(R.id.id_condis3);
				String sock3_con="Not Connected";
				if (int_sock3_con==0)
				{	sock3_con="Not Connected";
				}
				else if (int_sock3_con==1)
				{	sock3_con="Connected";
				}
				text_socket3_con_dis.setText(sock3_con);
				
				//Displaying device status
				int int_sock3_stat = file6.getInt("key_sok3_stat",0);
				TextView text_socket3_stat_dis = (TextView) findViewById(R.id.id_statusdis3);
				String sock3_stat="Off";
				if (int_sock3_stat==0)
				{	sock3_stat="Off";
				}
				else if (int_sock3_stat==1)
				{	sock3_stat="On";
				}
				text_socket3_stat_dis.setText(sock3_stat);
				
				//Displaying name
				String sock3_name = file6.getString("key_sok3_name","Null");
				TextView text_socket3_name_dis = (TextView) findViewById(R.id.id_namedis3);
				text_socket3_name_dis.setText(sock3_name);
				//Displaying location
				String sock3_location = file6.getString("key_sok3_location","Null");
				TextView text_socket3_location_dis = (TextView) findViewById(R.id.id_locationdis3);
				text_socket3_location_dis.setText(sock3_location);
				//Displaying type
				String sock3_type = file6.getString("key_sok3_type","Null");
				TextView text_socket3_type_dis = (TextView) findViewById(R.id.id_typedis3);
				text_socket3_type_dis.setText(sock3_type);
				
				//Displaying calculate energy reading
				int int_sock3_do_cal_energy = file6.getInt("key_sok3_energy",0);
				TextView text_socket3_do_cal_energy_dis = (TextView) findViewById(R.id.id_do_cal_energy3);
				String sock3_do_cal_energy="Off";
				if (int_sock3_do_cal_energy==0)
				{	sock3_do_cal_energy="Off";
				}
				else if (int_sock3_do_cal_energy==1)
				{	sock3_do_cal_energy="On";
				}
				text_socket3_do_cal_energy_dis.setText(sock3_do_cal_energy);
				
				//Displaying power ratings
				int sock3_power = file6.getInt("key_sok3_power",0);
				TextView text_socket3_power_dis = (TextView) findViewById(R.id.id_powerratingdis3);
				String convert_sock3_power = "" + sock3_power;
				text_socket3_power_dis.setText(convert_sock3_power);
				
				//Dispalying voltage ratings
				int sock3_voltage = file6.getInt("key_sok3_volt",0);
				TextView text_socket3_voltage_dis = (TextView) findViewById(R.id.id_voltageratingdis3);
				String convert_sock3_voltage = "" + sock3_voltage;
				text_socket3_voltage_dis.setText(convert_sock3_voltage);
				
				LinearLayout layout3 = (LinearLayout) findViewById(R.id.id_layout3);
				TextView sock3_speed = (TextView) findViewById(R.id.id_sock3_speed);
				int sock3_speed_val = file6.getInt("key_sok3_speed",0);
				if (sock3_type == "Analog") {
					layout3.setVisibility(View.VISIBLE);
					sock3_speed.setText("Speed : "+sock3_speed_val);
				}
				else {
					layout3.setVisibility(View.GONE);
				}
				
				/*
				seek3 = (SeekBar) findViewById(R.id.seekBar3);		
				tv3 = (TextView) findViewById(R.id.id_sock3_speed1);
				
				if (sock3_type=="Analog") {
					seek3.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
						public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
							progressChanged3 = progress;
						}
						public void onStartTrackingTouch(SeekBar seekbar) {
						// TODO Auto-generated method stub
						}
						public void onStopTrackingTouch(SeekBar seekbar) {
							tv3.setText(""+progressChanged3);
							SharedPreferences file3 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
							SharedPreferences.Editor file_editor3 = file3.edit();
							file_editor3.putInt("key_sok3_speed",progressChanged3);
							file_editor3.commit();
						}
					});
				}
				else {
					tv3.setText("DISABLED");
				}
				*/	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket3, menu);
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
	
	//go home
		public void home3(View view) {
			Intent nikhome3 = new Intent(this, Homepage_Devicelist.class);
			startActivity(nikhome3);
		}
		
		//edit settings for socket 3
		public void editSocket3 (View view) {
			Intent intent39 = new Intent(this, Edit_socket3.class);
			startActivity(intent39);
		}
	
}
