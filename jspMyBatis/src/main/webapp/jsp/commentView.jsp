<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
         import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page import="com.bit.domain.member.vo.Member" %>
<%
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(request.getAttribute("commentList"));
      out.print(json);
%>

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