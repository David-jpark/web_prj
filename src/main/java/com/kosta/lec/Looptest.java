package com.kosta.lec;

public class Looptest {

	public static void main(String[] args) {
//		int num = 1;
//		for (int i = 0; i<5 ; i++) { // 행
//			for(int k = 4; k > i ; k--) {
//				System.out.print(" ");
//			}
//			for(int j = 0; j < num; j+=1) { // 열
//				System.out.print("*");
//				
//			}
//			num = num + 2;
//			System.out.println();
//		}
//		
//		int star = 9;
//		for(int i= 0; i < 5; i++) {
//			for(int j = 0; j < i; j++) {
//				System.out.print(" ");
//			}
//			for(int k = 0; k < star; k++) {
//				System.out.print("*");
//			}
//			star = star - 2;
//			System.out.println();
//		}
		// 회문
		int number = 81341;
		int tmp = number;
		int result = 0; 
		while (tmp != 0) {
		    int digit = tmp % 10; 
		    result = result * 10 + digit; 
		    tmp /= 10; 
		}
		if (number==result) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}

}
