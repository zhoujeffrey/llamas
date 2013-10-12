package com.pennlist;

import java.io.UnsupportedEncodingException;

import org.apache.http.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.PersistentCookieStore;
import com.loopj.android.http.RequestParams;

public class ServerSingleton {
	
	private static ServerSingleton instance;

    private final String BASE_URL = com.pennlist.Constants.API_URL;

    private AsyncHttpClient client;
    private PersistentCookieStore cookieStore;
    private Context context;
    
    
    public static ServerSingleton initInstance(Context con)
	{
    		instance= new ServerSingleton ();
			instance.context = con;
	    	instance.client = new AsyncHttpClient();
//	    	instance.cookieStore = new PersistentCookieStore(con);
//	    	instance.client.setCookieStore(instance.cookieStore);
//	    	instance.client.addHeader("Accept", "application/json");
//	    	instance.client.addHeader("Content-Type","application/json");
//	    	try {
//				instance.client.setUserAgent("PocketFlock/"+MyApplication.getContext().getPackageManager().getPackageInfo(MyApplication.getContext().getPackageName(), 0).versionName+" (android, "+Build.MODEL+", "+Build.VERSION.SDK_INT+")");
//			} catch (NameNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
	        instance.client.setTimeout(com.pennlist.Constants.TIMEOUT);

	       


		return instance;
	}
    
    public void clearCookies(){
    	cookieStore.clear();
    }
    
	public static ServerSingleton getInstance()
	{
		// Return the instance

		if (instance == null) {
			initInstance(MyApplication.getContext());

		}

		return instance;
	}

	private ServerSingleton()
	{
		// Constructor hidden because this is a singleton
	}
	

	public void login(String email, String password, AsyncHttpResponseHandler handler) {
    	JSONObject info = new JSONObject();
    	try {
    		JSONObject container = new JSONObject();
//    		container.put("email",email);
//    		container.put("password",password);
    		container.put("email","yoshimi77@gmail.com");
    		container.put("password","longstone");
    		info.put("user",container);


		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
        post("sessions",info,handler);
        
        //On successful login, save shared preference with token and then include token in all posts if not null

    }
	
	public boolean isOnline(){
    	ConnectivityManager cm = (ConnectivityManager) MyApplication.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo netInfo = cm.getActiveNetworkInfo();
    	if(netInfo != null && netInfo.isConnectedOrConnecting())
    		return true;
    	
    	return false;
    }
	
    private String getAbsoluteUrl(String relativeUrl) {

    	
    	return BASE_URL + relativeUrl;
    }
	
	 public void post(final String url, final JSONObject params, final AsyncHttpResponseHandler responseHandler) {
	    	
		
	    				JSONObject paramsToSend = params;
	    				
	    				// ACCESS SHARED PREFERNECE AND PULL TOKEN
	    				
	    				
	    				try {
							paramsToSend.put("token","INSERT TOKEN VALUE HERE");
						} catch (JSONException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	    				try {
							client.post(context,getAbsoluteUrl(url), new StringEntity(paramsToSend.toString()), "application/json",responseHandler);
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	    
	    }
	 

	    public void get(String url, JSONObject params, AsyncHttpResponseHandler responseHandler) {
	    	RequestParams rparam = new RequestParams();
	    	try {
	    		// TODO: Generalize this method!
				rparam.put("query",params.getString("query"));
			} catch (JSONException e) {
				e.printStackTrace();
			}
	        client.get(getAbsoluteUrl(url), rparam, responseHandler);
	    }
	    
	    public void get(String url, AsyncHttpResponseHandler asyncHttpResponseHandler) {
	        client.get(getAbsoluteUrl(url), asyncHttpResponseHandler);
	    }
	    public void put(final String url, final JSONObject params, final AsyncHttpResponseHandler responseHandler) {
	    			
	    	JSONObject paramsToSend = params;
			
	    	
			// ACCESS SHARED PREFERNECE AND PULL TOKEN
	    	
	    			try{
	    				paramsToSend.put("token","INSERT TOKEN VALUE HERE");
						client.put(context,getAbsoluteUrl(url), new StringEntity(paramsToSend.toString()), "application/json",responseHandler);
					}
	    	        catch (JSONException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	        catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

					}
	    		}
	

		}

