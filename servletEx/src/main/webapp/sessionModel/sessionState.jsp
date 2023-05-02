<%@ page import="java.util.Enumeration" %>
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
<%
      Enumeration<String> er = session.getAttributeNames();
      int i=0;
      while(er.hasMoreElements()){
            i++;
            String sName = er.nextElement().toString();
            String sValue = (String) session.getAttribute(sName);
            out.print("SessionName: "+ sName + "<br>");
            out.print("SessionValue: "+ sValue + "<br>");
      }
      if(i==0){
            out.print("모든 세션이 삭제되었습니다.");
      }
%>
<a href="welcome.jsp">welcome...</a>
</body>
</html>
