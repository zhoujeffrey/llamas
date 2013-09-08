package com.PennApps.llamas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.util.Log;
import android.widget.ImageView;

public class GameActivity extends Activity implements LooperDelegate {
	ImageView img = null;
	int score;
	final BackgroundThread thread = new BackgroundThread();
	private int llama_y, base_y, base_x;
	private float llama_y_vel;
	
	int[] backgroundImageArray = {
			R.drawable.f01,
			R.drawable.f02,
			R.drawable.f03,
			R.drawable.f04,
			R.drawable.f05,
			R.drawable.f06,
			R.drawable.f07,
			R.drawable.f08,
			R.drawable.f09,
			R.drawable.f10,
			R.drawable.f11,
			R.drawable.f12,
			R.drawable.f13,
			R.drawable.f14,
			R.drawable.f15,
			R.drawable.f16,
			R.drawable.f17,
			R.drawable.f18,
			R.drawable.f19,
			R.drawable.f20,
			R.drawable.f21,
			R.drawable.f22,
			R.drawable.f23,
			R.drawable.f24,
			R.drawable.f25,
			R.drawable.f26,
			R.drawable.f27,
			R.drawable.f28,
			R.drawable.f29,
			R.drawable.f30,
			R.drawable.f31,
			R.drawable.f32,
			R.drawable.f33,
			R.drawable.f34,
			R.drawable.f35,
			R.drawable.f36,
			R.drawable.f37,
			R.drawable.f38,
			R.drawable.f39,
			R.drawable.f40,
			R.drawable.f41,
			R.drawable.f42,
	};
	/*
	class AnotherView extends ImageView {

		public AnotherView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}
		
		public void onDraw(){
			
		}
		
	}
	*/
	
	private List<Obstacle> obstacle_list = new ArrayList<Obstacle>();
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		score = 0;

		img = (ImageView) findViewById(R.id.bgView);;
		img.setBackgroundResource(R.drawable.f01);
		
		
		
    	thread.loopDelegate = this;
		thread.execute(img);
		

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
			
			if (base_x <= test_this_obs.loc_x) {
				// If x is no not there, don't look at y
				if (llama_y >= test_this_obs.loc_y && llama_y <= test_this_obs.loc_y + test_this_obs.len_y) {
					// Check to see that y is okay
					handle_collision(test_this_obs);
				}
			}
			i++;
		}
	}
	
	private void handle_collision(Obstacle collided_obstacle){
		if (collided_obstacle.type == 0){
			thread.cancel(true);
			this.finish();
			startActivity(new Intent(getApplicationContext(), MainActivity.class));
			
		}
		else {
			// Trampoline
			
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



	@Override
	public void refreshView(final int counter) {
		
		runOnUiThread(new Runnable() {
		     public void run() {



		    	 if(img!=null) {
		    			img.setBackgroundResource(backgroundImageArray[counter-1]);	
		    	 }
		    	 calculate_collision(10, 10);
		    	 if(llama_y > base_y) {
		    		 llama_y = llama_y - 5;
		    		 if (llama_y < base_y) {
		    			 llama_y = base_y;
		    		 }
		    	 }
		    }
		});
		
		
		
	}

}
