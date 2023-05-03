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
<%
  session.setAttribute("mySessionName", "sessionName");
  session.setAttribute("myNum", 30);
%>
<a href="sessionGet.jsp">sessionGet</a>
</body>
</html>
