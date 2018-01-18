package com.situ.day43.servlet;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class MyServletTest {
	@Test
	public void test1() {
		//手动创建执行
		IServlet servlet = new ServletImpl();
		servlet.init();
		servlet.service();
		servlet.destory();
	}
	
	/*
	 * 直接new ServletImpl()，这种编码方式称为硬编码，代码写死，
	 * 为了后期程序的可扩展性，开发中通过使用实现类全限定名（com.situ.day43.servlet.ServletImpl）
	 * 通过反射记载字符串指定的类，并通过反射实例化
	 */
	@Test
	public void test2() throws Exception {
		String servletClass = "com.situ.day43.servlet.ServletImpl";
		Class clazz = Class.forName(servletClass);
		ServletImpl servlet = (ServletImpl) clazz.newInstance();//如果类有无参构造方法，可以直接clazz.newInstance();
		servlet.init();
		servlet.service();
		servlet.destory();
	}
	
	//读取配置文件，获取<servlet-class>配置的内容，取代固定的字符串
	@Test
	public void test3() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/com/situ/day43/servlet/web.xml"));
		//获得根标签
		Element rootElement = document.getRootElement();
		//获得第一个<servlet子元素>
		Element servletElement = rootElement.element("servlet");
		//获得字符串实现类<servlet-class>的值
		String servletClass = servletElement.elementText("servlet-class");
		Class clazz = Class.forName(servletClass);
		ServletImpl servlet = (ServletImpl) clazz.newInstance();//如果类有无参构造方法，可以直接clazz.newInstance();
		servlet.init();
		servlet.service();
		servlet.destory();
	}

}
