package com.situ.day43.servlet;

public class ServletImpl1 implements IServlet{

	@Override
	public void init() {
		System.out.println("ServletImpl1.init()");
	}

	@Override
	public void service() {
		System.out.println("ServletImpl1.service()");
	}

	@Override
	public void destory() {
		System.out.println("ServletImpl1.destory()");
	}

}
