package com.kosta.lec;

public class Mypro1 {

	public static void main(String[] args) {
		// for 중첩으로 나비 만들기
		for (int i = 1, n=1; i <= 10; i++) { //  
			for(int j = 1; j <= 10; j++) { //
				System.out.print(((j >= n+1) && (j <= 10-n))?" ":"*");


			}
			if(i<5) {
				n++;
			} else {
				n--;
			}

			System.out.println();
		}
		/* 10행 10열의 배열 , 조건으로 공백과 별을 번갈아가며 찍음
		 * i,j와 n은 1부터 시작 i가 10보다 크거나 같을 때 까지 1씩 증가 반복문
		 * n+1 <= j <= 10-n의 범위에 공백을 출력 (i는 행, j는 열)
		 * (1)+1 <= j(칸) <= 10-(1) 2 ~ 9
		 * (2)+1 <= j(칸) <= 10-(2) 3 ~ 8
		 * 
		 * j가 n+1한 것 보다 크거나 같고 j가 10-n 한 것보다 작거나 같음을 모두 만족하면
		 * true로 공백 출력 , 그렇지 않으면 *을 출력
		 * -별 줄이기-
		 * if문 사용 i가 5보다 작으면 n을 늘리고 그렇지 않으면 n을 줄인다.
		 */
	}

}
