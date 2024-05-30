<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  ##################### 서버로 부터의 응답 String #######################  -->
<h2>초간단 AJAX <font color=red>(F12필수)</font></h2>
<form id="Str_Str_Form" >
<input id ="searchGubun" type = hidden name ="searchGubun" value="">
<input id ="searchStr" type="text" name="searchStr">
<input type="button" id="AjaxBtn" value="초간단AJAX전송">
</form>
<hr>
<div id="resultDIV"></div>
<!--  ##################### 서버로 부터의 응답 String #######################  -->
<h2>서버로 부터의 응답 String <font color=red>(F12필수)</font></h2>
<form id="Str_Str_Form1" action="/RestServlet" method="get">
<select name="searchGubun">
	<option value="title">제목</option>
	<option value="contents">내용</option>
	<option value="regid">글쓴이</option>
</select>
<input type="text" name="searchStr">
<input type="button" id="1__Str_Str_Btn" value="1.Str-Str">
</form>
<hr>

<form id="JsonStr_Str_Form" action="/RestServlet" method="get">
<select name="searchGubun">
	<option value="title">제목</option>
	<option value="contents">내용</option>
	<option value="regid">글쓴이</option>
</select>
<input type="text" name="searchStr">
<input type="button" id="2__JsonStr_Str_Btn"  value="2.JsonStr-Str">
</form>
<hr>

<form id="Json_Str_Form" action="/RestServlet" method="get">
<select name="searchGubun">
	<option value="title">제목</option>
	<option value="contents">내용</option>
	<option value="regid">글쓴이</option>
</select>
<input type="text" name="searchStr">
<input type="button" id="3__Json_Str_Btn"  value="3.Json-Str">
</form>
<hr><br><br><br>


<!--  ##################### 서버로 부터의 응답 JSON #######################  -->
<h2>서버로 부터의 응답 JSON <font color=red>(F12필수)</font></h2>
<form id="Str_Json_Form">
<select name="searchGubun">
	<option value="title">제목</option>
	<option value="contents">내용</option>
	<option value="regid">글쓴이</option>
</select>
<input type="text" name="searchStr">
<input type="button" id="4__Str_Json_Btn"  value="1.Str-JSON">
</form>
<hr>

<form id="JsonStr_Json_Form" action="/RestServlet" method="get">
<select name="searchGubun">
	<option value="title">제목</option>
	<option value="contents">내용</option>
	<option value="regid">글쓴이</option>
</select>
<input type="text" name="searchStr">
<input type="button" id="5__JsonStr_Json_Btn"  value="2.JsonStr-JSON">
</form>
<hr>

<form id="Json_Json_Form" action="/RestServlet" method="get">
<select name="searchGubun">
	<option value="title">제목</option>
	<option value="contents">내용</option>
	<option value="regid">글쓴이</option>
</select>
<input type="text" name="searchStr">
<input type="button" id="6__Json_Json_Btn"   value="3.Json-JSON">
</form>
<hr>


<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
	//$(function() {    });
	
	
	$("#AjaxBtn").click(  function(){
		//alert("초간단AJAX");
		var sg = $("#searchGubun").val();
		var ss = $("#searchStr").val();
		$.ajax({
			method : "GET",
			url : "<%=request.getContextPath()%>/RestServlet?pagecode=R001",
			data : "searchGubun="+sg+"&searchStr="+ss,
			error : function(myval){ console.log("에러"+myval); },
			success : function(myval){ 
								console.log("성공"+myval);
								$("#resultDIV").html("<b>"+myval+"</b>")
			}
			
		});
	});
	
	//searchGubun=contents&searchStr=%E3%84%B4%E3%84%B4 -> 한글을 인코딩해서 주소값보임
	//searchGubun=contents&searchStr=111111
	
	//글자를 글자로
	$("#1__Str_Str_Btn").click(  function(){
		//alert("1");
		var sendFormData = $("#Str_Str_Form1").serialize();
		console.log(sendFormData);
		$.ajax({
			method : "GET",
			url : "<%=request.getContextPath()%>/RestServlet?pagecode=R001",
			data : sendFormData ,
			error : function(myval){ console.log("에러"+myval); },
			success : function(myval){
				//JSON모양의 글자가 들어옴
				console.log("성공:"+myval);
				
				//obj = JSON.parse(str); 
				//JSON모양의 글자를 객체 JSON으로 변환
				var myval_obj = JSON.parse(myval); //객체를 받아와서 표현
				console.log("변환성공:"+myval_obj);
				console.log("변환성공:"+myval_obj[0]["regid"]);
				
				//https://api.jquery.com/jQuery.map/
				//[{"seq":0,"title":"aaa","regid":"kim"},{"seq":0,"title":"bbb","regid":"lee"}]
				var htmlStr = "<table border=1 width=50%><tr><th>제목</th><th>글쓴이</th></tr>";
				// 테이블 만들기
				$.map(myval_obj, function( MYval, MYidx ) { //function( val, 변수)
					htmlStr +="<tr><td>"+ MYval["title"] +"</td><td>"+ MYval["regid"] +"</td></tr>" 
					console.log(MYval["title"] +","+ MYval["regid"]+ ","+ MYidx);
				});
				htmlStr +="</table>";
				$("#resultDIV").empty();
				$("#resultDIV").html("1. <b>"+htmlStr+"</b>") 
			}
			
		});
	});
	
	//JSON글자를 글자로
	$("#2__JsonStr_Str_Btn").click(  function(){
		//alert("2");
		var objData = {"name":"kim","pw":"123"};
		console.log(objData);
		
		var strData = JSON.stringify(objData);
		console.log(strData);
		
		$.ajax({
			method : "POST",
			url : "<%=request.getContextPath()%>/RestServlet?pagecode=R002",
			data : "MY_JSONKEY=" + JSON.stringify(objData) , //*핵심
			error : function(myval){ console.log("에러"+myval); },
			success : function(myval){console.log("성공:"+myval);}
		});
	});
	
	//JSON을 글자로
	$("#3__Json_Str_Btn").click(  function(){
		//alert("3");
		var objData = {"title":"asssd","regid":"hong"};
		
		$.ajax({
			method : "POST",
			url : "<%=request.getContextPath()%>/RestServlet?pagecode=R003",
			contentType : "application/json; charset=UTF-8", //*핵심
			data : JSON.stringify(objData) ,
			error : function(myval){ console.log("에러"+myval); },
			success : function(myval){console.log("성공:"+myval);}
		});
	});
	
	//글자를 json으로
	$("#4__Str_Json_Btn").click(  function(){
		//alert("4");
		var sendFormData = $("#Str_Json_Form").serialize();
		
		$.ajax({
			method : "POST",
			url : "<%=request.getContextPath()%>/RestServlet?pagecode=R004",
			data : sendFormData ,
			dataType : "json",	// 생략가능
			error : function(myval){ console.log("에러"+myval); },
			success : function(myval){
							console.log("성공:"+myval);
							console.log(myval['status']+ "," + myval['message']);
							
				}
		});
	});
	
	$("#5__JsonStr_Json_Btn").click(  function(){
		//alert("5");
		var objData = {"name":"kim","pw":"123"};
		console.log(objData);
		var strData = JSON.stringify(objData);
		console.log(strData);
		
		$.ajax({
			method : "POST",
			url : "<%=request.getContextPath()%>/RestServlet?pagecode=R005",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8", // defalt
			data : "MY_JSONKEY=" + JSON.stringify(objData) ,
			dataType : "json",
			error : function(myval){ console.log("에러"+myval); },
			success : function(myval){
				console.log("성공:"+myval);
				console.log(myval['status']+ "," + myval['message']);
				
				}
		});
	});
	$("#6__Json_Json_Btn").click(  function(){
		//alert("6");
		var objData = {"title":"asssd","regid":"hong"};
		
		$.ajax({
			method : "POST",
			url : "<%=request.getContextPath()%>/RestServlet?pagecode=R006",
			contentType : "application/json; charset=UTF-8",
			data : JSON.stringify(objData) ,
			dataType : "json",
			error : function(myval){ console.log("에러"+myval); },
			success : function(myval){
				console.log("성공:"+myval);
				console.log(myval['status']+ "," + myval['message']);
				
				}
		});
	});
	
</script>

</body>
</html>