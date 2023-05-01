<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          function checkFun(){
              var checked = document.querySelector('input[type="checkbox"]').checked;
              document.location.href='cookiePop.jsp';
          }
      </script>
</head>
<body>
<img src="../img/common/DSC04152.jpg" width="500" height="300">
<input type="checkbox" name="ck" onclick="checkFun()">  오늘 하루 이창을..
</body>
</html>
