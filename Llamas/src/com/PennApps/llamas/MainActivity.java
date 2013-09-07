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
		class MyGestureDetector extends SimpleOnGestureListener {
		
			@Override
			public boolean onDoubleTap(MotionEvent e) {
				// Drop trampoline image at location e
				
				return false;

			}
			
	 	
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                // Calculate angle
            	double angle = Math.toDegrees(Math.atan2(e2.getY()-e1.getY(),e2.getX()-e1.getX()));
            	
            	// Confirm swipe distance and length
            	 if(Math.abs(e1.getX() - e2.getX()) > Constants.SWIPE_MIN_DISTANCE && Math.abs(velocityX) 
            			 > Constants.SWIPE_THRESHOLD_VELOCITY)
            	 {
            		 if(angle<60 && angle >37) {
            			// Call method steep slope
            		 } else
            			 if (angle<=37 && angle >22){
            				// Call method medium slope
            			 } else 
            				 if (angle<=22 && angle >7){
            					// Call method low slope
            				 } else
            					 if(angle<=7) {
            						 //Call method flat slope
            					 }
            	 	 	 
            		 
            	 } else
            		 return true;
            	
                
       
            } catch (Exception e) {
            	// nothing
            }
            return false;
        }
	}

	
	
}
