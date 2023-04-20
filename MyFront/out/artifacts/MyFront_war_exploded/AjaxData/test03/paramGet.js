function startMethod(){
	var xhr=new XMLHttpRequest();
	var url="http://localhost:8080/AjaxData/test03/result.jsp?"+getParameterValues();
	
	xhr.onreadystatechange=function(){
			if(xhr.readyState==4 && xhr.status==200){
				document.getElementById('display').innerHTML=xhr.responseText;
		}
	}
	xhr.open("GET",url, true);  // 서버에 GET방식으로 요청
	xhr.send(null);             // 요청자료 전송  
}
function getParameterValues(){
	var name=encodeURI(document.getElementById("name").value);
	var age=encodeURI(document.getElementById("age").value);
	var phone=encodeURI(document.getElementById("phone").value);
	
	return "name="+name+"&age="+age+"&phone="+phone; // name=kim&age=20&phone=111-1111
}