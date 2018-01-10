package com.situ.day37;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter1 implements Filter {
	public HelloFilter1() {
		System.out.println("HelloFilter1.HelloFilter1()");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("HelloFilter1.init()");
		String encodingValue = filterConfig.getInitParameter("encoding");
		System.out.println(encodingValue);
		//获得所有参数的名字的集合
		Enumeration<String> enumeration = filterConfig.getInitParameterNames();
		//遍历名字的集合，根据名字得到value
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			//根据name得到value
			String value = filterConfig.getInitParameter(name);
			System.out.println(name + " : " + value);
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("HelloFilter1.doFilter() before");
		//执行下一个过滤器或放行（访问Servlet）
		chain.doFilter(request, response);
		System.out.println("HelloFilter1.doFilter() after");
	}

	@Override
	public void destroy() {
		System.out.println("HelloFilter1.destroy()");
	}
}
