package com.kosta.sample.craw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class CrawNaverServlet
 */
@WebServlet("/CrawNaverServlet")
public class CrawNaverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CrawNaverServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		CrawTest ct = new CrawTest();
		ArrayList<NewsVO> list = ct.getNaverNews();
		//System.out.println(list.size());
		Gson gson = new Gson();
		String jsonres = gson.toJson(list);
		PrintWriter out = response.getWriter(); // 화면에 print 출력
		out.print(jsonres);
//		for(NewsVO nvo : list) {
//			out.println(nvo.getTitle());
//			out.println(nvo.getRef());
//		}
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
