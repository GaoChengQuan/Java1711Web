package com.situ.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
/**
 * Controller层作用：
 * 1、获取界面上的数据，例如add(String name,int age....)，然后封装成Student
 * 2、为界面展示提供数据，例如：List<Student> findAll();
 * 真正完成功能还是要调用Service完成。
 * 后期Controller做的功能会有SprinMVC、Struts2框架帮助我们完成。
 */
public class FindStudentServlet extends HttpServlet{
	private IStudentService studentService = new StudentServiceImpl();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.接收请求参数，封装成对象
		//2.调业务层处理
		List<Student> list = studentService.findAll();
		//3.控制界面的跳转
		//乱码问题
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
