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
<%--EMP링크 클릭시 EMP list로 이동 : *.do 패턴으로 dispatcherServlet.java 로 이동됨 --%>
<a href="/Web/multi.do?cmd=empList">EMPLIST</a>
<a href="/Web/multi.do?cmd=dept">DEPT</a>
<a href="/Web/multi.do?cmd=multi&t=salgrades">SALGRADES</a>
</body>
</html>
