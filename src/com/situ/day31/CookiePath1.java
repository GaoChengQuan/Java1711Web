package com.situ.day31;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiePath1
 */
public class CookiePath1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession();
		// 1、创建Cookie没有设置路径，那么这个Cookie只在/Java1711Web/servlet/这个目录下面有效
		Cookie cookie = new Cookie("goodsName", "IPhone7");
		cookie.setPath("/");
		resp.addCookie(cookie);
	}
}
