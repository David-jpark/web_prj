<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"
%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kosta.sample.board.BoardVO" %>
<%@ page import="com.kosta.sample.board.ReplyVO" %>



<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.7.1.js"></script>
        <script>
        // form 제어하기
        $(function() {
		        $("#uptButton").click( function() {
		        	alert("수정");
					$("#boardForm").attr("method","post")
					$("#boardForm").attr("action","<%=request.getContextPath()%>/BoardServlet?pagecode=B003")
					$("#boardForm").submit();
					return true;	
		        	});
		        $("#delButton").click( function() {
		        	alert("삭제");
					$("#boardForm").attr("method","post")
					$("#boardForm").attr("action","<%=request.getContextPath()%>/BoardServlet?pagecode=B004")
					$("#boardForm").submit();
					return true;
					});
		        $("#listButton").click( function() {
					location.href = "<%=request.getContextPath()%>/BoardServlet?pagecode=B001";
					});
    			});
        </script>
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="index.jsp">Start Bootstrap</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                <div class="input-group">
                    <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                </div>
            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Settings</a></li>
                        <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading">Core</div>
                            <a class="nav-link" href="index.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>
                            <div class="sb-sidenav-menu-heading">Interface</div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                Layouts
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="layout-static.html">Static Navigation</a>
                                    <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                                <div class="sb-nav-link-icon"><i class="fas fa-book-open"></i></div>
                                Pages
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                                        Authentication
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    
 <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
     <nav class="sb-sidenav-menu-nested nav">

     	  	
<!-- ---------------  로그인/로그아웃 처리 ------------------------- -->
<%
String userid = (String)session.getAttribute("KEY_SESS_USERID");
String uname  = (String)session.getAttribute("KEY_SESS_UNAME");
String grade  = (String)session.getAttribute("KEY_SESS_GRADE");

if (grade != null) {
%>      
          <a class="nav-link" href="<%=request.getContextPath()%>/UserServlet">Logout</a>
<% } else { %>      
      	  <a class="nav-link" href="<%=request.getContextPath()%>/login.jsp">Login</a>
<% } %>


         <a class="nav-link" href="register.html">Register</a>
         <a class="nav-link" href="password.html">Forgot Password</a>
     </nav>
 </div>
 
 
                                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                                    </a>
                                    <div class="collapse" id="pagesCollapseError" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                                        <nav class="sb-sidenav-menu-nested nav">
                                            <a class="nav-link" href="401.html">401 Page</a>
                                            <a class="nav-link" href="404.html">404 Page</a>
                                            <a class="nav-link" href="500.html">500 Page</a>
                                        </nav>
                                    </div>
                                </nav>
                            </div>
                            <div class="sb-sidenav-menu-heading">Addons</div>
                            <a class="nav-link" href="charts.html">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                Charts
                            </a>
                            
<!--  ------------------ BOARD 연결------------------------ -->                            
 <a class="nav-link" href="<%=request.getContextPath()%>/BoardServlet">
     <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
     Tables    
 </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="small">Logged in as:</div>
                        Start Bootstrap
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Tables
                        
                        
<!-- ---------------  세션 보이기 ------------------------- -->		
<%
if (grade != null) {
	out.println(uname + "님 환영합니다.");
	if (grade.equals("u")) {
		out.println("사용자접속");
	} else if (grade.equals("a")) {
		out.println("관리자접속");
	}
}
%>
                        
       
       
       
                        
                        </h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Tables</li>
                        </ol>
                        
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>
                                DataTable Example
                            </div>
                            <div class="card-body">
                            
                            <%
                            BoardVO bvo = (BoardVO)request.getAttribute("KEY_BOARDVO");
                            
                            %>
                           
                           
                           <form id="boardForm" >
                           <input type="hidden" name="seq" value="<%=bvo.getSeq()%>">
							<input type="hidden" name="regid" value="<%=bvo.getRegid()%>">
                           
                                <table border="1" width="100%">
                                    <tr>
								         <th width="20%">글번호</th>
								         <td width="80%"><%=bvo.getSeq() %></td>
								   </tr>
								   <tr>
								         <th>작성자</th>
								         <td><%=bvo.getRegid()%></td>
								   </tr>
								   <tr>
								         <th>작성일</th>
								         <td><input type="text" name="regdate" value="<%=bvo.getRegdate()%>" readonly></td>
								   </tr>
								   <tr>
								         <th>제목</th>
								         <td><input type="text" name="title" size="60"  value=<%=bvo.getTitle() %>></td>
								   </tr>
								   <tr>
								         <th>내용</th>
								         <td><textarea name="contents" cols="80" rows="6" ><%=bvo.getContents() %></textarea></td>
								   </tr>
				
								   	<td colspan=2 align="center">			
								   		<a id="uptButton" class="btn btn-primary btn-block" >수정</a>
								   		<a id="delButton" class="btn btn-primary btn-block">삭제</a>
										<a id="listButton" class="btn btn-primary btn-block">목록</a>
								   	</td>
								  
                                </table>
                             </form>   
                                <br>
								<table width=100% border=1>
						
                   		<%
                   		ArrayList<ReplyVO> replies = (ArrayList<ReplyVO>)request.getAttribute("KEY_REPLYLIST");
                   			for(ReplyVO rvo : replies) {
                   			
                   			int rseq = rvo.getRseq();
                   			String reply = rvo.getReply();
                   			String regid = rvo.getRegid();
                   			//String regdate = rvo.getRegdate(); 
                   			
                   			if (reply != null) {
                   			%>
             			<tr><td><font color=red><a href = "<%=request.getContextPath()%>/BoardServlet?pagecode=B005&seq=<%=bvo.getSeq()%>&rseq=<%=rseq%>">[X]</a></font><%=reply%></td></tr>
                   		 
                   		<%
                   			}
                   			
                   			 } %>
								</table>
								
								<br>
								
								<form method="post" action="<%=request.getContextPath()%>/BoardServlet?pagecode=B006">
								<table width=100% border=1>
								<input type=hidden name=seq value="<%=bvo.getSeq()%>">
								
								<tr>
									<td>
										<input type="text" size=100 name="reply">
										<input type="submit" value="댓글등록">
									</td>
								</tr>
								</table>
                                
                                </form>
                                
                                
                            </div>
                        </div>
                    </div>
                </main>
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>