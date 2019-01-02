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
import android.widget.TextView;

public class Socket2 extends Activity {

	//private SeekBar seek2 = null;
	int progressChanged2 = 0;
	int pattisamps=2000;
	String url = "http://nikhilsrihari.site90.net/index.php";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket2);
		
		
				//Initialising the global file......
				SharedPreferences file6 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
				
				//Displaying connection status
				int int_sock2_con = file6.getInt("key_sok2_con",1);
				TextView text_socket2_con_dis = (TextView) findViewById(R.id.id_condis2);
				String sock2_con="Not Connected";
				if (int_sock2_con==0)
				{	sock2_con="Not Connected";
				}
				else if (int_sock2_con==1)
				{	sock2_con="Connected";
				}
				text_socket2_con_dis.setText(sock2_con);
				
				//Displaying device status
				int int_sock2_stat = file6.getInt("key_sok2_stat",0);
				TextView text_socket2_stat_dis = (TextView) findViewById(R.id.id_statusdis2);
				String sock2_stat="Off";
				if (int_sock2_stat==0)
				{	sock2_stat="Off";
				}
				else if (int_sock2_stat==1)
				{	sock2_stat="On";
				}
				text_socket2_stat_dis.setText(sock2_stat);
				
				//Displaying name
				String sock2_name = file6.getString("key_sok2_name","Null");
				TextView text_socket2_name_dis = (TextView) findViewById(R.id.id_namedis2);
				text_socket2_name_dis.setText(sock2_name);
				//Displaying location
				String sock2_location = file6.getString("key_sok2_location","Null");
				TextView text_socket2_location_dis = (TextView) findViewById(R.id.id_locationdis2);
				text_socket2_location_dis.setText(sock2_location);
				//Displaying type
				String sock2_type = file6.getString("key_sok2_type","Null");
				TextView text_socket2_type_dis = (TextView) findViewById(R.id.id_typedis2);
				text_socket2_type_dis.setText(sock2_type);
			
				//Displaying calculate energy reading
				int int_sock2_do_cal_energy = file6.getInt("key_sok2_energy",0);
				TextView text_socket2_do_cal_energy_dis = (TextView) findViewById(R.id.id_do_cal_energy2);
				String sock2_do_cal_energy="Off";
				if (int_sock2_do_cal_energy==0)
				{	sock2_do_cal_energy="Off";
				}
				else if (int_sock2_do_cal_energy==1)
				{	sock2_do_cal_energy="On";
				}
				text_socket2_do_cal_energy_dis.setText(sock2_do_cal_energy);
				
				//Displaying power ratings
				int sock2_power = file6.getInt("key_sok2_power",0);
				TextView text_socket2_power_dis = (TextView) findViewById(R.id.id_powerratingdis2);
				String convert_sock2_power = "" + sock2_power;
				text_socket2_power_dis.setText(convert_sock2_power);
				
				//Dispalying voltage ratings
				int sock2_voltage = file6.getInt("key_sok2_volt",0);
				TextView text_socket2_voltage_dis = (TextView) findViewById(R.id.id_voltageratingdis2);
				String convert_sock2_voltage = "" + sock2_voltage;
				text_socket2_voltage_dis.setText(convert_sock2_voltage);
				LinearLayout layout2 = (LinearLayout) findViewById(R.id.id_layout2);
				
				TextView sock2_speed = (TextView) findViewById(R.id.id_sock2_speed);
				int sock2_speed_val = file6.getInt("key_sok2_speed",0);
				if (sock2_type == "Analog") {
					layout2.setVisibility(View.VISIBLE);
					sock2_speed.setText("Speed : "+sock2_speed_val);
				}
				else {
					layout2.setVisibility(View.GONE);
				}
				
				/*
				seek2 = (SeekBar) findViewById(R.id.seekBar2);		
				tv2 = (TextView) findViewById(R.id.id_sock2_speed1);
				seek2.setVisibility(v);
				if (sock2_type=="Analog") {
					seek2.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
						public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser){
							progressChanged2 = progress;
						}
						public void onStartTrackingTouch(SeekBar seekbar) {
						// TODO Auto-generated method stub
						}
						public void onStopTrackingTouch(SeekBar seekbar) {
							
							
							
							tv2.setText(""+progressChanged2);
							
							SharedPreferences file2 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
							SharedPreferences.Editor file_editor2 = file2.edit();
							file_editor2.putInt("key_sok2_speed",progressChanged2);
							file_editor2.commit();
							
							
							
							make_u_sleep();
							
						}
					});
				}
				else {
					tv2.setText("DISABLED");
				}
					*/
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket2, menu);
		return true;
	}
	
	/*
	public void make_u_sleep(){
		try {
    		Thread.sleep(pattisamps);
		} 
		catch (InterruptedException e) {
		}
	}
 */
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
		public void home2(View view) {
			Intent nikhome2 = new Intent(this, Homepage_Devicelist.class);
			startActivity(nikhome2);
		}
		
		//edit settings for socket 2
		public void editSocket2 (View view) {
			Intent intent29 = new Intent(this,Edit_socket2.class);
			startActivity(intent29);
		}
	
}
