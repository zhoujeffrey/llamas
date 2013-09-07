package com.PennApps.llamas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class BackgroundView extends View {

	public int X_OFFSET;
	Bitmap background;
	
	Paint paint = new Paint();
	
	public BackgroundView(Context context){
		super(context);
		init();
	}
	
	public void onDraw(Canvas c){
		
		// here we want to update the background. depending on the X_OFFSET we will choose which
		// of the images we will draw on the canvas
		
		if (X_OFFSET==0){
			// use the setBackgroundResource(SOME_IMAGE); here
		}
		// finally, based on our logic above, update the image
		c.drawBitmap(background, 0, 0, paint);
	}
	
	
	
	public void init(){
		
	}
	
}
