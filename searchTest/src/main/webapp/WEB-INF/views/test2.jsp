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
</html>
