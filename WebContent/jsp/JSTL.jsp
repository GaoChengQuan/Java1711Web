<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.situ.student.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//int age = 18;
		pageContext.setAttribute("age", 18);
		pageContext.setAttribute("gender", "女");
	%>
	<c:set var="age" value="20"></c:set>
	<!-- 1、单条件判断 -->
	${age }
	<c:if test="${age==20}">
		今年20岁
	</c:if>
	
	<hr/>
	<c:if test="${gender=='男'}">
		男
	</c:if>
	<c:if test="${gender=='女'}">
		女
	</c:if>
	
	<hr/>
	<!-- 2、多条件判断 -->
	<%
		int score = 77;
		pageContext.setAttribute("score", score);
	%>
	<c:set var="score" value="100"></c:set>
	<c:choose>
		<c:when test="${score>=90 && score<=100}">
			优秀
		</c:when>
		<c:when test="${score>=80 && score<90}">
			良好
		</c:when>
		<c:when test="${score>=70 && score<80}">
			一般
		</c:when>
		<c:when test="${score>=60 && score<70}">
			一般
		</c:when>
		<c:otherwise>
			一般
		</c:otherwise>
	</c:choose>
	
	<hr/>
	<!-- 3、集合遍历 -->
	<!-- 3.1、遍历List<String> -->
	<!-- 3.2、遍历List<Student> -->
	<!-- 
		for(int i = 0; i < 5; i++) {
			syso(i);
		} 
	 -->
	<c:forEach begin="0" end="5" var="i">
		${i}<br/>
	</c:forEach>
	<%
		Student student1 = new Student("张三1", 21, "男", "青岛", new Date(), new Date());
		Student student2 = new Student("张三2", 22, "男", "青岛", new Date(), new Date());
		Student student3 = new Student("张三3", 23, "男", "青岛", new Date(), new Date());
		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);
		pageContext.setAttribute("list", list);
	%>
	<c:forEach items="${list}" var="student">
		${student.name} -- ${student.age} <br/>
	</c:forEach>
	
<!-- 3.3、遍历Map<String,String>
   	Map<String,Student>
   	Map<Student,Map<String,Student>
 -->
 <%
 	Student stu1 = new Student("张三1", 21, "男", "青岛", new Date(), new Date());
	Student stu2 = new Student("张三2", 22, "男", "青岛", new Date(), new Date());
	Student stu3 = new Student("张三3", 23, "男", "青岛", new Date(), new Date());
	Map<String, Student> map = new HashMap<String, Student>();
	map.put("stu1", stu1);
	map.put("stu2", stu2);
	map.put("stu3", stu3);
	request.setAttribute("map", map);
 %>
 <c:forEach items="${map}" var="entry">
 	${entry.key} -- ${entry.value}<br/>
 	${entry.key} -- ${entry.value.name}<br/>
 </c:forEach>

</body>
</html>