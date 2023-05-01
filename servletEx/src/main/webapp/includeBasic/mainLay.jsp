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
<table cellpadding="0" cellspacing="0" border="1" width="80%" align="center">
      <tr>
            <td colspan="12">
                  <jsp:include page="top.jsp">
                        <jsp:param name="param1" value="topTDValue"/>
                  </jsp:include>
            </td>
      </tr>
      <tr>
            <td bgcolor="blue" colspan="4">
                  <jsp:include page="left.jsp">
                        <jsp:param name="param1" value="leftTDValue"/>
                        <jsp:param name="imgUrl" value="../img/button/btn_calendar.gif"/>
                  </jsp:include>
            </td>
            <td bgcolor="#ff1493" colspan="8">
                  본문 레이아웃<br><br><br><br><br><br><br><br><br>
            </td>
      </tr>
      <tr>
            <td colspan="12" bgcolor="gray">
                  <jsp:include page="bottom.jsp">
                        <jsp:param name="param1" value="BottomClass"/>
                        <jsp:param name="imgUrl" value="../img/button/btn_align_btm.gif"/>
                  </jsp:include>
            </td>
      </tr>
</table>
</body>
</html>
