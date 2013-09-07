package com.PennApps.llamas;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class GameActivity extends Activity {
	
	
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
		
		ImageView img = (ImageView) findViewById(R.id.gameBg);
		img.setBackgroundResource(R.drawable.f01);
		
		
		//BackgroundThread thread = new BackgroundThread();
		//thread.execute(img);
		

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
			
			ImageView view = params[0];
			
			//sets up an infinite loop in the thread
			while(true){
				

				
				// This will cause the thread to sleep for the pre-determined time
				try {
					java.lang.Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				view.postInvalidate();
				
			}
			
			
			// TODO Auto-generated method stub
			
		}

	}
}
