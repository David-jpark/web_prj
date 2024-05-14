package com.kosta.lec;

public class Lec06cons {
	
	// 기본생성자 : ()안에 파라미터가 없다
	// 클래스 내에 생성자가 하나도 없으면 컴파일러가 기본 생성자를 만들어준다.
	int userPoint = 0; //iv
	
//	생성자 함수도 오버로딩 가능
	public Lec06cons(){ // 생성자 함수
	/**
	 * this() : 생성자 함수
	 * this() : main() 함수에서는 사용 불가.
	 * 생성자함수() : this() 사용가능 단, 첫줄에
	 */
	//new Lec06cons(5) == this(5);
	this(5); //this 키워드는 한번 밖에 사용할 수 없다
	new Lec06cons(10); // 여러번 사용할때는 직접 생성자를 불러온다.
	add(10,30);
	mul(5,3);
		
	}
	
	public void mul (int n1, int n2) {
		System.out.println("인스턴스 메소드 mul : " + n1 * n2);
	}
	
	public static void add(int n1, int n2) {
		System.out.println("클래스 메소드 static add : " +n1 + n2);
	}
	
	
	
	// 인스턴스(화)가 필요한 변수, 전역변수 => 지역변수를 구분하기위해 this를 사용하여 구분
	// this : 클래스가 인스턴스화 된 주소값을 가지고 있다.
	public Lec06cons(int userPoint) { //(지역변수) 타이핑이 들어갔기 때문에 기본생성자 생성x
//		전역변수    = 지역변수
//		userPoint = point;
		this.userPoint = userPoint; // 변수 이름이 같을때 어디를 참조하는지 모른다.
									// this를 사용하여 전역변수를 참조한다. 
		System.out.println(this);
		System.out.println("매개변수가 있는 생성자 : public Lec06cons(int userpoint)");
	}
	
	public static void main(String[] args) {
//		클래스명	참조변수 = new 생성자();
		Lec06cons obj = new Lec06cons(500);
		System.out.println(obj);
		System.out.println("===================");
	
		/**
		// this는 생성자함수를 호출 후에 만들어진 주소를 지칭하는 키워드
		// 즉 : 언제 new가 될지 모르기 때문에 실행시 메모리에 바로 올라갈 static 메소드 안에서는 쓰지 못함.
		// System.out.println(this); 인스턴스화를 해야 쓸 수 있다.
		*/
		Lec06cons obj2 = new Lec06cons();
		System.out.println(obj2);
	
		/**
		생성자(constructor) 함수

		- 역할
		- 인스턴스 초기화 메소드는 최초 클래스 주소를 만드는 메소드
		- 인스턴스 변수의 초기화를 위한 용도

		- 문법(자바)
		- 클래스 이름과 동일한 메소드 → ex) Lec06();
		- 클래스의 인스턴스 생성(t = new 클래스() ) → ex) t.iv, t.insMethod()

		- 일반 메소드와 차이점
		- 메소드 → return이 없으면 일반적으로는 타입을 void로 한다. ex) public void addNumber(){…}
		- 생성자 함수 → return이 없어도 void 타입을 적지 않음 ex) public Lec06(){…}
		*/
	}
	

}
