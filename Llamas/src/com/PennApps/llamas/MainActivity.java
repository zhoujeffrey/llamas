package com.PennApps.llamas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.button1).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				
				startActivity(new Intent(getApplicationContext(), GameActivity.class));
				finish();
				
			}
			

			
		});
		
	
		
		
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

	// Gesture listener class
	
	
	
}
