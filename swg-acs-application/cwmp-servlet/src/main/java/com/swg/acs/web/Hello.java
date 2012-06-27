package com.swg.acs.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Hello extends ACSServlet {

	private static final long serialVersionUID = 1L;

	static String PAGE_HEADER = "<html><head><title>helloworld</title><body>";

	static String PAGE_FOOTER = "</body></html>";

	Hashtable users = new Hashtable();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		users.put("Wallace:cheese",     "allowed");
		users.put("Gromit:sheepnapper", "allowed");
		users.put("Penguin:evil",       "allowed");
	}

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// Get Authorization header
	    String auth = req.getHeader("Authorization");

	    // Do we allow that user?
	    if (!allowUser(auth)) {
	      // Not allowed, so report he's unauthorized
	      resp.setHeader("WWW-Authenticate", "BASIC realm=\"users\"");
	      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	      // Could offer to add him to the allowed user list
	    }
	    else {
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
	
	@SuppressWarnings("restriction")
	protected boolean allowUser(String auth) throws IOException {
	    if (auth == null) return false;  // no auth

	    if (!auth.toUpperCase().startsWith("BASIC ")) 
	      return false;  // we only do BASIC

	    // Get encoded user and password, comes after "BASIC "
	    String userpassEncoded = auth.substring(6);

	    // Decode it, using any base 64 decoder
	    sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
	    String userpassDecoded = new String(dec.decodeBuffer(userpassEncoded));
	    
	    // Check our user list to see if that user and password are "allowed"
	    if ("allowed".equals(users.get(userpassDecoded)))
	      return true;
	    else
	      return false;
	  }

}
