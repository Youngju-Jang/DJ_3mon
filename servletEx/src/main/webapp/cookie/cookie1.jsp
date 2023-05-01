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
<form action="cookieCreate.jsp" method="post">
      <input type="radio" value="red" name="color">red
      <input type="radio" value="blue" name="color">blue
      <input type="radio" value="cyan" name="color">cyan
      <input type="radio" value="gray" name="color">gray
      <input type="radio" value="yellow" name="color">yellow

      <input type="submit" value="Send">
</form>
</body>
</html>
