package com.PennApps.llamas;

import android.os.Bundle;
import android.app.Activity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Gesture listener class
	
		 	private static final int SWIPE_MIN_DISTANCE = 120;
	    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
	
	class MyGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                // Calculate angle
            	double angle = Math.toDegrees(Math.atan2(e2.getY()-e1.getY(),e2.getX()-e1.getX()));
            	
            	// Confirm swipe distance and length
            	 if(Math.abs(e1.getX() - e2.getX()) > SWIPE_MIN_DISTANCE && Math.abs(velocityX) 
            			 > SWIPE_THRESHOLD_VELOCITY)
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
