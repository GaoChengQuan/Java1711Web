<%@page import="com.situ.student.entity.Student"%>
<%@page import="com.situ.student.service.impl.StudentServiceImpl"%>
<%@page import="com.situ.student.dao.impl.StudentDaoImpl"%>
<%@page import="com.situ.student.service.IStudentService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- JSP脚本 -->	
	<% 
		String name = "zhansgan";
		IStudentService studentService = new StudentServiceImpl();
		List<Student> list = studentService.findAll();
	%>
	<!-- JSP表达式 -->
	<%=name %>
	<!-- JSP声明 -->
	<%!
		int age = 20;
		public int getAge() {
			return age;
		}
	%>
	
	<table border='1' cellspacing='0'>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>地址</th>
		</tr>
	<%
		for (Student student : list) {
	%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getAge()%></td>
				<td><%=student.getGender()%></td>
				<td><%=student.getAddress()%></td>
			</tr>
	<%
		}
	%>
	</table>
	
	<hr/>
	<%
		for (int i=1; i <= 6; i++) {
	%>
			<h<%=i%>>标题<%=i%></h<%=i%>>
	<%
		}
	%>
	<hr/>
	<!-- 9*9乘法表 -->
	<%
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
	%>
				<%=i%>*<%=j%>=<%=i*j%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
			}
	%>
			<br/>
	<%
		}
	%>
	
	
	
	
</body>
</html>