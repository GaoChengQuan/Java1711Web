package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.util.Constant;

public class AddStudentServlet extends HttpServlet{
	private IStudentService studentService = new StudentServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		int count = (int)servletContext.getAttribute("count");
		System.out.println("count: " + count);
		count++;
		servletContext.setAttribute("count", count);
		
		//1.接收参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		Student student = new Student(name, Integer.parseInt(age), gender, address, new Date(), new Date());
		System.out.println(student);
		//2.业务处理
		int result = studentService.add(student);
		//3.输出响应 Magic number
		resp.setContentType("text/html;charset=utf-8");
		/*PrintWriter printWriter = resp.getWriter();
		if (result == Constant.ADD_SUCCESS) {
			printWriter.println("Add Success");
		} else if (result == Constant.ADD_NAME_REPEAT) {
			printWriter.println("Name Repeat");
		} else {
			printWriter.println("Add Fail");
		}
		printWriter.close();*/
		
		//重定向
		resp.sendRedirect("/Java1711Web/findStudent");
	}
}
