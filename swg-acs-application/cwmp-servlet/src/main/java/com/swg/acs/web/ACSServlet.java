/**
 * 
 */
package com.swg.acs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.swg.acs.message.soap.CwmpMessageBuilder;
import com.swg.acs.message.soap.CwmpMessageParser;
import com.swg.acs.message.soap.MessageParser;
import com.swg.acs.message.soap.SoapMessageBuilder;

/**
 * @author satriaprayoga
 *
 */
public abstract class ACSServlet extends HttpServlet{
	private static final long serialVersionUID = 4729089365346761948L;
	
	protected static Logger logger=Logger.getLogger(ACSServlet.class);
	
	protected static String LAST_INFORM="lastinform";
	
	private CwmpSoapContext cwmpSoapContext;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private final void processRequest(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		logger.debug("Get Request: "+req.getMethod());
		process(req, resp);
	}
	
	protected abstract void process(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException;
	
	public CwmpSoapContext getCwmpSoapContext() {
		if(cwmpSoapContext==null)
			cwmpSoapContext=new DefaultCwmpSoapContext();
		return cwmpSoapContext;
	}
	
	public void setCwmpSoapContext(CwmpSoapContext cwmpSoapContext) {
		this.cwmpSoapContext = cwmpSoapContext;
	}
	
	private class DefaultCwmpSoapContext implements CwmpSoapContext{

		private SoapMessageBuilder builder;
		private MessageParser messageParser;
		private CpeAuthenticator authenticator;
		
		@Override
		public SoapMessageBuilder getSoapMessageBuilder() {
			if(builder==null)
				builder=CwmpMessageBuilder.getSoapMessageBuilderInstance();
			return builder;
		}

		@Override
		public MessageParser getMessageParser() {
			if(messageParser==null)
				messageParser=CwmpMessageParser.getMessageParserInstance();
			return messageParser;
		}
		
		@Override
		public CpeAuthenticator getAuthenticator() {
			if(authenticator==null)
				authenticator=new CpeAuthenticator();
			return authenticator;
		}
		
	}

}
