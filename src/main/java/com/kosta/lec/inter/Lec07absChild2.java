package com.kosta.lec.inter;

public abstract class Lec07absChild2 extends Lec07abs{
	//부모 추상클래스, 자식도 추상클래스
	//반드시 추상메소드를 오버라이딩 할 필요 없다
	//둘 다 추상이기 때문에 
	
	public static void main(String[] args) {
		Lec07absChild c = new Lec07absChild();
		c.normalMethod(); // 부모의 메소드 사용은 가능
		
//		Lec07absChild2 c2 = new Lec07absChild2();
//		c2.normalMethod(); // 자식도 추상클래스라서 부모 메소드 사용x

	}

}
