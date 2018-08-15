<%@page import="kr.or.connect.mvcexam.dto.gang"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
<%
Map map = (Map)session.getAttribute("map");
Set<String> keyset = map.keySet();
for(String str : keyset){
	%>
	<a class="item gang2"><%=str %></a>
	<%
}


%>
</body>
<script>
$('.gang2').click(function(){
	var str = $(this)[0].innerHTML;
	var xhr = new XMLHttpRequest();
	xhr.onload=function(){
		if(xhr.readyState === xhr.DONE){
			if(xhr.status===200 || xhr.status ===201){
				$('#test2').html(xhr.responseText);
			}else{
				alert("실패?");
			}
		}
	}
	xhr.open("POST", "remove");
	xhr.setRequestHeader("Content-Type", "application/json; charSet=UTF-8");
	xhr.send(str);
})

</script>
</html>
