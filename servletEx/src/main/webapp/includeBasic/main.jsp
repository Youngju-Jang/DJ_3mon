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
      int data = 100;
      pageContext.setAttribute("pageData", data+1);
%>
<c:set var="data" value="<%=data%>"/>
MAIN CONTENTS <br>
<%--pageContext : ${pageScope.pageData} <br>--%>
<%--${param.param1}--%>
<%--pageContext : ${pageData} <br>--%>
<%--DATA : ${data}<Br><Br><Br>--%>
<%--img--%>
<img src="${param.imgUrl}" width="30px"><br>
</body>
</html>
