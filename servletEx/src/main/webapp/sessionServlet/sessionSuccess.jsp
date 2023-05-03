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
<c:if test="${id==null or id eq''}">
      <c:redirect url="${pageContext.request.contextPath}/sessionServlet/sessionLogin.jsp"/>
</c:if>
<body>
<a href="${pageContext.request.contextPath}/logoutServlet">${id}님 로그아웃</a>
</body>
</html>
