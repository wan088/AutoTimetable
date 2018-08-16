<%@page import="kr.or.connect.mvcexam.controller.PlusController.gang2"%>
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
<%
String[] colors = {
		"antiquewhite",
		"#dcf2e9",
		"lightblue",
		"#f2e8e8",
		"#fff8cc",
		"#eff9cc",
		"lightblue",
		"#ffe9e9",
		"lightsalmon",
		"lightyellow"
		
};

List<List> answer=(List)request.getAttribute("timeTable"); 
int colorIdx=0;
for(List<gang2> list: answer){
	//여기부터 하나의 강의 많아야 2개
	for(gang2 gang2: list){
		%><div style="position: absolute;
    width: 150px;
    background-color: <%=colors[colorIdx] %>;
    left: <%=gang2.getYoil()*150+115%>px;
    top: <%=gang2.getStart()*23+26%>px;
    height: <%=gang2.getLen()*23%>px;
    font-size : 14px;
    text-align : center;
    "><%=gang2.getName() %><br><%=gang2.getNumber() %></div><%
	}
	colorIdx++;
}

%>

</body>
</html>