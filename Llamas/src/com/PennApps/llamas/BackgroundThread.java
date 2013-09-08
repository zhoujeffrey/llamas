package com.PennApps.llamas;

import java.util.ArrayList;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

interface LooperDelegate
{
	public void refreshView(int counter);
}
	
public class BackgroundThread extends AsyncTask<ImageView, Void, Void> {
	
		
	public LooperDelegate loopDelegate = null;

		final int SLEEP_TIME = 50;
		
		ArrayList<Bitmap> allImgs = new ArrayList<Bitmap>();
		
		
		protected void onPreExecute(){
			
		}

		@Override
		protected Void doInBackground(ImageView... params) {
			
			ImageView view = params[0];
			int counter = 1;
			//sets up an infinite loop in the thread
			while(true){
				

				
				// This will cause the thread to sleep for the pre-determined time
				try {
					java.lang.Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(loopDelegate != null)
					loopDelegate.refreshView(counter);
				counter++;
				
				if (counter>42)
					counter=1;
			}
			
			
			// TODO Auto-generated method stub
			
		}

	}