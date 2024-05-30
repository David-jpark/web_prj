package com.kosta.sample.jstl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.sample.board.BoardVO;

/**
 * Servlet implementation class JstlServlet
 */
@WebServlet("/JstlServlet")
public class JstlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JstlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// empty일때 ArrayList<BoardVO> = null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO bvo = new BoardVO();
		bvo.setRegid("kim");
		bvo.setTitle("제목");
		list.add(bvo);
		bvo = new BoardVO();
		bvo.setRegid("kim2");
		bvo.setTitle("제목2");
		list.add(bvo);
		request.setAttribute("KEY_BOARDVO", list);
		
//		HashMap<String, BoardVO> map = new HashMap<String, BoardVO>();
//		BoardVO bvo = new BoardVO();
//		bvo.setRegid("kim");
//		bvo.setTitle("제목");
//		map.put("map_key", bvo);
//		request.setAttribute("KEY_MAPVO", map);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("SESS_ID", "kim");
//		session.setAttribute("SESS_GRADE", "gold");
		
		//쿠키 정보 만들기
		Cookie ck = new Cookie("MY_COOKIE_UID", "lee"); // Servlet cookie
		ck.setMaxAge(100);
		response.addCookie(ck);
		
		RequestDispatcher rd = request.getRequestDispatcher("lec_jstl.jsp");
		rd.forward(request, response);
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
