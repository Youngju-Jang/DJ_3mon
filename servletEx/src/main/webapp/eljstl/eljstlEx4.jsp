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
<form action="bloodType.jsp" method="post">
      이름: <input type="text" name="user">
      <input type="radio" name="bType" value="A">A형
      <input type="radio" name="bType" value="B">B형
      <input type="radio" name="bType" value="AB">AB형
      <input type="radio" name="bType" value="O">O형<br><br>
      <input type="submit" value="send">
</form>
</body>
</html>
