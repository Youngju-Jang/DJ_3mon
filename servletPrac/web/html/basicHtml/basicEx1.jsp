<%@ page import="static java.awt.Color.blue" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>jQuery UI Spinner - Default functionality</title>
      <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
      <link rel="stylesheet" href="/resources/demos/style.css">
      <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
      <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
      <script src="/resources/demos/external/jquery-mousewheel/jquery.mousewheel.js"></script>
      <script>
          $( function() {
              var spinner = $( "#spinner" ).spinner();

              $( "#disable" ).on( "click", function() {
                  if ( spinner.spinner( "option", "disabled" ) ) {
                      spinner.spinner( "enable" );
                  } else {
                      spinner.spinner( "disable" );
                  }
              });
              $( "#destroy" ).on( "click", function() {
                  if ( spinner.spinner( "instance" ) ) {
                      spinner.spinner( "destroy" );
                  } else {
                      spinner.spinner();
                  }
              });
              $( "#getvalue" ).on( "click", function() {
                  alert( spinner.spinner( "value" ) );
              });
              $( "#setvalue" ).on( "click", function() {
                  spinner.spinner( "value", 5 );
              });

              $( "button" ).button();
          } );
      </script>
</head>
<body>
<%--<%--%>
<%--      for(int i=1; i<=6; i++){--%>
<%--%>--%>
<%--      <h<%=i%>> Test <%=i%> </h<%=i%>>--%>
<%--      <font size=<%=i%> color="green">ㅎㅎㅎ</font>--%>
<%--      <font size=<%=i%> color="green">ㅎㅎㅎ</font>--%>
<%--      <div>d3iv</div><div>dfsfsdf</div><span>span</span><span>span</span>--%>
<%--<%--%>
<%--      }--%>
<%--%>--%>
      <%
            for(int i=1; i<=7; i++){
                 if(i%2==0){
      %>
            <font size="<%=i%>" color="red">TestFont</font>
      <%
                 }else{
                      %>
            <font size="<%=i%>" color="blue">TestFont</font>
            <hr color="pink" width="100%" size="<%=i*10%>px">
<%
                        }
                  }
            %>

      <p>
            <label for="spinner">Select a value:</label>
            <input id="spinner" name="value">
      </p>

      <p>
            <button id="disable">Toggle disable/enable</button>
            <button id="destroy">Toggle widget</button>
      </p>

      <p>
            <button id="getvalue">Get value</button>
            <button id="setvalue">Set value to 5</button>
      </p>
      <table>
            <caption> 교재 가격 현황 </caption>
            <tr>
                  <th> 서적명 </th>
                  <th> 출판사 </th>
                  <th> 가격 </th>
                  <th> 기타 </th>
            </tr>
            <Tr>
                  <td >HTML5</td>
                  <td>공갈닷컴</td>
                  <td>30,000원</td>
                  <td></td>
            </Tr>
            <Tr>
                  <td colspan="2">합계</td>
                  <td>87,000원</td>
            </Tr>
      </table>

      <form>
            <fieldset>
                  <legend> 회원가입 </legend>
                  <label for="id">ID:</label>
                  <input type="text" name="id" id="id"> <br>
                  <label for="pwd">Password:</label>
                  <input type="password" id="pwd" name="password"><br>
                  <input type="reset" value="초기화">
                  <input type="submit" value="로그인">
            </fieldset>

            <label for="cars">Choose a car:</label>
            <select id="cars" name="cars">
                  <option value="volvo">Volvo</option>
                  <option value="saab">Saab</option>
                  <option value="fiat">Fiat</option>
                  <option value="audi">Audi</option>
            </select> <br>

            <label for="browsers">Browser</label>
            <input list="browsers" name="browser">
            <datalist id="browsers">
                  <option value="Internet Explorer">
                  <option value="Firefox">
                  <option value="Chrome">
                  <option value="Opera">
                  <option value="Safari">
            </datalist>
            <input type="submit">

      </form>


</body>
</html>
