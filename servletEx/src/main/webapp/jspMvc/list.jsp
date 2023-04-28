<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$(document).ready(function(){
		if(${id}==null){
		}


		var now = new Date();
		$(".loginWrap>span").eq(1).text(now.getHours()+":"+now.getMinutes()+":"+now.getSeconds());
		$(".loginWrap>span").eq(0).text(now.getFullYear()+"."+now.getMonth()+"."+now.getDay());
	});
</script>
<head>
<title>관리자</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=10" />
<meta http-equiv="imagetoolbar" content="no" />
<link href="../css/contents.css" rel="stylesheet" type="text/css" />
<%
	String id = (String) session.getAttribute("id");
	if (id == null) {
		response.sendRedirect("adminLogin.jsp");
	}
%>
</head>
<body>
	<div id="wrapper">
		<div id="header">
				<div class="topInfoWrap">
					<div class="topInfoArea clfix">
						<div class="loginWrap">
							<span class="fir"></span>
							<span></span>
							<span><em>${id}님</em> 좋은 하루 되세요</span>
							<a href="" class="btnLogout"><img src="../img/common/btn_logout.gif" alt="로그아웃" /></a>
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
							<span class="button"><a href="#">검색</a></span>
							<span class="button"><a href="#">글쓰기</a></span>
						</span>
					</div>

					<table class="bbsWrite mgb35">
						<caption></caption>
						<colgroup>
							<col width="95" />
							<col width="395" />
							<col width="95" />
							<col />
						</colgroup>
						<tbody>
						<tr>
							<th>검색</th>
							<td>
								<select>
									<option>선택하세요</option>
								</select>
								<input type="text" name="" class="inputText" size="30" />
							</td>
						</tr>
						</tbody>
					</table>

					<table class="bbsList">
						<colgroup>
							<col width="30" />
							<col width="130" />
							<col width="130" />
							<col width="130" />
							<col width="130" />
							<col width="130" />
							<col width="130" />
							<col width="130" />
<%--							<col />--%>
						</colgroup>
						<thead>
						<tr>
							<th scope="col" class="fir">NO.</th>
							<th scope="col">EMPNO</th>
							<th scope="col">ENAME</th>
							<th scope="col">SAL</th>
							<th scope="col">MGR</th>
							<th scope="col">COMM</th>
							<th scope="col">HIREDATE</th>
							<th scope="col">DEPTNO</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${empList}" var="emp" varStatus="vs">
						<tr>
							<td class="fir">${vs.index +1}</td>
							<td>${emp.empno}</td>
							<td>${emp.ename}</td>
							<td>${emp.sal}</td>
							<td>${emp.mgr}</td>
							<td>${emp.comm}</td>
							<td>${emp.hiredate}</td>
							<td>${emp.deptno}</td>
						</tr>
						</c:forEach>
						</tbody>
					</table>

					<div class="paging">
						<a href="#"><img src="../img/button/btn_first.gif" alt="처음페이지" /></a>
						<a href="#"><img src="../img/button/btn_prev.gif" alt="이전" /></a>
						
						<span>
							<a href="#">1</a>
							<a href="#">2</a>
							<a href="#">3</a>
							<strong>4</strong>
							<a href="#">5</a>
							<a href="#">6</a>
							<a href="#">7</a>
							<a href="#">8</a>
							<a href="#">9</a>
						</span>				

						<a href="#"><img src="../img/button/btn_next.gif" alt="다음" /></a>
						<a href="#"><img src="../img/button/btn_last.gif" alt="마지막페이지" /></a>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>