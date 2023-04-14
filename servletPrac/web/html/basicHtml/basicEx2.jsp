<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
      <meta charset="UTF-8">
      <meta name="viewport"
            content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
      <meta http-equiv="X-UA-Compatible" content="ie=edge">
      <title>Document</title>
      <style>
            table{
                border : 1px solid;
                margin: 20px;

            }
            tr{
                background-color: blue;
            }
            th, td {
                padding: 5px;
                background-color: red;
                width: 50px;
            }
      </style>
</head>
<body>
<table border="1" cellpadding="50" cellspacing="100" >
      <thead>
      <tr>
            <th>김말자</th>
            <th>장영주</th>
      </tr>
      <tr>
            <th>짱영주</th>
            <th>영주장</th>
      </tr>
      </thead>
</table>
<table border="1" width="80%" align="center" cellpadding="12" cellspacing="0">
      <thead>
      <tr id="firstTr">
      <%
            for(int i=2; i<=9; i++){
      %>
            <th><%=i%>단</th>
      <%
            }
      %>
      </tr>
      </thead>
      <tbody>
            <%
                  for(int i=1; i<=9; i++){
            %>
      <tr>
            <%
                  for(int j=2; j<=9; j++){
            %>
            <td onmouseover="this.style.backgroundColor='gray'" onmouseleave="this.style.backgroundColor='pink'"><%=j%> * <%=i%> = <%=i*j%></td>
            <%
                  }
            %>
      </tr>
      <%
            }
      %>
      </tbody>

</table>
</body>
</html>
