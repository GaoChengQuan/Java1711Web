<%@page import="com.situ.student.entity.Student"%>
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
	<%
		List<Student> list = (List<Student>)request.getAttribute("list");
	%>
	<a href="/Java1711Web/html/add_student.html">添加学生</a>
	<table border='1' cellspacing='0'>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th>地址</th>
			<th>删除</th>
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
				<td><a href="/Java1711Web/delete.do?id=<%=student.getId()%>">删除</a></td>
			</tr>
	<%
		}
	%>
	</table>
</body>
</html>