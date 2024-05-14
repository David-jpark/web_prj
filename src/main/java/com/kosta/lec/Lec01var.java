package com.kosta.lec;

//
/*  */
/** */
// Access Modifier(접근자) : 밖에서 들어올 수 있는지 (접근권한)
// public(default), protect, private
public class Lec01var {
	// 객체(object) =~ 인스턴스(instance) : 메모리에 할당된 주소값을 가지고 있는 객체 - 인스턴스 화 -> 메모리에 올라갔다.
	// 변수(variable) : 값을 나타냄
	// 메소드(method) : void [main] 기능을 나타냄
	// 함수(function) : 생성자 함수
	
	public static void main(String[] args) {
		// 타입 변수명; int age; => 변수선언
		// 타입 변수명 = 값; int age = 20; => 변수선언, 초기화(값 최초할당)
		// 				 int age = 30; => 초기화 후 다른값(할당)
		// +는 붙인다.
		int age = 20;
		System.out.println("hello" + age);
		
		/////////////////////////////////////////////////////////////////////////// 4/24
		long lv = 1000; // 8byte <-- 4byte int형은 수치로 내부변환이 일어난다, casting이 일어남
		long lv2 = 1000L; // L을 붙이는 이유 ?
		System.out.println(lv+","+lv2);
		
		double dv = 3.14;
		double dv2 = 3.14d; // 이터럴 표기 불필요, 실수형의 기본타입은 double 
		System.out.println(dv+","+dv);
		
		boolean bv = true;
		boolean bv2 = false;
		// 1byte -> 4byte
		System.out.println(bv);
		
		char cv = 'A'; // JAVA는 char = ''는 한글자만 가능 
		String cv2 = "smith"; // String = "" 여러글자
		
		System.out.println("abc\n def\t"); // \n은 줄바꿈, \t는 tab
		
		//boolean db;			// 변수 선언만 하고 초기화를 하지 않은 상태는 에러가 나지 않고
		//System.out.println(db); // 해당 변수를 사용하려고 할 때 -> 문법 에러
		
		boolean db = true;
		System.out.println(db); // 반드시 변수를 선언하면 초기화 후 사용!
		
		//char cv3 = ''; // 공백이라도 넣어야 한다. 에러발생
		char cv3 = ' '; // blank 공백이라도 넣기
		
		String str1 = null; 		  // Ref.타입의 기본값은 null
		String str2 = ""; 			  // 아래와 같은 문법이다.
		String str3 = new String(""); //
		
		// *** any type + "문자열" == 문자열
		boolean bv3 = false;
		System.out.println(bv3); 	// boolean 결과 출력
		System.out.println(bv3+""); // false라는 문자열 출력
		System.out.println(7+7+""); // 7+7= 14 결과로 14 문자열 출력

		
		//byte b = 128; // -2^7 ~ 2^7(127) 수의 범위를 넘어가서 에러발생
		//System.out.println(b);
		byte b = 127;
		System.out.println(b); // 127
		System.out.println(b+1); // 128 -> byte가 int로 변환
		
		int res = b + 1;
		System.out.println(res);
		
		//byte res2 = b + 1; // byte 1 <-- byte 4 오버플로우 발생 엉뚱한 값으로 변환
		//System.out.println(res2); //
		
		byte res2 = (byte) (b + 1); //  1 <-- 4 큰타입을 작은 타입으로 강제 캐스팅
		System.out.println(res2); // 오버플로우 발생 최대값을 넘어서 최소값으로 출력 
		
		//**********************************
		// 큰 타입을 작은 타입으로 변환하는 경우 강제 캐스팅
		// float(4) <-- double(8)
		float fv = (float)3.14;
		
		// 작은 타입을 큰 타입으로 변환하는 경우 암묵적 캐스팅
		// double(8) <-- float(4)
		double d = 1.4e3f;
		
		//////////////////////// 문제 //////////////////////////////
		// int보다 작은 타입은 int형으로 자동 캐스팅을 하고 인코딩 작업
		System.out.println('A'+'B'); // ASCII A=65, B=66 = 131 
		System.out.println('1'+ 2); // ASCII 1=49 +2 == 51
		System.out.println('1' + '2');// ASCII 1=49, 2=50 == 99
		//System.out.println(true + null); // error 발생 이유는? 
		
		//형 변환 생략 가능한 경우
		byte bb = 10; 			//byte = 1
		char chch = 'A';		//char = 2
		int ii = 100;			//int  = 4
		long ll = 1000L;		//long = 8
		
		bb = (byte)ii;			//byte = 1, int  = 4 // type mismatch //생략x 1 <-- 4
		chch = (char)bb;		//char = 2, byte = 1 // type mismatch // 생략x 2 <-- 1 문자형,정수형
		short ss = (short)chch; //short= 2, char = 2 // type mismatch // 생략x 2 <-- 2 문자형,정수형
		float ff = (float)ll;	//float= 4, long = 8 // 생략o 실수형 4 <-- 정수형8 실수형이 더 큼
		ii = (int)chch;			//int  = 4, char = 1 // 생략o 4 <-- 1
		
		System.out.println(ff);
		System.out.println(ss);
		// 출력결과
		
		
		
	}


}
