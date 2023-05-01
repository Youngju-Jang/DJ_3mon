<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="main.jsp"%>
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
${param.param1} BOTTOM CONTENTS <br>
<%--${param1}<br>--%>
DATA : ${data} <br>
pageContext : ${pageData} <br>
</body>
</html>
