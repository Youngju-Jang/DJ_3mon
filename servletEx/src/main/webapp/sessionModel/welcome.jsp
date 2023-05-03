<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.util.stream.StreamSupport" %>
<%@ page import="java.util.Spliterator" %>
<%@ page import="java.util.Spliterators" %>
<%@ page import="java.sql.SQLOutput" %>
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
<%
      Enumeration<String> er = session.getAttributeNames();
      int i = 0;
//      while(er.hasMoreElements()){
//           i++;
//           String sName = er.nextElement().toString();
//           String sValue = (String) session.getAttribute(sName);
//           if(sValue.equals("abc")){
//                out.print(sValue+"님 안녕하세요!<br>");
//           }else if(sName.equals("id")){
//                 out.print(sValue+"님 안녕하세요!<br>");
//           }
//      }
      Stream<String> str = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(er.asIterator(), Spliterator.ORDERED),
                false
      );
      str.filter(item -> {
                      System.out.println("filter item : " + item);
                      return item.equals("id");
                })
                .findFirst().ifPresent(item -> {
                      String sValue = (String) session.getAttribute(item);
                      System.out.println("@@sValue : " + sValue);
//                      out.print(sValue + "님 안녕하세요 <br>");
                      System.out.println("ifPresent : " + sValue);
                });


%>
<a href="logout.jsp">로그아웃</a>
<a href=" sessionState.jsp">SessionState...</a>
</body>
</html>
