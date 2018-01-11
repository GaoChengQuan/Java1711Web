package com.situ.day38;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSessionAttributeListener.attributeAdded()");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSessionAttributeListener.attributeRemoved()");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		System.out.println("MyHttpSessionAttributeListener.attributeReplaced()");
	}
}
