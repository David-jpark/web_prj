<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!--  JS 테스트  -->
	<script src="js/my.js"></script>

	<script>
	 //public int myprint(int a, int b){ syso.print...}
	 function myprint(a, b){
		 alert(a+b);
		 console.log(a+b);
	 }
	</script>
	
		<!--  CSS 테스트 -->
		<link href="css/my.css" rel="stylesheet" />
		<style>
	  p {
	    color: red;
	    font-weight:bold;
	  }
	  </style>
	  
	  
	  <!--  JQuery 테스트 
	  id ="abc" $("#abc")
	  class="abc" $(".abc")
	  -->
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script> 
	
	<script>
		$(function() {
			//$("p").test("여기의 text로 변경");
			$("#PTAG_ID").text("여기의 text로 변경 #PTAG_ID");
			
			//$(".PTAG_CLASS").test("여기의 text로 변경 .PTAG_CLASS");
			$("#PTAG_ID_11").text("여기의 text로 변경 #PTAG_ID_11");
			$("#PTAG_ID_22").text("여기의 text로 변경 #PTAG_ID_22");
			
			// uname에 값 넣기 value= "hong"
			//$("#uname").val("hong"); // id로 접근 
			//$(".unmae").val("hong"); // class로 접근
			//$("input[name='uname']").val("hong"); // name으로 접근
			//var msg = $("#seq").val(); // seq값 가져오기
			//alert(msg);
			
			// <form> 제어하기
			$("#regbtn").click( function() {
				if ($("#uname").val() == "") {
					alert("아이디 입력하세요");
					$("#uname").focus();
					return false;
				}else if ($("#passwd").val() == ""){
					alert("비번 입력하세요");
					$("#passwd").focus();
					return false;
				}
				
				$("#loginForm").attr("method","post")
				$("#loginForm").attr("action","<%=request.getContextPath()%>/BoardServlet")
				$("#loginForm").submit();
				return true;
			});
			
			
		});
	</script>
	

</head>

<body>

		<!-- Java -> document.getElementByName("loginForm") -->
	<form name="loginForm" id="loginForm"> method action <br>
		hidden: <input type="hidden" name="seq" id="seq" class = "seq" value="12345"><br>
		uname: <input type="text" name="uname" id="uname" class="uname"><br>
		passwd: <input type="password" name="passwd" id="passwd" class="passwd"><br>
		<input type="button" name="regbtn" id="regbtn" class="regbtn" value="가입">
	</form>
	
	<p id="PTAG_ID">Not loaded yet.</p><br><br> <!--  ID값은 고유해야한다. -->
	<p id="PTAG_ID_11" class="PTAG_CLASS">aaaaa</p>	<!--  class값은 일괄 적용/고유하지 않아도 된다. -->
	<p id="PTAG_ID_22" class="PTAG_CLASS">bbbbb</p>
	
	
	
	<!-- Java 호출
	Java import webapp.js. 
	lec_script ls = new lec_script();
	ls.myprint(5,3);
	-->
	
	<!--  JavaScript 호출 
	<script src="js/scripts.js"></script>
	-->
	<a href="#" onClick = "myprint(5,3)">내부 js 클릭</a><br>
	<div onClick = "myprint(5,3)"> 내부js div 클릭</div>
	<a href="#" onClick = "myjsprint()">외부 my.js 클릭</a><br>
	
	
	
	
	
	
	
	<!-- 
	jQuery는 HTML의 클라이언트 사이드 조작을 단순화 하도록 
	설계된 크로스 플랫폼의 자바스크립트 라이브러리다. 
	
	- <form> 요소값(elements) 제어
	- 조건문(if)
	- 반복문(for , foreach)
	- 전송 (Ajax)
	-->
	
	
	
</body>
</html>