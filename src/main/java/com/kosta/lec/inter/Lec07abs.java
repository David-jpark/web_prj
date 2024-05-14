package com.kosta.lec.inter;
//abstract 추상

/**
 * abstract (추상,미완성)
 * 구조적 :다른 클래스들이 부모클래스의 [자식으로 관리]가 되어질 필요가 있는 경우
 * 기능적 :다른 클래스들이 부모클래스에서 제공되는 (메소드를 공통으로 사용하고: normalMethod)
 * 		 (일부 메소드는 [각자가 구현]해야하는 경우 : absMethod)
 * -----------------------------------------------------------------------
 *  - 클래스 :인스턴스 생성 불가 (new 못함) 
 *  	   :abstract 메소드가 있을 수도 있다.
 *  	   :일반메소드) 메소드를 사용하고 싶으면 : 자식new.부모일반메소드()
 *  	   :추상메소드) 메소드를 사용하고 싶으면 : 반드시 오버라이딩, 자식new.자식오버라이딩메소드()
 *  - 메소드 : 바디가 없는 메소드
 */
public abstract class Lec07abs {
	//abstract public void absMethod(); --> 비추
	//추상 메소드
	public abstract void absMethod();
	//추상 메소드가 여러개 있으면 전부 다 오버라이딩
	public abstract void absMethod2();
	public abstract void absMethod3();
	
	public static void staticMethod() {
		System.out.println("Parent_staticMethod call");
	}
	
	
	public void normalMethod() {
		System.out.println("Parent_normalMethod call");
	}
	
	
	
	
	
	
	// 공통으로 쓸 전역 static 은 abstract 클래스여도 동작한다.
//	public static void main(String[] args) {
//		Lec07abs o = new Lec07abs(); // 추상이라 new로 불러올 수 없다.
//		o.normalMethod(;)
//		normalMethod();
//		System.out.println("main 실행");
//	}

}
