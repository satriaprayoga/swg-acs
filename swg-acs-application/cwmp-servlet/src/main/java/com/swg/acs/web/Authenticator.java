/**
 * 
 */
package com.swg.acs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author satriaprayoga
 *
 */
public interface Authenticator {

	public boolean authenticate(HttpServletRequest request,HttpServletResponse response);
	
	public boolean isBasic(HttpServletRequest request,HttpServletResponse response);
	
	public boolean isDigest(HttpServletRequest request,HttpServletResponse response);
}
