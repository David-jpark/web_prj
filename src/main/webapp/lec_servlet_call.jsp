<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--<a href = "http://localhost:8081/Board_servlet_url">Servlet GET 호출</a>-->
<a href = "/Board_servlet_url">Servlet GET 호출</a><br><br>

<form method = "GET" action = "/Board_servlet_url">
	<input type = "submit" value="Servlet GET 호출">
</form> 
<br>
<form method = "POST" action = "/Board_servlet_url">
	<input name = "userid" type = "text" placeholder = "아이디 입력"><br>
	<input name = "userpw" type = "password" placeholder = "비밀번호 입력"><br>
	<input name = "gender" type = "radio" value = "male"> 남자 
	<input name = "gender" type = "radio" value = "female"> 여자 <br>
	<input name = "habit" type = "checkbox" value = "mount">등산
	<input name = "habit" type = "checkbox" value = "fish">낚시
	<input name = "habit" type = "checkbox" value = "music">음악
	<input name = "habit" type = "checkbox" value = "art">미술 <br>
	
	<select name = "subject">
		<option value = "kor">국어</option>
		<option value = "eng">영어</option>
		<option value = "math">수학</option>
	</select> <br>
	
	<input type = "file" name = "userfile"><br>
	
	<input type = "hidden" name = "ssn" value = "12345"><br>
	
	<textarea name = "contents" rows=10 cols=50>
	</textarea><br>
	
	<br><br><input type = "submit" value="Servlet POST 호출">
</form>







</body>
</html>