<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
         import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page import="com.bit.domain.member.vo.Member" %>
      <%
            System.out.println();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(request.getAttribute("memberList"));
            out.print(json);
      %>

<%--<c:forEach items="${memberList}" var="member">--%>
<%--      ${member.no}. : ${member.name} : ${member.hobby} : ${member.today}<br>--%>
<%--</c:forEach>--%>
