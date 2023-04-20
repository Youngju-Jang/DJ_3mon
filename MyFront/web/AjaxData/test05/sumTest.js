function sum(){
	var xhr=new XMLHttpRequest();
	var param1="a=" + document.getElementById("bottom").value;
	var param2="b=" + document.getElementById("height").value;
	var url="http://localhost:8080/AjaxData/test05/sumTest.jsp?" + param1 + "&" + param2;
	
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			document.getElementById("sumResult").innerHTML=xhr.responseText;
		}
	}
	xhr.open("GET", url, true);
	xhr.send(null);
}