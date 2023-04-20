<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("id").equals("abcd") && 
			            request.getParameter("passwd").equals("1234")){
%>		
	{"result":"ok"}	
<%
	}else{
%>
    {"result":"fail"}	
<%		
	}
%>