<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
            self.close();
      </script>
</head>
<body>
<%
      Cookie cookie = new Cookie("pop", "pop");
      cookie.setMaxAge(30);
      response.addCookie(cookie);
%>
</body>
</html>
