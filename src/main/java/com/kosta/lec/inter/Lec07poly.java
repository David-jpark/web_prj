package com.kosta.lec.inter;
//다형성

/**********************************
 * 다형성 : 다양한 형태의 성질
 * - PC(Parent-Child) - 자식 인스턴스로 부모타입의 객체에 접근하는 것
 * - 유연성, 유지보수, 가독성, 확장성
 * 
 * -Child c = new Child();
 * -Parent p = new Parent();
 * -Parent pc = new Child(); <-- 다형성
 * -Child cp = new Parent(); XXX안된다
 * 
 * -**전부(변수,메소드) 부모 호출, 오버라이딩은 자식 것
 * 
 * (자신의 클래스에 있는 메소드)들을 제한적으로 사용하면서
 * (부모에게도 있는 자식의 메소드:오버라이딩) 
 *  공통부로 쓸 수 있는 부분을 구현해야할때
 * 
 */



class polyParent{
	public int point = 100;
	public void add(int a) {  // 오버라이딩
		System.out.println(a*100+"부모");
	}
	
	public void parentMethod() {
		System.out.println("parentMethod() call");
	}
}

public class Lec07poly extends polyParent {
	public int point = 10;
	@Override
	public void add(int a) { // 부모오버라이딩 -> 자식에 있으면 자식 것만 쓴다.
		System.out.println(a*10+"자식");
	}
	
	public void childMethod() {
		System.out.println("childMethod() call");
	}
	public static void main(String[] args) {
		/**
		 * 변수 		 : 타입을 따른다.
		 * 메소드 	 : 인스턴스를 따른다.
		 * 다형성 메소드 : 타입을 따른다.(부모, 자식-오버라이딩)
		 * Parent pc = new Child();
		 * pc : 변수  		 - 부모
		 * pc : 메소드 		 - 부모
		 * pc : 오버라이딩 메소드 - 자식
		 */
		
		//1. 자식타입 = 자식인스턴스();
//		Lec07poly c = new Lec07poly();
//		System.out.println(c.point); // 자식
//		c.add(8);    				 // 자식 
//		c.parentMethod();	//상속된 부모메소드 사용
//		c.childMethod();	//본인인 자식메소드 사용
		
		//2. 부모타입 = 부모인스턴스();
//		polyParent p = new polyParent();
//		System.out.println(p.point); //부모
//		p.add(5);					 //부모 
//		p.parentMethod();			//부모
		
		//3. 부모타입 = 자식인스턴스(); -> 다형성
		polyParent pc = new Lec07poly();
		System.out.println(pc.point);  //부모
		pc.add(3); 					  //자식 - 오버라이딩
		pc.parentMethod(); 			 //부모
//		pc.childMethod(); 			//에러 : 타입은 부모타입이라서. 부모에게 없는 메소드
		
	}

}
