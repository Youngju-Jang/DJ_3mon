<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
      request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
      <title>Title</title>
</head>
<body>
<form action="../post.do" method="post">
      이름 : <input type="text" name="irum">
      점수 : <input type="number" name="score">
      <input type="submit" value="SEND">
      <input type="reset" value="RESET">
</form>
</body>
</html>
