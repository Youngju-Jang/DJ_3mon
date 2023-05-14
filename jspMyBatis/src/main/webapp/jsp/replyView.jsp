<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="${pageContext.request.contextPath}/css/reply.css" rel="stylesheet" />
</head>
<body>
<!-- 덧글 div-->
<div class="cmt_comm">
  <form action="#">
    <fieldset class="fld_cmt" style="width: 1000px;">
      <legend class="screen_out">댓글 작성</legend>
      <textarea class="tf_cmt" cols="115" rows="5" title="한줄 토크를 달아주세요">한줄 토크를 달아주세요! (300자)</textarea>
      <button type="submit" class="btn_cmt"  >등록</button>
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
      <a href="#none">답글</a><span class="txt_bar">|</span><a href="#none">수정</a><span class="txt_bar">|</span><a href="#none">삭제</a>
    </div>
  </div>
</div>

<!--덧글 div 끝 -->
</body>
</html>