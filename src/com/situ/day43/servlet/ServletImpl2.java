package com.situ.day43.servlet;

public class ServletImpl2 implements IServlet{

	@Override
	public void init() {
		System.out.println("ServletImpl2.init()");
	}

	@Override
	public void service() {
		System.out.println("ServletImpl2.service()");
	}

	@Override
	public void destory() {
		System.out.println("ServletImpl2.destory()");
	}

}
