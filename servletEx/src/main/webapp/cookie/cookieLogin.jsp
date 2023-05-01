<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <meta name="copyright" content="Copyright 2009 @ high1 all rights reserved"/>
      <link href="<%=request.getContextPath()%>/css/contents.css" rel="stylesheet" type="text/css"/>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {
              $("#btnSubmit").click(function () {
                  var checked = $("#checker").is(':checked');
                  if(checked){
                      var id = $("#user_id").val();
                      var checkCookie = `checked=true;`;
                      var idCookie = `id=`+id;
                      document.cookie = checkCookie;
                      document.cookie = idCookie;
                  }
                  $("form").submit();
              })
          })
      </script>
</head>
<body>
<%
      Cookie[] cookies = request.getCookies();
      String checked = "";
      String id = "";
      if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                  if (cookies[i].getName().trim().equalsIgnoreCase("saveId")) {
                        checked = cookies[i].getValue();
                  }
                  if (cookies[i].getName().trim().equalsIgnoreCase("id")) {
                        id = cookies[i].getValue();
                  }
            }
      }

%>

<%--<form name="login" method="post" action="../cartStruts/adminCheckLogin.action">--%>
<form name="login" method="post" action="/Web/login.do?cmd=login">
      <div id="loginWrapper">
            <div class="loginForm">
                  <fieldset>
                        <legend>관리자 시스템 로그인</legend>
                        <dl>
                              <dt><img src="${pageContext.request.contextPath}/img/common/th_id.gif" alt="아이디"/></dt>
                              <dd><input type="text" name="id" class="text" id="user_id" value="<%=(checked!=null)? id : null%>"/></dd>

                              <dt><img src="${pageContext.request.contextPath}/img/common/th_pw.gif" alt="비밀번호"/></dt>
                              <dd><input type="password" name="pass" class="text" id="user_passwd"/></dd>
                        </dl>
                        <div class="btn">
                              <img id="btnSubmit" src="${pageContext.request.contextPath}/img/button/btn_login.gif"
                                   alt="LOGIN" title="LOGIN"/>
                        </div>

                        <div class="saveId"><input type="checkbox" id="checker" name="checker" checked="<%=(checked!=null)?true : false%>"
                        />
                              <img src="${pageContext.request.contextPath}/img/common/save_id.gif" alt="아이디 저장"/>
                        </div>
                  </fieldset>
            </div>
      </div>
</form>
</body>
</html>