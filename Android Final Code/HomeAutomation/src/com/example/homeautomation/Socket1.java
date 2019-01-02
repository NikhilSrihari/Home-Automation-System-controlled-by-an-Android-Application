package com.example.homeautomation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Socket1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket1);
		
		//Initialising the global file......
		SharedPreferences file6 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		//Displaying connection status
		int int_sock1_con = file6.getInt("key_sok1_con",1);
		TextView text_socket1_con_dis = (TextView) findViewById(R.id.id_condis1);
		String sock1_con="Not Connected";
		if (int_sock1_con==0)
		{	sock1_con="Not Connected";
		}
		else if (int_sock1_con==1)
		{	sock1_con="Connected";
		}
		text_socket1_con_dis.setText(sock1_con);
		
		//Displaying device status
		int int_sock1_stat = file6.getInt("key_sok1_stat",0);
		TextView text_socket1_stat_dis = (TextView) findViewById(R.id.id_statusdis1);
		String sock1_stat="Off";
		if (int_sock1_stat==0)
		{	sock1_stat="Off";
		}
		else if (int_sock1_stat==1)
		{	sock1_stat="On";
		}
		text_socket1_stat_dis.setText(sock1_stat);
		
		//Displaying name
		String sock1_name = file6.getString("key_sok1_name","Null");
		TextView text_socket1_name_dis = (TextView) findViewById(R.id.id_namedis1);
		text_socket1_name_dis.setText(sock1_name);
		//Displaying location
		String sock1_location = file6.getString("key_sok1_location","Null");
		TextView text_socket1_location_dis = (TextView) findViewById(R.id.id_locationdis1);
		text_socket1_location_dis.setText(sock1_location);
		//Displaying type
		String sock1_type = file6.getString("key_sok1_type","Null");
		TextView text_socket1_type_dis = (TextView) findViewById(R.id.id_typedis1);
		text_socket1_type_dis.setText(sock1_type);
		
		//Displaying calculate energy reading
		int int_sock1_do_cal_energy = file6.getInt("key_sok1_energy",0);
		TextView text_socket1_do_cal_energy_dis = (TextView) findViewById(R.id.id_do_cal_energy1);
		String sock1_do_cal_energy="Off";
		if (int_sock1_do_cal_energy==0)
		{	sock1_do_cal_energy="Off";
		}
		else if (int_sock1_do_cal_energy==1)
		{	sock1_do_cal_energy="On";
		}
		text_socket1_do_cal_energy_dis.setText(sock1_do_cal_energy);
		
		//Displaying power ratings
		int sock1_power = file6.getInt("key_sok1_power",0);
		TextView text_socket1_power_dis = (TextView) findViewById(R.id.id_powerratingdis1);
		String convert_sock1_power = "" + sock1_power;
		text_socket1_power_dis.setText(convert_sock1_power);
		
		//Dispalying voltage ratings
		int sock1_voltage = file6.getInt("key_sok1_volt",0);
		TextView text_socket1_voltage_dis = (TextView) findViewById(R.id.id_voltageratingdis1);
		String convert_sock1_voltage = "" + sock1_voltage;
		text_socket1_voltage_dis.setText(convert_sock1_voltage);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket1, menu);
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
	public void home1(View view) {
		Intent nikhome1 = new Intent(this, Homepage_Devicelist.class);
		startActivity(nikhome1);
	}
	
	//edit settings for socket 1
	public void editSocket1 (View view) {
		Intent intent9 = new Intent(this, Edit_socket1.class);
		startActivity(intent9);
	}
	
}
