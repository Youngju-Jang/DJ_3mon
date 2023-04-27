<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Title</title>
      <%
            request.setCharacterEncoding("UTF-8");
      %>
</head>
<jsp:useBean id="bean" class="com.bit.model.BoardBean" scope="request"/>
<jsp:setProperty name="bean" property="*"/>
<body>
<jsp:getProperty name="bean" property="pass"/>
<%=bean.getNo()%> <br>
<%=bean%> <br>
<%=bean.getPass()%> <br>
<a href="editRedirect.jsp">Redirect</a>
<%--<jsp:forward page="editRedirect.jsp"/>--%>
<%--Title : <%=request.getParameter("title")%>--%>
<%--</a>--%>
</body>
</html>
