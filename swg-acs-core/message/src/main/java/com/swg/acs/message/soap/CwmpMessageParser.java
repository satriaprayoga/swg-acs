/**
 * 
 */
package com.swg.acs.message.soap;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.DetailEntry;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFault;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;

import com.swg.acs.Message;
import com.swg.acs.MessageBody;
import com.swg.acs.MessageEnvelope;
import com.swg.acs.MessageHeader;
import com.swg.acs.message.Fault;

/**
 * @author satriaprayoga
 *
 */
public abstract class CwmpMessageParser implements MessageParser{
	private final Logger logger=Logger.getLogger(getClass());
	
	private static MessageParser messageParser;
	
	public static MessageParser getMessageParserInstance(){
		if(messageParser==null)
			messageParser=new CwmpSoapMessageParser();
		return messageParser;
	}

	@Override
	public Message parse(SOAPMessage soapMessage) throws SOAPException {
		if(soapMessage.getSOAPBody().hasFault()){
			return parseFault(soapMessage);
		}
		SoapUtil soapUtil=SoapUtil.getInstance();
		Message message=null;
		String name=soapUtil.getRequestName(soapMessage);
		logger.info("parsing message: "+name);
		if(name==null){
			throw new NoSuchElementException("name not found");
		}
		try {
			message=(Message) Class.forName("com.swg.acs.message."+name).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		parseMessageEnvelope(soapMessage, message);
		parseMessageHeader(soapMessage, message);
		parseMessageBody(soapMessage, message);
		message.configParse();
		return message;
	}
	
	protected Fault parseFault(SOAPMessage soapMessage)throws SOAPException{
		Fault fault=null;
		String faultCode;
		String faultString;
		Detail detail;
		SoapUtil soapUtil=SoapUtil.getInstance();
		try{
			SOAPFault soapFault=soapMessage.getSOAPBody().getFault();
			detail=soapFault.getDetail();
			if(detail==null)
			{
				faultCode=soapUtil.getRequestElementValue(soapFault, "faultcode");
				faultString=soapUtil.getRequestElementValue(soapFault, "faultstring");
				fault=new Fault(faultCode, faultString);
			}else{
				Iterator<DetailEntry> iterator=detail.getDetailEntries();
				if(iterator.hasNext()){
					SOAPElement element=soapUtil.getRequestChildElement(detail, "Fault");
					SOAPElement fc=soapUtil.getRequestChildElement(element, "FaultCode");
					faultCode=fc.getValue();
					SOAPElement fs=soapUtil.getRequestChildElement(element, "FaultString");
					faultString=fs.getValue();
					fault=new Fault(faultCode, faultString);
					Iterator paramFaults=element.getChildElements(new QName("SetParameterValuesFault"));
					while(paramFaults.hasNext()){
						SOAPElement pfe=(SOAPElement)paramFaults.next();
						fault.addParameterFault(soapUtil.getRequestElementValue(pfe, "ParameterName"), 
								soapUtil.getRequestElementValue(pfe, "FaultCode"), 
								soapUtil.getRequestElementValue(pfe, "FaultString"));
					}
				}
			}
			
		}catch(Exception e){
			
		}
		return fault;
	}
	
	protected abstract MessageEnvelope parseMessageEnvelope(SOAPMessage soapMessage,Message message)throws SOAPException;
	
	protected abstract MessageHeader parseMessageHeader(SOAPMessage soapMessage,Message message)throws SOAPException;
	
	protected abstract MessageBody parseMessageBody(SOAPMessage soapMessage,Message message)throws SOAPException;
}
