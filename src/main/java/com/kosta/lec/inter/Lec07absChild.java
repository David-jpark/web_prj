package com.kosta.lec.inter;


// 상속받은 메소드를 반드시 구현해야한다는 error message
//The type Lec07absChild
//must implement the inherited abstract method (오버라이딩)
//Lec07abs.absMethod()

// abstract를 사용하는 이유는 각자가 클래스별로 구현해야하는 기능이 다를때 사용한다.
// 한 부모에 자식클래스로 관리가 들어가야할 경우에 사용
// 잘 안쓰고 interface나 commonUtil을 사용하는게 좋다.
public class Lec07absChild extends Lec07abs {
	// ***부모클래스의 abstract Method를 반드시 오버라이딩해서 써야한다!
	@Override
	public void absMethod() { //abstract를 뺀다.
		System.out.println("Child_abstract_Override");
	}
	// 추상메소드가 하나만 필요하면 하나만 구현하고 나머지는 빈 바디로 놔두면 된다.
	public void absMethod2() {	
	}
	public void absMethod3() {		
	}
	
	@Override
	public void normalMethod() {
		System.out.println("Child_NM 변경 call");
		System.out.println("Child_normalMethod call : 옵션, 오버라이딩 바디 변경");
	}
	public static void main(String[] args) {
//		Lec07abs p = new Lec07abs(); // 추상이라 new로 불러올 수 없다.
//		p.normalMethod();
		
		Lec07absChild c = new Lec07absChild();
		c.normalMethod(); // 자식에게 있어서 자식것을 호출
//		Lec07abs.staticMethod(); 클래스간 구별을 위해서 쓴다. 생략가능
		staticMethod();
		System.out.println("Child_main 실행");
		
		c.absMethod(); // 오버라이딩된 자식의 메소드 호출

	}

}
