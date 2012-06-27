/**
 * 
 */
package com.swg.acs.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author satriaprayoga
 *
 */
public abstract class ACSServlet extends HttpServlet{
	private static final long serialVersionUID = 4729089365346761948L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req,resp);
	}
	
	protected abstract void process(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException;

}
