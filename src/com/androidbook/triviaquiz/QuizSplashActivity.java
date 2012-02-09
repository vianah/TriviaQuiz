package com.androidbook.triviaquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

public class QuizSplashActivity extends QuizActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        TextView logo1 = (TextView) this.findViewById(R.id.TextViewTopTitle);
        Animation fadeIn1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fadeIn1);
        
        TextView logo2 = (TextView) this.findViewById(R.id.TextViewBottomTitle);
        Animation fadeIn2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        logo2.startAnimation(fadeIn2);
       
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		TextView logo1 = (TextView) this.findViewById(R.id.TextViewBottomTitle);
		logo1.clearAnimation();
	}
}