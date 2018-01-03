<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%=pageContext.getAttribute("name") %><br/>
	<%=pageContext.getAttribute("name", PageContext.REQUEST_SCOPE) %><br/>
	<%=pageContext.getAttribute("name", PageContext.SESSION_SCOPE) %><br/>
	<%=pageContext.getAttribute("name", PageContext.APPLICATION_SCOPE) %><br/>
	<br/>
	<%=pageContext.findAttribute("name") %>
</body>
</html>