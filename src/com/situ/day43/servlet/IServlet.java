package com.situ.day43.servlet;

public interface IServlet {
	public void init();		//初始化
	public void service();  //执行业务
	public void destory();  //销毁
}
