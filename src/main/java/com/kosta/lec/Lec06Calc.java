package com.kosta.lec;
//3번
public class Lec06Calc {		// 1. 제일 먼저 메모리에 올라옴.
	
	public static String add(String s1, String s2) {
		String adds = s1 + s2;
		return adds;
	}
	
	public int mul(int n1, int n2) {
		int mul1 = n1 * n2;
		return mul1;
	}
	
	public static void main(String[] args) { // 2.static main 영역 //3. main 변수
											// 4. 변수영역
		Lec06Calc rv = new Lec06Calc();		// 5. 메소드 호출
		int mul = rv.mul(2, 4);
		System.out.println(mul);
		
		String res = add("가","나다");
		System.out.println(res);

	}

}
