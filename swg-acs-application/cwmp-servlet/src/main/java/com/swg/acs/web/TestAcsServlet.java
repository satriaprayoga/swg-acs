/**
 * 
 */
package com.swg.acs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.swg.acs.Message;
import com.swg.acs.message.GetRPCMethodsResponse;
import com.swg.acs.message.soap.CwmpMessageBuilder;
import com.swg.acs.message.soap.SoapUtil;

/**
 * @author satriaprayoga
 *
 */
public class TestAcsServlet extends AcsServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		MessageFactory mf=null;
		try {
			mf=MessageFactory.newInstance();
			SOAPMessage message=mf.createMessage(null, req.getInputStream());
			String requestName=SoapUtil.getInstance().getRequestName(message);
			logger.info("Accepting soap request: "+requestName);
			if(requestName.equals("GetRPCMethods")){
				Message respons=new GetRPCMethodsResponse();
				resp.setContentType("text/xml");
				resp.setStatus(HttpServletResponse.SC_OK);
				SOAPMessage reply=CwmpMessageBuilder.getSoapMessageBuilderInstance().build(respons);
				reply.writeTo(resp.getOutputStream());
			}
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
