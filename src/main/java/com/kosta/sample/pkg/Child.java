package com.kosta.sample.pkg;

/**
* 오버라이딩 (overriding)
* 상속관계에서 부모 메소드를 재사용(재사용 : 선언부는 같고 바디는 다를 수도 있다) 하는 것
* 접근제어자는 protected 부모 <= 자식 public 또는 protected 같거나 높아야함
* 예외 : (부모의 예외 >= 자식 예외) 자식 예외가 더 많을 수 없다.
*/
class MyParent{
	protected int myPrint(String name, int age) throws RuntimeException {
		System.out.println("부모"+name);
		return age;
	}
}


public class Child extends MyParent {
	//굳이 복붙해서 오버라이딩 타이핑을 하는 이유는 => 바디를 바꾸겠다.
	@Override
//	private int myPrint(String name, int age)  
	protected int myPrint(String name, int age) throws RuntimeException { //똑같이 할꺼면 오버라이딩을 할 필요 없다.(낭비)
		System.out.println("자식"+name);
		System.out.println("11"); //<-- 추가
		return age;
	} /** ! myPrint 를 주석처리해서 없애면 extends(상속)한 부모 클래스의 메소드를 불러옴
		*/
	public static void main(String[] args) {
		Child d = new Child();
		d.myPrint("홍길동", 20);

	}

}
