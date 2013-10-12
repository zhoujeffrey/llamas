package com.pennlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.pennlist.DaoMaster.DevOpenHelper;



public class DaoSingleton {


		private static DaoSingleton instance;

		public DaoMaster daoMaster;
		public DaoSession daoSession;
		public SQLiteDatabase db;
		public DevOpenHelper helper;

		public void initInstance(Context c)
		{
			helper = new DaoMaster.DevOpenHelper(c, "com.pennlist", null);
			db = helper.getWritableDatabase();
			daoMaster = new DaoMaster(db);
			daoSession = daoMaster.newSession();
			assert(daoSession != null);
		}

		public static DaoSingleton getInstance()
		{
			// Return the instance
			if(instance == null)
			{
				instance = new DaoSingleton();
				instance.initInstance(MyApplication.getContext());
			}
			return instance;
		}

		private DaoSingleton()
		{
			// Constructor hidden because this is a singleton
		}

		public void customSingletonMethod()
		{
			// Custom method
		}
	}