<%@page import="kr.or.connect.mvcexam.dto.gang"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
</head>
<body>
<% List<gang> list=(List)request.getAttribute("timeTable"); 
for(gang gang : list){
	String str =gang.getTimes();
	
}
%>

</body>
</html>