package com.kosta.lec;
//예외처리
/**
 * 컴파일 에러
 * 런타임 에러
 *  - Exception : 예외 (개발자가 수습할 수 있다.)
 *  - Error : 에러
 *  예외처리를 하는 이유?
 *  의도치 않은 문제가 발생 했을 때 프로그램을 정상적으로 끝까지 돌려보려는 목적 
 *  
 *  try{
 *  	//TODO
 *  } catch(__Exception e){
 *  	//[예외] 처리부	
 *  } catch(_Exception e){
 *  
 *  } catch(Exception e){
 *  
 *  } finally {
 *   [정상][예외] 어떤 상황이든 무조건 실행
 *  }
 */
 
public class Lec08excep {
//	------------------------------------------------------------
	public void myPrint() { //throw ArithmeticException, Exception <- 작은거부터 큰거로{
		try { 
			System.out.println("111");
			System.out.println("222");
			
//			ArithmeticException myExc = new ArithmeticException();
			Exception myExc = new Exception();
			throw myExc; // java 런타임이 받아서 실행
//			System.out.println("33"); throw에서 끝나기 때문에 에러
		} catch(Exception e) {
			System.out.println("444");
			System.out.println(e.getClass());
		} finally {
			System.out.println("555");
		}
	}
	public static void wait2() throws InterruptedException {
		
	}
//	------------------------------------------------------------
	public static void main(String[] args) {
		try {
			wait2();
		} catch(InterruptedException e) {
			System.out.println("예외처리");
		}

		
		System.out.println("----start----");
		
		Lec08excep excp = new Lec08excep();
		try{
			excp.myPrint(); // 호출한 곳으로 예외를 던진다.
		} catch(ArithmeticException e) {
			System.out.println("잡았음");
			e.printStackTrace(); // 스택 몇번째 줄에서 에러가 발생했는지 알려줌
		} catch(Exception e) {
			System.out.println("잡았음2");
		}
		
		System.out.println("myPrint() call done...");
		
		
		int res = 0;
		
//		try {
//			System.out.println("111");
//			System.out.println("222");
//			//예외를 만들어서 던진다
////			ArithmeticException myExc = new ArithmeticException();
//			Exception myExc = new Exception();
//			throw myExc; // java 런타임이 받아서 실행
////			System.out.println("33"); throw에서 끝나기 때문에 에러
//		} catch(Exception e) {
//			System.out.println("444");
//			System.out.println(e.getClass());
//		} finally {
//			System.out.println("555");
//		}
		System.out.println();
		
		
		
		try {
			//코드라인 작성
			System.out.println("1.try");
			int num = 100;
			res = num/0;	// 오류발생 사항
		} catch (ArithmeticException e) {  
			//예외가 발생했을 경우
			System.out.println("1.catch");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			//			개발자 예외처리부 코드라인

		}catch(Exception e) { // catch의 맨 끝에는 exception을 넣어주는게 좋다.
			//예외가 발생했을 경우
			System.out.println("1.catch");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			//			개발자 예외처리부 코드라인
		} finally {
			System.out.println("try-catch 무조건 실행");
		}
		try {
			System.out.println("2.try");
			int[] arr = {1,2,3};
			System.out.println(arr[6]);
			//for (int i = 0; i<arr.length; i++) {
			//System.out.print(arr[i]);
			//}

		}catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println("2.catch");
			System.out.println(e1.getMessage());
			System.out.println(e1.getCause());
			System.out.println(e1.getClass());
			//			개발자 예외처리부 코드라인

		} catch(Exception e) { // catch의 맨 끝에는 exception을 넣어주는게 좋다.
			//예외가 발생했을 경우
			System.out.println("2.catch");
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			System.out.println(e.getClass());
			//			개발자 예외처리부 코드라인
		} finally {
			System.out.println("try-catch 무조건 실행");
		}
		System.out.println();
		System.out.println(res);
		System.out.println("---done---");

	}

}
