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
<body>
<%--<c:forTokens items="java, html, mysql, Script, reAct, Spring" delims="," var="name">--%>
<%--      <c:out value="${name}"></c:out>--%>
<%--</c:forTokens>--%>
<c:set var="i" value="java"/>
<c:set var="u" value="${i}"/>

${u ne "java" and 5>3}
<c:if test="${u eq 'java'}">
      <c:redirect url="eljstlEx2.jsp"></c:redirect>
</c:if>
</body>
</html>
