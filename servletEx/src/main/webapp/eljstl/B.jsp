<%--
  Created by IntelliJ IDEA.
  User: joj1043
  Date: 2023/04/28
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Title</title>
</head>
<body>
<c:set var="blood" value="${param.bType}"/>
<c:out value="${blood}"/>
<h1> B형은 B형이다</h1>
</body>
</html>
