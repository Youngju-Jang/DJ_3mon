<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <title>관리자</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=10" />
  <meta http-equiv="imagetoolbar" content="no" />
  <link href="${pageContext.request.contextPath}/css/contents.css" rel="stylesheet" type="text/css" />


</head>
<body>


<div id="wrapper">
  <div id="header">
    <div class="topInfoWrap">
      <div class="topInfoArea clfix">
        <div class="loginWrap">
          <span class="fir">2022.05.17</span>
          <span>13:30:22</span>
          <span><em>OOO님</em> 좋은 하루 되세요</span>
          <a href="" class="btnLogout"><img src="${pageContext.request.contextPath}/img/common/btn_logout.gif" alt="로그아웃" /></a>
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
							<span class="button"> <a href="">수정</a></span>
							<span class="button"><a href="">삭제</a></span>
							<span class="button"><a href="">목록</a></span>
						</span>
        </div>
        <table class="bbsList">
          <colgroup>
            <col width="400" />
            <col width="100" />
            <col width="" />
          </colgroup>
          <tr>
            <th scope="col" class="fir">이미지</th>
            <th scope="col">글번호</th>
            <td>${board.no}</td>
          </tr>
          <tr>

            <td class="fir" rowspan="7">
              <c:if test='${not empty board.fileName}'>
                <img src='${pageContext.request.contextPath}/upload/${board.fileName}' width="400" height="400"/>
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
  </div>
</div>
</body>
</html>






