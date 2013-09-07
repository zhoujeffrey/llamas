package com.PennApps.llamas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.ImageView;

public class GameActivity extends Activity {
	
	private List<Obstacle> obstacle_list = new ArrayList<Obstacle>();
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		BackgroundThread thread = new BackgroundThread();
		thread.execute();
		
		ImageView img = (ImageView) findViewById(R.id.gameBg);
		img.setBackgroundResource(R.drawable.f01);

//		// Get the background, which has been compiled to an AnimationDrawable object.
//		 AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
//		 
//		 frameAnimation.start();
		 
		 
			
	}
	
	private void calculate_collision(float llama_x, float llama_y) {
		// Cycle through data object
		
		int i = 0;
		Obstacle test_this_obs;
		
		while (i < obstacle_list.size()) {
			test_this_obs = obstacle_list.get(i);
			
			if (llama_x >= test_this_obs.loc_x && llama_x <= test_this_obs.loc_x + test_this_obs.len_x) {
				// If x is no not there, don't look at y
				if (llama_y >= test_this_obs.loc_y && llama_y <= test_this_obs.loc_y + test_this_obs.len_y) {
					// Check to see that y is okay
					handle_collision(test_this_obs);
				}
			}
			i++;
		}
	}
	
	private boolean handle_collision(Obstacle collided_obstacle){
		if (collided_obstacle.type == 0){
			// Death
			return false;
		}
		else if (collided_obstacle.type == 1) {
			// Some sort of Jump Action
			return true;
		}
		else {
			// Something else
			return true;
		}
	}
	
	
	public class BackgroundThread extends AsyncTask<ImageView, Void, Void> {
	
		final int SLEEP_TIME = 50;
		
		ArrayList<Bitmap> allImgs = new ArrayList<Bitmap>();
		
		protected void onPreExecute(){
			
		}

		@Override
		protected Void doInBackground(ImageView... params) {
			
			
			int counter = R.drawable.f01;
			//sets up an infinite loop in the thread
			while(true){
				
				// This will cause the thread to sleep for the pre-determined time
				try {
					java.lang.Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ImageView view = params[0];
				view.setBackgroundResource(counter);
				if (counter==R.drawable.f42) counter = R.drawable.f01;
				else counter++;
			}
			
			
			// TODO Auto-generated method stub
			
		}

	}
	
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
