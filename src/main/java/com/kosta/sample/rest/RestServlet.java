package com.kosta.sample.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kosta.sample.board.BoardVO;


@WebServlet("/RestServlet")
public class RestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String pagecode = request.getParameter("pagecode");
		Gson gson = new Gson();
		
		//----------------------"#1__Str_Str_Btn" 또는 "#AjaxBtn" ---------------------
		if(pagecode.equals("R001")) {
			String searchGubun = request.getParameter("searchGubun");
			String searchStr   = request.getParameter("searchStr");
			System.out.println(searchGubun + "," + searchStr);
			
			ArrayList<BoardVO> list = new ArrayList<BoardVO>();
			BoardVO bvo = new BoardVO();
			bvo.setTitle("aaa");
			bvo.setRegid("kim");
			list.add(bvo); //[ {"title":"aaa" , "legid":"kim"} ]
			bvo = new BoardVO();
			bvo.setTitle("bbb");
			bvo.setRegid("lee");
			list.add(bvo); // [ {"title":"aaa" , "legid":"kim"}, {"title":"bbb" , "legid":"lee"} ]
			
			//String responseStr = "This is Server Messege";
//			Gson gson = new Gson();
			String gsonString = gson.toJson(list);
			System.out.println(gsonString +","+ gsonString.getClass());
			
			PrintWriter out = response.getWriter();
			out.print(gsonString);
		}
		
//		} else if (pagecode.equals("R002")) {
//			String str = request.getParameter("MY_JSONKEY");
//			System.out.println(str+ ","+ str.getClass());
//			PrintWriter out = response.getWriter();
//			out.print("R002 응답성공");
			
		
		
//		} else if (pagecode.equals("R003")) {
//			String jsonStr = request.getReader().lines().collect(Collectors.joining());
//			System.out.println(jsonStr);
//			PrintWriter out = response.getWriter();
//			out.print("");
			
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String pagecode = request.getParameter("pagecode");
		Gson gson = new Gson();
		
		//-----------------"#3__JsonStr_Str_Btn"-post로-----------------	
		//data : JSON.stringify(objData)
		if (pagecode.equals("R003")) {
			response.setContentType("text/html;charset=UTF-8");
			String jsonStr = request.getReader().lines().collect(Collectors.joining());
			System.out.println(jsonStr+ ","+ jsonStr.getClass());
			
			//obj : JSON.stringify {"title":"asssd","regid":"hong"}
			//str : "{"title":"asssd","regid":"hong"}" 모양 글자로
			BoardVO bvo = gson.fromJson(jsonStr, BoardVO.class);
			System.out.println(bvo.getTitle());
			PrintWriter out = response.getWriter();
			out.print("R003 응답성공");
			
		
		//--------------"#2__JsonStr_Str_Btn"-post로-----------------	
		} else if (pagecode.equals("R002")){
			response.setContentType("text/html;charset=UTF-8");
			String jsonStr = request.getParameter("MY_JSONKEY");
			System.out.println(jsonStr+ ","+ jsonStr.getClass());
			PrintWriter out = response.getWriter();
			out.print("R002 응답성공");
		
		//-------------------"#4__Str_Json_Btn"--------------------	
		} else if (pagecode.equals("R004")) {
			response.setContentType("application/json;charset=UTF-8"); //json을 받는다.

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("status", "200");
			map.put("message", "R004 응답성공");
			String jsonStr = gson.toJson(map);
			//String jsonStr = "{\"status\":\"200\", \"message\":\"R004 응답성공\"}";
			PrintWriter out = response.getWriter();
			out.print(jsonStr);
			
		//-----------------"#5__JsonStr_Json_Btn"------------------	
		} else if (pagecode.equals("R005")) {
			response.setContentType("application/json;charset=UTF-8");
			String jsonStrParam = request.getParameter("MY_JSONKEY");
			System.out.println(jsonStrParam+ ","+ jsonStrParam.getClass());
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("status", "200");
			map.put("message", "R005 응답성공");
			String jsonStr = gson.toJson(map);
			//String jsonStr = "{\"status\":\"200\", \"message\":\"R004 응답성공\"}";
			PrintWriter out = response.getWriter();
			out.print(jsonStr);
			
			
		//-----------------"#6__Json_Json_Btn"---------------------	
		} else if (pagecode.equals("R006")) {
			response.setContentType("application/json;charset=UTF-8");
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("status", "200");
			map.put("message", "R006 응답성공");
			String jsonStr = gson.toJson(map);
			//String jsonStr = "{\"status\":\"200\", \"message\":\"R004 응답성공\"}";
			PrintWriter out = response.getWriter();
			out.print(jsonStr);
		}
		
		
	}

}
