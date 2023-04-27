<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
      <title>Bootstrap Example</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<%
      request.setCharacterEncoding("UTF-8");

%>
<body>
<%--<%= request.getParameter("writer")%>--%>
<%--${param.writer}--%>
<%--<%--%>
<%--      Enumeration<String> en = request.getParameterNames();--%>
<%--      while (en.hasMoreElements()) {--%>
<%--%>--%>
<%--      <%= en.nextElement()%>--%>
<%--<%--%>
<%--      }--%>
<%--%>--%>
<%
//      Enumeration<String> en = request.getParameterNames();
//      while(en.hasMoreElements()){
//           String param = en.nextElement();
//           out.print(param + " : " + request.getParameter(param));
//      }
%>
<%
      Map<String, String[]> map = request.getParameterMap();
      Iterator<Map.Entry<String, String[]>> iterator = map.entrySet().iterator();
      while(iterator.hasNext()){
            Map.Entry<String, String[]> entry = iterator.next();
            out.priwnt(entry.getKey() +":"+entry.getValue()[0]);
      }
%>
<div class="container">
      <h2>Contextual Classes</h2>
      <p>Contextual classes can be used to color table rows or table cells. The classes that can be used are: .active,
            .success, .info, .warning, and .danger.</p>
      <table class="table">
            <thead>
            <tr>
                  <th>Firstname</th>
                  <th>Lastname</th>
                  <th>Email</th>
            </tr>
            </thead>
            <tbody>

            <tr>
                  <td>${param.writer}</td>
                  <td>${param.subject}</td>
                  <td>def@somemail.com</td>
            </tr>
            <tr class="success">
                  <td>Success</td>
                  <td>Doe</td>
                  <td>john@example.com</td>
            </tr>
            <tr class="danger">
                  <td>Danger</td>
                  <td>Moe</td>
                  <td>mary@example.com</td>
            </tr>
            <tr class="info">
                  <td>Info</td>
                  <td>Dooley</td>
                  <td>july@example.com</td>
            </tr>
            <tr class="warning">
                  <td>Warning</td>
                  <td>Refs</td>
                  <td>bo@example.com</td>
            </tr>
            <tr class="active">
                  <td>Active</td>
                  <td>Activeson</td>
                  <td>act@example.com</td>
            </tr>
            </tbody>
      </table>
</div>

</body>
</html>


