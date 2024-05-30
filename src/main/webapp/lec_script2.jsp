<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
var arr = [{"empno":"7733","ename":"smith"},
			{"empno":"7799","ename":"king"}];
for(var i =0; i<arr.length; i++){
	console.log(arr[i]["empno"]);
}

var arr2 = [["7733","smith"],["7799","king"]];
for(var i =0; i<arr2.length; i++){
	console.log(arr2[i][0]);
}
//forEach문 (대문자 주의)
var arr3 = [["7733","smith"],["7799","king"]];
arr3.forEach(function(val,idx) {;
console.log(idx + "," + val[1]);

});

</script>

<script>
// script안이면 어디든 넣어도 상관없다.

// 호출하기
	function myprint(prm){
		console.log("myprint() 호출." + prm);
	}

	function myprint2(prm){
		alert("myprint2() 호출." + prm);
	}
</script>

<script src="https://code.jquery.com/jquery-3.7.1.js"></script> 
	
	<script>
		//each 반복문 (function 순서 주의)
		$(function() {
			myprint("홍길동");
			
			var arr4 = [["7733","smith"],["7799","king"]];
			$.each(arr4, function(idx, val){
				console.log(idx + "," + val[1]);
				
			});
			
			//map 반복문
			var arr5 = [{"empno":"7733","ename":"smith"},
				{"empno":"7799","ename":"king"}];
			$.map(arr5, function(val, idx){
				console.log(idx+ "," + val["ename"]);
				
			});
			//바디에서는 어디에 두건 상관없지만 헤더는 구별한다.
			$("#myBtn").click(  function(){
				myprint2("JQuary홍길동");
			});
			
			$("#myDiv").click(  function(){
				myprint2("JQuaryDivClick");
			});
			
			
		});
	</script>
	
</head>
<body>
스크립트 반복문 연습<br>

<a href="#" onClick="myprint2('홍길동');"> 스크립트 호출 </a>
<table border=1 width=200><tr><td style="cursor:pointer" onClick="myprint2('홍길동');">스크립트 호출</td></tr></table>
<input type="button" id="myBtn" value="버튼 클릭">
<div style="cursor:pointer" id="myDiv">divClick</div>

</body>
</html>