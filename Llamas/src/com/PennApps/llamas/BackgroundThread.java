package com.PennApps.llamas;

import android.os.AsyncTask;

public class BackgroundThread extends AsyncTask<BackgroundView, Void, Void> {
	
	final int SLEEP_TIME = 100;

	@Override
	protected Void doInBackground(BackgroundView... params) {
		
		BackgroundView view = params[0]; 
		
		//sets up an infinite loop in the thread
		while(true){
			
			view.X_OFFSET += 5;
			view.postInvalidate();
			// This will cause the thread to sleep for the pre-determined time
			try {
				java.lang.Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		// TODO Auto-generated method stub
		
	}

}
