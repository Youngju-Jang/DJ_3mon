<%@ page import="com.bit.dao.EmpDao" %>
<%@ page import="com.bit.model.EmpBean" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
      <title>관리자</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
      <meta http-equiv="X-UA-Compatible" content="IE=10"/>
      <meta http-equiv="imagetoolbar" content="no"/>
      <link href="../css/contents.css" rel="stylesheet" type="text/css"/>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>

          $(function () {
              $("span#save").click(function () {
                  $("form").submit();
              });
          });
      </script>
      <%
            EmpDao dao = EmpDao.getInstance();
            List<EmpBean> empList = dao.selectEmpList();
            int listIdx = Integer.parseInt(request.getParameter("listIdx"));
            EmpBean user = empList.get(listIdx);
            request.setAttribute("user", user);
      %>
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
                        <form action="editInsert.jsp" method="post">
                              <table class="bbsWrite">
                                    <colgroup>
                                          <col width="90"/>
                                          <col/>
                                    </colgroup>

                                    <tbody>
                                    <tr>
                                          <th scope="row">작성자</th>
                                          <td><input type="text" name="writer" class="inputText" size="30"
                                                     value="<%=user.getEname()%>" /></td>
                                    </tr>
                                    <tr>
                                          <th scope="row">제목</th>
                                          <td><input type="text" name="subject" class="inputText" size="50"
                                                     value="입사일 : <%=user.getHiredate()%>"/></td>
                                    </tr>
                                    <tr>
                                          <th scope="row">내용</th>
                                          <td class="editer">
								<textarea name="content">
									Empno : ${user.empno}
                                                      ename : <%= user.getEname()%>
								</textarea>
                                          </td>
                                    </tr>
                                    <tr>
                                          <th scope="row">이미지첨부</th>
                                          <td>
                                                <input type="file" name="file\" class="inputText" size="50"/>
                                          </td>
                                    </tr>
                                    </tbody>
                              </table>
                        </form>
                  </div>
            </div>
      </div>
</div>
</body>
</html>