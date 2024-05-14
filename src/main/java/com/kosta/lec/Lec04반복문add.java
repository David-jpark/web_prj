package com.kosta.lec;

public class Lec04반복문add {

	public static void main(String[] args) {
		//for 추가문법
		
//		for(타입 변수 : 멀티데이터) {}
		String[] arrStr = {"A","B","C"};
		for(String val : arrStr) {
			System.out.println(val);	
		}
		
		int[] dan = {2,3,4,5};
		int[] gob = {1,2,3};
		for (int d : dan) {
			for (int g : gob) {
			System.out.println(d + "*" + g + "="+ d*g);
		}
			System.out.println();
		}
	}

}
