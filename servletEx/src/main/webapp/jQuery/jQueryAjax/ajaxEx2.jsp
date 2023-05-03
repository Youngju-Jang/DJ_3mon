<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <title>Title</title>
      <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
      <link rel="stylesheet" href="/resources/demos/style.css">
      <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
      <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
      <script>
          $(function () {
              $("#accordion").accordion();

              function ajaxProcess(type, url, dataType, id) {
                  $.ajax({
                      type,
                      url,
                      dataType,
                      error: function () {
                          alert('ajax error');
                      },
                      success: function (data) {
                          $('div#'+id).html("<p>"+data+"</p>")
                          // $("div#accordion > div:nth-of-type(" + num + ")").html(data);
                      }
                  })
              }

              $("h3").click(function () {
                  $(this).next().find("div").html("<p>" + "test1111111111" + "</p>");
                  ajaxProcess('GET', '../ajaxData/ajaxResult'+this.id.substring(1)+'.jsp', 'text', this.id);
              });

              // ajaxProcess('GET', '../ajaxData/ajaxResult2.jsp', 'text', 2);
          });
      </script>
</head>
<body>
<div id="accordion">
      <h3 id="h1">Section 1</h3>
      <div id="h1">
            <p>
                  Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
                  ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
                  amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
                  odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
            </p>
      </div>
      <h3 id="h2">Section 2</h3>
      <div id="h2">
            <p>
                  Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet
                  purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor
                  velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In
                  suscipit faucibus urna.
            </p>
      </div>
      <h3 id="h3">Section 3</h3>
      <div id="h3">
            <p>
                  Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis.
                  Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero
                  ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis
                  lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
            </p>
            <ul>
                  <li>List item one</li>
                  <li>List item two</li>
                  <li>List item three</li>
            </ul>
      </div>
      <h3 id="h4">Section 4</h3>
      <div id="h4">
            <p>
                  Cras dictum. Pellentesque habitant morbi tristique senectus et netus
                  et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in
                  faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia
                  mauris vel est.
            </p>
            <p>
                  Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus.
                  Class aptent taciti sociosqu ad litora torquent per conubia nostra, per
                  inceptos himenaeos.
            </p>
      </div>
</div>
</body>
</html>
