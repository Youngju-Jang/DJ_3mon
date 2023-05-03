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
<%! String id, pass;%>
<%
      id = request.getParameter("id");
      pass = request.getParameter("pass");
      if(id.equals("abc") && pass.equals("123")){
            session.setAttribute("id", id);
//            session.setAttribute("id", "Test");
            session.setMaxInactiveInterval(60);
            response.sendRedirect("welcome.jsp");
      }else{
           response.sendRedirect("welcome.jsp");
      }
%>
</body>
</html>
