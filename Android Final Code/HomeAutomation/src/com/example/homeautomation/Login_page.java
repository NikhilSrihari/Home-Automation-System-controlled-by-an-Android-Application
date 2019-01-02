package com.example.homeautomation;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import android.app.Activity;
import android.os.Process;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Login_page extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_page);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_page, menu);
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
	
	// Pressing the login button
	public void loginButton (View view) {
		SharedPreferences file2 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		String message3 = file2.getString("key_user_name","Major Project");
		String message4 = file2.getString("key_pwd","nnvvs");
		Intent intent1 = new Intent(this, Connecting_page.class);
		Intent intent2 = new Intent(this, Login_page.class);
	    EditText editText1 = (EditText) findViewById(R.id.id_user_name);
	    String message1 = editText1.getText().toString();
	    EditText editText2 = (EditText) findViewById(R.id.id_pwd);
	    String message2 = editText2.getText().toString();
	    
	    if (message1.equals(message3)) {
			if (message2.equals(message4)) {
				startActivity(intent1);		
			}
			else {
				startActivity(intent2);
			}
	    }
		else {
			startActivity(intent2);			
		}
		
	}
	
	//Pressing the forgtepwd button
	public void forgetpwdButton (View view) {
		Intent intent3 = new Intent(this, Forgetpwd.class);
		startActivity(intent3);
	}
	
}
