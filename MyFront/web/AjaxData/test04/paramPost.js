function startMethod(){
	var xhr=new XMLHttpRequest();
	var url="http://localhost:8080/AjaxData/test04/result.jsp";
	
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById('display').innerHTML=xhr.responseText;
		}
	}
	xhr.open("POST",url, true);  // 서버에 POST방식으로 요청
	xhr.setRequestHeader("Content-Type",
                          "application/x-www-form-urlencoded;charset=UTF-8");
	//Content-Type:데이터가 어떤 종류인지 알려줌
	//key=value로 Map형태로 표현(ex. name=kim&age=20&phone=010-111-1111)
	// application/x-www-form-urlencoded;charset=UTF-8 ==> key/value형태 
	xhr.send(getParameterValues());              // 요청자료 전송  
}
function getParameterValues(){
	var name=encodeURI(document.getElementById("name").value);
	var age=encodeURI(document.getElementById("age").value);
	var phone=encodeURI(document.getElementById("phone").value);
	
	return "name="+name+"&age="+age+"&phone="+phone; // name=kim&age=20&phone=111-1111
}