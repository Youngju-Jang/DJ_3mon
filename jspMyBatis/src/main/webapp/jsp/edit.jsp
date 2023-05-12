<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <link href="../css/contents.css" rel="stylesheet" type="text/css"/>
      <link href="${pageContext.request.contextPath}/css/reply.css" rel="stylesheet"/>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {
              $("span#save").click(function () {
                  //제약사항
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
                              <span><em>OOO님</em> 좋은 하루 되세요</span>
                              <a href="" class="btnLogout"><img src="../img/common/btn_logout.gif" alt="로그아웃"/></a>
                        </div>
                  </div>
            </div>
            <div class="gnbSubWrap">

            </div>
      </div>
      <div id="container">
            <div id="contentsWrap" class="contentsWrap">
                  <div class="contents">
                        <h1 class="title">게시판 등록</h1>
                        <div class="btnSet clfix mgb15">
						<span class="fr">
							<span class="button" id="save"><a href="#">저장</a></span>
							<span class="button"><a href="#">수정</a></span>
							<span class="button"><a href="#">목록</a></span>
							<span class="button"><a href="#">삭제</a></span>
						</span>
                        </div>
                        <form action="${pageContext.request.contextPath}/insertBoard.do?cmd=insertBoard" method="post"
                              enctype="multipart/form-data">
                              <table class="bbsWrite">
                                    <colgroup>
                                          <col width="90"/>
                                          <col/>
                                    </colgroup>
                                    <tbody>
                                    <tr>
                                          <th scope="row">작성자</th>
                                          <input type="hidden" name="id" value="${userName}"/>
                                          <td><input type="text" name="writer" class="inputText" size="50"/></td>
                                    </tr>
                                    <tr>
                                          <th scope="row">제목</th>
                                          <td><input type="text" name="title" class="inputText" size="50"/></td>
                                    </tr>
                                    <tr>
                                          <th scope="row">비밀</th>
                                          <td><input type="password" name="password" class="inputText" size="50"/></td>
                                    </tr>
                                    <tr>
                                          <th scope="row">내용</th>
                                          <td class="editer">
                                                <textarea name="contents"></textarea>
                                          </td>
                                    </tr>
                                    <tr>
                                          <th scope="row">이미지첨부</th>
                                          <td>
                                                <input type="file" name="file" class="inputText" size="50"/>
                                          </td>
                                    </tr>
                                    </tbody>
                              </table>
                        </form>

                  </div>
            </div>

      <!-- 덧글 div-->
      <div class="cmt_comm">
            <form action="#">
                  <fieldset class="fld_cmt" style="width: 1000px;">
                        <legend class="screen_out">댓글 작성</legend>
                        <textarea class="tf_cmt" cols="115" rows="5"
                                  title="한줄 토크를 달아주세요">한줄 토크를 달아주세요! (300자)</textarea>
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
                        <a href="#none">답글</a><span class="txt_bar">|</span><a href="#none">수정</a><span class="txt_bar">|</span><a
                            href="#none">삭제</a>
                  </div>
            </div>
      </div>
      <!--덧글 div 끝 -->
      </div>
</div>

</body>
</html>