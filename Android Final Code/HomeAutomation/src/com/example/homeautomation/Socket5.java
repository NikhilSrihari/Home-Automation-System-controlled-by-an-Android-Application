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

public class Socket5 extends Activity {

	//private static final int VISIBLE = 0;
	//private static final int GONE = 0;
	private SeekBar seek5 = null;
	private TextView tv5 = null;
	int progressChanged5 = 0;
	int pattisamps=2000;
	String url = "http://nikhilsrihari.site90.net/index.php";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket5);
		
		
		
		//Initialising the global file......
				SharedPreferences file6 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
				
				//Displaying connection status
				int int_sock5_con = file6.getInt("key_sok5_con",1);
				TextView text_socket5_con_dis = (TextView) findViewById(R.id.id_condis5);
				String sock5_con="Not Connected";
				if (int_sock5_con==0)
				{	sock5_con="Not Connected";
				}
				else if (int_sock5_con==1)
				{	sock5_con="Connected";
				}
				text_socket5_con_dis.setText(sock5_con);
				
				//Displaying device status
				int int_sock5_stat = file6.getInt("key_sok5_stat",0);
				TextView text_socket5_stat_dis = (TextView) findViewById(R.id.id_statusdis5);
				String sock5_stat="Off";
				if (int_sock5_stat==0)
				{	sock5_stat="Off";
				}
				else if (int_sock5_stat==1)
				{	sock5_stat="On";
				}
				text_socket5_stat_dis.setText(sock5_stat);
				
				//Displaying name
				String sock5_name = file6.getString("key_sok5_name","Null");
				TextView text_socket5_name_dis = (TextView) findViewById(R.id.id_namedis5);
				text_socket5_name_dis.setText(sock5_name);
				//Displaying location
				String sock5_location = file6.getString("key_sok5_location","Null");
				TextView text_socket5_location_dis = (TextView) findViewById(R.id.id_locationdis5);
				text_socket5_location_dis.setText(sock5_location);
				//Displaying type
				String sock5_type = file6.getString("key_sok5_type","Null");
				TextView text_socket5_type_dis = (TextView) findViewById(R.id.id_typedis5);
				text_socket5_type_dis.setText(sock5_type);
				
				//Displaying calculate energy reading
				int int_sock5_do_cal_energy = file6.getInt("key_sok5_energy",0);
				TextView text_socket5_do_cal_energy_dis = (TextView) findViewById(R.id.id_do_cal_energy5);
				String sock5_do_cal_energy="Off";
				if (int_sock5_do_cal_energy==0)
				{	sock5_do_cal_energy="Off";
				}
				else if (int_sock5_do_cal_energy==1)
				{	sock5_do_cal_energy="On";
				}
				text_socket5_do_cal_energy_dis.setText(sock5_do_cal_energy);
				
				//Displaying power ratings
				int sock5_power = file6.getInt("key_sok5_power",0);
				TextView text_socket5_power_dis = (TextView) findViewById(R.id.id_powerratingdis5);
				String convert_sock5_power = "" + sock5_power;
				text_socket5_power_dis.setText(convert_sock5_power);
				
				//Dispalying voltage ratings
				int sock5_voltage = file6.getInt("key_sok5_volt",0);
				TextView text_socket5_voltage_dis = (TextView) findViewById(R.id.id_voltageratingdis5);
				String convert_sock5_voltage = "" + sock5_voltage;
				text_socket5_voltage_dis.setText(convert_sock5_voltage);
				
		
				
				LinearLayout layout5 = (LinearLayout) findViewById(R.id.id_layout5);
				TextView sock5_speed = (TextView) findViewById(R.id.id_sock5_speed);
				int sock5_speed_val = file6.getInt("key_sok5_speed",0);
				if (sock5_type == "Analog") {
					layout5.setVisibility(View.VISIBLE);
					sock5_speed.setText("Speed : "+sock5_speed_val);
				}
				else {
					layout5.setVisibility(View.GONE);
				}
				
				/*
				seek5 = (SeekBar) findViewById(R.id.seekBar5);		
				tv5 = (TextView) findViewById(R.id.id_sock5_speed1);
				
				if (sock5_type=="Analog") {
					seek5.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
						public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
							progressChanged5 = progress;
						}
						public void onStartTrackingTouch(SeekBar seekbar) {
						// TODO Auto-generated method stub
						}
						public void onStopTrackingTouch(SeekBar seekbar) {
							tv5.setText(""+progressChanged5);
							SharedPreferences file5 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
							SharedPreferences.Editor file_editor5 = file5.edit();
							file_editor5.putInt("key_sok5_speed",progressChanged5);
							file_editor5.commit();
						}
					});
				}
				else {
					tv5.setText("DISABLED");
				}
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket5, menu);
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
		public void home5(View view) {
			Intent nikhome5 = new Intent(this, Homepage_Devicelist.class);
			startActivity(nikhome5);
		}
		
		//edit settings for socket 1
		public void editSocket5 (View view) {
			Intent intent59 = new Intent(this, Edit_socket5.class);
			startActivity(intent59);
		}
	
}
