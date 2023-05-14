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

<%--[--%>
<%--<c:forEach var="i" items="${ajaxList}" varStatus="cnt">--%>
<%--      <c:choose>--%>
<%--            <c:when test="${fun:length(ajaxList) eq cnt.count }">--%>
<%--                  {"no":${i.no},"name":"${i.name}","hobby":"${i.hobby}","today":"${i.today}"}--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                  {"no":${i.no},"name":"${i.name}","hobby":"${i.hobby}","today":"${i.today}"},--%>
<%--            </c:otherwise>--%>
<%--      </c:choose>--%>

<%--</c:forEach>--%>
<%--]--%>
