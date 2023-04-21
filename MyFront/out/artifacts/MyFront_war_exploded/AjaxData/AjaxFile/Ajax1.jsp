<%--
  Created by IntelliJ IDEA.
  User: joj1043
  Date: 2023/04/21
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Title</title>
      <script type="text/javascript" src="httpRequest.js"></script>
      <script type="text/javascript">
          function loadProcess(url, param, callBackProcess, method) {
              sendRequest(url, param, callBackProcess, method);
              console.log(httpRequest);
          }

          function loadProcess2(url, param, callBackProcess, method) {
              sendRequest(url, param, callBackProcess, method);
              console.log(httpRequest);
          }

          function callBackProcess() {
              if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                  // document.getElementById("aspan").innerHTML = httpRequest.getElementsByTagName('statuses');
                  var xml = httpRequest.responseXML;
                  var rootE = xml.getElementsByTagName('statuses');
                  var output = '';

                  output += "<h3>"+ rootE[0].childNodes[1].childNodes[1].firstChild.nodeValue +"</h3>";
                  document.getElementById("aspan").innerHTML += output;
              }
          }

          function callBackProcess2() {
              if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                  document.getElementById("bspan").innerHTML = httpRequest.responseText;
              }
          }

          function callBackProcessJson() {
              if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                  var str = httpRequest.responseText;
                  var result=JSON.parse(str);
                  // alert(result["age"]);
                  var output="";

                  for(var i in result){
                      if(typeof result[i] == "object"){
                          output += "<h3>" + i + ": </h3>";
                          for(var j in result[i]){
                              output += `&nbsp;&nbsp;<h4>`+ j +" : "+ result[i][j]+"</h4>";
                          }
                          continue;
                      }
                      output += "<h3>" +i + " : "+ result[i] + "</h3>";
                  }
                  document.getElementById("bspan").innerHTML = output;
              }
          }
      </script>
</head>
<body>

<input type="button" value="이도경" onclick="loadProcess('twitter.xml', null, callBackProcess, 'GET')">
<input type="button" value="김민준" onclick="loadProcess2('ajaxData.jsp', null, callBackProcess2, 'GET')">
<input type="button" value="json" onclick="loadProcess2('ajaxJson.jsp', null, callBackProcessJson, 'GET')">
<br>
<span id="aspan"></span>
<span id="bspan"></span>
</body>
</html>
