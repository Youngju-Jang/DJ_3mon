<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <link href="${pageContext.request.contextPath}/css/contents.css" rel="stylesheet" type="text/css"/>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {

              $("a#search").click(function () {
                  if ($("select#option").val() == 'empty' || $("input[name='search']").val().length == 0) {
                      alert('Search KeyWord...');
                      $("select#option").prop("selectedIndex", 0);
                      $("input[name='search']").val('');
                      return false;
                  }

                  $("form").submit();
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
                              <span><em></em>${userName}님 좋은 하루 되세요</span>
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
                        <h1 class="title">게시판 리스트</h1>
                        <div class="btnSet clfix mgb15">
						<span class="fr">
							<span class="button"><a href="#" id="search">검색</a></span>
                                          <span class="button"><a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect">새로고침</a></span>
							<span class="button"><a href="${pageContext.request.contextPath}/jsp/edit.jsp">글쓰기</a></span>
						</span>기
                        </div>
                        <form action="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=1"
                              method="post">
                              <table class="bbsWrite mgb35">
                                    <caption></caption>
                                    <colgroup>
                                          <col width="150"/>
                                          <col width="150"/>
                                          <col width="150"/>
                                          <col width="150"/>
                                          <col width="150"/>
                                          <col width="150"/>
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                          <th>검색</th>
                                          <td>
                                                <select style="width: 100%" id="option" name="option">
                                                      <option value="empty">선택하세요</option>
                                                      <option value="title">TITLE</option>
                                                      <option value="contents">CONTENTS</option>
                                                      <option value="writer">WRITER</option>
                                                </select>
                                          </td>
                                          <td>
                                                <input type="text" name="search" class="inputText" size="30"
                                                       value="${search}"/>
                                          </td>
                                    </tr>
                                    </tbody>
                              </table>
                        </form>
                        <table class="bbsList">
                              <colgroup>
                                    <col width="150"/>
                                    <col width="150"/>
                                    <col width="150"/>
                                    <col width="150"/>
                                    <col width="150"/>
                                    <col width="150"/>
                                    <col width="150"/>
                              </colgroup>
                              <thead>
                              <tr>
                                    <th scope="col" class="fir">No.</th>
                                    <th scope="col">IMG</th>
                                    <th scope="col">TITLE</th>
                                    <th scope="col">WRITER</th>
                                    <th scope="col">FILENAME</th>
                                    <th scope="col">DATE</th>
                                    <th scope="col">조회수</th>
                              </tr>
                              </thead>

                              <tbody>
                              <c:forEach items="${boardList}" var="board">
                                    <tr>
                                          <td>
                                                <a href='hit.do?cmd=hit&no=${board.no}&page=${requestScope.page}'>${board.no}<a/>
                                          </td>
                                          <td>
                                                <c:if test='${not empty board.fileName}'>
                                                      <img src='${pageContext.request.contextPath}/upload/${board.fileName}'
                                                           width="50" height="50"/>
                                                </c:if>
                                          </td>
                                          <td>${board.title}</td>
                                          <td>${board.writer}</td>
                                          <td>${board.fileName}</td>
                                          <td>${board.regdate}</td>
                                          <td>${board.hit}</td>
                                    </tr>
                              </c:forEach>


                              </tbody>
                        </table>

                        <div class="paging">
                              <a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_first.gif"
                                               alt="처음페이지"/></a>
                              <a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_prev.gif"
                                               alt="이전"/></a>

                              <span>
							<a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=1&search=${search}&option=${option}">1</a>
							<a href="${pageContext.request.contextPath}/listSelect.do?cmd=listSelect&page=2&search=${search}&option=${option}">2</a>
							<a href="#">3</a>
							<strong>4</strong>
							<a href="#">5</a>
							<a href="#">6</a>
							<a href="#">7</a>
							<a href="#">8</a>
							<a href="#">9</a>
						</span>

                              <a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_next.gif"
                                               alt="다음"/></a>
                              <a href="#"><img src="${pageContext.request.contextPath}/img/button/btn_last.gif"
                                               alt="마지막페이지"/></a>

                        </div>
                  </div>
            </div>
      </div>
</div>
</body>
</html>