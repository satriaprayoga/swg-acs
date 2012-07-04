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
public abstract class AcsServlet extends HttpServlet{
	private static final long serialVersionUID = -1846966876359498194L;
	
	final Logger logger=Logger.getLogger(getClass());
	
	protected abstract void process(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		logger.debug("Accepting request: "+req.getMethod()+", from: "+req.getRemoteAddr());
		process(req, resp);
	}
}
