package com.kosta.lec;

/**
 *  ArrayList : 중복o, 순서보장o
 */

import java.util.ArrayList;

public class Lec11collArrayList {

	public static void main(String[] args) {
		
		//Create table list(); -> Oracle
		ArrayList list = new ArrayList();
		
		//Create = insert into list values("abc"); 
		list.add("abs");
		list.add(10);
		list.add('A');
		
		//Read = select count(1) from list;
		System.out.println("list.size(): "+list.size());
		System.out.println("read	  : "+ list); //[abs, 10, A, def]
		//----------컬렉션 ArrayList ---------------
		System.out.print("Arraylist : ");
		for(int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		//Update = Update list set col = 'zzz' where seq = 0;
		list.add(3, "def"); // 없으면 넣는다.
		list.set(0, "zzz"); // set 0번째를 바꾼다.
		System.out.println("set	  : "+list); // [zzz, 10, A, def]
		
		//Delete =
		list.remove(1);
		list.remove("10"); // 삭제 안됨 "10" 글자형태라
		list.remove(Integer.valueOf(10)); // list에서 숫자 지우기
		System.out.println("remove	  : "+ list);
		
		//추가기능
		int idx = list.indexOf("def");
		System.out.println("def index : "+ idx); // 원하는 값의 Index 값 찾기
		
		
		//-------- 배열 String[] ------------------
		System.out.println();
		System.out.print("array	  : ");
		String[] arr = {"abs","10","A","def"}; // 다른 타입을 반영하지 못함 String == String
		for(int j = 0; j<arr.length; j++) {
			System.out.print(arr[j]+" ");
		}
	}

}
