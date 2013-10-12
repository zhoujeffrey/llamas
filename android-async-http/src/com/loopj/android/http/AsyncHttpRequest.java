/*
    Android Asynchronous Http Client
    Copyright (c) 2011 James Smith <james@loopj.com>
    http://loopj.com

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.loopj.android.http;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

import android.util.Log;

class AsyncHttpRequest implements Runnable {
    private final AbstractHttpClient client;
    private final HttpContext context;
    private final HttpUriRequest request;
    private final AsyncHttpResponseHandler responseHandler;
    private boolean isBinaryRequest;
    private int executionCount;

    public AsyncHttpRequest(AbstractHttpClient client, HttpContext context, HttpUriRequest request, AsyncHttpResponseHandler responseHandler) {
        this.client = client;
        this.context = context;
        this.request = request;
        this.responseHandler = responseHandler;
        if(responseHandler instanceof BinaryHttpResponseHandler) {
            this.isBinaryRequest = true;
        }
    }

    @Override
    public void run() {
        try {
            if(responseHandler != null){
                responseHandler.sendStartMessage();
            }

            makeRequestWithRetries();
			Log.i("Timeout", "past make request with retries");

//            if(responseHandler != null) {
//                responseHandler.sendFinishMessage();
//            }
        } catch (IOException e) {
            if(responseHandler != null) {
                responseHandler.sendFinishMessage(e, (String) null);
                
                if(this.isBinaryRequest) {
                    responseHandler.sendFailureMessage(e, (byte[]) null);
                } else {
                    responseHandler.sendFailureMessage(e, (String) null);
                }
            }
        } catch (Exception e){
        	responseHandler.sendFailureMessage(e,"generic error");
        }
    }

    private void makeRequest() throws IOException {
        if(!Thread.currentThread().isInterrupted()) {
        	try {
        		HttpResponse response = client.execute(request, context);
        		if(!Thread.currentThread().isInterrupted()) {
        			if(responseHandler != null) {
        				responseHandler.sendResponseMessage(response);
            			Log.i("Timeout", "IN MAKE REQUEST TRY LOOP IF HANDLER EXISTS response: "+response.toString());

        			}
        		} else{
        			Log.i("Timeout", "IN MAKE REQUEST TRY LOOP ELSE (HANDLER DOES NOT EXIST)");

        			//TODO: should raise InterruptedException? this block is reached whenever the request is cancelled before its response is received
        		}
        	} catch (IOException e) {
        		if(!Thread.currentThread().isInterrupted()) {
        			Log.i("Timeout", "IN MAKE REQUEST IO EXCEPTION: "+e.getCause());
        			Log.i("Timeout", "INMAKE REQUEST IO EXCEPTION: "+e.getMessage());
        			
        			throw e;
        		}
        	}
        }
    }

    private void makeRequestWithRetries() throws SocketTimeoutException {
        // This is an additional layer of retry logic lifted from droid-fu
        // See: https://github.com/kaeppler/droid-fu/blob/master/src/main/java/com/github/droidfu/http/BetterHttpRequestBase.java
        boolean retry = true;
        IOException cause = null;
        HttpRequestRetryHandler retryHandler = client.getHttpRequestRetryHandler();
        while (retry) {
            try {
                makeRequest();
                return;
            } catch (UnknownHostException e) {
		        if(responseHandler != null) {
		            responseHandler.sendFailureMessage(e, "can't resolve host");
		        }
	        	return;
        
            } catch (IOException e) {
            	if (e instanceof SocketTimeoutException) {
            		if(responseHandler != null) {
            			responseHandler.sendFailureMessage(e, "socket time out");
            			Log.i("Timeout", "IN ASYNC CAUSE: "+e.getCause());
            			Log.i("Timeout", "IN ASYNC MESSAGE: "+e.getMessage());
            			return;
            		}
            	} else if (e instanceof SocketException) {
            		if(responseHandler != null) {
            			responseHandler.sendFailureMessage(e, "socket time out");
            		}
            		return;
            	}

            	else {
            		cause = e;
            		retry = retryHandler.retryRequest(cause, ++executionCount, context);
            	}
            } catch (NullPointerException e) {
                // there's a bug in HttpClient 4.0.x that on some occasions causes
                // DefaultRequestExecutor to throw an NPE, see
                // http://code.google.com/p/android/issues/detail?id=5255
                cause = new IOException("NPE in HttpClient" + e.getMessage());
                retry = retryHandler.retryRequest(cause, ++executionCount, context);
            }
        }

        // no retries left, crap out with exception
        SocketTimeoutException ex = new SocketTimeoutException();
        ex.initCause(cause);
        throw ex;
    }
}
