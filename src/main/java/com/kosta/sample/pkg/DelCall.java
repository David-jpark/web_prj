package com.kosta.sample.pkg;

//패키지 = 폴더
//유사한 기능을 하는 클래스의 묶음
//예약어로 패키지명 사용 불가
//import 패키지.패키지.*(클래스명)
//동일한 패키지 내 클래스는 import 안해도 된다.
//import com.kosta.sample.pkg.*; 이미 선언되있음.
class Parent{
	public Parent() { //기본 생성자
		System.out.println("Parent() 생성자 콜");
	}
	public Parent(String name){ //기본 생성자가 아니라서 오류가 난다. 
		System.out.println("Parent(String name) 생성자 콜");
	}
}
public class DelCall extends Parent {
	public DelCall() {
		super("ABC");
		System.out.println("DelCall() 기본생성자 콜");
	}
	public DelCall(int a) {
		/**
		 * 자식의 생성자를 호출할 때 상속(extends Parent)은 있는데 부모의 생성자 호출이 없을 경우
		 * 컴파일러가 기본부모생성자 super(); 키워드를 붙여줌.
		*/
		//super(); 안보이지만 extends Parent 상속시 --> 부모의 기본생성자 
		System.out.println("delcall(int a) 생성자 콜");
	}
		
	
	public static void main(String[] args) {
		DelCall me = new DelCall(); //Parent(String name) 생성자 콜
									//DelCall() 기본생성자 콜
		
		DelCall me2 = new DelCall(5);//Parent() 생성자 콜
									//DelCall(int a) 생성자 콜
		
		//다른 사람의 클래스를 가져다 사용할 경우
		//1. ex) import 패키지.패키지.deldel; //지정된 클래스 불러오기
		//2. 메모리에 올려야 실행 가능 == 클래스의 new 생성자(); 부터 확인 타입,값
		//3. ex) DelDel 클래스의 생성자 d = new 생성자(); --> d.메소드() 사용
		
		DelDel d = new DelDel();
		d.myPrint();				//ddd

	}

}
