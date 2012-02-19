package com.androidbook.triviaquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class QuizGameActivity extends QuizActivity {
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.game_menu, menu);
		menu.findItem(R.id.settings_menu).setIntent (new Intent(
				getApplicationContext(), QuizSettingsActivity.class));
		menu.findItem(R.id.help_menu).setIntent(new Intent(
				getApplicationContext(), QuizHelpActivity.class));
		return true;
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
    }
}