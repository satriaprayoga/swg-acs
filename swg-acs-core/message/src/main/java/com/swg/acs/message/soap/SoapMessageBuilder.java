/**
 * 
 */
package com.swg.acs.message.soap;

import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.swg.acs.Message;

/**
 * Interface untuk membuat suatu {@link SOAPMessage}
 * @author satriaprayoga
 *
 */
public interface SoapMessageBuilder {

	/**
	 * Membuat {@link SOAPMessage} dari kelas {@link Message}
	 * @param message
	 * @return
	 * @throws SOAPException
	 */
	SOAPMessage build(Message message)throws SOAPException;
}
