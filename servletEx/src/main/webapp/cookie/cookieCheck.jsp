<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {

          });
      </script>
</head>
<%
      String checker = request.getParameter("checker");
      String id = request.getParameter("id");
      Cookie cookie = new Cookie("checker", id);
      cookie.setMaxAge(checker != null ? 30 : 0);
      response.addCookie(cookie);

      response.sendRedirect("cookieLogin2.jsp");
%>
<body>

</body>
</html>
