package com.kosta.lec.inter;
//인터페이스 interface

// 인터페이스는 main이 오지 못한다
// 자신의 것을 다른 사람에게 주고자하는 목적 => 실행의 목적이 아님 => 부모가 되려는 목적
// 인터페이스는 [공통의 메소드]를 모아 [부모 역할]이 목적

/**
 * abstract : 추상, 일반이 올수있다. (추상 메소드, 일반메소드)
 * interface : 완전추상 (only 추상 메소드)
 * - 변수  : static 상수만 가진다.
 * - 메소드 : 추상 메소드만 가진다.
 * - [인터페이스]다중상속 : 자식 interface extends 부모인터1, 부모인터2 - 다중상속 가능
 * - [클래스]  단일상속 : 자식 class extends 부모class
 */

public interface Lec07inter extends InterParent1, InterParent2{
//	public void add() {  } --> 바디가 있는 메소드는 절대 사용 불가
//	public abstract void add();
	
	double PI = 3.14159; 
//	public static final double PI = 3.14159; 자동으로 static 붙임
//	무조건 public, 무조건 final = 값 변경 불가
	
	public void add(); // 타이핑을 안해도 abstract를 자동완성시킴
	
}
interface InterParent1{
	public void inter1ParentMethod1();
	public void inter1ParentMethod2();
}
	
interface InterParent2{
	public void inter2ParentMethod1();
	public void inter2ParentMethod2();
}
	
	
	
