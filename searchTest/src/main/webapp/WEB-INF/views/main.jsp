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
          <div style="text-align:center; width:100%"><i class="chevron down icon orange big" style=""></i></div>
          <div id="test2" style="height:434px; overflow:scroll;">
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
          <div class="ui left floated compact segment" style="width:95%; margin-left:2.5%; text-align:center;margin-bottom: 2px;
    background-color: lightcyan;">
			 <span style="margin-left:12px"> 
			  월
			  <div class="ui fitted checkbox">
			    <input  id="mon" type="checkbox" checked="checked">
			    <label></label>
			  </div>
			 </span>
			 
			 <span style="margin-left:12px"> 
			  화
			  <div class="ui fitted checkbox">
			    <input id="tus" type="checkbox" checked="checked">
			    <label></label>
			  </div>
			 </span>
			 
			 <span style="margin-left:12px"> 
			  수
			  <div class="ui fitted checkbox">
			    <input id="wed" type="checkbox" checked="checked">
			    <label></label>
			  </div>
			 </span>
			 
			 <span style="margin-left:12px">
			  목
			  <div class="ui fitted checkbox">
			    <input id="tur" type="checkbox" checked="checked">
			    <label></label>
			  </div>
			 </span>
			 
			 <span style="margin-left:12px">
			  금
			  <div class="ui fitted checkbox">
			    <input id="fri" type="checkbox" checked="checked">
			    <label></label>
			  </div>
			 </span>
			  
			</div>
          <button id="doAuto" class="orange ui button" style="width: 95%;margin-left: 2.5%;height: 50px;font-size: 20px;">
          시간표 자동생성</button>
        </div>
       <div class="pusher">
          <div class="ui basic segment">
            <div class="ui basic segment">
            <h3 class="ui header"></h3>
            <table class="ui celled table" style="text-align: center; width: auto	;">
              <thead>
                <tr>
                <th style="width: 100px;"></th>
                <th style="width: 150px;">월</th>
                <th style="width: 150px;">화</th>
                <th style="width: 150px;">수</th>
                <th style="width: 150px;">목</th>
                <th style="width: 150px;">금</th>
                
              </tr></thead>
              <tbody>
                <tr>
                  <td style="padding:0px;">09:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  
                </tr>
                <tr>
                  <td style="padding:0px;">10:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">11:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">12:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">13:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">14:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">15:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">16:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">17:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">18:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">19:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">20:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">21:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">22:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td style="padding:0px;">23:00~</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
                <tr>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
              </tbody>
              <tfoot>
                <tr><th colspan="6">
                  <div id="tableNum" class="ui right floated pagination menu">  
                    <a class="icon item">
                      <i id="leftMoc" class="left chevron icon"></i>
                    </a>
                    <a class="item gangNum">1</a>
                    <a class="item gangNum">2</a>
                    <a class="item gangNum">3</a>
                    <a class="item gangNum">4</a>
                    <a class="item gangNum">5</a>
                    <a class="icon item">
                      <i id="rightMoc" class="right chevron icon"></i>
                    </a>
                  </div>
                </th>
              </tr></tfoot>
            </table>
          </div>
        	
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
    	$('.gang2').click(function(){
    		var str = $(this)[0].innerHTML;
    		var xhr = new XMLHttpRequest();
    		xhr.onload=function(){
    			if(xhr.readyState === xhr.DONE){
    				if(xhr.status===200 || xhr.status ===201){
    					$('#test2').html(xhr.responseText);
    				}else{
    					alert("실패");
    				}
    			}
    		}
    		xhr.open("POST", "remove");
    		xhr.setRequestHeader("Content-Type", "application/json; charSet=UTF-8");
    		xhr.send(str);
    	})
    	$('#doAuto').click(function(){
    		var xhr = new XMLHttpRequest();
    		xhr.onload=function(){
    			if(xhr.readyState === xhr.DONE){
    				if(xhr.status===200 || xhr.status ===201){
    					$('.header').html(xhr.responseText);
    					$('#tableNum').html()
    				}else{
    					alert("조건에 맞는 시간표가 존재하지 않습니다");
    				}
    			}
    		}
  			var condi=0;
  			if($('#mon')[0].checked){
    			condi+=10000;
    		}
  			if($('#tus')[0].checked){
    			condi+=1000;
    		}
  			if($('#wed')[0].checked){
    			condi+=100;
    		}
  			if($('#tur')[0].checked){
    			condi+=10;
    		}
  			if($('#fri')[0].checked){
    			condi+=1;
    		}
    		xhr.open("GET", "make?condi="+condi);
    		xhr.send();
    	})
    	$(".gangNum").click(function(){
    		var xhr = new XMLHttpRequest();
    		xhr.onload=function(){
    			if(xhr.readyState === xhr.DONE){
    				if(xhr.status===200 || xhr.status ===201){
    					$('.header').html(xhr.responseText);
    				}else{
    					alert("더이상 시간표가 존재하지 않습니다");
    				}
    			}
    		}
    		var param=$(this)[0].innerHTML-1;
    		var condi=0;
  			if($('#mon')[0].checked){
    			condi+=10000;
    		}
  			if($('#tus')[0].checked){
    			condi+=1000;
    		}
  			if($('#wed')[0].checked){
    			condi+=100;
    		}
  			if($('#tur')[0].checked){
    			condi+=10;
    		}
  			if($('#fri')[0].checked){
    			condi+=1;
    		}
    		xhr.open("GET", "make?table="+param+"&condi="+condi);
    		xhr.send();
    	})

      </script>
 
</html>