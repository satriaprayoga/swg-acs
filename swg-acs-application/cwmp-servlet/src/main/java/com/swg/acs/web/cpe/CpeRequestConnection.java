/**
 * 
 */
package com.swg.acs.web.cpe;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;

/**
 * @author satriaprayoga
 *
 */
public class CpeRequestConnection implements RequestConnection{

	private String acsUsername;
	private String acsPassword;
	
	private String url;
	private int port;
	
	private RequestConnectionCallback requestConnectionCallback=RequestConnectionCallback.DEFAULT_CALLBACK;
	
	public CpeRequestConnection(String url,int port) {
		this.url=url;
		this.port=port;
	}
	
	public CpeRequestConnection(String url) {
		this.url=url;
	}
	
	
	@Override
	public String connect(int maxRetry) throws IOException {
		DefaultHttpClient client=new DefaultHttpClient();
		client.setHttpRequestRetryHandler(new CpeRetryRequestHandler(maxRetry));
		try{
			client.getCredentialsProvider().setCredentials(new AuthScope(url, port), 
					new UsernamePasswordCredentials(acsUsername,acsPassword));
			HttpGet get=new HttpGet(url);
			HttpResponse response=client.execute(get);
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				//TODO:handle response here
			}
		}finally{
			client.getConnectionManager().shutdown();
		}
		if(requestConnectionCallback!=null)
			requestConnectionCallback.onConnected();
		return new String();
	}
	
	public void setUsernamePassword(String username,String password){
		acsUsername=username;
		acsPassword=password;
	}
	
	public void setRequestConnectionCallback(
			RequestConnectionCallback requestConnectionCallback) {
		this.requestConnectionCallback = requestConnectionCallback;
	}
	
	public RequestConnectionCallback getRequestConnectionCallback() {
		return requestConnectionCallback;
	}
	
	private static class CpeRetryRequestHandler implements HttpRequestRetryHandler{

		private final int maxRetry;
		
		public CpeRetryRequestHandler(int maxRetry) {
			this.maxRetry=maxRetry;
		}
		
		@Override
		public boolean retryRequest(IOException exception, int executionCount,
				HttpContext context) {
			if(executionCount>=maxRetry){
				return false;
			}
			HttpRequest request = (HttpRequest) context.getAttribute(
	                ExecutionContext.HTTP_REQUEST);
	        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest); 
	        if (idempotent) {
	            return true;
	        }
			return false;
		}
		
	}

}
