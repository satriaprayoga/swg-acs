package com.swg.acs.mock;

import java.io.IOException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPConstants;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class TestClient {

	public static void main(String[] args) throws SOAPException, IOException {
		SOAPMessage soapMsg =
				MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL).createMessage();
		//Get the body from the envelope
		SOAPPart soapPart = soapMsg.getSOAPPart();
		SOAPEnvelope env = soapPart.getEnvelope();
		SOAPBody body = env.getBody();
		//Create a qualified name for the namespace of the
		//objects used by the service.
		String iNs = "http://ns.soacookbook.com/catalog";
		String elementName = "isbn";
		QName isbnQName = new QName(iNs, elementName);
		//Add the <isbn> element to the SOAP body
		//as its only child
		body.addBodyElement(isbnQName).setValue("12345");
		//debug print what we're sending
		soapMsg.writeTo(System.out);
		
		SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = scf.createConnection();
		//Create an endpoint to invoke
		URL endpoint = new URL("http://localhost:8080/" +
		"swg-acs");
		// Send request to endpoint, get response
		connection.call(soapMsg, endpoint);

	}
}
