package com.situ.day43.servlet;

public class ServletImpl implements IServlet{

	@Override
	public void init() {
		System.out.println("ServletImpl.init()");
	}

	@Override
	public void service() {
		System.out.println("ServletImpl.service()");
	}

	@Override
	public void destory() {
		System.out.println("ServletImpl.destory()");
	}

}
