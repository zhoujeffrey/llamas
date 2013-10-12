package com.pennlist;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import android.content.Context;
import android.content.SharedPreferences;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.pennlist.ListingDao.Properties;



public class DataManager {
	
	public void pullListingsFromServer() {
		SharedPreferences timestampPreferences = MyApplication.getContext().getSharedPreferences(Constants.sharedPrefsKey, Context.MODE_PRIVATE);
		String timestamp = timestampPreferences.getString(Constants.sharedPrefsTimeStamp,null); 

		
		ServerSingleton.getInstance().get("XXXX DUMMY link",new AsyncHttpResponseHandler() {
			@Override
			public void onSuccess(String responseString){
				
				
				JsonFactory jsonFactory = new JsonFactory(); 
				JsonParser jp;
				
				try {
					jp = jsonFactory.createJsonParser(responseString);
					jp.nextToken();
					
					Listing listingToAdd;
					ObjectMapper mapper = new ObjectMapper();
					mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
					List<Listing> id_matches;
					
					while (jp.nextToken() == JsonToken.START_OBJECT) {
						
						// Check if it matches current listing
						listingToAdd = mapper.readValue(jp, Listing.class);
//Update function						
//						id_matches = DaoSingleton.getInstance().daoSession.getListingDao().queryBuilder()
//								.where(Properties.Id.eq(listingToAdd.getId()),Properties.Date.eq(listingToAdd.getDate())).list();
//						
//						if(id_matches.size()>0)
//						{}
//							// Update function
//						else {
							DaoSingleton.getInstance().daoSession.insert(listingToAdd);
//						}
					}
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				
				
			}
			
			
		});
	}
	

}