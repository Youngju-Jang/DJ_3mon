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
      Object ob1 = session.getAttribute("mySessionName");
      String mySessionName = (String)ob1;
      out.print(mySessionName+"<br>");

      Object ob2 = session.getAttribute("myNum");
      Integer myNum = (Integer)ob2;
      System.out.println(myNum);
      out.print(myNum+"<br>");

      Enumeration<String> er = session.getAttributeNames();
      int i=0;
      while(er.hasMoreElements()){
           i++;
           String sName = er.nextElement().toString();
           String sValue = (String) session.getAttribute(sName);
           if(sValue.equals("abc")){
                out.print(sValue+"님 안녕하세요!<br>");
           }
      }

%>
</body>
</html>
