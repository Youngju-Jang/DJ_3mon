<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>������</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <meta name="copyright" content="Copyright 2009 @ high1 all rights reserved"/>
      <link href="../css/contents.css" rel="stylesheet" type="text/css"/>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
      $(function(){
          $("img#btnSubmit").click(function(){
              if($("input[name='id']").val().length==0 || $("input[type='password']").val().length==0){
                  alert('ID or Password Check');
                  $("input[name='id']").val('');
                  $("input[type='password']").val('');
                  $("input[name='id']").focus();
                  return false;
              }else{
                  $("form[name='login']").submit();
              };
          });
      });
      </script>
</head>
<body>
<form name="login" method="post" action="loginProcess.jsp">
      <div id="loginWrapper">
            <div class="loginForm">
                  <fieldset>
                        <legend>������ �ý��� �α���</legend>
                        <dl>
                              <dt><img src="../img/common/th_id.gif" alt="���̵�"/></dt>
                              <dd><input type="text" name="id" class="text" id="user_id"/></dd>

                              <dt><img src="../img/common/th_pw.gif" alt="��й�ȣ"/></dt>
                              <dd><input type="password" name="pass" class="text" id="user_passwd"/></dd>
                        </dl>
                        <div class="btn">
                              <img id="btnSubmit" src="../img/button/btn_login.gif" alt="LOGIN" title="LOGIN"/>
                        </div>

                        <div class="saveId"><input type="checkbox" id="checker" name="checker"/>
                              <img src="../img/common/save_id.gif" alt="���̵� ����"/>
                        </div>
                  </fieldset>
            </div>
      </div>
</form>
</body>
</html>