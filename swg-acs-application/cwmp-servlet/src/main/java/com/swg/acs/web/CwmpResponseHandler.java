/**
 * 
 */
package com.swg.acs.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.swg.acs.Message;
import com.swg.acs.message.GetRPCMethodsResponse;
import com.swg.acs.message.TransferCompleteResponse;
import com.swg.acs.message.soap.MessageParser;
import com.swg.acs.message.soap.SoapMessageBuilder;


/**
 * @author satriaprayoga
 *
 */
public class CwmpResponseHandler implements RequestHandler{
	
	private SoapMessageBuilder soapMessageBuilder;
	private MessageParser messageParser;
	
	public CwmpResponseHandler() {
	}
	
	public CwmpResponseHandler(SoapMessageBuilder messageBuilder,MessageParser messageParser) {
		this.soapMessageBuilder=messageBuilder;
		this.messageParser=messageParser;
	}

	@Override
	public Message getMessageRequest(HttpServletRequest request)
			throws SOAPException, IOException {
		return null;
	}

	@Override
	public Message sendResponse(Message request, OutputStream outputStream)
			throws SOAPException, IOException {
		Message response=null;
		SOAPMessage message=null;
		String requestName=request.getName();
		if(requestName.equals("GetRPCMethods")){
			response=new GetRPCMethodsResponse();
		}else if(requestName.equals("TransferComplete")){
			response=new TransferCompleteResponse();
		}
		message=soapMessageBuilder.build(response);
		message.writeTo(outputStream);
		outputStream.flush();
		outputStream.close();
		return response;
	}

	public void setMessageParser(MessageParser messageParser) {
		this.messageParser = messageParser;
	}
	
	public void setSoapMessageBuilder(SoapMessageBuilder soapMessageBuilder) {
		this.soapMessageBuilder = soapMessageBuilder;
	}
	
	public MessageParser getMessageParser() {
		return messageParser;
	}

}
