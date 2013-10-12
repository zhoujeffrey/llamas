package com.pennlist;

import android.app.Application;
import android.content.Context;




public class MyApplication extends Application{
	private static boolean activityVisible;
	private static Context mContext;
	
	@Override
	public void onCreate()
	{
		super.onCreate();
        mContext = this;
//        UAirship.takeOff(this);
//        Log.i("UAirship","We're on");

       // Debug.startMethodTracing();
	}
	

	public void customAppMethod()
	{
		// Custom application method
	}
    public static Context getContext(){
        return mContext;
    }
    public static boolean isActivityVisible() {
        return activityVisible;
    }  

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
         }
}
