<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--태그 라이브러리 지시어 -->
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
	<%@ page import = "com.kosta.sample.board.BoardVO"%>
  	<%@ page import = "java.util.ArrayList" %>
  	<!--<%@ page import = "java.util.HashMap" %> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script> 
<% 
//ArrayList<BoardVO> vo = (ArrayList<BoardVO>)request.getAttribute(BoardVO);

//for(BoardVO vo : list)
	//vo.getName(); 
	//JSP를 쓰지 않는 기업일 경우 EL표현식으로 바꿀 필요가 있다
	// for문은 <c:foreach> 같은 EL표현식으로 표현할 수 있다.
	
%>

	<script>
		$(function() {
			
		});
	</script>
</head>
<body>
<%
//Servlet 코드
//BoardVO bvo = new BoardVO();
//bvo.setRegid("kim");
//bvo.setTitle("제목");
//request.setAttribute("KEY_BOARDVO", bvo);
// 아래있는 문법을 사용하려면 import를 해야한다.
//BoardVO bvo = (BoardVO)request.getAttribute("KEY_BOARDVO");
//out.println(bvo.getRegid() + "," + bvo.getTitle());
%>

<!--
{ requestScope.KEY_BOARDVO.regid } 
-->

<%
//ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("KEY_LISTVO");
//for(BoardVO bvo : list){
//	out.println(bvo.getTitle()+ "," + bvo.getRegid() + "<br>");
//}

%>
<!-- 
${requestScope.KEY_LISTVO[0]["regid"]}, ${requestScope.KEY_LISTVO[0]["title"]}<br>
${requestScope.KEY_LISTVO[1]["regid"]}, ${requestScope.KEY_LISTVO[1]["title"]}<br>
 -->
<%
//HashMap<String, BoardVO> map = (HashMap<String, BoardVO>)request.getAttribute("KEY_MAPVO");
//BoardVO vo = map.get("map_key");
//out.println(map.get("map_key").getRegid() + "," + map.get("map_key").getTitle() );
//for(BoardVO bvo : map.values()){
//	out.print(bvo.getTitle()+ "," + bvo.getRegid() + "<br>");
//}
%> 
 <!-- requestScope는 기본값이라 안붙혀도 된다.
 ${requestScope.KEY_MAPVO.map_key.regid}, ${KEY_MAPVO.map_key.title}
 -->
<%
//String id = (String)session.getAttribute("SESS_ID");
//String grade = (String)session.getAttribute("SESS_GRADE");
//out.println(id + "," + grade + "<br>");
%> 
<!-- JSP내장 객체 SCOPE : page > request > session > application 
	 EL내장 객체 SCOPE : pageScope > requestScope > sessionScope > applicationScope
-->

<!-- ${sessionScope.SESS_ID} -->

<!-- 
//서블릿 코드
Cookie ck = new Cookie("MY_COOKIE_UID", "lee"); // Servlet cookie
		ck.setMaxAge(100);
		response.addCookie(ck);
 -->
<% // 요청으로부터 모든 쿠키를 가져옵니다. 
Cookie[] cookies = request.getCookies(); 
String myCookieValue = null; 

if (cookies != null) { 
	for (Cookie cookie : cookies) { 
		out.println(cookie.getName() + "," + cookie.getValue() + "<br>");
			break; 
		} 
	} 

// 가져온 쿠키 값을 출력하거나 사용할 수 있습니다. 
//if (myCookieValue != null) { 
//	out.println("MY_COOKIE_UID value: " + myCookieValue); 
//	} else { out.println("MY_COOKIE_UID not found."); }
%>

${cookie.MY_COOKIE_UID.name}, ${cookie.MY_COOKIE_UID.value} 

<!--  JSTL : if, forEach -->
<%
String cval =  "lee";
int num = 10;
if(cval.equals("lee") && num == 10){
	out.println("ok");
} else {
	out.println("fail");
}
%>
<br>
<c:if test ="${cookie.MY_COOKIE_UID.value eq 'lee'}">
	ok lee

</c:if>
<br>

<c:set value="hong" var="userid"/>
<c:choose>
       <c:when test="${userid == 'hong'}">
            유저 : 홍
       </c:when>
       <c:when test="${userid == 'admin'}">
           어드민
       </c:when>
       <c:otherwise>
           손님
       </c:otherwise>
   </c:choose>
<br>

<!-- for(int i=1; i<=10; i+2) -->
<br>
forEach 반복문
<c:forEach var="myval" begin="1" end="10" step ="2" >
출력 : ${myval}
<br>
</c:forEach>

<br>
BoardVO의 List에서 forEach
<c:forEach items ="${KEY_BOARDVO}" var="bvo" >
  ${bvo.regid}, ${bvo.title} <br>
</c:forEach>

<br>
값이 있을경우 표시
<c:if test="${not empty KEY_BOARDVO}">
<c:forEach items ="${KEY_LISTVO}" var="bvo" varStatus="mysts">
  ${bvo.regid}, ${bvo.title} ${mysts.index} ${mysts.count}<br>
</c:forEach>
</c:if>
<br>
값이 없을경우 표시
<c:if test = "${empty KEY_BOARDVO}">
	데이터가 없습니다. <br>
</c:if>
<br>
<c:forTokens items="123-456-789" delims="-"   var="tel">
       ${tel}  <br>
</c:forTokens>

<c:set var ="mynum" value="12345789"/>
<fmt:formatNumber value="${mynum}" /> <br>
<fmt:formatNumber value="${mynum}" type="currency"/><br>
천단위 콤마<fmt:formatNumber value="${mynum}" type="currency" currencySymbol="\\"/><br>


contextPath ${pageContext.request.contextPath}
</body>
</html>