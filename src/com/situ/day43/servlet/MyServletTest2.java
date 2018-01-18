package com.situ.day43.servlet;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

public class MyServletTest2 {
	private Map<String, String> map = new HashMap<String, String>();
	
	@Before
	public void testParse() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/com/situ/day43/servlet/web.xml"));
		//获得根标签
		Element rootElement = document.getRootElement();
		//获得所有子元素<servlet>、<servlet-mapping>
		List<Element> childElements = rootElement.elements();
		//遍历所有
		//1.解析到<servlet>，将其子标签<servlet-name>和<servlet-class>放到map里面
		//2.解析到<servlet-mapping>，获得子标签<servlet-name>和<url-pattern>,
		//从map中获取1 的内容，组合成url=class键值对
		for (Element element : childElements) {
			//获得元素名字
			String name = element.getName();
			//如果是servlet，将<servlet-name>和<servlet-class>放到map里面
			if ("servlet".equals(name)) {
				String servletName = element.elementText("servlet-name");
				String servletClass = element.elementText("servlet-class");
				map.put(servletName, servletClass);
			}
			
			//如果是servlet-mapping，和servlet中的组合成key=url,value=clss
			//并添加到map
			if ("servlet-mapping".equals(name)) {
				String servletName = element.elementText("servlet-name");
				String urlPattern = element.elementText("url-pattern");
				String servletClass = map.get(servletName);
				//存放新的内容url=class
				map.put(urlPattern, servletClass);
				//将之前扫描<servlet>存放的删除
				map.remove(servletName);
			}
		}
		
		System.out.println(map);
	}
	
	
	@Test
	public void test1() throws Exception {
		//模拟路径
		String url = "/servlet2";
		//通过路径获得对应的实现类
		String servletClass = map.get(url);
		Class clazz = Class.forName(servletClass);
		IServlet servlet = (IServlet) clazz.newInstance();//如果类有无参构造方法，可以直接clazz.newInstance();
		servlet.init();
		servlet.service();
		servlet.destory();
	}
}
