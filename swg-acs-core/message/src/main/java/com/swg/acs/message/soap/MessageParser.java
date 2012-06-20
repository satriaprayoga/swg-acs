/**
 * 
 */
package com.swg.acs.message.soap;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.swg.acs.Message;

/**
 * @author satriaprayoga
 *
 */
public interface MessageParser {

	public Message parse(SOAPMessage soapMessage) throws SOAPException;
}
