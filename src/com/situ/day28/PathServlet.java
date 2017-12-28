package com.situ.day28;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PathServlet() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//Context上下文
    	System.out.println(req.getContextPath());// Java1711Web
    	System.out.println(req.getServletPath());// PathServlet
    	System.out.println(req.getRequestURI());// Java1711Web/PathServlet
    	System.out.println(req.getRequestURL());// http://localhost:8080/Java1711Web/PathServlet
    	
    	ServletContext servletContext = getServletContext();
		String pageSize = servletContext.getInitParameter("pageSize");
		System.out.println("Path pageSize: " + pageSize);
    }
}
