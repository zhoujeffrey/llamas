package com.pennlist;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import com.commonsware.cwac.loaderex.acl.SQLiteCursorLoader;


public class MainActivity extends ListActivity {
	
	SimpleCursorAdapter mAdapter;
	ListView listView;
    
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    		
    		listView = (ListView) findViewById(android.R.id.list);
    		ViewGroup parent = (ViewGroup) listView.getParent();
    		
    		mAdapter = new SimpleCursorAdapter(this,
    				android.R.layout.simple_list_item_1, null,
    				new String[] { "NAME" }, new int[] { android.R.id.text1 }, 0);

    		
    }

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(getApplicationContext(), "hehe!!!!", Toast.LENGTH_LONG).show();

	}
	
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		String rawQuery = "SELECT _id,NAME FROM NETWORK ORDER BY NAME ASC;";
		String[] queryParams = new String[] {};
		SQLiteCursorLoader loader = new SQLiteCursorLoader(getApplicationContext(), DaoSingleton.getInstance().helper,
				rawQuery, queryParams);

		return loader;
	}

	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// Swap the new cursor in. (The framework will take care of closing the
		// old cursor once we return.)
		mAdapter.changeCursor(data);
	}

	public void onLoaderReset(Loader<Cursor> loader) {
		// This is called when the last Cursor provided to onLoadFinished()
		// above is about to be closed. We need to make sure we are no
		// longer using it.
		mAdapter.changeCursor(null);

	}

	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
