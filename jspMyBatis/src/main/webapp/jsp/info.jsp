<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <link href="${pageContext.request.contextPath}/css/contents.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/css/reply.css" rel="stylesheet"/>


      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {
              $("button.btn_cmt").click(function () {
                  console.log($("#sessionId").val());
                  if ($("#sessionId").val().length == 0) {
                      window.location.href = "/jsp/AdminLogin.jsp";
                  }
                  if ($("textarea[name='content']").val().length == 0) {
                      alert('Add Comment...');
                      return false;
                  }
                  $("form[name='comm_form']").submit();
                  // 이후 ajax 로 변경하기
              });
          });
      </script>
</head>
<body>
<div id="wrapper">
      <div id="header">
            <div class="topInfoWrap">
                  <div class="topInfoArea clfix">
                        <div class="loginWrap">
                              <span class="fir">2022.05.17</span>
                              <span>13:30:22</span>
                              <span><em>${userName}님</em> 좋은 하루 되세요</span>
                              <a href="" class="btnLogout"><img
                                        src="${pageContext.request.contextPath}/img/common/btn_logout.gif" alt="로그아웃"/></a>
                        </div>
                  </div>
            </div>
            <div class="gnbSubWrap">

            </div>
      </div>
      <div id="container">
            <div id="contentsWrap" class="contentsWrap">
                  <div class="contents">
                        <h1 class="title">게시판 상세보기</h1>
                        <div class="btnSet clfix mgb15">
						<span class="fr">
                                          <c:if test="${userName eq board.id}">
                                                <span class="button" id="mod"><a href="${pageContext.request.contextPath}/jsp/password.jsp?job=mod&no=${board.no}">수정</a></span>
                                                <span class="button" id="del"><a href="${pageContext.request.contextPath}/jsp/password.jsp?job=del&no=${board.no}">삭제</a></span>
                                          </c:if>
							<span class="button"><a
                                                    href="${pageContext.request.contextPath}/jsp/list.jsp?page=${page}">목록</a></span>
						</span>
                        </div>
                              <table class="bbsList">
                                    <colgroup>
                                          <col width="400"/>
                                          <col width="100"/>
                                          <col width=""/>
                                    </colgroup>
                                    <tr>
                                          <th scope="col" class="fir">이미지</th>
                                          <th scope="col">글번호</th>
                                          <td>${board.no}</td>
                                    </tr>
                                    <tr>

                                          <td class="fir" rowspan="7">
                                                <c:if test='${not empty board.fileName}'>
                                                      <img src='${pageContext.request.contextPath}/upload/${board.fileName}'
                                                           width="400" height="400"/>
                                                </c:if>
                                          </td>
                                          <th scope="col">작성자</th>
                                          <td>${board.writer}</td>
                                    </tr>
                                    <tr>
                                          <th scope="col">제목</th>
                                          <td>${board.title}</td>
                                    </tr>
                                    <tr>
                                          <th scope="col">내용</th>
                                          <td height="200">${board.contents}</td>
                                    </tr>
                                    <tr>
                                          <th scope="col">등록일</th>
                                          <td>${board.regdate}</td>
                                    </tr>
                                    <tr>
                                          <th scope="col">조회수</th>
                                          <td>${board.hit}</td>
                                    </tr>

                              </table>
                  </div>
            </div>

            <!-- 덧글 div-->
            <div class="cmt_comm">
                  <form name="comm_form"
                        action="${pageContext.request.contextPath}/insertComment.do?cmd=insertComment&board=${board.no}&comment="
                  method="post">
                        <input type="hidden" value="${sessionScope.id}" id="sessionId" name="userId">
                        <fieldset class="fld_cmt" style="width: 1000px;">
                              <legend class="screen_out">댓글 작성</legend>
                              <textarea class="tf_cmt" cols="115" rows="5"
                                        title="한줄 토크를 달아주세요" name="content"></textarea>
                              <button type="submit" class="btn_cmt">등록</button>
                              <p class="info_append">
                                    <span class="screen_out">입력된 바이트 수 : </span>
                                    <span class="txt_byte">55</span> / 300자
                                    <span class="txt_bar">|</span>
                                    <a href="#none">댓글 운영원칙</a>
                              </p>
                        </fieldset>
                  </form>
                  <br>

                  <div class="list_cmt" style="width: 1000px; float: left;">
                        <div class="cmt_head"></div>
                        <div class="cmt_body">
			<span class="info_append">
				<span class="txt_name">글쓴이</span>
				<span class="txt_bar">|</span>
				<span class="txt_time">2022.01.01 14:22</span>
			</span>
                              <p class="txt_desc">
                                    댓글 내용이 나오는 곳...댓글댓글 내용이 나오는 곳...댓글 내용이 나오는 곳...댓글 내용이 나오는 곳...
                              </p>
                        </div>
                        <div class="cmt_foot">
                              <a href="#none">답글</a><span class="txt_bar">|</span><a href="#none">수정</a><span
                                  class="txt_bar">|</span><a
                                  href="#none">삭제</a>
                        </div>
                  </div>
            </div>
            <!--덧글 div 끝 -->
      </div>
</div>
</body>
</html>






