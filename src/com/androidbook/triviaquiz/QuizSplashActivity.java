package com.androidbook.triviaquiz;

import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.view.animation.*;
import android.view.animation.Animation.*;
import android.widget.*;

public class QuizSplashActivity extends QuizActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        startAnimating();
    }
    
    private void startAnimating() {
    	
        TextView logo1 = (TextView) this.findViewById(R.id.TextViewTopTitle);
        Animation fadeIn1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo1.startAnimation(fadeIn1);
        
        TextView logo2 = (TextView) this.findViewById(R.id.TextViewBottomTitle);
        Animation fadeIn2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        logo2.startAnimation(fadeIn2);
        
        Animation spinnin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController  controller = new LayoutAnimationController(spinnin);
        controller.setOrder(2);
        TableLayout table = (TableLayout) this.findViewById(R.id.tableLayout1);
        for (int i = 0; i < table.getChildCount(); i++) {
        	TableRow row = (TableRow) table.getChildAt(i);
        	row.setLayoutAnimation(controller);
		}
        
        fadeIn2.setAnimationListener(new AnimationListener() {
        	
			public void onAnimationEnd(Animation animation) {
        		// TODO Auto-generated method stub
        		startActivity(new Intent(QuizSplashActivity.this, 
        				QuizMenuActivity.class));
        		QuizSplashActivity.this.finish();
        	}
			public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
       
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		TextView logo1 = (TextView) this.findViewById(R.id.TextViewTopTitle);
		logo1.clearAnimation();
		
		TextView logo2 = (TextView) this.findViewById(R.id.TextViewBottomTitle);
		logo2.clearAnimation();
		
		TableLayout table = (TableLayout) this.findViewById(R.id.tableLayout1);
		for (int i = 0; i < table.getChildCount(); i++) {
			TableRow row = (TableRow) table.getChildAt(i);
			row.clearAnimation();
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		startAnimating();
	}
	
}