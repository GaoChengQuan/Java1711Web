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
		response.getWriter().write("是不是相等： " + (out == pageContext.getOut()));
		response.getWriter().write("是不是相等： " + (session == pageContext.getSession()));
	%>
	<br/>
	
	<%
		//pageContext.setAttribute("name", "page scope zhangsan");//默认存到page域对象中
		//pageContext.setAttribute("name", "request scope zhangsan", PageContext.REQUEST_SCOPE);//指定保存到request域中
		pageContext.setAttribute("name", "session scope zhangsan", PageContext.SESSION_SCOPE);//指定保存到session域中
		//pageContext.setAttribute("name", "application scope zhangsan", PageContext.APPLICATION_SCOPE);//指定保存到context域中
	%>
	<!--  -->
	<%=pageContext.getAttribute("name") %><br/>
	<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) %><br/>
	<%=pageContext.getAttribute("name", PageContext.SESSION_SCOPE) %><br/>
	<%=pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE) %><br/>
	<jsp:forward page="/jsp/pageContext2.jsp"></jsp:forward>
</body>
</html>