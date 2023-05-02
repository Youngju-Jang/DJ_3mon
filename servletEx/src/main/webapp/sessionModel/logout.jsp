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
            System.out.println("sName : " + sName);
            String sValue = (String) session.getAttribute(sName);
            System.out.println("sValue : " + sValue);
            if(sValue.equals("abc")){
                  session.removeAttribute(sName);
            }
      }
//      if(((String)session.getAttribute("id")).equals("abc")){
//           session.removeAttribute("id");
//      };
%>
<a href="sessionState.jsp">SessionState...</a>
</body>
</html>
