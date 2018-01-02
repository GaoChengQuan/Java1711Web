package com.situ.day31;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessTimeServlet
 */
public class LastAccessTimeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.记录当前的访问时间，设置到Cookie里面
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = simpleDateFormat.format(date);;
		Cookie cookie = new Cookie("lastAccessTime", time);
		resp.addCookie(cookie);
		
		//2.获得客户端携带的Cookie
		String lastAccessTime = null;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie coo : cookies) {
				if ("lastAccessTime".equals(coo.getName())) {
					lastAccessTime = coo.getValue();
				}
			}
		}
		
		resp.setContentType("text/html;charset=utf-8");
		if (lastAccessTime == null) {
			resp.getWriter().println("您是第一次访问");
		} else {
			resp.getWriter().println("您上次访问的时间： " + lastAccessTime);
		}
	}
}
