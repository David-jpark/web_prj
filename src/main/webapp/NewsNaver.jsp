<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.kosta.sample.craw.NewsVO" %>
<%@ page import ="java.util.ArrayList"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>

<script type="text/javascript">
$(function(){
	$("#newsbtn").click(function(){
	if($("#mybtn").css("display") == "none"){
		$("#mybtn").show();
	} else{
		$("#mybtn").hide();
		}
	});
	
});


</script>
<input type = "button" id="newsbtn" value="리스트보기">

<script>
$("#newsbtn").click(function(){
	$.ajax({
		method : "GET" ,
		url : "<%=request.getContextPath()%>/CrawNaverServlet" ,
		//data:
		//contentType:
		dataType: "json", 
		success : function(myStr){ // 객체로 내보냄
			console.log("성공"+myStr);
			var htmlStr = "<table border=1 width=50%><tr><th>제목</th><th>언론사</th></tr>";
			$.map(myStr, function( MYval, MYidx ) { //function( val, 변수)
				htmlStr +="<tr><td>"+ MYval["title"] +"</td><td>"+ MYval["ref"] +"</td></tr>" 
				console.log(MYval["title"] +","+ MYval["ref"]+ ","+ MYidx);
			});
			htmlStr +="</table>";
			$("#newsTable").html(htmlStr);
		},
		error : function(myStr){ 
			console.log("에러"); 
			}
	});
	
});

</script>
<div id ="newsTable"></div>

</body>
</html>