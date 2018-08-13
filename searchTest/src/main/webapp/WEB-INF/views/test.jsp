<%@page import="java.util.List"%>
<%@page import="kr.or.connect.mvcexam.dto.gang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
<%
List<gang> list =(List)request.getAttribute("list");
	for(gang gang:list){
		%>
		<a class="item gang1"><%=gang.getName() %></a>
		<%
	}
%>
</body>
<script>
$('.gang1').click(function(){
	str = $(this)[0].innerHTML;
	var data = {
		name: 'gangName',
		value: str,
	};
	var xhr = new XMLHttpRequest();
	xhr.onload = function(){
		if(xhr.readyState === xhr.DONE){
			if(xhr.status === 200 || xhr.status === 201){
				$('#test2').html(xhr.responseText);
			}else{
				alert("에러임");
			}
		}
	}
	xhr.open("POST", "register");
	xhr.setRequestHeader("Content-Type","application/json; charset=UTF-8");
	xhr.send(/* JSON.stringify(data) */str);
});
</script>
</html>