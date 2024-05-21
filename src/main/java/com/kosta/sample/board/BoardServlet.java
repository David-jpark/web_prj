package com.kosta.sample.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/Board_servlet_url")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ")
//							.append(request.getContextPath()); // contextPath -> /web_prj
		response.getWriter().append("GET");
		System.out.println("===request method : GET ===");
//		response.sendRedirect("index.html");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("POST");
		
		String vUserid = request.getParameter("userid");
		String vUserpw = request.getParameter("userpw");
		String vGen = request.getParameter("gender");
		String vSubject = request.getParameter("subject");
		String vUserfile = request.getParameter("userfile");
		String vSsn = request.getParameter("ssn");
		String vContents = request.getParameter("contents");
		String[] vHabit = request.getParameterValues("habit");
		System.out.println(vUserid);
		System.out.println(vUserpw);
		System.out.println(vGen);
		System.out.println(vSubject);
		System.out.println(vUserfile);
		System.out.println(vSsn);
		System.out.println(vContents);
		
		for(String vh : vHabit) {
			System.out.println(vh);
		}
		System.out.println("===request method : POST ===");
	}

}
