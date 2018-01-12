package com.situ.day38;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet2
 */
public class AjaxServlet2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println(name + ", " + age);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("{\"name\":\"lisi\",\"age\":33}");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println(name + ", " + age);
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().write("{\"name\":\"lisi\",\"age\":33}");
	}
}
