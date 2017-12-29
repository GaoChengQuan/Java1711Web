package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.situ.student.util.Constant;
import com.situ.student.util.JDBCUtil;

public class StudentMainServlet extends HttpServlet {
	private IStudentService studentService = new StudentServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String servletPath = req.getServletPath();
		System.out.println(servletPath);
		//处理post请求乱码
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		if ("/add.do".equals(servletPath)) {
			add(req, resp);
		} else if ("/findAll.do".equals(servletPath)) {
			findAll(req, resp);
		} else if ("/findByName.do".equals(servletPath)) {
			findByName(req, resp);
		} else if ("/showInfo.do".equals(servletPath)) {
			showInfo(req, resp);
		}
	}

	private void findByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		List<Student> list = studentService.findByName(name);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/showInfo.do").forward(req, resp);
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// 1.接收参数
		String name = req.getParameter("name");
		System.out.println("name:" + name);
		byte[] bytes = name.getBytes("iso8859-1");
		String newName = new String(bytes, "utf-8");
		System.out.println("newName: " + newName);
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String address = req.getParameter("address");
		Student student = new Student(name, Integer.parseInt(age), gender, address, new Date(), new Date());
		System.out.println(student);
		// 2.业务处理
		int result = studentService.add(student);
		// 3.输出响应 Magic number
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		if (result == Constant.ADD_SUCCESS) {
			printWriter.println("Add Success");
		} else if (result == Constant.ADD_NAME_REPEAT) {
			printWriter.println("Name Repeat");
		} else {
			printWriter.println("Add Fail");
		}
		printWriter.close();

		// 重定向
		// resp.sendRedirect("/Java1711Web/findStudent");
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 1.接收请求参数，封装成对象
		// 2.调业务层处理
		List<Student> list = studentService.findAll();
		// 3.控制界面的跳转
		req.setAttribute("list", list);
		req.getRequestDispatcher("/showInfo.do").forward(req, resp);
	}

	private void showInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Student> list = (List<Student>) req.getAttribute("list");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<a href='/Java1711Web/add_student.html'>添加</a>");
		printWriter.println("<table border='1' cellspacing='0'>");
		printWriter.println("<tr>            ");
		printWriter.println("	<th>编号</th>");
		printWriter.println("	<th>姓名</th>");
		printWriter.println("	<th>年龄</th>");
		printWriter.println("	<th>性别</th>");
		printWriter.println("	<th>地址</th>");
		printWriter.println("</tr>           ");

		for (Student student : list) {
			printWriter.println("<tr>            ");
			printWriter.println("	<td>" + student.getId() + "</td>   ");
			printWriter.println("	<td>" + student.getName() + "</td>");
			printWriter.println("	<td>" + student.getAge() + "</td>  ");
			printWriter.println("	<td>" + student.getGender() + "</td>  ");
			printWriter.println("	<td>" + student.getAddress() + "</td>");
			printWriter.println("</tr>           ");
		}

		printWriter.println("</table>");
	}
}
