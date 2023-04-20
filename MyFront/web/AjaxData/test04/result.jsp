<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name=request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	String phone=request.getParameter("phone");
%>
나의 이름은 <%=name %>이고 <%=age %>세 이며 연락처는 <%=phone %>입니다.
</body>
</html>