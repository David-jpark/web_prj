//package com.kosta.sample.chart;
//
//
//import java.util.ArrayList;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//
//
//
//
//@Controller //("/board") //-> /board/emp_spring으로 경로를 더줄수있다.			// 스프링에서 불러오는법
//public class EmpController {
//
//    @RequestMapping(value = "/emp_list_servlet", method = RequestMethod.GET) // 기존에 web.xml에 /emp가 있기 때문에 변경
//
//	public String empList(Model model) {	
//
//		EmpDAO dao = new EmpDAO();
//		ArrayList<EmpVO> list = dao.empSelect();
//		model.addAttribute("KEY_EMPLIST", list);
//		return "lec02_servlet";
//		
//	}
//
//
//}
