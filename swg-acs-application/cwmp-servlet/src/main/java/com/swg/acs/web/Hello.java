package com.swg.acs.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Hello extends ACSServlet {

	private static final long serialVersionUID = 1L;

	static String PAGE_HEADER = "<html><head><title>helloworld</title><body>";

	static String PAGE_FOOTER = "</body></html>";

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// Get Authorization header
		Authenticator authenticator=getCwmpSoapContext().getAuthenticator();
		if(!authenticator.authenticate(req, resp)){
			 resp.setHeader("WWW-Authenticate", "BASIC realm=\"ACS\"");
		     resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		}else {
	      // Allowed, so show him the secret stuff
	      out.println("Top-secret stuff");
	    }
		/*
		CwmpSoapContext cwmpSoapContext=getCwmpSoapContext();
		System.out.println("Get Request: "+req.getMethod());
		Message message=new GetRPCMethodsResponse();
		SoapMessageBuilder builder=cwmpSoapContext.getSoapMessageBuilder();
		SOAPMessage soapMessage=null;
		try {
			soapMessage=builder.build(message);
			resp.setContentType("text/xml");
			OutputStream outputStream=resp.getOutputStream();
			soapMessage.writeTo(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (SOAPException e) {
			e.printStackTrace();
		}
		 */
	}
	


}
