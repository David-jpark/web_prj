package com.kosta.sample.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.kosta.sample.common.MyOracleConnection; // JDBC 연결

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃
		HttpSession session = request.getSession();
		//하나하나 키를 사용해 지우기
//		session.getAttribute("KEY_SESS_USERID");
//		session.getAttribute("KEY_SESS_UNAME");
//		session.getAttribute("KEY_SESS_GRADE");
		
		session.invalidate();// 한번에 일괄 지우기
		
		session.setMaxInactiveInterval(0); //세션 유효타임 0초부터 못쓰게하겠다.
		response.sendRedirect("index.jsp");
	}

	// Spring에서는 annotation으로 여러개의 링크를 줄 수 있다.
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//TODO login, register를 써야한다. Servlet은 기능 하나당 URL은 하나
		
		// 페이지 구분을 위한 input type = hidden 값(P001, P002)
		String pagecode = request.getParameter("pagecode");

		UserDAO dao = new UserDAO();
		
		//--------register-------
		
		if (pagecode.equals("P001")) {
			UserVO uvo = new UserVO();
//			seq -> user_seq.nextval
			uvo.setUserid(request.getParameter("userid"));
			uvo.setUname(request.getParameter("uname"));
			uvo.setEmail(request.getParameter("email"));
			uvo.setPasswd(request.getParameter("passwd"));
//			uvo.setRegdate(request.getParameter("regdate")); -> sysdate로 가져감
			
			int insertRows = dao.userInsert(uvo);
			if(insertRows == 1) {
				//회원가입 성공
				response.sendRedirect("index.jsp");
			} else {
				//회원가입 실패
				response.sendRedirect("500.html");
			}
		//---------login---------
		} else if(pagecode.equals("P002")) {
			String userid = request.getParameter("userid");
			String passwd = request.getParameter("passwd");
			
//			boolean loginCheck = dao.userLogin(userid, passwd);
			UserVO uvo = dao.userLogin(userid, passwd);
//			if(loginCheck == true) {
			if(uvo != null) {
				//login 성공
				
				//session.add(~) 세션할당
				
				System.out.println("-----세션 할당 -----" + uvo.getGrade());
				// userid, uname, grade
				HttpSession session = request.getSession();
				session.setAttribute("KEY_SESS_USERID", uvo.getUserid());
				session.setAttribute("KEY_SESS_UNAME", uvo.getUname());
				session.setAttribute("KEY_SESS_GRADE", uvo.getGrade());
				
//				<%
//				String userid = (String)session.getAttribute("KEY_SESS_USERID");
//				String uname = (String)session.getAttribute("KEY_SESS_UNAME");
//				String grade = (String)session.getAttribute("KEY_SESS_GRADE");
//				// 단순 출력용이면 JSP문법으로 하는게 좋고
//				// 로직이 필요한 경우면 JAVA문법으로 하는게 좋다. 잘 구별해서 사용
//				if(grade.equals("u")) {
//					out.println("사용자 접속 : " +uname + "님 환영합니다.");
//					
//				} else if(grade.equals("a")) {
//					out.println("관리자 접속 : " +uname + "님 환영합니다.");
//				}
//				%>
//				<%=%> --> jsp에서 println
//				<%=session.getAttribute("KEY_SESS_USERID")%> 님 환영합니다.
				response.sendRedirect("index.jsp");
				
			} else {
				//login 실패
				response.sendRedirect("500.html");
			}
		//---------other---------	
		} else {
			//TODO 에러메세지나 다른 화면 출력
			response.sendRedirect("500.html"); // 500번 에러페이지로 보냄
			
		}
		doGet(request, response);
	}

}
