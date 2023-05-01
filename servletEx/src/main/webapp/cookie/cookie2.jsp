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
  <%
    String color = request.getParameter("color");
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length>0){
      for(int i=0; i< cookies.length; i++){
        if(cookies[i].getName().trim().equalsIgnoreCase("color")){

          color = cookies[i].getValue();
        }
      }
    }
  %>
</head>
<body bgcolor="<%=color%>">

</body>
</html>
