package com.situ.day28;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		String maxOnline = config.getInitParameter("maxOnline");
		System.out.println("maxOnline: " + maxOnline);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//此ServletConfig就是init传过来的那个
		ServletConfig servletConfig = getServletConfig();
		String maxOnline = servletConfig.getInitParameter("maxOnline");
		
		ServletContext servletContext = getServletContext();
		String pageSize = servletContext.getInitParameter("pageSize");
		System.out.println("Login pageSize: " + pageSize);
		
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("maxOnline: " + maxOnline);
		
		printWriter.close();
	}
}
