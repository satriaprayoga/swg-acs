package com.swg.acs.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.swg.acs.Message;
import com.swg.acs.message.GetRPCMethodsResponse;
import com.swg.acs.message.soap.SoapMessageBuilder;

@WebServlet("/")
public class Hello extends CwmpServlet {

	private static final long serialVersionUID = 1L;

	static String PAGE_HEADER = "<html><head><title>helloworld</title><body>";

	static String PAGE_FOOTER = "</body></html>";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("initializing Cwmp Servlet");
		super.init(config);
		setResponseHandler(new CwmpResponseHandler());
	}

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		OutputStream outputStream=resp.getOutputStream();
		CwmpSoapContext context=getCwmpSoapContext();
		Authenticator authenticator=context.getAuthenticator();
		if(!authenticator.authenticate(req, resp)){
			 resp.setHeader("WWW-Authenticate", "BASIC realm=\"ACS\"");
		     resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}else {
	      SoapMessageBuilder builder=context.getSoapMessageBuilder();
	      resp.setContentType("text/xml");
	      Message message=new GetRPCMethodsResponse();
	      try {
			SOAPMessage soapMessage=builder.build(message);
			outputStream=resp.getOutputStream();
			soapMessage.writeTo(outputStream);
		} catch (SOAPException e) {
			e.printStackTrace();
		}
	      outputStream.flush();
	      outputStream.close();
	    }
		
	}
	


}
