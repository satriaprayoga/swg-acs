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

/**
 * @author satriaprayoga
 *
 */
public abstract class CwmpServlet extends HttpServlet{
	private static final long serialVersionUID = 4729089365346761948L;
	
	protected static Logger logger=Logger.getLogger(CwmpServlet.class);
	
	protected static String LAST_INFORM="lastinform";
	
	private CwmpSoapContext cwmpSoapContext;
	
	private RequestHandler responseHandler;

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
			cwmpSoapContext=new Default();
		return cwmpSoapContext;
	}
	
	public void setCwmpSoapContext(CwmpSoapContext cwmpSoapContext) {
		this.cwmpSoapContext = cwmpSoapContext;
	}
	
	
	public void setResponseHandler(RequestHandler responseHandler) {
		this.responseHandler = responseHandler;
	}
	
	public RequestHandler getResponseHandler() {
		return responseHandler;
	}

}
