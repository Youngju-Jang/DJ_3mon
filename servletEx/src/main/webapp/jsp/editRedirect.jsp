<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Title</title>
</head>
<jsp:useBean id="bean" class="com.bit.model.BoardBean" scope="request"/>
<jsp:setProperty name="bean" property="*"/>
<body>
<jsp:getProperty name="bean" property="no"/>
<%=bean.getNo()%> <br>
<%=bean%> <br>
<%=bean.getPass()%>
</body>
</html>
