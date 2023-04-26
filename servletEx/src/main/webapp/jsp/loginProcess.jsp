<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Title</title>
</head>
<body>

<%--      ID: <%=request.getParameter("id")%>--%>
<%--      PW: <%=request.getParameter("pass")%> <br>--%>
<%--      ID : ${param.id}--%>
<%--      PW : ${param.pass}--%>
<%
      String id = request.getParameter("id");
      String pass = request.getParameter("pass");
      if(id.equals("Admin") && pass.equals("1234")){
           session.setAttribute("id", id);
           session.setMaxInactiveInterval(60);
           response.sendRedirect("list.jsp");
      }else{
           response.sendRedirect("adminLogin.jsp");
      }
%>
</body>
</html>
