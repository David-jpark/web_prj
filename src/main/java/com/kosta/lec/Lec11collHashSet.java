package com.kosta.lec;

import java.util.ArrayList;
import java.util.HashSet;


public class Lec11collHashSet {
/**
 * Set : 중복x, 순서보장x
 */
	
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add("abc");
		hs.add(10);
		hs.add('A');
		hs.add('A');
		hs.add('A');
		System.out.println("HashSet  : "+ hs);
		
		hs.remove('A');
		System.out.println("remove	 : "+ hs);
		
//		hs.clear();
//		System.out.println("clear    : "+ hs);
		
//		수정불가, 기존의 값을 지우고 신규 값으로 입력
//		abc --> zzz 값으로 바꿀땐
		hs.remove("abc");
		hs.add("zzz");
		System.out.println("re,add   : "+ hs); //추가되면서 순서보장x
		
		ArrayList list = new ArrayList(hs);
		System.out.println("ArrayList: "+list);
		System.out.println("type-class check : "+list.getClass());
		
		//[10,zzz]
		System.out.println("type-class check : "+list.get(0).getClass());
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(30);
		Integer res2 = list2.get(0);
		System.out.println("Generic-Casting(X): "+res2);
		
		
		
		
	}

}
