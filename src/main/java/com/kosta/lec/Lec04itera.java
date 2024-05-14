package com.kosta.lec;

public class Lec04itera {

	public static void main(String[] args) {
//		초기화 int i = 0;
//		조건문 i<=5;
//		반복문 i = i+1 , i+= 1 ,  i++
//		for (초기화; 조건문; 증감문) {  // ;는 구분자
//			TODO
//		}
//		int i = 0 					// 1. 초기화 먼저 동작
//		for (   ; i<=3; ) {			// 2. i<=3 비교 
//			System.out.println(i); //  3. i를 출력 
//				i++					// 4. i를 ++
//		}
//
//		while(조건문) {				// 조건이 맞을때 실행
//			TODO
//		}
//		int i = 0;					// 1. 초기화
//		while(i<=3) {				// 2.
//			System.out.println(i);
//			i++;
		
//		do {
//			TODO
//		} while(조건문);
//----------------------------------------------		
//		System.out.println("for문");
//		for (int i = 0; i<=3; i++) {
//			System.out.println(i);
//		}
//----------------------------------------------
//		System.out.println("while문");
//		int i = 0;
//		while(i<=3) {
//			System.out.println(i);
//			i++;
//		}
//----------------------------------------------
//		System.out.println("do-while문");
//		i = 0;
//		do {
//			System.out.println(i);
//			i++;
//		} while(i<=3);

//////////////////////////////////////////////////////////////////		
		//0부터 시작해서 0,2,4,6,8 출력
		System.out.println("for문");
		for (int i = 0; i<=8; i++) {
			System.out.print(i +" "); 	// \t는 탭 띄어쓰기
			i++;
		}
		
		System.out.println("\nwhile문"); // \n은 줄바꿈
		int i = 0;
		while(i<=8) {
			System.out.print(i + " ");
			i++;
			i++;
		}
		
		System.out.println("\ndo-while문");
		i = 0;
		do {
			System.out.print(i + " ");
			i++;
			i++;
		} while (i<=8);
//-------------------------------------------------------------		
		System.out.println("\n좋은 방법");
		for (i = 0; i<=8; i+=2) {
			System.out.print(i + " ");
		}
		
//-------------------------------------------------------------
		
		
		
		
	}

}
