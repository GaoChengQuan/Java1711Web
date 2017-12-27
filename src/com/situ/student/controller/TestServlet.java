package com.situ.student.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.获取参数
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		System.out.println("----------------------");
		//2.获得请求行
		System.out.println("请求方式：" + req.getMethod());//get post
		System.out.println("访问路径URI: " + req.getServletPath());
		System.out.println("Http版本：" + req.getProtocol());
		System.out.println("----------------------");
		//3.获得请求头（多个key：value）
		Enumeration<String> enumeration = req.getHeaderNames();//key的集合
		while (enumeration.hasMoreElements()) {//只是判断有没有下一个
			String key = (String) enumeration.nextElement();//真正取出
			String value = req.getHeader(key);
			System.out.println(key + " : " + value);
		}
	}
}
