<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <title>Title</title>
      <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
      <script>
          $(function () {
              $("input").click(function () {
                  // $(this).val('clicked');
                  // switch($(this).attr("id")){
                  //   case "c1" :
                  //     this.value = this.id;
                  //     break;
                  //   case "c2":
                  //     this.value = "test";
                  //     break;
                  //   default:
                  //     break;
                  // };
                  // alert(this.id);
              })
              // $("input#c2").click(function(){
              //     alert("c2");
              // })
              // $("input[value='Click3']").click(function(){
              //     alert('c3');
              // })
              function ajaxProcess(type, url, dataType, id){
                  $.ajax({
                      type,
                      url,
                      dataType,
                      error: function(){
                          alert('ajax error');
                      },
                      success: function(data){
                          console.dir(this);
                          $("div#"+id).html(data).css("color", id=='c1'?'blue':'red');
                      }
                  })
              }

              $("input").click(function(){
                  if(this.id=='c1'){
                      ajaxProcess('GET', '../ajaxData/ajaxResult1.jsp','text', this.id);
                  }
                  if(this.id=='c2'){
                      ajaxProcess('GET', '../ajaxData/ajaxResult2.jsp','text', this.id);
                  }
              })
          });
      </script>
</head>
<body>
<input type="button" value="Click1" id="c1">
<input type="button" value="Click2" id="c2">
<input type="button" value="Click3" id="c3">
<input type="button" value="Click4" id="c4">
<div id="c1"></div>
<div id="c2"></div>
<div id="c3"></div>
<div id="c4"></div>
</body>
</html>
