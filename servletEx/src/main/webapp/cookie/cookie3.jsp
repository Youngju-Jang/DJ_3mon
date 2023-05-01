<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


</body>
<html>
<head>
      <title>Title</title>
      <%
            String pop = "";
            Cookie[] cookies = request.getCookies();
            String checked = "";
            if (cookies != null && cookies.length > 0) {
                  for (int i = 0; i < cookies.length; i++) {
                        if (cookies[i].getName().trim().equalsIgnoreCase("pop")) {
                              pop = cookies[i].getValue();
                        }
                  }
            }
      %>

      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          function windowPop() {
              window.open("popup.jsp", "id", "left=100, top=50, width=300, height=300");
          }
      </script>
</head>

<%
      if (!pop.equals("pop")) {
%>
<body onload="windowPop()">
<%
      }else{
%>
<body>
<%
      }
%>

</body>
</html>
