package com.kosta.lec;
//2번
public class Lec06meth {
	// 인스턴스 -> 각자, 개인적
	// static -> 공유, 전체적
	
	/**
	// void 메소드는 => return이 없다.
	// 즉 호출 후 void res = myPrint("Hello"); <-- 에러
	// 호출만 하고 끝낸다. myPrint("Hello");
	*/
	public static void myPrint(String prm) {
		System.out.println(prm);
	}	
	public static void main(String[] args) {
	
//		void myPrint(String prm); 
		myPrint("Hello");
		
		System.out.println("main");
		//메소드를 가져다 쓴다. == 메소드 호출한다.
		main(7); 	// static method -> static method
		//main(7,i) //파라미터의 수 대로
		
		Lec06meth rv = new Lec06meth();
		//add (1,8); static -> instance method error발생 
		int callRes = rv.add(1,8); // add 메소드에 static 붙이거나, 클래스 참조변수(new)를 써서 사용
//		int callRes = 9; //원하는 결과
		System.out.println(callRes);
		
		System.out.println(rv.add(1, 8)); // 비추 : 1회성 출력, 변수에 값을 담아서 출력하는게 좋다. 
		
	}
	// int add, int res, int callRes -> return type 타입을 맞춰야한다.
	public int add(int a, int b) {
		int res = a + b;
		return res;
	}
	//메소드를 정의하다.
	public static void main(int args)		//----헤더 
	{										//----바디 {....}
		System.out.println("overloading main");	
		
	}
	
	
	
}
