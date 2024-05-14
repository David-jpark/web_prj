package com.kosta.lec;

public class Looptest2 {

	public static void main(String[] args) {
		//두 개의 주사위를 던졌을 때 눈의 합이 6이 되는 모든 경우의 수를 출력
		//1+(-2)+3+(-4)+... 계속 더했을때 몇까지 더해야 총합이 100 이상
		int a = 1;
		int b = 1;
		for (a = 1; a<=6; a++) {
			for(b = 1; b<=6; b++) {
				if(a + b == 6) {
					System.out.println(a+","+b);
				}
			}
		}
		int sum = 0;
		int i = 1;
		do {
			if (i%2 == 1) {
				sum = sum + i;
			} else {
				sum = sum + (i*-1);
			}
			i++;
		} while(sum < 100);
		System.out.println(i - 1);
		
		
	}

}
