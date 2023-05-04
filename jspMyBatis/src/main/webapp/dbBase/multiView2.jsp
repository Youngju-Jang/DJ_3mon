<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
      <title>Bootstrap Example</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
      <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
      <h2>Contextual Classes</h2>
      <p>Contextual classes can be used to color the table, table rows or table cells. The classes that can be used are: .table-primary, .table-success, .table-info, .table-warning, .table-danger, .table-active, .table-secondary, .table-light and .table-dark:</p>
      <table class="table">

            <thead>
            <tr>
                  <c:forEach var="entry" items="${list[0]}">
                        <th>${entry.key}</th>
                  </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="i" items="${list}">
                  <tr>
                        <c:forEach var="entry" items="${i}">
                              <th>${entry.value }</th>
                        </c:forEach>
                  </tr>
            </c:forEach>
            </tbody>
      </table>
</div>

</body>
</html>

