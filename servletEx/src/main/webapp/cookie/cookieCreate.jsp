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
<%
      // 쿠키생성, 브라우저 안에 쿠키의 정보를 넣어준다.
      String color=request.getParameter("color");
      Cookie cookie = new Cookie("color",color);
      cookie.setMaxAge(30);
      response.addCookie(cookie);
      response.sendRedirect("cookie2.jsp");
%>
<body>

</body>
</html>
