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

public class Socket4 extends Activity {

	private SeekBar seek4 = null;
	private TextView tv4 = null;
	int progressChanged4 = 0;
	int pattisamps=2000;
	String url = "http://nikhilsrihari.site90.net/index.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket4);
		
		//Initialising the global file......
				SharedPreferences file6 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
				
				//Displaying connection status
				int int_sock4_con = file6.getInt("key_sok4_con",1);
				TextView text_socket4_con_dis = (TextView) findViewById(R.id.id_condis4);
				String sock4_con="Not Connected";
				if (int_sock4_con==0)
				{	sock4_con="Not Connected";
				}
				else if (int_sock4_con==1)
				{	sock4_con="Connected";
				}
				text_socket4_con_dis.setText(sock4_con);
				
				//Displaying device status
				int int_sock4_stat = file6.getInt("key_sok4_stat",0);
				TextView text_socket4_stat_dis = (TextView) findViewById(R.id.id_statusdis4);
				String sock4_stat="Off";
				if (int_sock4_stat==0)
				{	sock4_stat="Off";
				}
				else if (int_sock4_stat==1)
				{	sock4_stat="On";
				}
				text_socket4_stat_dis.setText(sock4_stat);
				
				//Displaying name
				String sock4_name = file6.getString("key_sok4_name","Null");
				TextView text_socket4_name_dis = (TextView) findViewById(R.id.id_namedis4);
				text_socket4_name_dis.setText(sock4_name);
				//Displaying location
				String sock4_location = file6.getString("key_sok4_location","Null");
				TextView text_socket4_location_dis = (TextView) findViewById(R.id.id_locationdis4);
				text_socket4_location_dis.setText(sock4_location);
				//Displaying type
				String sock4_type = file6.getString("key_sok4_type","Null");
				TextView text_socket4_type_dis = (TextView) findViewById(R.id.id_typedis4);
				text_socket4_type_dis.setText(sock4_type);
				
				//Displaying calculate energy reading
				int int_sock4_do_cal_energy = file6.getInt("key_sok4_energy",0);
				TextView text_socket4_do_cal_energy_dis = (TextView) findViewById(R.id.id_do_cal_energy4);
				String sock4_do_cal_energy="Off";
				if (int_sock4_do_cal_energy==0)
				{	sock4_do_cal_energy="Off";
				}
				else if (int_sock4_do_cal_energy==1)
				{	sock4_do_cal_energy="On";
				}
				text_socket4_do_cal_energy_dis.setText(sock4_do_cal_energy);
				
				//Displaying power ratings
				int sock4_power = file6.getInt("key_sok4_power",0);
				TextView text_socket4_power_dis = (TextView) findViewById(R.id.id_powerratingdis4);
				String convert_sock4_power = "" + sock4_power;
				text_socket4_power_dis.setText(convert_sock4_power);
				
				//Dispalying voltage ratings
				int sock4_voltage = file6.getInt("key_sok4_volt",0);
				TextView text_socket4_voltage_dis = (TextView) findViewById(R.id.id_voltageratingdis4);
				String convert_sock4_voltage = "" + sock4_voltage;
				text_socket4_voltage_dis.setText(convert_sock4_voltage);
				
				
				LinearLayout layout4 = (LinearLayout) findViewById(R.id.id_layout4);
				TextView sock4_speed = (TextView) findViewById(R.id.id_sock4_speed);
				int sock4_speed_val = file6.getInt("key_sok4_speed",0);
				if (sock4_type == "Analog") {
					layout4.setVisibility(View.VISIBLE);
					sock4_speed.setText("Speed : "+sock4_speed_val);
				}
				else {
					layout4.setVisibility(View.GONE);
				}
		
				/*
				seek4 = (SeekBar) findViewById(R.id.seekBar4);		
				tv4 = (TextView) findViewById(R.id.id_sock4_speed1);
				
				if (sock4_type=="Analog") {
					seek4.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
						public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
							progressChanged4 = progress;
						}
						public void onStartTrackingTouch(SeekBar seekbar) {
						// TODO Auto-generated method stub
						}
						public void onStopTrackingTouch(SeekBar seekbar) {
							tv4.setText(""+progressChanged4);
							SharedPreferences file4 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
							SharedPreferences.Editor file_editor4 = file4.edit();
							file_editor4.putInt("key_sok4_speed",progressChanged4);
							file_editor4.commit();
						}
					});
				}
				else {
					tv4.setText("DISABLED");
				}
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket4, menu);
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
		public void home4(View view) {
			Intent nikhome4 = new Intent(this, Homepage_Devicelist.class);
			startActivity(nikhome4);
		}
		
		//edit settings for socket 1
		public void editSocket4 (View view) {
			Intent intent49 = new Intent(this, Edit_socket4.class);
			startActivity(intent49);
		}
	
}
