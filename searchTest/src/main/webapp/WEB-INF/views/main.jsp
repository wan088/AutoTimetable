<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/semantic/semantic.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    <script src="resources/semantic/semantic.js"></script>
    <title>동국 AutoTimetable</title>
    <style>
 
    </style>
</head>
 
<body>
    <div class="ui bottom attached segment pushable" style="margin-bottom:0px;">
        <div class="ui wide visible inverted left vertical sidebar menu">   
          <a class="item">
            <div class="ui icon input">
                <input type="text" placeholder="강의명으로 검색" name="searchClass" id="searchClass" onclick="return do();">
                <i id="letsSerach" class="search icon"></i>  
            </div>
          </a>    	
          <div id="test" style="height:200px; overflow:scroll;"></div>
          <div class="ui divider"></div>
          <div id="test2" style="height:500px; overflow:scroll;">
          <%
			Map map = (Map)session.getAttribute("map");
			if(map!=null){
          	Set<String> keyset = map.keySet();
			for(String str : keyset){
			%>
		<a class="item gang2"><%=str %></a>
			<%
			}
			}%>
          </div>      
        </div>
        <div class="pusher">
          <div class="ui basic segment">
            <h3 class="ui header">Application Conten</h3>
            <p></p>
            <p></p>
            <p></p>
            <p></p>
          </div>
        </div>
      </div>
</body>
      <script>

    	$('#searchClass').keypress(function(event){
    	     if ( event.which == 13 ) {
    	    	  	    	//$("#searchClass") 
    	    	  var str = $("#searchClass").serialize();
    	         $.ajax({
      	           type:"POST",
      	           url:"search",
      	           contentType: "application/x-www-form-urlencoded; charset=utf-8",
      	           data: str,
      	           datatype:"json",
      	           success: function(data) {
      	             $("#test").html(data);		
      	           },
      	           error: function(e) {
      	             alert("검색어를 입력해주세요");
      	           }
      	         }); 
    	     }
    	});

      </script>
 
</html>