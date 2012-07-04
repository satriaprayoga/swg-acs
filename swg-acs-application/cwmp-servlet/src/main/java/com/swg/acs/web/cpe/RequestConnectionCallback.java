/**
 * 
 */
package com.swg.acs.web.cpe;

/**
 * @author satriaprayoga
 *
 */
public interface RequestConnectionCallback {

	public static final RequestConnectionCallback DEFAULT_CALLBACK=new Dummy();
	
	public void onConnected();
	
	static class Dummy implements RequestConnectionCallback{
		@Override
		public void onConnected() {
			
		}
	}
}
