<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
            $(function(){

            });
      </script>
</head>
<body>
<c:choose>
      <c:when test="${param.lesson eq 'java'}">JAVA APPLICATION</c:when>
      <c:when test="${param.lesson eq 'mysal'}">DBMS</c:when>
      <c:when test="${param.lesson eq 'html'}">FRONT APPLICATION</c:when>
      <c:when test="${param.lesson eq 'ajax'}">FRONT AJAX APPLICATION</c:when>
</c:choose>
</body>
</html>
