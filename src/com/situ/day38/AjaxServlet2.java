package com.situ.day38;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mchange.v2.c3p0.stmt.GooGooStatementCache;
import com.situ.student.entity.Student;
import com.situ.student.service.IStudentService;
import com.situ.student.service.impl.StudentServiceImpl;
import com.sun.org.apache.xerces.internal.util.EntityResolver2Wrapper;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
		JSONArray jsonArray = JSONArray.fromObject(list);
		resp.getWriter().write(jsonArray.toString());
		
		//resp.getWriter().write("{\"name\":\"lisi\",\"age\":33}");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println(name + ", " + age);
		
		resp.setContentType("text/html;charset=utf-8");
		
		Student student = new Student("zhangsan", 20, "男", "青岛", new Date(), new Date());
		/*JSONObject object = JSONObject.fromObject(student);
		resp.getWriter().write(object.toString());*/
		Gson gson = new Gson();
		gson.toJson(student);
		
		//resp.getWriter().write("{\"name\":\"lisi\",\"age\":33}");
	}
	
	public static void main(String[] args) {
		/*Student student = new Student("zhangsan", 20, "男", "青岛", new Date(), new Date());
		Gson gson = new Gson();
		String json = gson.toJson(student);
		System.out.println(json);*/
		
		Gson gson = new Gson();
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
		String json = gson.toJson(list);
		System.out.println(json);
	}
	
}
