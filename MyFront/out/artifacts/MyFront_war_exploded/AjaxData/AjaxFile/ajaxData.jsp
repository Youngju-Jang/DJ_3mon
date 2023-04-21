<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
      String state = request.getParameter("state");
%>
<%
      if(state != null && state.equals("t")){
%>
원시 타입 코드와 마찬가지로 동일한 변수 a, b 가 존재합니다.

여기서 modify(a, b) 를 호출한 후에 a.age 의 값이 변경되었기 때문에 Call by Reference 로 파라미터를 넘겨주었다고 착각하기 쉽습니다.
<%
      }else {
%>
하지만 Reference 자체를 전달하는 게 아니라 주소값만 전달해주고 modify() 에서 생긴 변수들이 주소값을 보고 객체를 같이 참조하고 있는 겁니다.

단계별 그림으로 확인해봅니다.
<%
      }
%>