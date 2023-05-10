<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=10" />
      <meta http-equiv="imagetoolbar" content="no" />
      <meta name="copyright" content="Copyright 2009 @ high1 all rights reserved" />
      <link href="../css/contents.css" rel="stylesheet" type="text/css" />
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <!-- 모델1 모델2 -->
      <script>
          $(function(){
              $("img#btnSubmit").click(function(){
                  if($("input[name='name']").val().length==0||$("input[type='password']").val().length==0){
                      alert('ID OR PASS CHECK!');
                      $("input[name='name']").val('');
                      $("input[type='password']").val('');
                      $("input[name='name']").focus();
                      return false;
                  }else{
                      // $("form[name='login']").submit();
                      $.ajax({
                          url:'${pageContext.request.contextPath}/loginSelect.do?cmd=login',
                          type:'POST',
                          data:{"cmd":'login',"name":$("input#name").val(),"password":$("input#password").val()},
                          success:function(data){
                              console.log("ajax success");
                              console.log(data);
                              if(data.trim()=='T'){
                                  document.location.href='${pageContext.request.contextPath}/listSelect.do?cmd=listSelect';
                              }else{
                                  $("dt#show").html("<font color='red'> Check</font>");
                                  $("input[name='id']").val('');
                                  $("input[name='pass']").val('');
                                  $("input[name='id']").focus();
                              }
                          },error:function(){
                              console.log('error');
                          }
                      });
                  }
              });
          });
      </script>
</head>
<body>
<form name="login" method="post" action="${pageContext.request.contextPath}/loginSelect.do?cmd=login">
<%--      로그인시 *.do? 패턴이기 때문에 dispatcherServlet.java 로 이동--%>
<%--      파라미터로 cmd, name, password 를 같이 보냄 --%>
      <div id="loginWrapper">
            <div class="loginForm">
                  <fieldset>
                        <legend>관리자 시스템 로그인</legend>
                        <dl>
                              <dt id="show"></dt>
                              <dt><img src="../img/common/th_id.gif" alt="아이디" /></dt>
                              <dd><input type="text" name="name" class="text" id="name" /></dd>

                              <dt><img src="../img/common/th_pw.gif" alt="비밀번호" /></dt>
                              <dd><input type="password" name="password" class="text" id="password" /></dd>
                        </dl>
                        <div class="btn">
                              <img id="btnSubmit" src="../img/button/btn_login.gif" alt="LOGIN" title="LOGIN"  />
                        </div>

                        <div class="saveId"><input type="checkbox" id="checker" name="checker" />
                              <img src="../img/common/save_id.gif" alt="아이디 저장" />
                        </div>
                  </fieldset>
            </div>
      </div>
</form>
</body>
</html>