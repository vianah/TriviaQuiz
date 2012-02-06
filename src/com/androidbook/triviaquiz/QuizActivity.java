package com.androidbook.triviaquiz;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;

public class QuizActivity extends Activity {
    
	public static final String GAME_PREFERENCES = "GamePrefs";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		SharedPreferences Settings = 
				getSharedPreferences(GAME_PREFERENCES, MODE_PRIVATE);
		SharedPreferences.Editor PrefEditor = Settings.edit();
		PrefEditor.putString("UserName", "Wiltzu");
		PrefEditor.putInt("Age", 21);
		PrefEditor.commit();
		
		if(Settings.contains("UserName")) {
			// We have a user name
			String user = Settings.getString("UserName", "Wiltzu");
		}
	}
 
}