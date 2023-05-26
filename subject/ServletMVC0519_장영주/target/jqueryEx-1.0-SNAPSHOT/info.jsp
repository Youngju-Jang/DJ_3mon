<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
<html>

<head>

      <meta charset="utf-8" >
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">

      <title>Start Simple Web</title>

      <!-- Bootstrap Core CSS -->
      <link href="css/bootstrap.css" rel="stylesheet">

      <!-- Custom CSS -->
      <link href="css/clean-blog.css" rel="stylesheet">
      <link href="css/board.css" rel="stylesheet">
      <!-- Custom Fonts -->
      <link
                href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
                rel="stylesheet" type="text/css">
      <link
                href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
                rel='stylesheet' type='text/css'>
      <link
                href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
                rel='stylesheet' type='text/css'>

      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>-->
      <%--      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>--%>
      <%--      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>--%>
      <%--      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>--%>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

      <![endif]-->
      <script>
          $(function () {
              $.ajax({
                  url: '${pageContext.request.contextPath}/insertComment.do?cmd=selectComment&board=${board.no}&comment=',
                  type: 'POST',
                  data: '',
                  success: function (data) {
                      console.log("ajax success");
                      console.log(data);
                      $("div#ajaxData").html(data);
                  }, error: function () {
                      console.log('error');
                  }
              });
              $("button.btn_cmt").click(function () {
                  console.log($("#sessionId").val());
                  if ($("#sessionId").val().length == 0) {
                      window.location.href = "/signin.jsp";
                  }
                  if ($("textarea[name='content']").val().length == 0) {
                      alert('Add Comment...');
                      return false;
                  }
                  // $("form[name='comm_form']").submit();
                  // 이후 ajax 로 변경하기
                  $.ajax({
                      url: '${pageContext.request.contextPath}/insertComment.do?cmd=insertComment&board=${board.no}&comment=',
                      type: 'POST',
                      data: $("form#first_comm").serialize(),
                      success: function (data) {
                          console.log("ajax success");
                          console.log(data);
                          $("textarea[name='content']").val('');
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

<jsp:include page="header.jsp"></jsp:include>


<!-- Page Header -->
<!-- Set your background image for this header on the line below. -->
<header class="intro-header"
        style="background-image: url('img/about-bg.jpg'); height: 200px">
      <div class="container">
            <div class="row">
                  <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <div class="site-heading"
                             style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
                              <h2>SAMPLE</h2>
                              <span class="subheading">BULLETIN BOARD</span>
                        </div>
                  </div>
            </div>
      </div>
</header>
<div class="board-field">
      <div class="list-group">
            <div class="list-group-item board-title">
                  <div class="board-title">
                        <span class="board-category">[JAVASCRIPT]</span><a href="#">
                        ${board.title} </a>
                  </div>
                  <div class="board-meta"
                       style="font-weight: 400; font-size: 1.2rem; color: #404040">
                        <p>
                              <i class="glyphicon glyphicon-user"></i> ${userName} 님
                              <i class="glyphicon glyphicon-comment"></i> ${board.hit}
                              <i class="glyphicon glyphicon-ok"></i> ${commentList.size()}
                              <i class="glyphicon glyphicon-time"></i> ${board.regdate}
                              <i class="glyphicon glyphicon-thumbs-up"></i> 0
                              <i class="glyphicon glyphicon-thumbs-down"></i> 0
                        </p>
                  </div>
                  <div class="clear"></div>
            </div>
            <div class="list-group-item">
                  <span class="board-contents"> ${board.contents} </span>
                  <c:if test='${not empty board.fileName}'>
                        <img src='/upload/${board.fileName}'
                             width="400" height="400"/>
                  </c:if>
                  <p style="text-align: center; margin-top: 30px">
                        <button class="btn btn-success">
                              <i class="glyphicon glyphicon-thumbs-up"></i>공감
                        </button>
                        <button class="btn btn-warning">
                              <i class="glyphicon glyphicon-thumbs-down"></i>비공감
                        </button>
                  </p>감
            </div>
            <div class="bottom" style="margin: 10px;margin-top: 20px; text-align: right">
                  <a href="${pageContext.request.contextPath}/board.jsp?page=${page}"
                     class="btn btn-default btn-xs pull-left">목록으로</a>
                  <c:if test="${userName eq board.id}">
                        <a href="${pageContext.request.contextPath}/password.jsp?job=mod&no=${board.no}"
                           class="btn btn-default btn-xs">수정</a>
                        <a href="${pageContext.request.contextPath}/password.jsp?job=del&no=${board.no}"
                           target="_action_frame_bbs" class="btn btn-default btn-xs"
                           onclick="return confirm('정말로 삭제하시겠습니까?');">삭제</a>
                  </c:if>
                  <a href="#" class="btn btn-default btn-xs">스크랩</a>
            </div>
            <div class="clear"></div>
      </div>
</div>
<!-- 덧글 div-->
<div class="cmt_comm">
      <form name="comm_form"
      <%--                        action="${pageContext.request.contextPath}/insertComment.do?cmd=insertComment&board=${board.no}&comment="--%>
            method="post" id="first_comm">
            <input type="hidden" value="${sessionScope.id}" id="sessionId" name="userId">
            <fieldset class="fld_cmt" style="width: 1000px;">
                  <legend class="screen_out">댓글 작성</legend>
                  <textarea class="tf_cmt" cols="115" rows="5"
                            title="한줄 토크를 달아주세요" name="content"></textarea>
                  <button type="button" class="btn_cmt">등록</button>
                  <p class="info_append">
                        <span class="screen_out">입력된 바이트 수 : </span>
                        <span class="txt_byte">55</span> / 300자
                        <span class="txt_bar">|</span>
                        <a href="#none">댓글 운영원칙</a>
                  </p>
            </fieldset>
      </form>
      <br>


      <div id="ajaxData">

      </div>
</div>
<!-- Footer -->
<footer>
      <div class="container">
            <div class="row">
                  <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                        <ul class="list-inline text-center">
                              <li><a href="#"> <span class="fa-stack fa-lg"> <i
                                        class="fa fa-circle fa-stack-2x"></i> <i
                                        class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
							</span>
                              </a></li>
                              <li><a href="#"> <span class="fa-stack fa-lg"> <i
                                        class="fa fa-circle fa-stack-2x"></i> <i
                                        class="fa fa-home fa-stack-1x fa-inverse"></i>
							</span>
                              </a></li>
                              <li><a href="#"> <span class="fa-stack fa-lg"> <i
                                        class="fa fa-circle fa-stack-2x"></i> <i
                                        class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
                              </a></li>
                        </ul>
                        <p class="copyright text-muted">Copyright &copy;2016 SIST. All
                              rights reserved | code by milib</p>
                  </div>
            </div>
      </div>
</footer>
<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.js"></script>

<!-- Custom Theme JavaScript -->
<script src="js/clean-blog.min.js"></script>
</body>

</html>
