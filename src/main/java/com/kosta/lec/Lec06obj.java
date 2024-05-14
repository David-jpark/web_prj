package com.kosta.lec;
//1번
public class Lec06obj {
	// 전역변수
		   int invar = 0;// 인스턴스(화 new) 변수 -> 인스턴스 화를 해야 쓸 수 있다.
	static int clavar = 0; //클래스(static) 변수
	
	/**
	 * 인스턴스 : 변수/메소드
	 * 클래스(static) : 변수/메소드
	 * static의 특징은 주소가 있어서 static이 없어도 참조가 가능하다.
	 * 메모리에 올라간다 == 인스턴스화 == 주소가있다 == 참조가능 : new, static
	 */
	
	/**Overloading(오버로딩) : *(하나의 클래스)*에서 메소드 복붙해서 에러가 안나면
	 * 1: *(메소드 이름)*을 같게
	 * 2: 괄호를 변형 --> *(파라미터의 타입or개수)*을 다르게 변경
	 *  매개변수 == 아규먼트 == 파라미터 == 인자 (string *args*) 괄호 안 변수
	 *  관리를 쉽게하기위해, 동일한 이름이면서 기능을 달리할때 사용
	 */
	
	// 인스턴스 메소드
	public void main(String args) { //static을 뺀다.
		//invar는 인스턴스변수, main은 인스턴스 메소드는 
		//클래스를 객체를 만들어(new) 참조변수.invar 호출
		//clavar는 클래스(static)변수 --> static(실행시점에 메모리 상주) 클래스.cv 호출
		// 						   --> new --> 참조변수.clavar 호출
		
		System.out.println(invar);
		System.out.println(clavar);
		System.out.println("인스턴스 main 메소드");
	}
	// 메소드 안에 파라미터도 변수
	//클래스(static) 메소드
	public static void main(String[] args) {
		/***************************************
		//지역변수
//		int num = 0; // 지역변수는 쓸 수 있다 -> 변수 선언을 하지 않으면?
//		System.out.println(num); // 클래스 메소드가 정해지지 않아 사용불가
		
		//에러 : int invar = 0,  static void main...()
		//invar는 인스턴스변수, 클래스(static) 메소드에서는 호출 불가
//		System.out.println(invar);
		
		//해결 :invar: 인스턴스 변수를 호출하려면 클래스의 객체를 만들어서 참조변수.invar 호출
		Lec06obj rv = new Lec06obj();
//		System.out.println(invar); //에러 인스턴스화 하지 않아 쓸 수 없다
		System.out.println(rv.invar); // 참조변수
		
		******************************************/
		Lec06obj rv = new Lec06obj();
		System.out.println(rv.invar); // 인스턴스변수 :참조변수.invar
		System.out.println(Lec06obj.clavar);//클래스변수 :클래스명.clavar
		System.out.println(clavar);//클래스변수 :(클래스명)은 생략가능
		
		
		
		
		
	}

}
