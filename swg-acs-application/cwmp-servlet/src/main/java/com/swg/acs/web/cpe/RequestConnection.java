/**
 * 
 */
package com.swg.acs.web.cpe;

import java.io.IOException;

/**
 * Interface untuk mengirim Connection Request ke CPE
 * @author satriaprayoga
 *
 */
public interface RequestConnection {

	/**
	 * method untuk ngirim connection request
	 * @param maxRetry maksimum usaha koneksi ke cpe
	 * @return
	 * @throws IOException
	 */
	public String connect(int maxRetry)throws IOException;
}
