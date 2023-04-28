<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>num7</title>
      <style type="text/css">
          th {
              width: 150px;
          }
      </style>
      <script type="text/javascript" src="httpRequest.js"></script>
      <script type="text/javascript">
          function loadProcess(url, param, callBackProcess, method) {
              sendRequest(url, param, callBackProcess, method);
              console.log(httpRequest);
          }

          function callBackProcessJson() {
              if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                  var dom = httpRequest.responseText;
                  var domparse = JSON.parse(dom);
                  // 백틱으로 하기
                  var employess = domparse['Employees'];
                  // 제목만들기
                  for(var key in employess[0]){
                      var head = `<th>\${key}</th>`;
                      document.getElementById("item").innerHTML += head;
                  }
                  for(var i=0; i<employess.length; i++){
                      console.dir(employess[i]);
                      var tr = document.createElement("tr");
                      Object.keys(employess[i]).forEach(function(value){
                          var td = document.createElement("td");
                          var content = `<td>\${employess[i][value]}</td>`;
                          td.innerHTML = content;
                          tr.appendChild(td);
                          document.getElementById("tbody").appendChild(tr);
                      });
                  }//for
              }// if
          }

          loadProcess('num7Data.jsp', null, callBackProcessJson, 'GET');
      </script>
</head>
<body>

<table cellpadding="10" cellspacing="0" width="80" align="center" border="1px solid">
      <thead>
      <tr id="item"></tr>
      </thead>
      <tbody id="tbody">
      </tbody>
</table>

</body>
</html>
