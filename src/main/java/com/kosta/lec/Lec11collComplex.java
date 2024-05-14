package com.kosta.lec;

import java.util.ArrayList;
import java.util.HashMap;


public class Lec11collComplex {

	public static void main(String[] args) {
		//웹에서 보여주는 것은 대부분 String
		//이후에 DB에서 가져오는 형태로 변경
//-------------------------ArrayList(HashMap)-------------------------------
		//ArrayList(HashMap)
		
		final int DATA_ROWS = 10;
		ArrayList<HashMap<String, String>> map = new ArrayList<HashMap<String,String>>();
		for(int i = 1; i<=DATA_ROWS; i++) {
			HashMap<String, String> arr2 = new HashMap<String, String>();
			arr2.put("seq",""+i);
			arr2.put("title","제목"+i);
			arr2.put("rdate","2024-01-01");
			arr2.put("regid", "kim"+i);
			map.add(arr2);
		}
		
		for(int i = 0; i<map.size(); i++) {
			String seq = map.get(i).get("seq");
			String title = map.get(i).get("title");
			String rdate = map.get(i).get("rdate");
			String regid = map.get(i).get("regid");
			System.out.println(seq+"\t"+title+"\t"+rdate+"\t"+regid);
		}
		
		//ORM --> MyBatis(iBatis) --> Hibernate --> JPA 
		// 개발언어와 SQL의 데이터를 자동으로 매핑, 편리성과 가독성을 높여줌
		//user_daily_point_by_
		//userDailyPointby_
		
		
		
		
		
//----------------------ArrayList(ArrayList)----------------------------------		
		// ArrayList(ArrayList)
//		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
//		
////		ArrayList<String> arr = new ArrayList<String>();
////		{"1", "제목1", "2024-01-01", "KIM"};
////		list.add(arr);
////		arr.add("1");
////		arr.add("제목1");
////		arr.add("2024-01-01");
////		arr.add("KIM");
//		
//		
//		for(int a = 0; a<5; a++) {
//			ArrayList<String> arr = new ArrayList<String>();
//			list.add(arr);
//			arr.add(""+a);
//			arr.add("제목"+a);
//			arr.add("2024-02-02");
//			arr.add("KIM"+a);
//			list.get(a);
//		}
//		System.out.println("번호"+"\t"+"제목"+"\t"+"날짜"+"\t\t"+"이름");
//		for(int a = 1; a<list.size(); a++) {
//			String seq = list.get(a).get(0);
//			String title = list.get(a).get(1);
//			String date = list.get(a).get(2);
//			String name = list.get(a).get(3);
//			System.out.println(seq+"\t"+title+"\t"+date+"\t"+name);
//		}
//		System.out.println(list.get(0).get(1)); 
		
		
		
		
//---------------------------------------------------------배열로 고정된 형과 고정된 배열 수 	
		// ArrayList(String[])
//		String[] arr = {"1", "제목1", "2024-01-01", "KIM"};
//		
//		
//		ArrayList list = new ArrayList();
//		list.add(arr);
//		System.out.println(list); // 배열을 넣었기 때문에 주소값이 표시됨
//		
//		String[] res = (String[])list.get(0);
//		System.out.println(res[1]);
		
//		String[] arr = {"1", "제목1", "2024-01-01", "KIM"};
//		
//		
//		ArrayList<String[]> list = new ArrayList<String[]>(); // 제네릭 습관화
//		list.add(arr);
//		System.out.println(list.get(0)[1]);
//		String[] res = list.get(0);
//		System.out.println(res[1]);
		
		
	}

}
