/**
 * 
 */
package com.swg.acs.web;

import com.swg.acs.message.soap.CwmpMessageBuilder;
import com.swg.acs.message.soap.CwmpMessageParser;
import com.swg.acs.message.soap.MessageParser;
import com.swg.acs.message.soap.SoapMessageBuilder;

/**
 * @author satriaprayoga
 *
 */
class Default implements CwmpSoapContext {

	private SoapMessageBuilder builder;
	private MessageParser messageParser;
	private Authenticator authenticator;
	
	@Override
	public SoapMessageBuilder getSoapMessageBuilder() {
		if(builder==null)
			builder=CwmpMessageBuilder.getSoapMessageBuilderInstance();
		return builder;
	}

	@Override
	public MessageParser getMessageParser() {
		if(messageParser==null)
			messageParser=CwmpMessageParser.getMessageParserInstance();
		return messageParser;
	}
	
	@Override
	public Authenticator getAuthenticator() {
		if(authenticator==null)
			authenticator=new BasicAuthenticator();
		return authenticator;
	}
	
}
