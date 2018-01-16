package com.situ.day38;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.crypto.Data;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextInitialized()");
		
		String currentTime = "2018-01-11 11:53";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date date = null;
		try {
			date = format.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Timer定时器
		//TimerTask:任务
		//firstTime:第一次执行的时间
		//peroid:间隔多久再执行
		Timer timer =  new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				//System.out.println("银行计息...");
			}
		}, date, 5000);
		// 24小时 1000*60*60*24
		// 真实业务：模拟银行计息
		// 起始时间：定义成晚上12点
		// 间隔时间：24小时
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextDestroyed()");
	}
}
