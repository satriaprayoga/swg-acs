package com.swg.acs.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Hello extends ACSServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static String PAGE_HEADER = "<html><head><title>helloworld</title><body>";

	static String PAGE_FOOTER = "</body></html>";

	@Override
	protected void process(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter writer=resp.getWriter();
		writer.println(PAGE_HEADER);
		writer.println("<h1>"+"Test" +"</h1>");
		writer.println(PAGE_FOOTER);
		writer.close();
		
	}

}
