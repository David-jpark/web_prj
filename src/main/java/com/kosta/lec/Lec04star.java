package com.kosta.lec;

public class Lec04star {

	public static void main(String[] args) {
//----------------1.가로별----------------
//		for(int i = 0; i < 5; i++) {
//			System.out.print("*");
//		}
//----------------2.세로별----------------
//		for(int i = 0; i < 5; i++) {
//			System.out.println("*");
//		}
//----------------3.바둑판----------------
//		for(int i = 0; i < 5; i++) { 		//행
//			for(int j = 0; j < 5; j++) {	//열
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//----------------4.삼각형----------------
//		for(int i=1; i<=5; i++) {
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//---------------5.역삼각형----------------
//		for(int i=5; i>=0; i--) {
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		
//---------------6.반대삼각형---------------
//		for(int i=1; i<6; i++) {
//			for(int j=5; j>i; j--) {
//				System.out.print(" ");
//			}
//			for(int j=0; j<i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		---------- 다른방법 -------------
//		for(int i = 4; i > -1; i--) {		//4 3 2 1 0
//			for(int j = 0; j < 5; j++) {	//0 1 2 3 4
//				if(j < i) {
//					System.out.print(" ");
//				}else {
//					System.out.print("*");
//				}
//			}
//			System.out.println();
//		}
//-----------------7.피라미드----------------------
//		int star = 1;
//		for(int i = 0; i < 5; i++) {
//			for(int j = 4; j > i; j--) {
//				System.out.print(" ");
//			}
//			for (int k = 0; k < star; k+=1) {
//				System.out.print("*");
//			}
//			star = star + 2;
//			System.out.println();
//		}
//----------------8.역피라미드---------------------
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
		
//		for (int i = 1, n=1; i <= 10; i++) { //  
//			for(int j = 1; j <= 10; j++) { //
//				System.out.print(((j >= n+1) && (j <= 10-n))?" ":"*");
//
//
//			}
//			if(i<5) {
//				n++;
//			} else {
//				n--;
//			}
//
//			System.out.println();
//		}
		
//		for(int i = 1, n=1;i <= 10; i++ ) {
//			for(int j = 1; j <= 11; j++) {
//				System.out.print(((j >= n+1) && (j <= 11-n)?"*":" "));
//			}
//			if(i<5) {
//				n++;
//			}else {
//				n--;
//			}
//			System.out.println();
//		}
		
		for(int i = 1, n=1;i <= 10; i++ ) {
			for(int j = 1; j <= 11; j++) {
				System.out.print(((j >= n+1) && (j <= 11-n)?"*":" "));
			}
			if(i<5) {
				n++;
			}else {
				n--;
			}
			System.out.println();
		}
		
		
		
	}

}
