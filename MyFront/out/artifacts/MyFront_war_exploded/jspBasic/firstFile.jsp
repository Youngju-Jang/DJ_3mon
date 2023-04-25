<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
      <title>Title</title>
</head>
<body>
<%
      for(int i=0; i<5; i++){

%>
           <h1>Hello JSP<%=i%></h1>
<%
      }
%>

</body>
</html>
