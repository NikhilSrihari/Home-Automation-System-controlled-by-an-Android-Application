package com.example.homeautomation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Forgetpwd extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forgetpwd);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.forgetpwd, menu);
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
	
	//Master code/password....
	public void masterpwd(View view) {
		SharedPreferences file3 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		String message3 = file3.getString("key_master_pwd","nnvvs");
		Intent intent4 = new Intent(this, Login_page.class);
		Intent intent8 = new Intent(this, Resetpwd.class);
	    EditText editText1 = (EditText) findViewById(R.id.id_masterpwd);
	    String message1 = editText1.getText().toString();
	    if (message1.equals(message3)) {
	    	SharedPreferences.Editor file_editor3 = file3.edit();
			file_editor3.putString("key_user_name","Major Project");
			file_editor3.putString("key_pwd","nnvvs");
			file_editor3.commit();
	    	startActivity(intent8);
	    	
	    }
	    else {
	    	startActivity(intent4);
	    }
	}

	public void securityquestion(View view) {
		SharedPreferences file4 = getSharedPreferences("global_file", Context.MODE_PRIVATE);
		String message4 = file4.getString("key_sec_question","trical");
		Intent intent6 = new Intent(this, Login_page.class);
	    Intent intent7 = new Intent(this, Resetpwd.class);
	    EditText editText2 = (EditText) findViewById(R.id.id_securityquestion);
	    String message2 = editText2.getText().toString();
	    if (message4.equals(message2)) {
	    	
	    	SharedPreferences.Editor file_editor4 = file4.edit();
			file_editor4.putString("key_user_name","Major Project");
			file_editor4.putString("key_pwd","nnvvs");
			file_editor4.commit();
	    	startActivity(intent7);
	    }
	    else {
	    	startActivity(intent6);
	    }
	}
	
}
