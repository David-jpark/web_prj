package com.kosta.lec;

public class Lec05arr {

	public static void main(String[] args) {
//		java Hello "3" "5" 파라미터 받는 자리
//		실행 . class arg[0], arg[5]
//		System.out.println(arg[0]+arg[1]);
		
		//배열 (array) : 타입이 [같은] 변수 [여러개]를 사용하려는 목적
		//배열 선언
		
		//int num1 = 10; 일반적 변수 선언
		//int num2 = 10; 여러개의 변수를 선언 할 때는?
		//int num;
//		System.out.println(num); //선언 후 초기화 없이 사용하면 에러
		
		//배열변수 선언 = 배열 선언
//		int[] num;
//		int[] num = new int[3]; // int타입의 변수 여러개
//		System.out.println(num[0]); // 배열의 접근은 인덱스(index) 0번째 부터 시작
//		System.out.println(num[1]);
//		System.out.println(num[2]);
//		
//		System.out.println("num.length:" + num.length);
//		for (int i = 0; i<num.length; i++) { // num의 값에 따라 변하게 num.length를 써준다
//			System.out.println(num[i]);
//		}
		// error, 변수 선언 후 라인바꿈 후 값을 초기화하면 값을 찾지 못해 에러가 발생
//		int[] numArr;
//		numArr = {10,20,30}; 

//		int[] numArr1 = {10,20,30}; // 보이진 않지만 자동으로 객체 인스턴스를 생성하여 new가 생성	
//		int[] numArr2 = new int[] {10,20,30}; // 위와 동일하게 작동
	
//		int[] numArr3 = new int[3];
//		int[] numArr4 = new int[] {10,20,30}; // 위와 서로 같다.
			
//			int[] numArr3 = new int[3]; // 보편적으로 많이 사용
//			int[] numArr1 = {10,20,30}; // 보편적으로 많이 사용
			
//---------------------------배열 구구단----------------------------------
//		int[] gob = new int[] {1,2,3,4,5,6,7,8,9};
//		int[] dan = new int[] {2,4,6,8};
//		for(int i = 0; i<dan.length; i++) {
//			System.out.println(dan[i]+"단");
//			for(int j = 0; j<gob.length; j++)
//				System.out.print(dan[i]+"*"+gob[j]+"="+(dan[i]*gob[j])+"\t");
//			System.out.println();
//		}
//---------------------- 배열을 쓰지 않은 예 ! ---------------------------------
//		int[] gob = new int[10];
//		int[] dan = new int[10]; 
//		for(int i = 2; i<dan.length; i+=2) {
//			System.out.println(i+"단");
//			for(int j = 1; j<gob.length; j++) {
//				System.out.println(i+"*"+j+"="+(i*j));
//			}
//		}
	
//		int[] gob = new int[]{2,4,6,8};
//		int[] dan = new int[9]; 
//		for(int i = 0; i<dan.length; i++) {
//			System.out.print(dan[i]+ "단");
//			for(int j = 0; j<gob.length; j++) {
//					gob[j] = j + 1;
//					System.out.println(dan[i]+"*"+gob[j]+"="+(dan[i]*gob[j])+"\t");
//		}
//					System.out.println();
//	}			
//			
		
		//다차원, 1차[], 2차[][], ...n차[][][]...[]
		//2행 3열
//		int[][] score = new int[2][3];
//		int[][] score = new int[][] { {100,70,80},
//								 	  {99,88,77}
//									};
//		for(int i = 0; i<2; i++) {
//			for(int j = 0; j<3; j++) {
//				System.out.print(score[i][j]+"\t");
//			}
//			System.out.println();
//		}
////-------------------length 사용--------------------
//		for(int i = 0; i<score.length; i++) {		//2행
//			for(int j = 0; j<score[0].length; j++) {//3열
//				System.out.print(score[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		
		//2,3,4
//		int[][][] score2 = new int[][][] {//[2][3][4]
//											{
//												{1,2,3,4},
//												{1,2,3,4},
//												{1,2,3,4}
//											},
//											{
//												{1,2,3,4},
//												{1,2,3,4},
//												{1,2,3,4}
//											}
//		};
//		
//--------------------------연습문제------------------------------
		
//		int[] arr[]; 선언은 되지만 초기화가 안됨
//		int[] arr = {1,2,3,}; -- 1,2,3 이고 뒤에 , 는 값이 없어져 버린다.
//		int[] arr = new int[5];
//		int[] arr = new int[5] {1,2,3,4,5}; error
//		int arr[5]; error 
//		int[] arr[] = new int[3][]; -- 가변배열
		
//------------------------------------------------------------------
//		int[] arr = {10,20,30,40,50};
//		int sum = 0;
//		
//		for(int i = 0; i<arr.length; i++) {
//			sum += arr[i];
////			System.out.println("sum="+sum); //계산 과정이 다 보이게된다.
//		}
//		System.out.println("sum="+sum);
	
//--------------------------------------------------------------------
//		int[][] arr = { { 5, 5, 5, 5, 5}, 
//						{10,10,10,10,10}, 
//						{20,20,20,20,20}, 
//						{30,30,30,30,30} }; 
//		int total = 0; 
//		float average = 0; 
//		int cnt = 0;
//		for(int i = 0; i<arr.length; i++) {
//			for(int j = 0; j<arr[0].length; j++) {
//				total += arr[i][j];
////				average = (float)total / arr[i].length ;
////				arr[i]위치만 loop되기 때문에 평균 계산이 되지 않는다.
//				cnt++;
//			}
//				
//		}
//		average = (float)total / cnt ; 
//		// for에서 계산하는 경우 효율이 떨어지므로 for문 밖에서 진행하는게 좋다.
//		System.out.println("total="+total); 
//		System.out.println("average="+average);
//-------------------------------------------------------------
		
		// 큰 금액의 동전을 우선적으로 거슬러 줘야한다
//		int[] coinUnit = {500, 100, 50, 10};
//		int money = 2680;
//		System.out.println("money="+money);
//		for(int i=0;i<coinUnit.length;i++) {
//			int chg = money/coinUnit[i];
//			money = money%coinUnit[i];
//			System.out.println(coinUnit[i]+"원"+chg+"개");
//		}
		
		
//		int[] coinUnit = {500, 100, 50, 10};
//		int money = 2680;
//		System.out.println("money="+money);
//		int chg = 0;
//		for(int i=0;i<coinUnit.length;i++) {
//			chg = money / coinUnit[i];
//			System.out.println(coinUnit[i]+"원"+chg+"개");
//			money = money - (coinUnit[i]*chg);
//		}
//--------------------------------------------------------------
		
//		1.(32~126) 아스키 코드 출력
//		2.System.out.println((char)65);
//		3.int inputNum = 65;
//		4.char inputChar = 'A'
		
		int[] arr = new int[1];
		int inputNum = 65;
		char inputChar = 'B';
		String inputStr = "ABC";
		for (int i = 32; i <= 126; i++){
			char a = (char)inputNum;
			int b = (int)inputChar;
//			System.out.println(((char)i+ "\t")+i); // 아스키코드 출력
//			System.out.println("글자로 = "+ a +" 숫자로 = "+ b);			
		}
		System.out.println("----------------");
		inputNum = 65;
		System.out.println((char)inputNum);
		inputChar = 'A';
		System.out.println((int)inputChar);
//---------------------String = 배열---------------------------
//https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
		
//		String inputStr = "abc";
//		String inputStr = new String("abc"); // new 생성시마다 힙에 저장
//		char data[] = {'a','b','c'}; // newString은 char의 배열과 같다.
		
		//****API**** charAt(i) : str ==> char
		for(int i=0; i<inputStr.length();i++) { // ()가 있다 메소드라서
			char c = inputStr.charAt(i);
			System.out.println(c+ "," +(int)c);
			
		}
		
		//****API**** toCharArray(str) ==> char[] => 글자 여러개
		char[] carr = inputStr.toCharArray();
		for(int i = 0; i<carr.length; i++) { // ()가 없다
			System.out.println(carr[i]+ "," +(int)carr[i]);
		}
//-----------------------------------------------------------------
//		String temp = "A";
//		for(int i = 0; i<1000; i++) {
//			temp = temp +i;
//		} // string temp에 i값이 저장되면서 계속 메모리를 잡아먹는다. 좋지 않은 설계 
		  
		
		
		
		
		
	}

}
