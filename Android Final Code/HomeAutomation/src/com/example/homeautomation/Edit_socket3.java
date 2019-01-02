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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Edit_socket3 extends Activity {

	int pattisamps=2000;
	String url = "http://nikhilsrihari.site90.net/index.php";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_socket3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_socket3, menu);
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
	
	
	
	

	//EDITING IS COMPLETE......
	public void editComplete3 (View view) {
		String name_value = "NULL";
		String type_value= "NULL" ;
		String location_value = "NULL"; 
		int con_stat_value=0;
		int volt_value=0;
		int power_value=0;
		int cal_energy_value=0;
		EditText editText1 = (EditText) findViewById(R.id.id_edit_device_location3);
		EditText editText2 = (EditText) findViewById(R.id.id_power_rating3);
		EditText editText3 = (EditText) findViewById(R.id.id_voltage_rating3);
		// Creating the only needed intent to main home page...
		Intent intent111 = new Intent(this, Socket3.class);
		
		//Is device connected????
		CheckBox sock1_check_box1 = (CheckBox) findViewById(R.id.id_con3);
		boolean con_checked = sock1_check_box1.isChecked();
		if (con_checked){
			con_stat_value=1;
		}
		else {
			con_stat_value=0;
		}
		if(con_stat_value==1){
			//Device name and device type info......
			CheckBox sock1_check_box2 = (CheckBox) findViewById(R.id.id_tube3);
			CheckBox sock1_check_box3 = (CheckBox) findViewById(R.id.id_fan3);
			CheckBox sock1_check_box4 = (CheckBox) findViewById(R.id.id_bulb3);
			CheckBox sock1_check_box5 = (CheckBox) findViewById(R.id.id_cfl3);
			CheckBox sock1_check_box6 = (CheckBox) findViewById(R.id.id_ac3);
			CheckBox sock1_check_box7 = (CheckBox) findViewById(R.id.id_heater3);
			CheckBox sock1_check_box8 = (CheckBox) findViewById(R.id.id_other_analog3);
			CheckBox sock1_check_box9 = (CheckBox) findViewById(R.id.id_other_digital3);
			boolean sock1_name_checkbox1 = sock1_check_box2.isChecked();
			boolean sock1_name_checkbox2 = sock1_check_box3.isChecked();
			boolean sock1_name_checkbox3 = sock1_check_box4.isChecked();
			boolean sock1_name_checkbox4 = sock1_check_box5.isChecked();
			boolean sock1_name_checkbox5 = sock1_check_box6.isChecked();
			boolean sock1_name_checkbox6 = sock1_check_box7.isChecked();
			boolean sock1_name_checkbox7 = sock1_check_box8.isChecked();
			boolean sock1_name_checkbox8 = sock1_check_box9.isChecked();
			if (sock1_name_checkbox1){
           		name_value="Tubelight";type_value="Digital";
            }
			else if (sock1_name_checkbox2){
            	name_value="Fan";type_value="Analog";
           	}	
			else if (sock1_name_checkbox3){
           		name_value="Incandescent Bulb";type_value="Digital";
         	}	
			else if (sock1_name_checkbox4){
           		name_value="CFL Bulb";type_value="Digital";
            }	
			else if (sock1_name_checkbox5){
           		name_value="Air Conditioner";type_value="Digital";
           	}
			else if (sock1_name_checkbox6){
          		name_value="Heater";type_value="Digital";
         	}	
           	else if (sock1_name_checkbox7){
          		name_value="Other Analog Devices";type_value="Analog";
            }	
            else {
            	name_value="Other Digital Devices";type_value="Digital";
            }
            //Devive location info....
			location_value = editText1.getText().toString();
			//calc energy??? and energy ratings
			CheckBox sock1_check_box10 = (CheckBox) findViewById(R.id.id_edit_calculate_energy3);
			boolean energy_cal_checked = sock1_check_box10.isChecked();
			if (energy_cal_checked) {
				cal_energy_value=1;
			}
			else { 
				cal_energy_value=0;
			}
			if (cal_energy_value==1) {
				power_value = Integer.parseInt(editText2.getText().toString());
				volt_value = Integer.parseInt(editText3.getText().toString());
			}
			else {
				power_value=0;volt_value=0;cal_energy_value=0;
			}
			
		}
		else if (con_stat_value==0){
			name_value="NULL";type_value="NULL";location_value="NULL";
			power_value=0;volt_value=0;cal_energy_value=0;
		}
	    //Updating File.......
		SharedPreferences file10 = getSharedPreferences("global_file", Context.MODE_PRIVATE);		
		SharedPreferences.Editor file_editor10 = file10.edit();
		file_editor10.putString("key_sok3_name",name_value);
		file_editor10.putString("key_sok3_type",type_value);
		file_editor10.putString("key_sok3_location",location_value);
		file_editor10.putInt("key_sok3_con",con_stat_value);
		file_editor10.putInt("key_sok3_volt",volt_value);
		file_editor10.putInt("key_sok3_power",power_value);
		file_editor10.putInt("key_sok3_energy",cal_energy_value);
		file_editor10.putInt("key_sok3_speed",0);
		file_editor10.putInt("key_sok3_stat",0);
		file_editor10.commit();
		
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://nikhilsrihari.site90.net/index.php");
				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
					nameValuePairs.add(new BasicNameValuePair("informa","0e1" ));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					httpclient.execute(httppost); // send the parameter to the server
				}
				catch (ClientProtocolException e) {
		    	 
				} 
				catch (IOException e) {
		    	 
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://nikhilsrihari.site90.net/index.php");
				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
					nameValuePairs.add(new BasicNameValuePair("informa","0r1" ));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					httpclient.execute(httppost); // send the parameter to the server
				}
				catch (ClientProtocolException e) {
		    	 
				} 
				catch (IOException e) {
		    	 
				}
			}
		}).start();
		
		try {
    		Thread.sleep(pattisamps);
		} 
		catch (InterruptedException e) {
		}
		
		new DownloadWebPage_sok3(this).execute(url);
		
	}
	
	
	
	
	public void check3 (View view) {
		String message_analog = "Analog";
		String message_digital = "Digital";
		TextView textview1t = (TextView) findViewById(R.id.id_edit_type_display3);
		CheckBox sock1_check_box20 = (CheckBox) findViewById(R.id.id_tube3);
		CheckBox sock1_check_box30 = (CheckBox) findViewById(R.id.id_fan3);
		CheckBox sock1_check_box40 = (CheckBox) findViewById(R.id.id_bulb3);
		CheckBox sock1_check_box50 = (CheckBox) findViewById(R.id.id_cfl3);
		CheckBox sock1_check_box60 = (CheckBox) findViewById(R.id.id_ac3);
		CheckBox sock1_check_box70 = (CheckBox) findViewById(R.id.id_heater3);
		CheckBox sock1_check_box80 = (CheckBox) findViewById(R.id.id_other_analog3);
		CheckBox sock1_check_box90 = (CheckBox) findViewById(R.id.id_other_digital3);
		boolean sock1_name_checkbox11 = sock1_check_box20.isChecked();
		boolean sock1_name_checkbox21 = sock1_check_box30.isChecked();
		boolean sock1_name_checkbox31 = sock1_check_box40.isChecked();
		boolean sock1_name_checkbox41 = sock1_check_box50.isChecked();
		boolean sock1_name_checkbox51 = sock1_check_box60.isChecked();
		boolean sock1_name_checkbox61 = sock1_check_box70.isChecked();
		boolean sock1_name_checkbox71 = sock1_check_box80.isChecked();
		boolean sock1_name_checkbox81 = sock1_check_box90.isChecked();
		if (sock1_name_checkbox11){
			textview1t.setText(message_digital);
        }
		else if (sock1_name_checkbox21){
			textview1t.setText(message_analog);
       	}	
		else if (sock1_name_checkbox31){
			textview1t.setText(message_digital);
     	}	
		else if (sock1_name_checkbox41){
			textview1t.setText(message_digital);
        }	
		else if (sock1_name_checkbox51){
			textview1t.setText(message_digital);
       	}
		else if (sock1_name_checkbox61){
			textview1t.setText(message_digital);
     	}	
       	else if (sock1_name_checkbox71){
       		textview1t.setText(message_analog);
        }	
        else if (sock1_name_checkbox81){
        	textview1t.setText(message_digital);
        }
        else {
        	textview1t.setText(" ");
        }
        
	}
	
	
	
	
	
	
}
