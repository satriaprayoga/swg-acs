/**
 * 
 */
package com.swg.acs.web;

import com.swg.acs.message.soap.MessageParser;
import com.swg.acs.message.soap.SoapMessageBuilder;

/**
 * @author satriaprayoga
 *
 */
public interface CwmpSoapContext {

	public SoapMessageBuilder getSoapMessageBuilder();
	public MessageParser getMessageParser();
	public Authenticator getAuthenticator();
}
