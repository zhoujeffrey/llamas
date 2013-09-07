package com.PennApps.llamas;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

public class GameActivity extends Activity {
	@Override
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
		while (true) {
			// There are still objects in the data structure compare the location of the object
			// with the location of the LLama
			
			
			// Test object
			int temp_obj_x = 0;
			int temp_obj_y = 0;
			
			if (llama_x != temp_obj_x) {
				// If x is no not there, don't look at y
				
				if (llama_y != temp_obj_y) {
					// Check to see that y is okay
					handle_collision();
					// return true;
				}
				else {
					// return false;
				}
			}
			else {
				// return false;
			}
		}
	}
	
	private boolean handle_collision(){
		return false;
	}
	
	
	public class BackgroundThread extends AsyncTask<ImageView, Void, Void> {
	
		final int SLEEP_TIME = 10;

		@Override
		protected Void doInBackground(ImageView... params) {
			
			ImageView view = params[0];
			
			
			
			return null;
//			//sets up an infinite loop in the thread
//			while(true){
//				
//				view.X_OFFSET += 5;
//				view.postInvalidate();
//				// This will cause the thread to sleep for the pre-determined time
//				try {
//					java.lang.Thread.sleep(SLEEP_TIME);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//			}
//			
			
			// TODO Auto-generated method stub
			
		}

	}
}
