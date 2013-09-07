package com.PennApps.llamas;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class GameActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		ImageView img = (ImageView) findViewById(R.id.gameBg);
		img.setBackgroundResource(R.drawable.background);
		
		// Get the background, which has been compiled to an AnimationDrawable object.
		 AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();
		 
		 frameAnimation.start();
			
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
}
