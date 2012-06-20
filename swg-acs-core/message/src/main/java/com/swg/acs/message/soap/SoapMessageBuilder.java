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
public interface SoapMessageBuilder {

	SOAPMessage build(Message message)throws SOAPException;
}
