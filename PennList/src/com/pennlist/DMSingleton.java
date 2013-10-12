package com.pennlist;



public class DMSingleton {

	private static DMSingleton instance;

	public DataManager dataManager;

	public void initInstance()
	{
			dataManager = new DataManager();

	}

	public static DMSingleton getInstance()
	{
		// Return the instance
		if (instance == null) {
			instance = new DMSingleton();
			instance.initInstance();
		}
		return instance;
	}

	private DMSingleton()
	{
		// Constructor hidden because this is a singleton
	}


}