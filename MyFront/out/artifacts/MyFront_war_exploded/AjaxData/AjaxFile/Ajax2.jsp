<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
      <title>Title</title>
      <script type="text/javascript" src="httpRequest.js"></script>
      <script type="text/javascript">
          function twitterStart(url, params, callback, method) {
              sendRequest(url, params, callback, method);
          }

          function view() { // callback
              document.getElementById("showTable").style.visibility = 'visible';
              if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                  // console.log(httpRequest.responseXML);
                  printInfo();
              }
          }

          var twitters = [];

          function printInfo() {
              var xmlData = httpRequest.responseXML;
              var status_list = xmlData.getElementsByTagName('status');
              for (var i = 0; i < status_list.length; i++) { // statusList for
                  var status_childNodes = status_list[i].childNodes;
                  var twitter = {};
                  for (var x = 0; x < status_childNodes.length; x++) { // status 한개
                      var node = status_childNodes[x];
                      var value = node.childNodes[0];
                      if (value) {
                          var currentNodeName = node.nodeName;
                          // console.log(currentNodeName);
                          if (currentNodeName == 'created_at' || currentNodeName == 'text' || currentNodeName == 'source') {
                              twitter[currentNodeName] = value.nodeValue;
                          } else if (currentNodeName == 'user') {
                              var user_object = getUserObject(node.childNodes);
                              twitter['screen_name'] = user_object.screen_name;
                              twitter['profile_image_url'] = user_object['profile_image_url'];
                              twitter['id'] = user_object.id;
                          }// else if
                          twitter.flag = true;
                      }
                  }// for (status 한개)
                  if (twitter.flag) {
                      twitters.push(twitter);
                  }
              }// statusList for
              drawing(twitters);
          } // printInfo

          function drawing(twitters) {
              Object.keys(twitters[0]).forEach(function (value) {
                  console.log(value);
                  var head = `<th>\${value}</th>`;
                  document.getElementById("subject").innerHTML += head;
              }); // forEach
              for (var i in twitters) {
                  var content = `<tr>`;
                  Object.keys(twitters[i]).forEach(function (value) {
                      // console.log(i +" : "+ value +" : "+twitters[i][value]);
                      var td = `<td>\${twitters[i][value]}</td>`;
                      content += td;
                  }); // forEach
                  content += `</tr>`;
                  document.getElementById("tbody").innerHTML += content;
              }
          }

          function getUserObject(user_node) {
              var user_vo = {};
              for (var i = 0; i < user_node.length; i++) {
                  var node = user_node[i];
                  if (node) {
                      var value = node.childNodes[0];
                      if (node.nodeName == 'screen_name' || node.nodeName == 'profile_image_url' || node.nodeName == 'id') {
                          user_vo[node.nodeName] = value.nodeValue;
                      }
                  }
              }// for
              return user_vo;
          }

          function load() {
              document.getElementById("showTable").style.visibility = 'hidden';
          }
      </script>
</head>
<body onload="load()">

<input type="button" value="Twitter" onclick="twitterStart('twitter.xml', null, view, 'GET')">
<table cellpadding="10" cellspacing="0" border="1" width="80%" align="center" id="showTable">
      <thead id="thead">
      <tr id="subject"></tr>
      </thead>
      <tbody id="tbody">
      </tbody>
</table>
</body>
</html>
