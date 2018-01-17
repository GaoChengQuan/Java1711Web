package com.situ.day42;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class DOMTest1 {
	/*
	 * 得到节点信息
	 */
	@Test
	public void test1() {
		try {
			// 创建xml解析器对象
			SAXReader reader = new SAXReader();
			// 读取xml文档，返回Document对象
			Document document = reader.read(new File("./src/com/situ/day42/contacts.xml"));
			// nodeIterator得到当前节点下所有子节点，不包含孙节点以以下节点。
			Iterator<Node> iterator = document.nodeIterator();
			while (iterator.hasNext()) {// 判断是否有下一个元素
				Node node = iterator.next();
				System.out.println(node.getName());// 得到节点名称

				// 继续找出其下面的子节点
				// 只有标签节点才有子节点
				// 判断当前节点是标签节点
				if (node instanceof Element) {
					Element element = (Element) node;
					Iterator<Node> it = element.nodeIterator();
					while (it.hasNext()) {
						Node n = it.next();
						System.out.println(n.getName());
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 递归遍历所有节点
	 */
	@Test
	public void test2() throws Exception {
		// 创建xml解析器对象
		SAXReader reader = new SAXReader();
		// 读取xml文档，返回Document对象
		Document document = reader.read(new File("./src/com/situ/day42/contacts.xml"));
		//得到根节点
		Element rootElement = document.getRootElement();
		getChildNodes(rootElement);
	}

	/*
	 * 得到当前节点下所有子节点，不包含孙节点以以下节点。
	 */
	private void getChildNodes(Element rootElement) {
		System.out.println(rootElement.getName());
		
		Iterator<Node> iterator = rootElement.nodeIterator();
		while (iterator.hasNext()) {
			Node node = iterator.next();
			
			//判断是否是标签节点
			if (node instanceof Element) {
				Element element = (Element) node;
				//递归
				getChildNodes(element);
			}
		}
	}
	
	@Test
	public void test3() throws Exception {
		List<Contact> list = new ArrayList<Contact>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("./src/com/situ/day42/contacts.xml"));
		Element rootElement = document.getRootElement();//contactList
		Iterator<Element> iterator = rootElement.elementIterator("contact");//List<Contact>
		while (iterator.hasNext()) {
			Element element = iterator.next();//Contact
			Contact contact = new Contact();
			contact.setId(element.attributeValue("id"));
			contact.setName(element.elementText("name"));
			contact.setAge(element.elementText("age"));
			contact.setPhone(element.elementText("phone"));
			contact.setEmail(element.elementText("email"));
			contact.setQq(element.elementText("qq"));
			list.add(contact);
		}
		
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}
}
