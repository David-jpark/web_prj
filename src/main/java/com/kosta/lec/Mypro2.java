package com.kosta.lec;

import java.util.Scanner;

public class Mypro2 {
	public static void avg(int left, int right) {
		System.out.println((left + right) / 2);
	}
	public static void sum(int left, int right) {
		System.out.println(left + right);
	}

	public static void main(String[] args) {
		System.out.println("연산을 입력해주세요, 1:덧셈, 2:평균");
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		int a = sc1.nextInt();

		if (a == 1) {
			System.out.println("덧셈연산");
			int left = sc2.nextInt();
			int right = sc3.nextInt();
			System.out.println(left + right);
		} else if (a == 2) {
			System.out.println("평균연산");
			int left = sc2.nextInt();
			int right = sc3.nextInt();
			System.out.println((left + right) / 2);
		} else {
			System.out.println("올바르지 않습니다.");
		}


	}

}
