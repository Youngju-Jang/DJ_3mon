<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {
              $("input[type='button']").click(function () {
                  if($("input[name='no']").val().length == 0){
                      $("input[name='no']").val(0);
                  }
                  if ($("input[name='name']").val().length == 0 || $("input[name='hobby']").val().length == 0) {
                      $("input[name='name']").focus();
                      return false;
                  } else {
                      $.ajax({
                          url: '${pageContext.request.contextPath}/memberApp.do?cmd=memberApp&state='+this.id,
                          type: 'POST',
                          <%--data: '{name:${"input#name"}.val(), hobby:${"input#hobby"}.val()}',--%>
                          data: $("form#memberForm").serialize(),
                          success: function (data) {
                              $("div#list").text(JSON.stringify(data));
                          }, error: function () {
                              console.log('error');
                          }
                      });
                  }
                  <%--$.ajax({--%>
                  <%--    url:'${pageContext.request.contextPath}/memberApp.do?cmd=memberApp&state='+this.id,--%>
                  <%--    type:'POST',--%>
                  <%--    //data:{name:$("input#name").val(),hobby:$("input#hobby").val()},--%>
                  <%--    data:$("form#memberFrm").serialize(),--%>
                  <%--    dataType:'json',//json,xml,html,script--%>
                  <%--    success:function(value){--%>
                  <%--        $("table#table").show(1000).fadeOut(1000).fadeIn(1000);--%>
                  <%--        $("tr#theadRow *").remove();--%>
                  <%--        $("tbody#tbody *").remove();--%>
                  <%--        //head--%>
                  <%--        $(Object.keys(value[0])).each(function(index,item){--%>
                  <%--            //console.log(item);--%>
                  <%--            $("tr#theadRow").append("<td>"+item+"</td>");--%>
                  <%--        });--%>
                  <%--        //body--%>
                  <%--        $(value).each(function(index,dom){--%>
                  <%--            $("tbody#tbody").append("<tr>");--%>
                  <%--            $(Object.values(dom)).each(function(index,item){--%>
                  <%--                //console.log(item);--%>
                  <%--                $("tbody#tbody").append("<td>"+item+"</td>");--%>
                  <%--            });--%>
                  <%--        });--%>

                  <%--    },--%>
                  <%--    error:function(){--%>
                  <%--        alert('error');--%>
                  <%--    }--%>
                  <%--});--%>
              });
          });
      </script>
</head>
<body>
<form action="" method="post" id="memberForm">
      <input type="number" name="no" id="no">
      <input type="text" name="name" id="name">
      <input type="text" name="hobby" id="hobby">
      <input type="button" id="add" value="Add">
      <input type="button" id="mod" value="Mod">
      <input type="button" id="del" value="Del">
      <dt id="show"></dt>
</form>
<div id="list">List</div>
</body>
</html>
