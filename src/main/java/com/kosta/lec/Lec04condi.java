package com.kosta.lec;

public class Lec04condi {

	public static void main(String[] args) {
		
		// if
		int score = 70;
		String res = "";
//		if (score >= 90) {  			//괄호 블럭을 없애면 한 줄만 인식
//			System.out.println("A");
//		} else 
		
		// if() ~~ else if()...., else => 괄호 없어야함 
		//조건에 만족하지 않아도 실행은 되지만 결과값이 지정이 안됐기 때문에 값을 출력하지 않는다
		score = 10;
		if (score >= 90) {  			
			System.out.println("A");	
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		System.out.println("----done----");
		
//		score = 10;
//		if (score >= 90) {  			
//			System.out.println("A");	
//		} else {
//			System.out.println("F");
//		}
//		
//		
//		System.out.println("----done----");
		
//------------------------------------------------------------
		// Switch (변수) {
		//		case1:
		//			break;
		int score1 = 70;
		char grade = ' ';
		switch (score1) {
			case 90:   // 조건이 오지 못한다.
				grade ='A';
				break;
			case 80:
				grade ='B';
				break;
			case 70:
				grade ='C';
				break;
			default:
				grade ='F';
				break;
		}
		System.out.println(grade);
//------------------------------------------------------------
		System.out.println("----문제풀이----");
		
		int age = 19;
		char gen = 'm';
		if(age >= 10 && age < 20 && gen == 'm' ) {
			System.out.println(50);
		} else if (age >= 10 && age < 20 && gen == 'f'){
			System.out.println(0);
		} else if (age >= 20 && age < 30 && gen == 'm') {
			System.out.println(100);
		} else if (age >= 30 && age < 40 && gen == 'f') {
			System.out.println(0);
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
//-------------------------------------------------------------
		// 중첩 if
		age = 19;
		gen = 'm';
		String end = "";
		if(age >= 10 && age < 20 ) {
			if(gen == 'm') {  		//중첩 if안에 if를 무한으로 넣을 수 있다.
				end = "50";
			} else {
				end = "0";
			}
		} else if (age >= 20 && age < 30) {
			if(gen == 'm') {
				end = "100";
			} else {
				end = "0";
			}
		} else if (age >= 30 && age < 40) {
			if(gen == 'm') {
				end = "0";
			} else {
				end = "0";			// 조건이 없더라도 else 조건 값을 줘서
			}						// 수정을 용이하게 하는게 좋다.
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
		System.out.println(end);
		
	}

}
