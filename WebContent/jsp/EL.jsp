<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL从域中取出数据(EL最重要的作用) -->
	<%
		//1、获得普通字符串
		pageContext.setAttribute("name", "lisi");
		request.setAttribute("name", "zhangsan");
		//2、获得Student对象的值
		Student student = new Student("张三", 20, "男", "青岛", new Date(), new Date());
		session.setAttribute("student", student);
		//3、获得List<Student>的值
		Student student1 = new Student("张三1", 21, "男", "青岛", new Date(), new Date());
		Student student2 = new Student("张三2", 22, "男", "青岛", new Date(), new Date());
		Student student3 = new Student("张三3", 23, "男", "青岛", new Date(), new Date());
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		application.setAttribute("list", list);
	%>
	<!-- 1、获得普通字符串 -->
	<!-- 使用JSP表达式获取域中值 -->
	<%=pageContext.getAttribute("name") %><br/>
	<%=request.getAttribute("name") %><br/>
	<!-- EL表达式获取域中值 -->
	${pageScope.name}<br/>
	${requestScope.name}<br/>
	
	<hr/>
	<!-- 2、获得Student对象的值 -->
	<!-- 使用JSP表达式获取域中值 -->
	<%
		Student stu = (Student)session.getAttribute("student");
	%>
	<%=stu.getName() %><br/>
	<%=stu.getAge() %><br/>
	<!-- EL表达式获取域中值 -->
	${sessionScope.student.name}--${sessionScope.student.age}
	
	<hr/>
	<!-- 3、获得List<Student>的值 -->
	<!-- 使用JSP表达式获取域中值 -->
	<%
		List<Student> stuList = (List<Student>)application.getAttribute("list");
		//List<Student> stuList = (List<Student>)pageContext.findAttribute("list");
	%>
	<%=stuList.get(0).getName() %><br/>
	<!-- EL表达式获取域中值 -->
	${applicationScope.list[0].name}
	
	<hr/>
	<!-- 使用EL表达式全域自动查找 -->
	${name}<br/>
	${student.name} -- ${student.age}<br/>
	${list[0].name}
</body>
</html>