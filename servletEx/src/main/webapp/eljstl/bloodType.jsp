<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
      <title>Title</title>
      <fmt:requestEncoding value="UTF-8"/>
</head>
<body>
<c:set var="blood" value="${param.bType}"/>
<c:out value="${blood}"/>
<c:if test="${blood eq 'A'}">
<%--      <c:redirect url="A.jsp"></c:redirect>--%>
      <jsp:forward page="A.jsp"></jsp:forward>
</c:if>
<c:if test="${blood eq 'B'}">
      <jsp:forward page="B.jsp"></jsp:forward>
</c:if>
</body>
</html>
ㅎㅎㅎ