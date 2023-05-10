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
            <tr>
                  <td>${emp.employeeId}</td>
                  <td>${emp.firstName}</td>
                  <td>${emp.lastName}</td>
                  <td>${emp.email}</td>
                  <td>${emp.phoneNumber}</td>
                  <td>${emp.hireDate}</td>
                  <td>${emp.jobId}</td>
            </tr>
</table>
</body>
</html>
