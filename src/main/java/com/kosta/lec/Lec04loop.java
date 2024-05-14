package com.kosta.lec;

public class Lec04loop {

	public static void main(String[] args) {
		// 중첩 루프문(구구단)
//---------------------------세로 정렬해보기-----------------------------
//		for (int dan=2; dan<=9; dan+=2) {
//			System.out.print(dan+"\t");
//		
//			System.out.println();
//			for (int gob=2; gob<=9; gob+=2) {
//				System.out.println(dan+"*"+gob +"="+(dan*gob));
//			}
//		}

//		for(int tt=2; tt<=9; tt+=2) 
//			System.out.print(tt+"단"+"\t");
//			System.out.println();
//		
//		int ent = 1;
		
//-------------------------title 단 만들어보기--------------------------
//		for (int gob = 1; gob <= 4; gob++) {
//			
//			for (int dan = 2; dan <= 9; dan += 2) {
//				if ( gob == 1) {
//					//ent = 0;
//					System.out.print(dan +"\t");
//				
//				}
//				else
//				System.out.print(dan + "*" + gob + "=" + (dan * gob) + "\t");
//				//ent = 1;
//			}
//			System.out.println();
//			
//		}
//-------------------------------가로 나열------------------------------
//		for (int tt =2; tt<=9; tt++ ) {
//			System.out.print(tt+"단"+"\t");
//		}
//			
//			for	(int gob = 1; gob<=9; gob++) {
//				System.out.println("\t");
//				for(int dan = 2; dan<=9; dan++) {
//					System.out.print(dan+"*"+gob+"="+(dan*gob)+"\t");
//			}
//
//			
//		}

//		for (int dan=2; dan<=9 ; dan++) {	
//			System.out.println(dan + "단");
//			for(int gob=1; gob<=9; gob+=2) {
//				System.out.print(dan+"*"+gob+"="+(dan*gob) + "\t");
//			}
//		System.out.println();
//		
//		}

		
//-----------------------------------------------------------------
		//1~20까지 정수 중 2 또는 3의 배수가 아닌 수들의 총합1,5,7,11,13,17,19
//		int sum = 0;
//		for (int i = 0; i<=20 ; i++) {
//			if ((i%2 !=0) && (i%3 != 0)) {
//				sum = sum + i;
//				System.out.println(sum+" ");
//			}
//		}
//		System.out.println("\n"+sum);
		
//------------------------------------------------------------------		
		//1+(-2)+3+(-4)+... 계속 더했을때 몇까지 더해야 총합이 100 이상
//		int tsum = 0;
//		int i = 1;
//			while(tsum < 100) {
//				if (i%2 == 1) { // 홀수
//					tsum = tsum + i;
//				} else {		//짝수
//					
//					tsum = tsum + (i *-1);
//				}
//				i++;
//			}
//			System.out.println(i - 1);
//------------------------------------------------------------------
		// 다음의 for문을 while문으로 변경
//				for(int i=0; i<=10; i++) {
//					for(int j=0; j<=i; j++)
//						System.out.print("*");
//					System.out.println();
//				}
//		int i = 0;
//		while(i<=10) {
//			int j = 0;
//			while(j<=i) {
//				System.out.print("*");
//				j++;
//			}
//			System.out.println();
//			i++;
//		}
//두 개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력
		for(int ju1=1; ju1<=6; ju1++) {
//			System.out.println(ju1);
			for(int ju2=1; ju2<=6; ju2++) {
//				System.out.println(ju2);
				if(ju1 + ju2 == 6) {
					System.out.println(ju1+","+ju2);
				}
			}
		}
		
		
		
	}

}
