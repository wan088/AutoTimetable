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
		<a class="item"><%=gang.getName() %>-<%=gang.getNumber().substring(0,7) %></a>
		<%
	}

%>
</body>
</html>