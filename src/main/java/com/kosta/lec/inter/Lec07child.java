package com.kosta.lec.inter;

class Lec07parents{
	public void userCheck(String uid) {
		System.out.println("부모 userCheck()..." + uid);
	}
}

public class Lec07child extends Lec07parents {
	/**
	 * 오버라이딩(override)
	 * 상속(extends 키워드가 있어야 오버라이딩 가능)
	 * 1.헤더(선언부) : 동일
	 *   바디(내용부) : 동일 or 변형
	 * 2. 부모의 접근제어자 보다 자식 접근제어자가 커야한다. 부모 < 자식
	 * 3. 예외처리시 부모 메소드 보다 많은 수의 예외를 선언할 수 없다. 부모(4) > 자식(3)
	 */
	public void userCheck(String uid) {
		System.out.println("부모 userCheck()..."+ uid + "**");
	}
	
	int num = 100;
	public float add(float a, float b) {
		return a+b;
	}
	public void myPrint(String msg) {
		System.out.println(msg);
	}
	public static void main(String[] args) {
		Lec07child t = new Lec07child();
		System.out.println(t.num);
		
	}

}
