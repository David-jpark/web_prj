package com.kosta.lec.inter;

class Lec07parentclass{
	public void div() { }
}
// 클래스와 인터페이스를 같이 상속할 수 있다.
public class Lec07interChild extends Lec07parentclass 
implements InterParent1, InterParent2 { //Lec07inter 기능이 필요없어서 뺀 경우
	
	
	
	public static void main(String[] args) {
		

	}

// @ = Annotation 어노테이션 == 실행기나 컴파일러에게 안내하는 역할
//	@Override 
//	public void add() { //Lec07inter에서 오버라이딩이였지만 빠지면 그냥 메소드가 됨	
//	}
	
	/**
	// add를 사용하기 위해서 상속된 모든 메소드가 들어온다.
	// 그래서 인터페이스는 자잘하게 나눠 놓는다. 공통부,공통부 마다.
	// 상속 : implements Lec07inter --> 추상메소드는 1개
	// Lec07inter는  extends InterParent1, InterParent2
	// InterParent1, InterParent2에 포함되있는 추상메소드를 전부 다 오버라이딩해야함
	*/
	@Override
	public void inter1ParentMethod1() {}

	@Override
	public void inter1ParentMethod2() {}

	@Override
	public void inter2ParentMethod1() {}

	@Override
	public void inter2ParentMethod2() {}

}
