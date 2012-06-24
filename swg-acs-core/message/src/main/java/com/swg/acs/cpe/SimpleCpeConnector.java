/**
 * 
 */
package com.swg.acs.cpe;

import java.net.URL;

/**
 * @author satriaprayoga
 *
 */
public class SimpleCpeConnector implements CpeConnector{

	private URL cpeUrl;
	
	private boolean connected=false;
	
	public SimpleCpeConnector(URL cpeUrl) {
		this.cpeUrl=cpeUrl;
	}
	
	@Override
	public void requestConnection(){
		//TODO: isi method buat koneksi ke cpe
	}
	
	public synchronized URL getCpeUrl() {
		if(!connected)
			return null;
		return cpeUrl;
	}
	
	public boolean isConnected() {
		return connected;
	}

}
