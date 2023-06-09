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
<table border="1px solid black">
      <tr>
            <th>employee_id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>email</th>
            <th>phone_number</th>
            <th>hire_date</th>
            <th>job_id</th>
      </tr>
      <c:forEach items="${list}" var="emp" varStatus="vs">
            <tr>
<%--                  해당 번호 클릭시 emp info 페이지로 이동하도록 설정--%>
<%--                  *.do 형식이기 때문에 dispatchedrServlet.java 로 이동됨 --%>
                  <td><a href="/Web/multi.do?cmd=emp&empId=${emp.employeeId}">${emp.employeeId}</a></td>
                  <td>${emp.firstName}</td>
                  <td>${emp.lastName}</td>
                  <td>${emp.email}</td>
                  <td>${emp.phoneNumber}</td>
                  <td>${emp.hireDate}</td>
                  <td>${emp.jobId}</td>
            </tr>
      </c:forEach>
</table>
</body>
</html>
