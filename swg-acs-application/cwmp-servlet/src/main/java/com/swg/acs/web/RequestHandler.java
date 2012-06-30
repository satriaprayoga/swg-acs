/**
 * 
 */
package com.swg.acs.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPException;

import com.swg.acs.Message;

/**
 * @author satriaprayoga
 *
 */
public interface RequestHandler {

	Message getMessageRequest(HttpServletRequest request)throws SOAPException,IOException;
	
	Message sendResponse(Message request,OutputStream outputStream)throws SOAPException,IOException;
}
