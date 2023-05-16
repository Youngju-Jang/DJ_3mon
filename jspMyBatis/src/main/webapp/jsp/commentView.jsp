<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
         import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.bit.domain.member.vo.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%--%>
<%--      ObjectMapper objectMapper = new ObjectMapper();--%>
<%--      String json = objectMapper.writeValueAsString(request.getAttribute("commentList"));--%>
<%--      out.print(json);--%>
<%--%>--%>

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
<html>
<head>
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {
              $("a.reply").click(function(event){
                  event.preventDefault();
                 let buttonId = this.id;
                 $("form").hide();
                 $("form."+buttonId).toggle();
              });

              $("button.btn_cmt").click(function () {
                  let buttonId = this.id;
                  if ($("#sessionId").val().length == 0) {
                      window.location.href = "/jsp/AdminLogin.jsp";
                  }
                  if ($("textarea."+buttonId).val().length == 0) {
                      alert('Add Comment...');
                      return false;
                  }
                  $.ajax({
                      url: '${pageContext.request.contextPath}/insertComment.do?cmd=insertComment&board=${boardNo}&comment='+this.id,
                      type: 'POST',
                      data: $("form."+buttonId).serialize(),
                      success: function (data) {
                          console.log(data);
                          $("textarea."+buttonId).val('');
                          $("div#ajaxData").html(data);
                      }, error: function () {
                          console.log('error');
                      }
                  });
              });
          });
      </script>
</head>
<body>
<c:forEach items="${commentList}" var="cmt" varStatus="i">
      <c:choose>
            <c:when test="${cmt.lev ==0}">
                  원글임
                  no:${cmt.no} |ref: ${cmt.ref} |step: ${cmt.step} |lev: ${cmt.lev} |parentNum: ${cmt.parentNum}|reply:${cmt.reply}|content: ${cmt.content}
                  <br>
                  <br>
            </c:when>
            <c:when test="${cmt.lev == 1}">
                  댓글임
                  no:${cmt.no} |ref: ${cmt.ref} |step: ${cmt.step} |lev: ${cmt.lev} |parentNum: ${cmt.parentNum}|reply:${cmt.reply}|content: ${cmt.content}
                  <br>
                  <br>
            </c:when>
            <c:when test="${cmt.lev==2}">
                  대댓글임
                  no:${cmt.no} |ref: ${cmt.ref} |step: ${cmt.step} |lev: ${cmt.lev} |parentNum: ${cmt.parentNum}|reply:${cmt.reply}|content: ${cmt.content}
                  <br>
                  <br>
            </c:when>
      </c:choose>
      <div class="list_cmt ${cmt.lev <2 ? 'reply-right' : ''}" style="width: 1000px; float: left;">
            <div class="cmt_head"></div>
            <div class="cmt_body">
                                                <span class="info_append">
                                                      <span class="txt_name">${cmt.userId} 님</span>
                                                      <span class="txt_bar">|</span>
                                                      <span class="txt_time">${cmt.regdate}</span>
                                                </span>
                  <p class="txt_desc">
                              ${cmt.content}
                  </p>
            </div>
            <div class="cmt_foot">
                  <c:if test="${cmt.lev lt 2}">
                        <a href="#" id="${cmt.no}" class="reply">답글</a><span class="txt_bar">|</span>
                  </c:if>
                  <c:if test="${id eq cmt.userId}">
                        <a href="#">수정</a><span class="txt_bar">|</span>
                        <a href="#">삭제</a>
                  </c:if>
            </div>
      </div>
            <form name="comm_comm_form" class="${cmt.no}"
                  <%--                        action="${pageContext.request.contextPath}/insertComment.do?cmd=insertComment&board=${board.no}&comment="--%>
                  method="post" id="first_comm" style="display: none">
                  <input type="hidden" value="${sessionScope.id}" id="sessionId" name="userId">
                  <fieldset class="fld_cmt" style="width: 1000px;">
                        <legend class="screen_out">댓글 작성</legend>
                        <textarea class="tf_cmt ${cmt.no}" cols="115" rows="5"
                                  title="한줄 토크를 달아주세요" name="content" id="${cmt.no}"></textarea>
                        <button type="button" class="btn_cmt" id="${cmt.no}">등록</button>
                        <p class="info_append">
                              <span class="screen_out">입력된 바이트 수 : </span>
                              <span class="txt_byte">55</span> / 300자
                              <span class="txt_bar">|</span>
                              <a href="#none">댓글 운영원칙</a>
                        </p>
                  </fieldset>
            </form>
</c:forEach>
</body>
</html>
