package com.PennApps.llamas;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AnotherView extends ImageView {

	int counter = R.drawable.f01;
	
	public AnotherView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public AnotherView(Context context, AttributeSet as){
		super(context);
	}
	
	@Override
	public void onDraw(Canvas c){

		if (counter==R.drawable.f01) setBackgroundResource(R.drawable.f01);
		if (counter==R.drawable.f02) setBackgroundResource(R.drawable.f02); 
		if (counter==R.drawable.f03) setBackgroundResource(R.drawable.f03); 
		if (counter==R.drawable.f04) setBackgroundResource(R.drawable.f04);
		if (counter==R.drawable.f05) setBackgroundResource(R.drawable.f05); 
		if (counter==R.drawable.f06) setBackgroundResource(R.drawable.f06); 
		if (counter==R.drawable.f07) setBackgroundResource(R.drawable.f07); 
		if (counter==R.drawable.f08) setBackgroundResource(R.drawable.f08); 
		if (counter==R.drawable.f09) setBackgroundResource(R.drawable.f09); 
		if (counter==R.drawable.f10) setBackgroundResource(R.drawable.f10); 
		if (counter==R.drawable.f11) setBackgroundResource(R.drawable.f11); 
		if (counter==R.drawable.f12) setBackgroundResource(R.drawable.f12); 
		if (counter==R.drawable.f13) setBackgroundResource(R.drawable.f13); 
		if (counter==R.drawable.f14) setBackgroundResource(R.drawable.f14); 
		if (counter==R.drawable.f15) setBackgroundResource(R.drawable.f15); 
		if (counter==R.drawable.f16) setBackgroundResource(R.drawable.f16); 
		if (counter==R.drawable.f17) setBackgroundResource(R.drawable.f17); 
		if (counter==R.drawable.f18) setBackgroundResource(R.drawable.f18); 
		if (counter==R.drawable.f19) setBackgroundResource(R.drawable.f19); 
		if (counter==R.drawable.f20) setBackgroundResource(R.drawable.f20); 
		if (counter==R.drawable.f21) setBackgroundResource(R.drawable.f21); 
		if (counter==R.drawable.f22) setBackgroundResource(R.drawable.f22); 
		if (counter==R.drawable.f23) setBackgroundResource(R.drawable.f23); 
		if (counter==R.drawable.f24) setBackgroundResource(R.drawable.f24); 
		if (counter==R.drawable.f25) setBackgroundResource(R.drawable.f25); 
		if (counter==R.drawable.f26) setBackgroundResource(R.drawable.f26); 
		if (counter==R.drawable.f27) setBackgroundResource(R.drawable.f27); 
		if (counter==R.drawable.f28) setBackgroundResource(R.drawable.f28); 
		if (counter==R.drawable.f29) setBackgroundResource(R.drawable.f29); 
		if (counter==R.drawable.f30) setBackgroundResource(R.drawable.f30); 
		if (counter==R.drawable.f31) setBackgroundResource(R.drawable.f31); 
		if (counter==R.drawable.f32) setBackgroundResource(R.drawable.f32); 
		if (counter==R.drawable.f33) setBackgroundResource(R.drawable.f33); 
		if (counter==R.drawable.f34) setBackgroundResource(R.drawable.f34); 
		if (counter==R.drawable.f35) setBackgroundResource(R.drawable.f35); 
		if (counter==R.drawable.f36) setBackgroundResource(R.drawable.f36); 
		if (counter==R.drawable.f37) setBackgroundResource(R.drawable.f37); 
		if (counter==R.drawable.f38) setBackgroundResource(R.drawable.f38); 
		if (counter==R.drawable.f39) setBackgroundResource(R.drawable.f39); 
		if (counter==R.drawable.f40) setBackgroundResource(R.drawable.f40); 
		if (counter==R.drawable.f41) setBackgroundResource(R.drawable.f41);
		if (counter==R.drawable.f42) {
			setBackgroundResource(R.drawable.f42); 
			counter = R.drawable.f01-1;
		}
		counter++;
	
		
		
		
		
	}

}
