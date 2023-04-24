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
      <style type="text/css">
            th{
                width: 150px;
            }
      </style>
      <script type="text/javascript" src="httpRequest.js"></script>
      <script type="text/javascript">
          function loadProcess(url, param, callBackProcess, method) {
              sendRequest(url, param, callBackProcess, method);
              console.log(httpRequest);
          }

          function callBackProcessXml() {
              if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                  // document.getElementById("aspan").innerHTML = httpRequest.getElementsByTagName('statuses');
                  var xml = httpRequest.responseXML;
                  var rootE = xml.getElementsByTagName('statuses');
                  var output = '';
                  for (var i = 0; i < 10; i++) { // status 10개 돌리기
                      // output += "<h3>" + rootE[i].childNodes[1].childNodes[1].firstChild.nodeValue + "</h3>";
                      //   console.log(rootE[i].childNodes[1].childNodes[19].nodeName); //user
                      //   console.dir(rootE[i].childNodes[1].childNodes[19].childNodes); // nodeList(73)

                      var users = rootE[i].getElementsByTagName('user')
                      for (var j in users) {
                          console.dir(users[j].getElementsByTagName('url')[0].firstChild.nodeValue);
                          // console.dir(rootE[i].childNodes[1].childNodes[19].childNodes[j].textContent);
                          output += "<h3>" + j + ":" + users[j].getElementsByTagName('url')[0].firstChild.nodeValue + "</h3>";
                      }
                      output += "<hr>";
                  }
                  document.getElementById("aspan").innerHTML = output;
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
                  var result = JSON.parse(str);
                  // alert(result["age"]);
                  var output = "";

                  for (var i in result) {
                      if (typeof result[i] == "object") {
                          output += "<h3>" + i + ": </h3>";
                          for (var j in result[i]) {
                              output += `&nbsp;&nbsp;<h4>` + j + " : " + result[i][j] + "</h4>";
                          }
                          continue;
                      }
                      output += "<h3>" + i + " : " + result[i] + "</h3>";
                  }
                  document.getElementById("bspan").innerHTML = output;
              }
          }

          function callBackProcessJson2() {
                  //index for ,for in
              /* if(httpRequest.readyState==4&&httpRequest.status==200){
			  var dom= httpRequest.responseText;
			  var domparse=JSON.parse(dom);
			  console.log(domparse);//1�ܰ� ��ü ��üȮ��
			  for(var i=0;i<domparse.length;i++){
				//console.log(domparse[i]);
				for(var j in domparse[i]){
					  console.log(domparse[i][j]);

				}//for
			  }//for

		 }//if   */

              // Object.keys 로 하기
              // if (httpRequest.readyState == 4 && httpRequest.status == 200) {
              //     var dom = httpRequest.responseText;
              //     var domparse = JSON.parse(dom);
              //     // console.log(domparse);
              //     var output = "";
              //
              //     for (var i in domparse) {
              //         // console.log(domparse[i]);
              //         Object.keys(domparse[i]).forEach(function (value) {
              //             console.log(domparse[i][value]);
              //         })
              //     }
              // }
              if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                  var dom = httpRequest.responseText;
                  var domparse = JSON.parse(dom);
                  // 백틱으로 하기

                  for (var i in domparse) {
                      if (i == 0) {
                          Object.keys(domparse[0]).forEach(function (value) {
                              console.log(value);
                              var head = `<th>\${value}</th>`;
                              document.getElementById("item").innerHTML += head;
                          }); //forEach
                      }
                      var tr = document.createElement("tr");
                      Object.keys(domparse[i]).forEach(function (value) {
                          var td = document.createElement("td");
                          var content = `<td>\${domparse[i][value]}</td>`;
                          td.innerHTML = content;
                          tr.appendChild(td);
                          document.getElementById("tbody").appendChild(tr);
                      });
                  }// for

              }// if
          }
      </script>
</head>
<body>

<input type="button" value="이도경" onclick="loadProcess('twitter.xml', null, callBackProcessXml, 'GET')">
<input type="button" value="김민준" onclick="loadProcess('ajaxData.jsp', null, callBackProcess2, 'GET')">
<input type="button" value="장영주" onclick="loadProcess('ajaxJson.jsp', null, callBackProcessJson2, 'GET')">
<input type="button" value="json" onclick="loadProcess('ajaxJson.jsp', null, callBackProcessJson, 'GET')">
<br>
<span id="aspan"></span>
<span id="bspan"></span>

<table cellpadding="10" cellspacing="0" width="80" align="center">
      <thead>
      <tr id="item"></tr>
      </thead>
      <tbody id="tbody">

      </tbody>
</table>
</body>
</html>
